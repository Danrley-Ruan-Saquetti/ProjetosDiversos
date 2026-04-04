import { ArchetypeProfile, EntityBuilder } from "../../lib/index.js";
import { Dash } from "../components/behaviour/dash.js";
import { Movement } from "../components/behaviour/movement.js";
import { Rectangle } from "../components/shapes/rectangle.js";
import { PlayerTag } from "../components/tags/player-tag.js";
import { Transform } from "../components/transform.js";

export const PlayerPrefab = new EntityBuilder({
  profile: ArchetypeProfile.UNIQUE
})
  .with(PlayerTag)
  .with(Transform)
  .with(Rectangle, {
    width: 50,
    height: 50
  })
  .with(Movement, {
    speed: 300
  })
  .with(Dash, {
    dashCooldown: 3_000,
    dashDuration: 500,
    canDash: 1,
    dashing: 0,
    speedInDash: 500,
    speedNormal: 300,
  })
  .build()
