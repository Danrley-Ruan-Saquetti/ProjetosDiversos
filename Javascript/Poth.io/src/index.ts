import { PothioGame } from './game.js';

const canvas = document.querySelector<HTMLCanvasElement>('canvas#canvas-game')!

const game = new PothioGame(canvas)

game.start()
