import { IQuery, Keys, System, SystemInitializeContext, SystemUpdateContext } from "../../../lib/index.js";
import { Dash } from "../../components/behaviour/dash.js";
import { Movement } from "../../components/behaviour/movement.js";
import { PlayerPrefab } from "../../prefabs/player.prefab.js";

export class PlayerMovementSystem extends System {

  private query: IQuery

  initialize({ world }: SystemInitializeContext) {
    this.query = PlayerPrefab.instantiate(world).getQuery()
  }

  update({ input }: SystemUpdateContext) {
    const playerLocation = this.query.findFirstLocation()

    if (!playerLocation) {
      return
    }

    const moveX = input.isKeyHeld(Keys.KeyA) ? -1
      : input.isKeyHeld(Keys.KeyD) ? 1
        : 0
    const moveY = input.isKeyHeld(Keys.KeyW) ? -1
      : input.isKeyHeld(Keys.KeyS) ? 1
        : 0

    const movement = playerLocation.archetype.component(Movement)
    const dash = playerLocation.archetype.component(Dash)

    const dashing = dash.field('dashing')

    if (dashing[playerLocation.index]) {
      return
    }

    const horizontal = movement.field('horizontal')
    const vertical = movement.field('vertical')

    horizontal[playerLocation.index] = moveX
    vertical[playerLocation.index] = moveY
  }
}
