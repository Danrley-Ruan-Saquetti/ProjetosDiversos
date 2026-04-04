import { ComponentFieldType, createComponent } from "../../lib/index.js";

export const Transform = createComponent("Transform", {
  x: ComponentFieldType.Float32,
  y: ComponentFieldType.Float32,
})
