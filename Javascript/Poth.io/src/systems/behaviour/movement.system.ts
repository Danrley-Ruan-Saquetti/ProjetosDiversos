// @ts-nocheck

import { IQuery, System, SystemInitializeContext, SystemUpdateContext } from "../../../lib/index.js";
import { Movement } from "../../components/behaviour/movement.js";
import { Transform } from "../../components/transform.js";

export class MovementSystem extends System {

  private query: IQuery

  initialize({ world }: SystemInitializeContext) {
    this.query = world.getQuery([Transform, Movement])
  }

  updateAfter({ time }: SystemUpdateContext) {
    const archetypes = this.query.view()

    let i = 0, length = archetypes.length
    while (i < length) {
      const transform = archetypes[i].component(Transform)
      const movement = archetypes[i].component(Movement)

      const x = transform.field('x')
      const y = transform.field('y')
      const horizontal = movement.field('horizontal')
      const vertical = movement.field('vertical')
      const speed = movement.field('speed')

      let j = 0, size = archetypes[i].size
      while (j < size) {
        const magnitude = Math.sqrt(horizontal[j] * horizontal[j] + vertical[j] * vertical[j])

        let vectorX = 0
        let vectorY = 0

        if (magnitude != 0) {
          vectorX = horizontal[j] / magnitude
          vectorY = vertical[j] / magnitude
        }

        x[j] += vectorX * speed[j] * time.deltaTime
        y[j] += vectorY * speed[j] * time.deltaTime

        j++
      }

      i++
    }
  }
}
