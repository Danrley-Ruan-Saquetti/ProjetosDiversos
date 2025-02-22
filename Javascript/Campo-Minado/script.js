function Game() {
    const columns = 9
    const lines = 9

    const bombas = []
    const numberBomba = []
    const campo = []

    const startGame = () => {
        initComponents()
        selectBombas()
        countNumberBomb()
    }

    const initComponents = () => {
        clearComponents()

        for (let i = 0; i < lines; i++) {
            bombas.push([])
            numberBomba.push([])
            campo.push([])

            for (let j = 0; j < columns; j++) {
                bombas[i][j] = false
                numberBomba[i][j] = 0
                campo[i][j] = false
            }
        }
    }

    const clearComponents = () => {
        bombas.splice(0, bombas.length)
        numberBomba.splice(0, numberBomba.length)
        campo.splice(0, campo.length)
    }

    const selectBombas = () => {
        const qtdBombas = 10

        for (let i = 0; i < qtdBombas; i++) {
            const x = Math.round(Math.random() * (lines - 1))
            const y = Math.round(Math.random() * (columns - 1))

            if (bombas[x][y]) {
                i--
                continue
            }

            bombas[x][y] = true
        }
    }

    const countNumberBomb = () => {
        const incrementNumber = (x, y) => {
            for (let i = -1; i < 2; i++) {
                for (let j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) { continue }

                    let indexX = x + i
                    let indexY = y + j

                    if (indexX < 0 || indexX > lines - 1) { continue }

                    if (indexY < 0 || indexY > columns - 1) { continue }

                    if (bombas[indexX][indexY]) { continue }

                    numberBomba[indexX][indexY]++
                }
            }
        }

        for (let i = 0; i < lines; i++) {
            for (let j = 0; j < columns; j++) {
                if (!bombas[i][j]) { continue }

                incrementNumber(i, j)
            }
        }
    }

    const clickCampo = (x, y) => {
        openCampo(x, y)

        if (bombas[x][y]) {
            gameOver()
            return
        }

        openCampos(x, y)
    }

    const openCampo = (x, y) => {
        campo[x][y] = true
    }

    const openCampos = (x, y) => {
        if (numberBomba[x][y] > 0) { return }

        for (let i = -1; i < 2; i++) {
            for (let j = -1; j < 2; j++) {
                if (i == 0 && j == 0) { continue }

                let indexX = x + i
                let indexY = y + j

                if (indexX < 0 || indexX > lines - 1) { continue }

                if (indexY < 0 || indexY > columns - 1) { continue }

                if (campo[indexX][indexY]) { continue }

                openCampo(indexX, indexY)
                openCampos(indexX, indexY)
            }
        }
    }

    const gameOver = () => {
        console.log("Game Over")
    }

    return {
        startGame,
        clickCampo,
        campo,
        bombas,
        numberBomba
    }
}

const game = Game()

const start = () => {
    game.startGame()

    game.clickCampo(3, 2)

    createCampo()
}

const createCampo = () => {
    console.log(game.campo)
}

start()