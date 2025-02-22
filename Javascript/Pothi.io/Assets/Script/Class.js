class Player {
    constructor() {
        this.size = 30;
        this.x = (((canvas.clientWidth + (canvas.clientLeft * 2)) - this.size) / 2);
        this.y = (((canvas.clientHeight + (canvas.clientTop * 2)) - this.size) / 2);
        this.color = "#ff0000";
        this.accX = 0;
        this.accY = 0;
        this.vida = 3;
        this.score = 0;
        this.PoliciaDestruida = 0;
        this.cooldownDesh = 0;
    }
}

class Policia {
    constructor() {
        this.size = 30;
        do {
            this.x = Math.floor(Math.random() * ((canvas.clientLeft + canvas.clientWidth - 10) - (canvas.clientLeft + 10)));
        } while (this.x + (this.size + 100) > player.x && this.x - 100 < player.x + player.size);
        do {
            this.y = Math.floor(Math.random() * ((canvas.clientTop + canvas.clientHeight - 10) - (canvas.clientTop + 10)));
        } while (this.y + (this.size + 100) > player.y && this.y - 100 < player.y + player.size);
        this.color = "#fff";
    }
}

class Moeda {
    constructor() {
        this.size = 15;
        do {
            this.x = Math.floor(Math.random() * ((canvas.clientLeft + canvas.clientWidth - 10) - (canvas.clientLeft + 10)));
        } while (this.x + this.size > player.x && this.x < player.x + player.size);
        do {
            this.y = Math.floor(Math.random() * ((canvas.clientTop + canvas.clientHeight - 10) - (canvas.clientTop + 10)));
        } while (this.y + this.size > player.y && this.y < player.y + player.size);
        this.color = "#ffff00";
    }
}