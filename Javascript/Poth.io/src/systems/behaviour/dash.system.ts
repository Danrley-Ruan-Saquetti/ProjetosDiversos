// @ts-nocheck

import { EntityId, IQuery, IScheduler, IWorld, Keys, System, SystemInitializeContext, SystemUpdateContext } from "../../../lib/index.js";
import { Dash } from "../../components/behaviour/dash.js";
import { Movement } from "../../components/behaviour/movement.js";

export class DashSystem extends System {

  private scheduler: IScheduler

  private world: IWorld
  private query: IQuery

  initialize({ world, scheduler }: SystemInitializeContext) {
    this.world = world
    this.scheduler = scheduler
    this.query = world.getQuery([Dash, Movement])
  }

  update({ time, input }: SystemUpdateContext) {
    const archetypes = this.query.view()

    const isSprintPressed = input.isKeyHeld(Keys.ShiftLeft)
    const isMovePressed = input.isKeyHeld(Keys.KeyW) || input.isKeyHeld(Keys.KeyS) || input.isKeyHeld(Keys.KeyA) || input.isKeyHeld(Keys.KeyD)

    let i = 0, length = archetypes.length
    while (i < length) {
      const dash = archetypes[i].component(Dash)
      const movement = archetypes[i].component(Movement)

      let j = 0, size = archetypes[i].size
      while (j < size) {
        const dashCooldown = dash.field('dashCooldown')
        const dashCooldownTimer = dash.field('dashCooldownTimer')
        const dashDuration = dash.field('dashDuration')
        const canDash = dash.field('canDash')
        const dashing = dash.field('dashing')
        const speedInDash = dash.field('speedInDash')
        const currentSpeed = movement.field('speed')

        if (!canDash[j]) {
          dashCooldownTimer[j] += time.deltaTimeMilliseconds

          j++
          continue
        }

        if (dashing[j] || !isSprintPressed || !isMovePressed) {
          j++
          continue
        }

        canDash[j] = false
        dashing[j] = true
        currentSpeed[j] = speedInDash[j]

        const entityId = archetypes[i].entities[j]

        this.scheduler.scheduleOnce(() => this.resetDash(entityId), dashCooldown[j])
        this.scheduler.scheduleOnce(() => this.cancelDashAnimation(entityId), dashDuration[j])

        j++
      }

      i++
    }
  }

  private cancelDashAnimation(entityId: EntityId) {
    const location = this.world.getEntityLocation(entityId)

    if (!location) {
      return
    }

    const dash = location.archetype.component(Dash)
    const movement = location.archetype.component(Movement)

    const currentSpeed = movement.field('speed')
    const speedNormal = dash.field('speedNormal')
    const dashing = dash.field('dashing')

    currentSpeed[location.index] = speedNormal[location.index]
    dashing[location.index] = false
  }

  private resetDash(entityId: EntityId) {
    const location = this.world.getEntityLocation(entityId)

    if (!location) {
      return
    }

    const dash = location.archetype.component(Dash)

    const canDash = dash.field('canDash')
    const dashCooldownTimer = dash.field('dashCooldownTimer')

    dashCooldownTimer[location.index] = 0
    canDash[location.index] = true
  }
}
