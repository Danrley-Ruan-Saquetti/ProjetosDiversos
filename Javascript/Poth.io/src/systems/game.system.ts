// @ts-nocheck

import { EntityId, IQuery, IScheduler, IWorld, PrefabEntity, System, SystemInitializeContext, TimerTask } from "../../lib/index.js";
import { FollowTarget } from "../components/behaviour/follow-target.js";
import { Movement } from "../components/behaviour/movement.js";
import { Rectangle } from "../components/shapes/rectangle.js";
import { EnemyTag } from "../components/tags/enemy-tag.js";
import { Transform } from "../components/transform.js";
import { CameraPrefab } from "../prefabs/camera.prefab.js";
import { EnemyPrefab } from "../prefabs/enemy.prefab.js";
import { PlayerPrefab } from "../prefabs/player.prefab.js";

export class GameSystem extends System {

  private world: IWorld
  private scheduler: IScheduler

  private enemyQuery: IQuery
  private enemyPrefab: PrefabEntity<[typeof EnemyTag, typeof Transform, typeof Rectangle, typeof Movement, typeof FollowTarget]>

  private playerId: EntityId
  private spawnDistancePlayer = 1_000
  private spawnTimerTask: TimerTask

  initialize({ world, scheduler }: SystemInitializeContext) {
    this.world = world
    this.scheduler = scheduler

    const playerPrefab = PlayerPrefab.instantiate(world)
    const cameraPrefab = CameraPrefab.instantiate(world)
    this.enemyPrefab = EnemyPrefab.instantiate(world)

    this.enemyQuery = this.enemyPrefab.getQuery()

    this.playerId = playerPrefab.spawn()
    cameraPrefab.spawn({
      Camera: {
        follow: this.playerId
      }
    })
  }

  start() {
    this.scheduler.scheduleRepeat(() => {
      this.spawnEnemy()
    }, 1_000)
  }

  stop() {
    this.scheduler.cancel(this.spawnTimerTask)
  }

  private spawnEnemy() {
    const playerLocation = this.world.expectEntity(this.playerId)
    const playerTransform = playerLocation.archetype.component(Transform)

    const playerX = playerTransform.field('x')[playerLocation.index]
    const playerY = playerTransform.field('y')[playerLocation.index]

    const minX = playerX - this.spawnDistancePlayer
    const minY = playerY - this.spawnDistancePlayer
    const maxX = playerX + this.spawnDistancePlayer
    const maxY = playerY + this.spawnDistancePlayer

    this.enemyPrefab.spawn({
      Transform: {
        x: Math.random() * (maxX - minX) + minX,
        y: Math.random() * (maxY - minY) + minY,
      },
      FollowTarget: {
        follow: this.playerId
      }
    })
  }
}
