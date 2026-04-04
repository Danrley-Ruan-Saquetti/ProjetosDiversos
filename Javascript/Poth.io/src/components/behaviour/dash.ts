import { ComponentFieldType, createComponent } from "../../../lib/index.js";

export const Dash = createComponent('Dash', {
  dashCooldown: ComponentFieldType.Float32,
  dashCooldownTimer: ComponentFieldType.Float32,
  dashDuration: ComponentFieldType.Float32,
  canDash: ComponentFieldType.Float32,
  dashing: ComponentFieldType.Float32,
  speedInDash: ComponentFieldType.Float32,
  speedNormal: ComponentFieldType.Float32,
})
