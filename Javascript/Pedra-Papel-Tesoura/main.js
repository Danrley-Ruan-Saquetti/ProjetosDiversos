import Element from "./src/script/Element.js"

const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")

const MAX_ELEMENT = 30
const DIMENSION_ELEMENT = 20
const DIMENSION_WINDOW = { width: 400, height: 400 }

const SPAWN_ELEMENT = {
    position: () => {
        let x = Math.round(
                Math.random() *
                (DIMENSION_WINDOW.width -
                    DIMENSION_ELEMENT -
                    canvas.clientLeft)
            ),
            y = Math.round(
                Math.random() *
                (DIMENSION_WINDOW.height -
                    DIMENSION_ELEMENT -
                    canvas.clientTop)
            )
        return { x, y }
    },
    dimension: () => {
        let width = DIMENSION_ELEMENT
        let height = DIMENSION_ELEMENT

        return { width, height }
    },
}

canvas.width = DIMENSION_WINDOW.width
canvas.height = DIMENSION_WINDOW.height

let elements = []
let animateFrame

function setup() {
    for (let i = 0; i < MAX_ELEMENT; i++) {
        const typeEl =
            i < MAX_ELEMENT / 3 ? 1 : i < (MAX_ELEMENT / 3) * 2 ? 2 : 3

        elements.push(
            new Element(
                SPAWN_ELEMENT.position(),
                SPAWN_ELEMENT.dimension(),
                typeEl,
                i, { x: 0, y: 0 }
            )
        )
    }

    animate()
}

function detectColision() {
    for (let i = 0; i < elements.length - 1; i++) {
        const eli = elements[i]
        for (let j = i + i; j < elements.length; j++) {
            const elj = elements[j]

            if (eli.code == elj.code && eli.typeEl == elj.typeEl) continue

            if ((eli.position.x <= elj.position.x + elj.dimension.width && eli.position.y <= elj.position.y + elj.dimension.height) ||
                (eli.position.x <= elj.position.x + elj.dimension.width && eli.position.y + eli.dimension.height <= elj.position.y) ||
                (eli.position.x + eli.dimension.width >= elj.position.x && eli.position.y + eli.dimension.height >= elj.position.y) ||
                (eli.position.x + eli.dimension.width >= elj.position.x && elj.position.y >= elj.position.y)) elj.typeEl = eli.typeEl

        }
    }
}

function animate() {
    ctx.fillStyle = "#fff"
    ctx.fillRect(
        canvas.clientLeft,
        canvas.clientTop,
        canvas.clientWidth,
        canvas.clientHeight
    )

    elements.forEach((el, i) => {
        el.findTarget(elements, elements.length)
        el.update()
        el.draw(ctx)
    })

    detectColision()

    animateFrame = requestAnimationFrame(animate)
}

window.onload = setup
