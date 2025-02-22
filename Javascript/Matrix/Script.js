class FallingChar {
    constructor(position) {
        this.position = position
    }

    draw() {
        this.value = charArr[Math.floor(Math.random() * (charArr.length - 1))].toUpperCase()
        this.speed = Math.random() * FONT_SIZE() * 3 / 4 + FONT_SIZE() * 3 / 4 + 1

        ctx.fillStyle = 'rgba(0, 255, 0, .7)'
        ctx.font = FONT_SIZE() + 'px san-serif'
        ctx.fillText(this.value, this.position.x, this.position.y)
    }

    update() {
        this.draw()

        if (this.position.y > canvas.height) {
            this.position.x = createFallingChar().x
            this.position.y = createFallingChar().y
        }

        this.position.y += this.speed
    }
}

const canvas = document.getElementById('canvas')
const ctx = canvas.getContext('2d')

canvas.width = innerWidth
canvas.height = innerHeight

const charArr = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
    't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', 'А', 'В', 'Г', 'Д', 'Є', 'Ѕ',
    'З', 'И', 'Ѳ', 'І', 'К', 'Л', 'М', 'Н', 'Ѯ', 'Ѻ', 'П', 'Ч', 'Р', 'С', 'Т', 'Ѵ', 'Ф', 'Х', 'Ѱ', 'Ѿ', 'Ц',
];

const MAX_CHAR_COUNT = 100

const FONT_SIZE = () => {
    return canvas.width * 0.01
}

const maxColumns = () => {
    return canvas.width / FONT_SIZE()
}

const createFallingChar = () => {
    return { x: Math.floor(Math.random() * maxColumns()) * FONT_SIZE(), y: Math.random() * canvas.width / 2 - 50 }
}

let fallingCharArr = []
let frames = 0

function updateWindow() {
    canvas.width = innerWidth
    canvas.height = innerHeight
}

function animate() {
    if (innerWidth != canvas.width || innerHeight != canvas.height) updateWindow()
    if (fallingCharArr.length < MAX_CHAR_COUNT) fallingCharArr.push(new FallingChar(createFallingChar()))

    ctx.fillStyle = 'rgba(0, 0, 0, 0.05)'
    ctx.fillRect(0, 0, canvas.width, canvas.height)

    fallingCharArr.forEach(fC => fC.update())

    requestAnimationFrame(animate)
    frames++
}

animate()