import { ComponentFieldType, createComponent } from "../../../lib/index.js";

export const Camera = createComponent("Camera", {
  x: ComponentFieldType.Float32,
  y: ComponentFieldType.Float32,
  zoom: ComponentFieldType.Float32,
  follow: ComponentFieldType.Int16,
})
