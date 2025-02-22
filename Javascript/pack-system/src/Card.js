function Card() {
    const cards = {}

    const createCard = (command) => {
        const use = command.use ? command.use : false
        const number = command.number
        const naipe = command.naipe
        const id = `${number}${naipe}`

        cards[id] = { id, number, naipe, use }
    }

    return {
        cards,
        createCard,
    }
}
