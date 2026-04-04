import { ComponentFieldType, createComponent } from "../../../lib/index.js";

export const Movement = createComponent("Movement", {
  horizontal: ComponentFieldType.Float32,
  vertical: ComponentFieldType.Float32,
  speed: ComponentFieldType.Float32,
})
