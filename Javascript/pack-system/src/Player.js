function Player() {
    const players = {}

    const createUser = (dealerStart) => {
        const id = `${getLengthPlayers()}`
        const name = `Guest_${id}`
        const cards = {}
        const balance = 50000
        const dealer = dealerStart
        const playing = true
        const pointsHands = 0
        const valuePayed = 0
        const highCard = null
        const highCardHand = null

        players[id] = { id, name, cards, balance, playing, dealer, pointsHands, valuePayed, highCard, highCardHand }
    }

    const addCard = (command) => {
        players[command.idPlayer].cards[command.card.id] = command.card
    }

    const giveUp = (command) => {
        players[command.id].playing = false
    }

    const getLengthPlayers = () => {
        let contPlayers = 0
        Object.keys(players).map((i) => contPlayers++)

        return contPlayers
    }

    const getContPlayersPlaying = () => {
        let contPlayers = 0
        Object.keys(players).map((i) => { if (players[i].playing) { contPlayers++ } })

        return contPlayers
    }

    const clearHand = () => {
        Object.keys(players).map((i) => {
            players[i].cards = null
            players[i].playing = true
            players[i].cards = {}
            players[i].valuePayed = 0
            players[i].pointsHands = 0
            players[i].highCard = null
            players[i].highCardHand = null
        })
    }

    const payValue = (command) => {
        if (players[command.id].balance < command.value) { command.value = players[command.id].balance }
        players[command.id].balance -= command.value
        players[command.id].valuePayed += command.value
    }

    const getDealer = () => {
        let index = null
        Object.keys(players).map((i) => {
            if (players[i].dealer == true) {
                index = Number(i)
                return
            }
        })

        return index
    }

    const getSmall = (i, lengthPlayers = null) => {
        const _LENGTH_PLAYERS = lengthPlayers == null ? getLengthPlayers() : lengthPlayers
        return i + 1 == _LENGTH_PLAYERS ? 0 : i + 1
    }

    const getBig = (i, lengthPlayers = null) => {
        const _LENGTH_PLAYERS = lengthPlayers == null ? getLengthPlayers() : lengthPlayers
        return i + 2 == _LENGTH_PLAYERS ? 0 : i + 1 == _LENGTH_PLAYERS ? 1 : i + 2
    }

    const getNextBig = (i) => {
        return i + 1 == getLengthPlayers() ? 0 : i + 1
    }

    return {
        players,
        createUser,
        addCard,
        clearHand,
        getLengthPlayers,
        getContPlayersPlaying,
        payValue,
        giveUp,
        getDealer,
        getSmall,
        getBig,
        getNextBig,
    }
}
