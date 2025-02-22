function Pack() {
    const controlCard = Card()

    const pack = controlCard.cards

    const createPack = () => {
        for (let i = 1; i <= LENGTH_NAIPES; i++) {
            for (let j = 1; j <= LENGTH_CARDS_FOR_NAIPE; j++) {
                controlCard.createCard({ number: j, naipe: i, })
            }
        }
    }

    const shufflePack = () => {
        Object.keys(pack).map((i) => {
            if (!pack[i].use) { return }
            controlCard.cards[i].use = false
        })
    }

    return {
        pack,
        createPack,
        shufflePack,
    }
}
