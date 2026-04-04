// @ts-nocheck

import { IQuery, IWorld, System, SystemInitializeContext, SystemUpdateContext } from "../../../lib/index.js";
import { Camera } from "../../components/entity/camera.js";
import { Transform } from "../../components/transform.js";
import { CameraPrefab } from "../../prefabs/camera.prefab.js";
import { Mathf } from "../../utils/math.js";

export class CameraSystem extends System {

  private world: IWorld
  private queryCamera: IQuery

  private mouseInfluence = 0
  private mouseSpeed = 10

  constructor(
    private readonly canvas: HTMLCanvasElement
  ) {
    super()
  }

  initialize({ world }: SystemInitializeContext) {
    this.world = world

    const cameraPrefab = CameraPrefab.instantiate(world)

    this.queryCamera = cameraPrefab.getQuery()

    cameraPrefab.spawn()
  }

  updateAfter(context: SystemUpdateContext) {
    this.updateCamera(context)
  }

  private updateCamera({ time, input }: SystemUpdateContext) {
    const cameraLocation = this.queryCamera.findFirstLocation()

    if (!cameraLocation) {
      return
    }

    const camera = cameraLocation.archetype.component(Camera)
    const followEntityId = camera.field('follow')

    const cameraX = camera.field('x')
    const cameraY = camera.field('y')

    const cameraCenterWidth = this.canvas.width / 2
    const cameraCenterHeight = this.canvas.height / 2

    if (!followEntityId[cameraLocation.index]) {
      return
    }

    const mouseNormalizedX = (input.getMousePositionX() - cameraCenterWidth) / cameraCenterWidth
    const mouseNormalizedY = (input.getMousePositionY() - cameraCenterHeight) / cameraCenterHeight

    const mouseOffsetX = mouseNormalizedX * this.mouseInfluence
    const mouseOffsetY = mouseNormalizedY * this.mouseInfluence

    const entityLocation = this.world.expectEntity(followEntityId[cameraLocation.index])
    const transformPlayer = entityLocation.archetype.component(Transform)

    const entityX = transformPlayer.field('x')
    const entityY = transformPlayer.field('y')

    const targetX = entityX[entityLocation.index] + mouseOffsetX
    const targetY = entityY[entityLocation.index] + mouseOffsetY

    cameraX[cameraLocation.index] = Mathf.lerp(cameraX[cameraLocation.index], targetX, time.deltaTime * this.mouseSpeed)
    cameraY[cameraLocation.index] = Mathf.lerp(cameraY[cameraLocation.index], targetY, time.deltaTime * this.mouseSpeed)
  }
}
