const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")

const CARDS_FOR_COLOR = 4
const PLAYERS_MAX = 4 // 2 - 10
const CARDS_PLAYERS_MAX = 7 // Min 1
const NUMBERS_MAX = CARDS_FOR_COLOR * 20
const BUY_TWO_MAX = CARDS_FOR_COLOR * 2
const INVERT_MAX = CARDS_FOR_COLOR * 2
const SKIP_MAX = CARDS_FOR_COLOR * 2
const TOUCH_COLOR_MAX = 4
const BUY_FOUR_MAX = 4

const CARDS_MAX =
    NUMBERS_MAX +
    BUY_TWO_MAX +
    INVERT_MAX +
    SKIP_MAX +
    TOUCH_COLOR_MAX +
    BUY_FOUR_MAX
const FPS = 1000 / 1
const WINDOW_DIMENSION = {
    width: () => {
        return innerWidth
    },
    height: () => {
        return innerHeight
    },
}
const SYMBOLS = {
    moreTwo: "+2",
    invert: "I",
    skip: ">",
    moreFour: "+4",
    touchColor: "X",
}
const GET_CARD = () => {
    let cardI
    do {
        cardI = Math.round(Math.random() * CARDS_MAX)
    } while (!findCard(cardI));
    return cardI
}

canvas.width = WINDOW_DIMENSION.width()
canvas.height = WINDOW_DIMENSION.height()

const cards = [new Array(CARDS_MAX), new Array(CARDS_MAX)]
const USE_CARDS = []

let players = new Player()
let pack = new Pack()

let running

function setup() {
    let cont = 0
    for (let i = 0; i < cards[0].length; i++) {
        let aggregation = ""
        if (i < NUMBERS_MAX) {
            if (cont % 10 == 0) {
                cont = 0
            }
            aggregation = "" + cont
            cont++
        } else if (i < NUMBERS_MAX + BUY_TWO_MAX + INVERT_MAX + SKIP_MAX) {
            if (i < NUMBERS_MAX + BUY_TWO_MAX) {
                aggregation = SYMBOLS.moreTwo
            } else if (i < NUMBERS_MAX + BUY_TWO_MAX + INVERT_MAX) {
                aggregation = SYMBOLS.invert
            } else {
                aggregation = SYMBOLS.skip
            }
        } else {
            if (i < CARDS_MAX - BUY_FOUR_MAX) {
                aggregation = SYMBOLS.moreFour
            } else {
                aggregation = SYMBOLS.touchColor
            }
        }
        cards[0][i] = aggregation
    }

    cont = 0
    for (let i = 0; i < cards[1].length; i++) {
        let aggregation = cont
        if (i < NUMBERS_MAX) {
            if (i % (NUMBERS_MAX / 4) == 0) { cont++ }
            aggregation = cont
        } else if (i < NUMBERS_MAX + BUY_TWO_MAX + INVERT_MAX + SKIP_MAX) {
            if (i < NUMBERS_MAX + BUY_TWO_MAX) {
                if (i % (BUY_TWO_MAX / 4) == 0) { cont++ }
                aggregation = cont
            } else if (i < NUMBERS_MAX + BUY_TWO_MAX + INVERT_MAX) {
                if (i % (INVERT_MAX / 4) == 0) { cont++ }
                aggregation = cont
            } else {
                if (i % (SKIP_MAX / 4) == 0) { cont++ }
                aggregation = cont
            }
        } else {
            if (i < CARDS_MAX - BUY_FOUR_MAX) {
                aggregation = cont + 1
            } else {
                aggregation = cont + 2
            }
        }

        cards[1][i] = aggregation
    }

    initial()
}

function initial() {
    players = []

    for (let i = 0; i < CARDS_MAX; i++) {
        USE_CARDS.push(true)
    }

    const listCardPlayers = []
    for (let i = 0; i < PLAYERS_MAX; i++) {
        listCardPlayers.push([])
    }
    for (let i = 0; i < CARDS_PLAYERS_MAX; i++) {
        for (let j = 0; j < PLAYERS_MAX; j++) {
            const cardI = GET_CARD()

            USE_CARDS[cardI] = false
            listCardPlayers[j].push(cardI)
        }
    }
    for (let i = 0; i < PLAYERS_MAX; i++) {
        players.push(new Player(listCardPlayers[i], i))
    }

    const cardUseList = []
    for (let i = 0; i < USE_CARDS.length; i++) {
        if (USE_CARDS[i]) {
            cardUseList.push(i)
        }
    }
    pack = new Pack(cardUseList, [GET_CARD()])


    let a, buyCard = 50
    do {
        let b = GET_CARD()
        a = pack.buyCard(b)

        players[0].cardList.push(a)
        buyCard--
    } while (buyCard != 0);


    console.log(players.length);

    for (let i = 0; i < players.length - 1; i++) {
        for (let j = 0; j < players[i].cardList.length; j++) {
            for (let k = 0; k < players[i + 1].cardList.length; k++) {
                if (players[i].cardList[j] == players[i + 1].cardList[k]) {
                    console.log(players[i].cardList[j], players[i + 1].cardList[k])
                }
                console.log(i, j, k);
            }
            console.log("");
        }
        console.log("");
    }

    // running = setInterval(animate, FPS)
}

function findCard(I) {
    if (!check_cards()) return USE_CARDS[I] == true
}

function check_cards() {
    for (let i = 0; i < USE_CARDS.length; i++) {
        if (USE_CARDS[i]) return false
    }
    return true
}

function animate() {
    ctx.fillStyle = "#fff"
    ctx.fillRect(
        canvas.clientLeft,
        canvas.clientTop,
        canvas.clientWidth,
        canvas.clientHeight
    )
}

window.onload = setup

/*

*/
