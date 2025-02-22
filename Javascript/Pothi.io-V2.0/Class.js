class Player {
    constructor(x, y, size, color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.acc = { x: 0, y: 0 };
        this.score = 0;
        this.cooldownDesh = 0;
        this.vidas = 3;
    }

    draw() {
        ctx.fillStyle = this.color;
        ctx.fillRect(this.x, this.y, this.size, this.size);
    }

    update() {
        this.draw();
        this.x += this.acc.x;
        this.y += this.acc.y;

        if (this.acc.x > 3 || this.acc.x < -3) {
            this.acc.x *= 0.99;
        }
        if (this.acc.y > 3 || this.acc.y < -3) {
            this.acc.y *= 0.99;
        }
    }
}

class Projetil {
    constructor(x, y, radius, color, speed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.speed = speed;
    }

    draw() {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 10, false);
        ctx.fillStyle = this.color;
        ctx.fill();
    }

    update() {
        this.draw();
        this.x = this.x + this.speed.x
        this.y = this.y + this.speed.y
    }
}

class Policia {
    constructor(x, y, size, color, id) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.id = id;
    }

    draw() {
        ctx.fillStyle = this.color;
        ctx.fillRect(this.x, this.y, this.size, this.size);
    }

    update() {
        this.draw();
        if ((player.x > this.x) &&
            (player.x - this.x >= 1 || player.x - this.x <= -1)) {
            this.x += 1.5;
        } else if ((player.x < this.x) &&
            (player.x - this.x >= 1 || player.x - this.x <= -1)) {
            this.x -= 1.5;
        }
        if ((player.y > this.y) &&
            (player.y - this.y >= 1 || player.y - this.y <= -1)) {
            this.y += 1.5;
        } else if ((player.y < this.y) &&
            (player.y - this.y >= 1 || player.y - this.y <= -1)) {
            this.y -= 1.5;
        }
    }
}

class Moeda {
    constructor(x, y, size, color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    draw() {
        ctx.fillStyle = this.color;
        ctx.fillRect(this.x, this.y, this.size, this.size);
    }
}