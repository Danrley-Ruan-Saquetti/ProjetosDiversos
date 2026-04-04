import { ArchetypeProfile, EntityBuilder } from "../../lib/index.js";
import { FollowTarget } from "../components/behaviour/follow-target.js";
import { Movement } from "../components/behaviour/movement.js";
import { Rectangle } from "../components/shapes/rectangle.js";
import { EnemyTag } from "../components/tags/enemy-tag.js";
import { Transform } from "../components/transform.js";

export const EnemyPrefab = new EntityBuilder({
  profile: ArchetypeProfile.SMALL
})
  .with(EnemyTag)
  .with(FollowTarget)
  .with(Transform)
  .with(Rectangle, {
    width: 50,
    height: 50
  })
  .with(Movement, {
    speed: 200
  })
  .build()
