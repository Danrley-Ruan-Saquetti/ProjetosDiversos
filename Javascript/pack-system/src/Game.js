function Game() {
    const controlPack = Pack()
    const controlPlayer = Player()

    const POINTS = {
        royalStraightFlush: LENGTH_CARDS_FOR_NAIPE * 9,
        straightFlush: LENGTH_CARDS_FOR_NAIPE * 8,
        four: LENGTH_CARDS_FOR_NAIPE * 7,
        fullHouse: LENGTH_CARDS_FOR_NAIPE * 6,
        flush: LENGTH_CARDS_FOR_NAIPE * 5,
        straight: LENGTH_CARDS_FOR_NAIPE * 4,
        three: LENGTH_CARDS_FOR_NAIPE * 3,
        twoPairs: LENGTH_CARDS_FOR_NAIPE * 2,
        pair: LENGTH_CARDS_FOR_NAIPE * 1,
        highCard: LENGTH_CARDS_FOR_NAIPE * 0,
    }
    const nameClassification = (command) => {
        console.log(command);
        if (command.points < POINTS.pair) {
            return "High Card"
        }
        if (command.points < POINTS.twoPairs) {
            return "Pair"
        }
        if (command.points < POINTS.three) {
            return "Two Pair"
        }
        if (command.points < POINTS.straight) {
            return "Three"
        }
        if (command.points < POINTS.flush) {
            return "Straight"
        }
        if (command.points < POINTS.fullHouse) {
            return "Flush"
        }
        if (command.points < POINTS.four) {
            return "Full House"
        }
        if (command.points < POINTS.straightFlush) {
            return "Four"
        }
        if (command.points < POINTS.royalStraightFlush) {
            return "Straight Flush"
        }
        return "Royal Straight Flush"
    }

    const state = {
        pack: controlPack.pack,
        cardsTable: {},
        players: controlPlayer.players,
        pot: 0,
        blind: 100,
        runningMath: false,
        round: 0,
        maths: 0,
    }

    const createPlayer = (dealerStart = false) => {
        controlPlayer.createUser(dealerStart)
    }

    const getCard = () => {
        let card = null
        do {
            const number = Math.round(Math.random() * (LENGTH_CARDS_FOR_NAIPE - 1)) + 1
            const naipe = Math.round(Math.random() * (LENGTH_NAIPES - 1)) + 1

            const index = `${number}${naipe}`

            card = state.pack[index]
        } while (card.use || card == null)
        card.use = true

        return card
    }

    const distributeCards = () => {
        const LENGTH_CARD_FOR_PLAYER = 2

        for (let i = 0; i < LENGTH_CARD_FOR_PLAYER; i++) {
            Object.keys(state.players).map((j) => {
                const card = getCard()
                controlPlayer.addCard({ idPlayer: state.players[j].id, card })
            })
        }
    }

    const newMath = () => {
        const oldDealer = controlPlayer.getDealer()

        state.round = 0
        state.pot = 0
        state.runningMath = true
        state.cardsTable = {}
        state.maths++
            state.blind *= state.maths % 4 == 0 ? 2 : 1
        state.players[oldDealer].dealer = false
        state.players[oldDealer + 1 == controlPlayer.getLengthPlayers() ? 0 : oldDealer + 1].dealer = true

        const _smallSelected = controlPlayer.getSmall(controlPlayer.getDealer(), controlPlayer.getLengthPlayers())
        const _bigSelected = controlPlayer.getBig(controlPlayer.getDealer(), controlPlayer.getLengthPlayers())

        console.log(`Game: Dealer selected ${controlPlayer.getDealer()}\nSmall selected ${_smallSelected}\nBig selected ${_bigSelected}`)

        controlPlayer.clearHand()
        controlPack.shufflePack()
        distributeCards()
        payBlind()
    }

    const nextRound = () => {
        if (state.runningMath) {
            roundBets(state.round == 0)
            turnCards()
            classifyPlayers()

            Object.keys(state.players).map((i) => {
                controlPlayer.players[i].valuePayed = 0
            })
            state.round++
                if (controlPlayer.getContPlayersPlaying() <= 1 || state.round == 3) {
                    const winners = winner().winners
                    const VALUE_FOREACH_PLAYER = state.pot / winners.length

                    for (let i = 0; i < winners.length; i++) {
                        if (winners.length != 1) { console.log(`Console: Tier!`); }

                        state.players[winners[i].index].balance += VALUE_FOREACH_PLAYER
                        console.log(`Console: Player ${state.players[winners[i].index].name} winner!`);
                        if (controlPlayer.getContPlayersPlaying() > 1) {
                            console.log(`Console: ${nameClassification({points: state.players[winners[i].index].points})}!`);
                        }
                    }

                    state.runningMath = false
                }
        } else {
            console.log("Game: A partida acabou")
        }
    }

    const turnCards = () => {
        const card = getCard()
        state.cardsTable[card.id] = card

        if (state.round == 0) {
            for (let i = 0; i < 2; i++) {
                const otherCard = getCard()
                state.cardsTable[otherCard.id] = otherCard
            }
        }
    }

    const winner = () => {
        const winners = [{ points: -1, index: null }]
        const setWinner = (command, newBiggest = false) => {
            if (newBiggest) { winners.splice(0, winners.length) }
            winners.push({ points: command.points, index: command.index })
        }

        Object.keys(state.players).map((i) => {
            if (!state.players[i].playing || state.players[i].points < winners[0].points) { return }

            if (state.players[i].points == winners[0].points) { // Tier Hand
                if (state.players[i].highCard == state.players[winners[0].index].highCard) { // Tier Card
                    if (state.players[i].highCardHand == state.players[winners[0].index].highCardHand) { // Tier Hand / Split Pot
                        setWinner({ points: state.players[i].points, index: i })
                    } else if (state.players[i].highCardHand > state.players[winners[0].index].highCardHand) { // Hand Card Biggest
                        setWinner({ points: state.players[i].points, index: i }, true)
                    }
                } else if (state.players[i].highCard > state.players[winners[0].index].highCard) { // Card Biggest
                    setWinner({ points: state.players[i].points, index: i }, true)
                }
            } else if (state.players[i].points > winners[0].points) { // Card Biggest
                setWinner({ points: state.players[i].points, index: i }, true)
            }
        })

        return { winners }
    }

    const classifyPlayers = () => {
        Object.keys(state.players).map((i) => {
            if (!state.players[i].playing) { return }
            controlPlayer.players[i].points = classifyCards({ cards: state.players[i].cards, id: i })
        })
    }

    const classifyCards = (command) => {
        const getTotalCards = () => {
            const cards = []
            let highCardHand = -1
            Object.keys(command.cards).map((i) => {
                cards.push(command.cards[i])
                if (highCardHand < command.cards[i].number) {
                    highCardHand = command.cards[i].number
                }
            })
            Object.keys(state.cardsTable).map((i) => {
                cards.push(state.cardsTable[i])
            })

            return { cards, highCardHand }
        }

        let points = 0
        const totalCards = getTotalCards()
        const cards = totalCards.cards
        const highCardHand = totalCards.highCardHand
        let highCard = -1

        let _contPar = []
        for (let i = 0; i < cards.length - 1; i++) {
            const card1 = cards[i]

            if (highCard < card1.number) {
                highCard = card1.number
            }

            let _acceptNumber = true

            for (let i = 0; i < _contPar.length; i++) {
                if (_contPar[i].number == card1.number) {
                    _acceptNumber = false
                    break
                }
            }

            if (!_acceptNumber) { continue }

            for (let j = i + 1; j < cards.length; j++) {
                const card2 = cards[j]
                if (card1.number != card2.number) { continue }

                // Cont Pars/Three/Four
                let _validNumber = true
                for (let k = 0; k < _contPar.length; k++) {
                    if (_contPar[k].number == card1.number) {
                        _contPar[k].cont++
                            _validNumber = false
                        break
                    }
                }
                if (_validNumber) {
                    _contPar.push({ number: card1.number, cont: 2 })
                }
            }
        }

        let _validPar = { number: null, valid: false }
        let _validTwoPar = { numbers: { 1: null, 2: null }, valid: false }
        let _validThree = { number: null, valid: false }
        let _validFour = { number: null, valid: false }
        for (let i = 0; i < _contPar.length; i++) {
            switch (_contPar[i].cont) {
                case 2:
                    if (_validTwoPar.valid) {
                        if (_validTwoPar.numbers[1] < _contPar[i].number) {
                            _validTwoPar.numbers[1] = _contPar[i].number
                        } else if (_validTwoPar.numbers[2] < _contPar[i].number) {
                            _validTwoPar.numbers[2] = _contPar[i].number
                        }
                        continue
                    }
                    if (_validPar.valid) {
                        _validTwoPar.valid = true
                        _validTwoPar.numbers[1] = _contPar[i].number
                        _validTwoPar.numbers[2] = _validPar.number

                        _validPar.valid = false
                        _validPar.number = null
                        continue
                    }
                    _validPar.valid = true
                    _validPar.number = _contPar[i].number
                    continue
                case 3:
                    if (_validThree.number < _contPar[i].number) { continue }
                    _validThree.valid = true
                    _validThree.number = _contPar[i].number
                    continue
                case 4:
                    _validFour.valid = true
                    _validFour.number = _contPar[i].number
                    continue
            }
        }

        if (_validFour.valid) { // Four
            points = POINTS.four + _validFour.number
        } else {
            if (_validThree.valid && _validPar.valid) { // Full House
                let _numberBiggest = -1
                if (_validThree.number > _validPar.number) {
                    _numberBiggest = _validThree.number
                } else {
                    _numberBiggest = _validPar.number
                }

                points = POINTS.fullHouse + _numberBiggest
            } else {
                if (_validThree.valid) { // Three
                    points = POINTS.three + _validThree.number
                } else {
                    if (_validTwoPar.valid) { // Two Pairs
                        let _numberBiggest = -1
                        if (_validTwoPar.numbers[1] > _validTwoPar.numbers[2]) {
                            _numberBiggest = _validTwoPar.numbers[1]
                        } else {
                            _numberBiggest = _validTwoPar.numbers[2]
                        }

                        points = POINTS.twoPairs + _numberBiggest
                    } else {
                        if (_validPar.valid) { // Pair
                            points = POINTS.pair + _validPar.number
                        }
                    }
                }
            }
        }

        controlPlayer.players[command.id].highCard = highCard
        controlPlayer.players[command.id].highCardHand = highCardHand

        return points
    }

    const roundBets = (firstRound = false) => {
        let _checkpoint = firstRound ? controlPlayer.getNextBig(controlPlayer.getBig(controlPlayer.getDealer())) : controlPlayer.getSmall(controlPlayer.getDealer())
        let valueRound = 0
        let _valueCheckpoint = firstRound ? state.blind : 0
        let _contPlayersPayed = 0

        for (let i = _checkpoint; i < controlPlayer.getLengthPlayers(); i++) {
            if (!state.players[i].playing) { continue }
            if (state.players[i].balance <= 0) { continue }
            if (_contPlayersPayed == controlPlayer.getContPlayersPlaying()) { break }

            console.log(`\nGame: Value to pay ${_valueCheckpoint}`)

            let _valueAccept = false
            do {
                let valueAction
                let _actionAccept
                do {
                    _actionAccept = true
                    valueAction = Math.round(Math.random() * 4) + 1

                    if ((valueAction == 2 && _valueCheckpoint != 0) ||
                        (valueAction == 3 && _valueCheckpoint == state.players[i].valuePayed) ||
                        (valueAction == 1 && controlPlayer.getContPlayersPlaying() == 1)) {
                        _actionAccept = false
                    }
                } while (!_actionAccept)

                switch (valueAction) {
                    case 1:
                        { // give up
                            if (Math.random() * 100 < 50) {
                                controlPlayer.giveUp({ id: state.players[i].id })
                                console.log(`Game: Player ${state.players[i].name} give up`)
                                _valueAccept = true
                            }
                            break
                        }
                    case 2:
                        { // pass
                            console.log(`Game: Player ${state.players[i].name} pass`)
                            _valueAccept = true
                            _contPlayersPayed++
                            break
                        }
                    case 3:
                        { // pay
                            const valuePay = _valueCheckpoint - state.players[i].valuePayed
                            controlPlayer.payValue({ id: state.players[i].id, value: valuePay })
                            console.log(`Game: Player ${state.players[i].name} ${state.players[i].balance == 0 ? "all-in" : "pay " + valuePay}`)
                            valueRound += valuePay
                            _valueAccept = true
                            _contPlayersPayed++
                            break
                        }
                    case 4:
                        { // increase
                            if (Math.random() * 100 < 25) {
                                const VALUE_INCREASED = Math.abs(Math.round(Math.random() * ((state.players[i].balance * INCREASE_PERC) - (_valueCheckpoint - state.players[i].valuePayed)))) + 1
                                _valueCheckpoint += VALUE_INCREASED
                                controlPlayer.payValue({ id: state.players[i].id, value: _valueCheckpoint })
                                console.log(`Game: Player ${state.players[i].name} ${state.players[i].balance == 0 ? "all-in" : "increase " + VALUE_INCREASED}`)
                                _checkpoint = state.players[i].id
                                _valueAccept = true
                                _contPlayersPayed = 1
                                valueRound += _valueCheckpoint
                            }
                            break
                        }
                    case 5:
                        { // all-in
                            if (Math.random() * 100 < 5) {
                                _valueCheckpoint += state.players[i].balance
                                valueRound += _valueCheckpoint
                                controlPlayer.payValue({ id: state.players[i].id, value: state.players[i].balance })
                                console.log(`Game: Player ${state.players[i].name} all-in`)
                                _checkpoint = state.players[i].id
                                _valueAccept = true
                                _contPlayersPayed = 1
                            }
                            break
                        }
                }
            } while (!_valueAccept)

            if (i + 1 == controlPlayer.getLengthPlayers() && _contPlayersPayed != controlPlayer.getLengthPlayers()) {
                i = -1
            }
        }

        state.pot += valueRound
        console.log(`\nGame: Pot value ${state.pot}`)
    }

    const payBlind = () => {
        controlPlayer.payValue({ id: controlPlayer.getSmall(controlPlayer.getDealer()), value: state.blind / 2 })
        controlPlayer.payValue({ id: controlPlayer.getBig(controlPlayer.getDealer()), value: state.blind })
        console.log(`Game: ${controlPlayer.getSmall(controlPlayer.getDealer())} pay small ${state.blind / 2}\n${controlPlayer.getBig(controlPlayer.getDealer())} pay big ${state.blind}`)
    }

    controlPack.createPack()

    return {
        state,
        createPlayer,
        newMath,
        nextRound,
        classifyPlayers,
    }
}
