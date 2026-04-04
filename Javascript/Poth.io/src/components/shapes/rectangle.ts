import { ComponentFieldType, createComponent } from "../../../lib/index.js";

export const Rectangle = createComponent("Rectangle", {
  width: ComponentFieldType.Uint32,
  height: ComponentFieldType.Uint32,
})
