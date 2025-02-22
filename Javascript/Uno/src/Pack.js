class Pack {
    constructor(cardList, lot) {
        this.cardList = cardList
        this.lotList = lot
    }

    buyCard(I) {
        this.cardList[I] = false
        return I
    }
}
