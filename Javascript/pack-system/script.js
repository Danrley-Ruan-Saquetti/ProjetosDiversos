const LENGTH_CARDS_FOR_NAIPE = 13
const LENGTH_NAIPES = 4
const LENGTH_CARDS = LENGTH_NAIPES * LENGTH_CARDS_FOR_NAIPE
const INCREASE_PERC = .1

let game = null

function StartGame() {
    console.clear()
    console.log("\nConsole: New Game!")
    game = Game()

    const LENGTH_PLAYERS = Math.round(Math.random() * 8) + 1

    const _dealerSelected = Math.round(Math.random() * (LENGTH_PLAYERS - 1))

    for (let i = 0; i < LENGTH_PLAYERS; i++) {
        game.createPlayer(_dealerSelected == i)
    }
    console.log(game.state.players)
}

function NextMath() {
    if (game == null) {
        console.log("Console: Por favor, clique em iniciar jogo antes de começar a partida!")
        return
    }
    if (game.state.runningMath) {
        console.log("Console: Por favor, Espere a partida acabar ou inicie uma novo jogo para uma nova partida!")
        return
    }
    console.clear()
    console.log("\nConsole: NEW MATH!")
    game.newMath()
    ui()
}

function NextRound() {
    if (game == null) {
        console.log("Console: Por favor, clique em iniciar jogo antes de passar a rodada!")
        return
    }
    if (!game.state.runningMath) {
        console.log("Console: Por favor, clique em iniciar partida antes de passar a rodada!")
        return
    }
    console.log("\n\nConsole: NEW ROUND!")
    game.nextRound()
    ui()
}

function test() {
    console.clear()
    game.classifyPlayers()
}

function ui() {
    console.log(`\nConsole: Cards of the each Player`);
    Object.keys(game.state.players).map((i) => {
        console.log(game.state.players[i]);
        Object.keys(game.state.players[i].cards).map((j) => {
            console.log(game.state.players[i].cards[j]);
        })
        console.log("")
    })

    console.log(`Console: Cards of the Table`);
    Object.keys(game.state.cardsTable).map((i) => {
        console.log(game.state.cardsTable[i]);
        console.log("");
    })
}

window.onload = () => {
    document.getElementById("start-game").addEventListener("click", StartGame)
    document.getElementById("next-math").addEventListener("click", NextMath)
    document.getElementById("next-round").addEventListener("click", NextRound)
}
