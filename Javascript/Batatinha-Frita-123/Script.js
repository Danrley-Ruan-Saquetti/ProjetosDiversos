var players = [];
var canvas, ctx;
var largada, chegada;
var timer, correr, parar, controlCorrer, controlPlay;

class Player {
    constructor(chave, letra) {
        this.x = Math.floor(Math.random() * (largada - 20 - 30));
        this.y = Math.floor(Math.random() * (620 - 260));
        this.acc = 0;
        this.chave = chave;
        this.letra = letra;
        this.status = 0;
        this.vitorias = 0;
        this.freio = true;
    }

    resetarPos() {
        this.x = Math.floor(Math.random() * (largada - 20 - 30));
        this.y = Math.floor(Math.random() * (620 - 260));
        this.status = 0;
        this.freio = true;
    }
}

function setup() {
    document.getElementById("rodape").style.top = (window.innerHeight - document.getElementById("rodape").clientHeight - 10) + "px";

    controlPlay = 0;
    document.getElementById("restart").addEventListener("click", () => {
        var qtd_Player = document.getElementById("qtd_player").value;
        if (qtd_Player != undefined) {
            addPlayer(qtd_Player);
        }
        if (players.length == 0) {
            alert("Informe pelo menos um player para jogar!");
        } else {
            if (controlPlay == 0) {
                var play = document.createElement("button");
                var par = document.createElement("p");
                var texto = document.createTextNode("Play");

                par.appendChild(texto);
                play.appendChild(par);

                var can = document.getElementById("canvas");
                document.body.insertBefore(play, can);
                play.setAttribute("id", "start");
                var playButton = document.getElementById("start");
                playButton.style.position = "absolute";
                playButton.style.padding = "5px";
                playButton.style.left = "370px";
                playButton.style.top = "3px";
                playButton.style.outline = "none";
            }
            controlPlay++;
        }
    });
    if (controlPlay > 0) {
        document.getElementById("start").addEventListener("click", () => {
            canvas = document.getElementById("canvas");
            ctx = canvas.getContext("2d");
            largada = 100;
            chegada = 1100;
            timer = 60;
            correr = 5;
            controlCorrer = true;
            parar = 0;

            setInterval(verChegada, 1000 / 120);
            setInterval(draw, 1000 / 120);
            setInterval(verMovimento, 1000 / 120);
            setInterval(passarTempo, 1000);
            setInterval(acelerar, 1000 / 30);
            setInterval(frear, 1000 / 30);
            setInterval(mover, 1000 / 30);

            document.addEventListener("keydown", () => {
                for (var i = 0; i < players.length; i++) {
                    if (players[i].chave == event.keyCode) {
                        if (players[i].status == 0) {
                            players[i].freio = false;
                        }
                    }
                }
            });
            document.addEventListener("keyup", () => {
                for (var i = 0; i < players.length; i++) {
                    if (players[i].chave == event.keyCode) {
                        players[i].freio = true;
                    }
                }
            });

        });
    }

}

function frear() {
    for (var i = 0; i < players.length; i++) {
        if (players[i].acc > 0 && players[i].freio) {
            players[i].acc -= 0.1;
        } else if (players[i].acc < 0) {
            players[i].acc = 0;
        }
    }
}

function mover() {
    for (var i = 0; i < players.length; i++) {
        if (!players[i].freio) {
            if (players[i].status == 0) {
                if (players[i].acc < 2) {
                    players[i].acc += 0.5;
                    players[i].freio = false;
                }
            } else {
                players[i].freio = true;
            }
        }
    }
}

function acelerar() {
    for (var i = 0; i < players.length; i++) {
        players[i].x += players[i].acc;
    }
}

function pararMover() {
    for (var i = 0; i < players.length; i++) {
        if (players[i].chave == event.keyCode) {
            players[i].acc -= 0.1;
            players[i].freio = true;
        }
    }
}

function passarTempo() {
    if (timer > 0) {
        if (controlCorrer) {
            if (correr > 0) {
                correr--;
            } else {
                parar = 5;
                controlCorrer = false;
            }
        } else {
            if (parar > 0) {
                parar--;
            } else {
                correr = 5;
                controlCorrer = true;
            }
        }
        timer--;
        if (timer == 0) {
            for (var i = 0; i < players.length; i++) {
                if (players[i].status == 0) {
                    matarPlayer(i);
                }
            }
            resetar();
        }
    }
}

function contagem() {
    ctx.font = "30px monospace";
    ctx.fillStyle = "#fff";
    ctx.fillText("Tempo: " + timer, 550, 30);
}

function verMovimento() {
    if (!controlCorrer) {
        for (var i = 0; i < players.length; i++) {
            if (players[i].x > largada && players[i].acc != 0 && players[i].status == 0) {
                matarPlayer(i);
            }
        }
    }
}

function matarPlayer(i) {
    players[i].status = 2;
}

function verChegada() {
    var resete = true;
    for (var i = 0; i < players.length; i++) {
        if (players[i].status == 0) {
            if (players[i].x >= chegada) {
                players[i].status = 1;
                players[i].vitorias++;
            } else {
                resete = false;
            }
        }
    }
    if (resete) {
        resetar();
    }
}

function resetar() {
    for (var i = 0; i < players.length; i++) {
        players[i].resetarPos();
    }
    timer = 60;
    controlCorrer = true;
    correr = 5;
    parar = 0;
}

function addPlayer(qtd) {
    players = [];
    for (var i = 0; i < qtd; i++) {
        var cha = 0,
            letr;
        switch (i) {
            case 0:
                cha = 81; //q
                letr = "Q";
                break;
            case 1:
                cha = 77; //m
                letr = "M";
                break;
            case 2:
                cha = 90; //z
                letr = "Z";
                break;
            case 3:
                cha = 32; //espace
                letr = "-";
                break;
            case 4:
                cha = 80; //p
                letr = "P";
                break;
        }
        var pla = new Player(cha, letr);
        players.push(pla);
    }
}

function draw() {
    drawRect(0, 0, 1300, 990, "#000");
    drawRect(largada, 0, 5, 990, "#fff");
    drawRect(chegada, 0, 5, 990, "#fff");

    for (var i = 0; i < players.length; i++) {
        color = "#002aff";
        switch (players[i].status) {
            case 1:
                color = "#01ff01";
                break;
            case 2:
                color = "#ff0101";
                break;
        }
        drawRect(players[i].x - 1, players[i].y - 1, 22, 22, "#000");
        drawRect(players[i].x, players[i].y, 20, 20, color);
        ctx.font = "14px monospace";
        ctx.fillStyle = "#fff";
        ctx.fillText(players[i].letra, players[i].x + 6, players[i].y + 14);
    }
    contagem();
}

function drawRect(x, y, w, h, color) {
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);

    //Ranking
    ctx.font = "15px monospace";
    ctx.fillStyle = "#fff";
    ctx.fillText("Chave - Nº de Vitórias", chegada + 10, 16);
    var linhas = 34;
    for (var i = 0; i < players.length; i++) {
        ctx.fillText(players[i].letra + "  -  " + players[i].vitorias, chegada + 10, linhas);
        linhas += 17;
    }

    ctx.font = "70px monospace";
    if (controlCorrer) {
        ctx.fillStyle = "#01ff01";
    } else {
        ctx.fillStyle = "#ff0101";
    }
    var time = 0;
    if (controlCorrer) {
        time = correr;
    } else {
        time = parar;
    }
    ctx.fillText(time, chegada + 87, 217);
}


window.addEventListener("load", setup);