class Table {
    constructor(position, dimension, division) {
        this.position = position
        this.dimension = dimension
        this.division = division
    }

    draw() {
        ctx.fillStyle = GAMES_PARAMETERS.THEME_COLORS.PRIMARY_COLOR
        ctx.fillRect(this.position.x, this.position.y, this.dimension.width, this.dimension.height)
        ctx.fillStyle = GAMES_PARAMETERS.THEME_COLORS.SECOND_COLOR
        ctx.fillRect(this.division.position.x, this.division.position.y, this.division.dimension.width, this.division.dimension.height)
    }
}

class Player {
    constructor(position, dimension, key) {
        this.position = position
        this.dimension = dimension
        this.speed = { x: 0, y: 0 }
        this.points = 0
        this.lastKey = ''
        this.key = key
    }

    draw() {
        ctx.fillStyle = GAMES_PARAMETERS.THEME_COLORS.SECOND_COLOR
        ctx.fillRect(this.position.x, this.position.y, this.dimension.width, this.dimension.height)
    }

    update() {
        this.position.y += this.speed.y

        if (this.position.y + this.dimension.height > table.dimension.height) this.position.y = table.dimension.height - this.dimension.height
        else if (this.position.y < table.position.y) this.position.y = table.position.y

        this.draw()
    }
}

class Ball {
    constructor(position, radius, speed) {
        this.position = position
        this.radius = radius
        this.speed = speed
    }

    draw() {
        ctx.beginPath();
        ctx.arc(this.position.x, this.position.y, this.radius, 0, Math.PI * 2, false);
        ctx.fillStyle = GAMES_PARAMETERS.THEME_COLORS.SECOND_COLOR;
        ctx.fill();
    }

    update() {
        if (this.position.y + this.radius > table.dimension.height || this.position.y < table.position.x) this.speed.y *= -1
        if (this.position.x + this.radius > table.dimension.width || this.position.x - 8 < table.position.x) {
            if (this.position.x + this.radius > table.dimension.width) players[0].points++
                else if (this.position.x - 8 < table.position.x) players[1].points++
                    this.speed.x *= -1
            this.position = GAMES_PARAMETERS.BALL.POSITION()
        }

        this.position.x += this.speed.x
        this.position.y += this.speed.y

        this.draw()
    }
}

const canvas = document.getElementById('canvas')
const ctx = canvas.getContext('2d')

canvas.width = innerWidth
canvas.height = innerHeight

const KEYS = { w: false, s: false, o: false, l: false }

const GAMES_PARAMETERS = {
    TABLE: {
        POSITION: () => { return { x: canvas.clientLeft, y: canvas.clientTop } },
        DIMENSION: () => { return { width: canvas.clientWidth, height: canvas.clientHeight } },
        DIVISION: () => { return { position: { x: (canvas.clientWidth - 10) / 2, y: canvas.clientTop }, dimension: { width: 10, height: canvas.clientHeight } } }
    },
    PLAYERS: {
        DIMENSION_1_2: () => { return { width: 10, height: 100 } },
        POSITION_1: () => { return { x: table.position.x + GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2().width, y: (table.dimension.height - GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2().height) / 2 } },
        POSITION_2: () => { return { x: table.dimension.width - (GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2().width * 2), y: (table.dimension.height - GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2().height) / 2 } }
    },
    BALL: {
        RADIUS: () => { return GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2().width },
        POSITION: () => { return { x: (table.dimension.width - GAMES_PARAMETERS.BALL.RADIUS()) / 2, y: (table.dimension.height - GAMES_PARAMETERS.BALL.RADIUS()) / 2 } },
        SPEED: () => { return { x: Math.random() * 100 > 50 ? 5 : -5, y: (Math.random() - .5) * (Math.random() * 15) } }
    },
    THEME_COLORS: {
        PRIMARY_COLOR: '#000',
        SECOND_COLOR: '#fff'
    }
}

let table = new Table(GAMES_PARAMETERS.TABLE.POSITION(), GAMES_PARAMETERS.TABLE.DIMENSION(), GAMES_PARAMETERS.TABLE.DIVISION())
let ball = new Ball(GAMES_PARAMETERS.BALL.POSITION(), GAMES_PARAMETERS.BALL.RADIUS(), GAMES_PARAMETERS.BALL.SPEED())
let players = [
    new Player(GAMES_PARAMETERS.PLAYERS.POSITION_1(), GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2(), 0),
    new Player(GAMES_PARAMETERS.PLAYERS.POSITION_2(), GAMES_PARAMETERS.PLAYERS.DIMENSION_1_2(), 1)
]

console.log(players)

addEventListener('keydown', (ev) => {
    switch (ev.keyCode) {
        case 87:
            KEYS.w = true
            players[0].lastKey = 'w'
            break;
        case 83:
            KEYS.s = true
            players[0].lastKey = 's'
            break;
        case 79:
            KEYS.o = true
            players[1].lastKey = 'o'
            break;
        case 76:
            KEYS.l = true
            players[1].lastKey = 'l'
            break;
    }
})

addEventListener('keyup', (ev) => {
    switch (ev.keyCode) {
        case 87:
            KEYS.w = false
            break;
        case 83:
            KEYS.s = false
            break;
        case 79:
            KEYS.o = false
            break;
        case 76:
            KEYS.l = false
            break;
    }
})

function drawScored() {
    ctx.fillStyle = GAMES_PARAMETERS.THEME_COLORS.SECOND_COLOR
    ctx.font = '50px monospace'
    ctx.fillText(players[0].points, table.division.position.x / 2 - 15, 65)
    ctx.fillText(players[1].points, table.division.position.x * 1.5 - 15, 65)
}

function updateWindow() {
    const heightOld = canvas.height
    const widthOld = canvas.width

    if (innerHeight < innerWidth) {
        canvas.width = innerWidth
        canvas.height = innerHeight
    }

    table.position = GAMES_PARAMETERS.TABLE.POSITION()
    table.dimension = GAMES_PARAMETERS.TABLE.DIMENSION()
    table.division = GAMES_PARAMETERS.TABLE.DIVISION()

    players[0].position = { x: GAMES_PARAMETERS.PLAYERS.POSITION_1().x, y: (players[0].position.y * canvas.height) / heightOld }
    players[1].position = { x: GAMES_PARAMETERS.PLAYERS.POSITION_2().x, y: (players[0].position.y * canvas.height) / heightOld }

    ball.position.x = (ball.position.x * canvas.width) / widthOld
    ball.position.y = (ball.position.y * canvas.height) / heightOld
}

function check_Colision_Ball_Player() {
    const player1 = players[0]
    const player2 = players[1]
    if (((ball.position.x - 8 <= player1.position.x + player1.dimension.width && ball.position.x - 8 >= player1.position.x &&
                ball.position.y <= player1.position.y + player1.dimension.height && ball.position.y >= player1.position.y) ||
            (ball.position.x - 8 <= player1.position.x + player1.dimension.width && ball.position.x - 8 >= player1.position.x &&
                ball.position.y + ball.radius <= player1.position.y + player1.dimension.height && ball.position.y + ball.radius >= player1.position.y)) ||
        ((ball.position.x + ball.radius > player2.position.x && ball.position.x + ball.radius < player2.position.x + player2.dimension.width &&
                ball.position.y < player2.position.y + player2.dimension.height && ball.position.y > player2.position.y) ||
            (ball.position.x + ball.radius > player2.position.x && ball.position.x + ball.radius > player2.position.x &&
                ball.position.y + ball.radius > player2.position.y && ball.position.y + ball.radius < player2.position.y + player2.dimension.height))) ball.speed.x *= -1
}

function animate() {
    if (canvas.clientWidth != innerWidth || canvas.clientHeight != innerHeight) updateWindow()

    table.draw()

    players.forEach((player) => {
        player.speed.y = 0

        switch (player.key) {
            case 0:
                if (KEYS.w && player.lastKey === 'w') player.speed.y = -5
                else if (KEYS.s && player.lastKey === 's') player.speed.y = 5
                break;
            case 1:
                if (ball.position.x > (table.dimension.width / 2) && ball.speed.x > 0) {
                    if (ball.position.y > player.position.y + (player.dimension.height / 2)) {
                        if (ball.position.y - (player.position.y + (player.dimension.height / 2)) < 3) player.speed.y = .4
                        else player.speed.y = 3
                    } else if (ball.position.y < player.position.y + (player.dimension.height / 2)) {
                        if (ball.position.y - (player.position.y + (player.dimension.height / 2)) > -3) player.speed.y = -.4
                        else player.speed.y = -3
                    }
                } else {
                    if (player.position.y < GAMES_PARAMETERS.PLAYERS.POSITION_2().y) player.speed.y = 1
                    else if (player.position.y > GAMES_PARAMETERS.PLAYERS.POSITION_2().y) player.speed.y = -1
                }
                // if (KEYS.o && player.lastKey === 'o') player.speed.y = -5
                // else if (KEYS.l && player.lastKey === 'l') player.speed.y = 5
                break;
        }
        player.update()
    })

    ball.update()

    check_Colision_Ball_Player()
    drawScored()

    requestAnimationFrame(animate)
}

animate()
