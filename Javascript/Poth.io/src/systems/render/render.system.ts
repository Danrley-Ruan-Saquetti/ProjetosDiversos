// @ts-nocheck

import { IArchetype, IQuery, System, SystemInitializeContext } from "../../../lib/index.js";
import { Dash } from "../../components/behaviour/dash.js";
import { Camera } from "../../components/entity/camera.js";
import { Rectangle } from "../../components/shapes/rectangle.js";
import { CameraTag } from "../../components/tags/camera-tag.js";
import { EnemyTag } from "../../components/tags/enemy-tag.js";
import { PlayerTag } from "../../components/tags/player-tag.js";
import { Transform } from "../../components/transform.js";

export class RenderSystem extends System {

  private readonly ctx: CanvasRenderingContext2D

  private queryPlayer: IQuery
  private queryEnemy: IQuery
  private queryCamera: IQuery

  constructor(
    private readonly canvas: HTMLCanvasElement
  ) {
    super()

    const ctx = this.canvas.getContext('2d')

    if (!ctx) {
      throw new Error('Context2D not supported in this navigator')
    }

    this.ctx = ctx
  }

  initialize({ world }: SystemInitializeContext) {
    this.queryPlayer = world.getQuery([PlayerTag, Transform, Rectangle])
    this.queryEnemy = world.getQuery([EnemyTag, Transform, Rectangle])
    this.queryCamera = world.getQuery([CameraTag, Camera])
  }

  start() {
    this.resizeCanvas()

    window.addEventListener('resize', this.resizeCanvas.bind(this))
  }

  stop() {
    window.removeEventListener('resize', this.resizeCanvas.bind(this))
  }

  update() {
    this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height)
    this.ctx.save()

    this.updateCamera()
    this.renderEnemy()
    this.renderPlayer()
    this.renderCountEnemy()

    this.ctx.restore()
  }

  private updateCamera() {
    const cameraLocation = this.queryCamera.findFirstLocation()

    if (!cameraLocation) {
      return
    }

    const camera = cameraLocation.archetype.component(Camera)

    const cameraX = camera.field('x')
    const cameraY = camera.field('y')
    const cameraZoom = camera.field('zoom')

    this.ctx.translate(
      -(cameraX[cameraLocation.index] - this.canvas.width / 2),
      -(cameraY[cameraLocation.index] - this.canvas.height / 2)
    )
    this.ctx.scale(cameraZoom[cameraLocation.index], cameraZoom[cameraLocation.index])
  }

  private renderPlayer() {
    const archetypes = this.queryPlayer.view()

    let i = 0, length = archetypes.length
    while (i < length) {
      this.renderRectangle(archetypes[i], '#FFF')
      this.renderCooldownDashBar(archetypes[i], '#FFF')

      i++
    }
  }

  private renderEnemy() {
    const archetypes = this.queryEnemy.view()

    let i = 0, length = archetypes.length
    while (i < length) {
      this.renderRectangle(archetypes[i], '#FF0000')

      i++
    }
  }

  private renderRectangle(archetype: IArchetype, color: string) {
    this.ctx.fillStyle = color

    const transform = archetype.component(Transform)
    const rectangle = archetype.component(Rectangle)

    const x = transform.field('x')
    const y = transform.field('y')
    const width = rectangle.field('width')
    const height = rectangle.field('height')

    let i = 0, size = archetype.size
    while (i < size) {
      this.ctx.fillRect(x[i] - (width[i] / 2), y[i] - (height[i] / 2), width[i], height[i])
      i++
    }
  }

  private renderCooldownDashBar(archetype: IArchetype, color: string) {
    this.ctx.fillStyle = color

    const transform = archetype.component(Transform)
    const rectangle = archetype.component(Rectangle)
    const dash = archetype.component(Dash)

    const x = transform.field('x')
    const y = transform.field('y')
    const width = rectangle.field('width')
    const canDash = dash.field('canDash')
    const dashCooldown = dash.field('dashCooldown')
    const dashCooldownTimer = dash.field('dashCooldownTimer')

    let i = 0, size = archetype.size
    while (i < size) {
      if (!canDash[i]) {
        const widthBar = (dashCooldownTimer[i] * width[i]) / dashCooldown[i]

        this.ctx.fillRect(x[i] - (width[i] / 2), y[i] - 50, widthBar, 5)
      }

      i++
    }
  }

  private renderCountEnemy() {
    const cameraLocation = this.queryCamera.findFirstLocation()

    if (!cameraLocation) {
      return
    }

    const camera = cameraLocation.archetype.component(Camera)

    const cameraX = camera.field('x')
    const cameraY = camera.field('y')

    this.ctx.font = '30px Arial';
    this.ctx.fillStyle = '#FFF';
    this.ctx.textAlign = 'center';
    this.ctx.fillText(this.queryEnemy.count() + '', cameraX[cameraLocation.index] + (this.canvas.width / 2) - 100, cameraY[cameraLocation.index] - (this.canvas.height / 2) + 50);
  }

  private resizeCanvas() {
    const dpr = window.devicePixelRatio || 1

    const displayWidth = window.innerWidth
    const displayHeight = window.innerHeight

    this.canvas.width = displayWidth * dpr
    this.canvas.height = displayHeight * dpr
  }
}
