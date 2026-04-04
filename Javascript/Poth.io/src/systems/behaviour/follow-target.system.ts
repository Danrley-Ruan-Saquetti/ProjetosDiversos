// @ts-nocheck

import { IQuery, IWorld, System, SystemInitializeContext } from "../../../lib/index.js";
import { FollowTarget } from "../../components/behaviour/follow-target.js";
import { Movement } from "../../components/behaviour/movement.js";
import { Transform } from "../../components/transform.js";

export class FollowTargetSystem extends System {

  private world: IWorld
  private followTargetQuery: IQuery

  initialize({ world }: SystemInitializeContext) {
    this.world = world
    this.followTargetQuery = world.getQuery([FollowTarget, Transform, Movement])
  }

  updateAfter() {
    const archetypes = this.followTargetQuery.view()

    let i = 0, length = archetypes.length
    while (i < length) {
      const followTarget = archetypes[i].component(FollowTarget)
      const transform = archetypes[i].component(Transform)
      const movement = archetypes[i].component(Movement)

      const followTargetId = followTarget.field('follow')
      const x = transform.field('x')
      const y = transform.field('y')
      const horizontal = movement.field('horizontal')
      const vertical = movement.field('vertical')

      let j = 0, size = archetypes[i].size
      while (j < size) {
        const targetLocation = this.world.expectEntity(followTargetId[j])
        const transformTarget = targetLocation.archetype.component(Transform)

        const followTargetX = transformTarget.field('x')[targetLocation.index]
        const followTargetY = transformTarget.field('y')[targetLocation.index]

        const diffX = followTargetX - x[j]
        const diffY = followTargetY - y[j]

        const length = Math.hypot(diffY, diffX)

        let targetX = 0
        let targetY = 0

        if (length) {
          targetX = diffX / length
          targetY = diffY / length
        }

        horizontal[j] = targetX
        vertical[j] = targetY

        j++
      }

      i++
    }
  }
}
