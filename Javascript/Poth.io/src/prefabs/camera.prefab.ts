import { ArchetypeProfile, EntityBuilder } from "../../lib/index.js";
import { Camera } from "../components/entity/camera.js";
import { CameraTag } from "../components/tags/camera-tag.js";

export const CameraPrefab = new EntityBuilder({
  profile: ArchetypeProfile.UNIQUE
})
  .with(CameraTag)
  .with(Camera, {
    zoom: 1
  })
  .build()
