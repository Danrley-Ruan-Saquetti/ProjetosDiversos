const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

canvas.width = innerWidth;
canvas.height = 200;

document.getElementById("estatisticas").style.left = canvas.width / 2.3 + "px";
document.getElementById("estatisticas").style.top = canvas.top + "px";

let mapa;
let players;
let game;

let keys = {
    key: [
        'q', 'z', 'p', 'm', ';'
    ],
    keyCode: [
        '81', '90', '80', '77', '191', '', '', '', '', '', '', '', '', '', ''
    ]
}
let instervalos;
let animateFrame;

function setup() {
    mapa = new Mapa({ x: 0, y: 0 }, { w: canvas.width, h: canvas.height })
    players = [];
    game = new Game();
    instervalos = {};

    for (let i = 0; i < 5; i++) {
        let dim = { w: 15, h: 15 },
            pos = { x: Math.floor(Math.random() * (mapa.largada - dim.w)), y: Math.floor(Math.random() * (mapa.dim.h - dim.h)) },
            color = { estado: "#0000ff", neutro: "#0000ff", ganhou: "#00ff00", perdeu: "#ff0000" },
            speed = { x: 0 },
            codigo = { key: keys.key[i], keyCode: keys.keyCode[i] };

        players.push(new Player(pos, dim, codigo, color, speed));
    }

    animate();
    intervalo();

    addEventListener("keydown", (ev) => {
        for (let i = 0; i < players.length; i++) {
            if (players[i].codigo.keyCode == ev.keyCode) {
                players[i].key = true;
            }
        }
    });

    addEventListener("keyup", (ev) => {
        for (let i = 0; i < players.length; i++) {
            if (players[i].codigo.keyCode == ev.keyCode) {
                players[i].key = false;
            }
        }
    });
}

function intervalo() {
    instervalos.a = setInterval(() => {
        let avanco = { estado: "Avancar: ", tempo: 0, color: "#00ff00" };
        if (game.duracao == 0) {
            gameEnd();
        } else {
            game.duracao--;
            if (game.avanco.avancar > 0) {
                game.avanco.avancar--;
                if (game.avanco.avancar == 0) {
                    game.avanco.parar = 6;
                }
                avanco.tempo = game.avanco.avancar;
            } else if (game.avanco.parar > 0) {
                game.avanco.parar--;
                if (game.avanco.parar == 0) {
                    game.avanco.avancar = 6;
                }
                avanco.estado = "Parar: ";
                avanco.tempo = game.avanco.parar;
                avanco.color = "#ff0000";
            }
        }
        document.getElementById("tempo").innerHTML = game.duracao;
        document.getElementById("estado-avanco").innerHTML = avanco.estado;
        document.getElementById("tempo-avanco").innerHTML = avanco.tempo;
        document.getElementById("estado-avanco").style.color = avanco.color
        document.getElementById("tempo-avanco").style.color = avanco.color
    }, 1000);
}

function playerMove() {
    for (let i = 0; i < players.length; i++) {
        if (players[i].state == 0) {
            if (players[i].key) {
                if (players[i].speed.x < 1) {
                    players[i].speed.x += .02;
                } else {
                    players[i].speed.x = 1;
                }
            } else {
                if (players[i].speed.x > .02) {
                    players[i].speed.x -= .02;
                } else {
                    players[i].speed.x = 0;
                }
            }
        } else {
            if (players[i].speed.x > .02) {
                players[i].speed.x -= .02;
            } else {
                players[i].speed.x = 0;
            }
        }
    }
}

function animate() {
    animateFrame = requestAnimationFrame(animate);
    ctx.clearRect(canvas.clientLeft, canvas.clientTop, canvas.width, canvas.height);

    mapa.draw();

    playerMove();

    let endGame = true;
    for (let i = 0; i < players.length; i++) {
        const player = players[i];

        if (player.state == 0) {
            if (player.pos.x + player.dim.w > mapa.largada + 10) {
                if (player.speed.x != 0 && game.avanco.parar != 0) {
                    player.state = 2;
                } else if (player.pos.x + player.dim.w >= mapa.chegada) {
                    player.state = 1;
                    player.vitorias++;
                }
            }
        }
        if (player.state == 0) {
            endGame = false;
        }

        player.update();
    }

    if (endGame) {
        gameEnd();
    }
}

function gameEnd() {
    cancelAnimationFrame(animateFrame);
    clearInterval(instervalos.a);
    let i = setInterval(() => {
        ctx.clearRect(canvas.clientLeft, canvas.clientTop, canvas.width, canvas.height);
        mapa.draw();
        playerMove();
        for (let i = 0; i < players.length; i++) {
            const player = players[i];
            player.update();
        }
    }, 1000 / 60);
    setTimeout(() => {
        clearInterval(i);
        setup();
    }, 5000);
}


window.addEventListener("load", setup);