class Game {
    constructor() {
        this.duracao = 120;
        this.avanco = { parar: 0, avancar: 5 };
    }
}

class Mapa {
    constructor(pos, dim) {
        this.pos = pos;
        this.dim = dim;
        this.largada = Math.floor(dim.w / 10);
        this.chegada = dim.w - Math.floor(dim.w / 10);
    }

    draw() {
        ctx.fillStyle = "black";
        ctx.fillRect(this.pos.x, this.pos.y, this.dim.w, this.dim.h);
        ctx.fillStyle = "white";
        ctx.fillRect(this.largada, this.pos.y, 5, this.dim.h);
        ctx.fillRect(this.chegada, this.pos.y, 5, this.dim.h);
    }
}

class Player {
    constructor(pos, dim, codigo, color, speed) {
        this.pos = pos;
        this.dim = dim;
        this.codigo = codigo;
        this.key = false;
        this.color = color;
        this.speed = speed;
        this.state = 0; //0 - jogando / 1 - ganhou / 2 - perdeu
        this.vitorias = 0;
    }

    draw() {
        ctx.fillStyle = "black";
        ctx.fillRect(this.pos.x - 1, this.pos.y - 1, this.dim.w + 2, this.dim.h + 2);
        ctx.fillStyle = this.color.estado;
        ctx.fillRect(this.pos.x, this.pos.y, this.dim.w, this.dim.h);
        ctx.font = "13px monospace";
        ctx.fillStyle = "white";
        ctx.fillText(`${this.codigo.key}`, this.pos.x + 1, this.pos.y + 11);
    }

    update() {
        this.pos.x += this.speed.x;

        if (this.state != 0) {
            if (this.state == 1) {
                this.color.estado = this.color.ganhou;
            } else {
                this.color.estado = this.color.perdeu;
            }
        }

        this.draw();
    }
}