import { Game } from "../lib/index.js"
import { DashSystem } from "./systems/behaviour/dash.system.js"
import { FollowTargetSystem } from "./systems/behaviour/follow-target.system.js"
import { MovementSystem } from "./systems/behaviour/movement.system.js"
import { CameraSystem } from "./systems/entity/camera.system.js"
import { PlayerMovementSystem } from "./systems/entity/player-movement.system.js"
import { GameSystem } from "./systems/game.system.js"
import { RenderSystem } from "./systems/render/render.system.js"

export class PothioGame extends Game {

  constructor(
    private readonly canvas: HTMLCanvasElement
  ) {
    super()
  }

  protected initialize() {
    super.initialize()

    this.registerSystem(new GameSystem())
    this.registerSystem(new PlayerMovementSystem())
    this.registerSystem(new DashSystem())
    this.registerSystem(new CameraSystem(this.canvas))
    this.registerSystem(new FollowTargetSystem())
    this.registerSystem(new MovementSystem())
    this.registerSystem(new RenderSystem(this.canvas))
  }
}
