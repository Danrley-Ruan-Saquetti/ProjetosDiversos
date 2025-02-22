const canvas = document.getElementById("canvas"),
    ctx = canvas.getContext("2d");
var player, policiais,
    moeda;
var tempoS, tempoM;
var tempDraw, tempTemporizador, tempCooldown, tempDeshOffX, tempDeshOffY, tempMoverPolicia, tempMoverPlayer, tempColetarMoeda, tempColidirPolicia, tempColidirPlayer;

function setup() {
    document.getElementById("menu").classList.remove("off");
    document.getElementById("menu").classList.toggle("on");
    document.getElementById("modos").classList.remove("onModos");
    document.getElementById("modos").classList.toggle("offModos");
    document.getElementById("comecar").addEventListener("click", () => {
        selecionarModo();
        var barra = document.getElementById("barra_lateral"),
            caixas = document.getElementById("controles_updates");

        barra.style.height = "60%";
        caixas.style.top = "70%";
    });
    audio(1);
}

function selecionarModo() {
    document.getElementById("modos").classList.remove("offModos");
    document.getElementById("modos").classList.toggle("onModos");
    document.getElementById("comecar").addEventListener("click", () => {
        document.getElementById("modos").classList.remove("onModos");
        document.getElementById("modos").classList.toggle("offModos");
    });
}

function startGame() {
    document.getElementById("menu").classList.remove("on");
    document.getElementById("menu").classList.toggle("off");
    document.getElementById("modos").classList.remove("onModos");
    document.getElementById("modos").classList.toggle("offModos");
    document.getElementById("comecar").removeEventListener("click", () => {});
    tempoS = tempoM = 0;

    player = new Player();
    moeda = new Moeda();
    policiais = [];
    for (var i = 0; i < 4; i++) {
        addPolicia();
    }

    ativarintervalo();

    document.addEventListener("keydown", (ev) => {
        if (player.cooldownDesh == 0 && ev.keyCode == 32) {
            if (player.accX != 0) {
                if (player.accX > 0) {
                    player.accX = 10;
                } else {
                    player.accX = -10;
                }
                player.accY = 0;
                player.cooldownDesh = 3;
                audio(3);
            } else if (player.accY != 0) {
                if (player.accY > 0) {
                    player.accY = 10;
                } else {
                    player.accY = -10;
                }
                player.accX = 0;
                player.cooldownDesh = 3;
                audio(3);
            }
        } else if (player.accX <= 5 && player.accX >= -5 && player.accY <= 5 && player.accY >= -5) {
            switch (ev.keyCode) {
                case 65:
                    if (player.accX <= 5 && player.accX >= -5) {
                        player.accX = -5;
                    }
                    break;
                case 87:
                    if (player.accY <= 5 && player.accY >= -5) {
                        player.accY = -5;
                    }
                    break;
                case 68:
                    if (player.accX <= 5 && player.accX >= -5) {
                        player.accX = 5;
                    }
                    break;
                case 83:
                    if (player.accY <= 5 && player.accY >= -5) {
                        player.accY = 5;
                    }
                    break;
            }
        }
    });
    document.addEventListener("keyup", (ev) => {
        switch (ev.keyCode) {
            case 65:
            case 68:
                player.accX = 0;
                break;
            case 87:
            case 83:
                player.accY = 0;
                break;
        }
    })
}

function ativarintervalo() {
    clearIntervalo();
    tempDraw = setInterval(draw, 1000 / 240);
    tempTemporizador = setInterval(temporizador, 1000);
    tempCooldown = setInterval(cooldown, 1000);
    tempDeshOffX = setInterval(deshOffX, 100);
    tempDeshOffY = setInterval(deshOffY, 100);
    tempMoverPolicia = setInterval(moverPolicia, 1000 / 160);
    tempMoverPlayer = setInterval(moverPlayer, 1000 / 60);
    tempColetarMoeda = setInterval(coletarMoeda, 1000 / 60);
    tempColidirPolicia = setInterval(colidirPolicia, 1000 / 60);
    tempColidirPlayer = setInterval(colidirPlayer, 1000 / 60);
}

function clearIntervalo() {
    drawRect(canvas.clientTop, canvas.clientLeft, canvas.clientWidth, canvas.clientHeight, "#000000"); //Fundo
    clearInterval(tempDraw);
    clearInterval(tempTemporizador);
    clearInterval(tempDeshOffX);
    clearInterval(tempDeshOffY);
    clearInterval(tempCooldown);
    clearInterval(tempMoverPolicia);
    clearInterval(tempMoverPlayer);
    clearInterval(tempColetarMoeda);
    clearInterval(tempColidirPolicia);
    clearInterval(tempColidirPlayer);
    document.removeEventListener("keydown", () => {});
    document.removeEventListener("keyup", () => {});
}

function mostrarResultado() {
    const Resultado = document.querySelector("#resultadoPartida h2"),
        duracao = document.querySelector("#resultadoPartida #duracao"),
        score = document.querySelector("#resultadoPartida #score"),
        carDes = document.querySelector("#resultadoPartida #carDes");

    var tempo;
    if (tempoM > 0) {
        tempo = tempoM + "m" + tempoS + "s";
    } else {
        tempo = tempoS + "s";
    }

    Resultado.textContent = "Resultado Final";
    duracao.textContent = "Tempo: " + tempo;
    carDes.textContent = "Carros Destruídos: " + player.PoliciaDestruida;
    score.textContent = "Score: " + player.score;
}

function audio(a) {
    switch (a) {
        case 1: //Fundo
            var audio = new Audio("Audio/Ambiente_som.mp3");
            audio.play();
            break;
        case 2: //Coletar moeda
            var audio = new Audio("Audio/Coin_Collect_som.mp3");
            audio.play();
            break;
        case 3: //Desh
            var audio = new Audio("Audio/Desh_som.mp3");
            audio.play();
            break;
        case 4: //Impacto
            var audio = new Audio("Audio/Impacto_som.mp3");
            audio.play();
            break;
    }
}

function temporizador() {
    tempoS++;
    if (tempoS % 60 == 0) {
        tempoS = 0;
        tempoM++;
    }
}

function cooldown() {
    if (player.cooldownDesh != 0) {
        player.cooldownDesh--;
    }
}

function deshOffY() {
    if (player.accY > 5) {
        player.accY--;
    } else if (player.accY < -5) {
        player.accY++;
    }
}

function deshOffX() {
    if (player.accX > 5) {
        player.accX--;
    } else if (player.accX < -5) {
        player.accX++;
    }
}

function moverPlayer() {
    player.x += player.accX;
    player.y += player.accY;
    if (player.x < canvas.clientLeft) {
        player.x = canvas.clientLeft;
        player.accX = 0;

    } else if (player.x + player.size > canvas.clientWidth + canvas.clientLeft) {
        player.x = (canvas.clientWidth + canvas.clientLeft) - player.size;
        player.accX = 0;
    }
    if (player.y < canvas.clientTop) {
        player.y = canvas.clientTop;
        player.accY = 0;

    } else if (player.y + player.size > canvas.clientHeight + canvas.clientTop) {
        player.y = (canvas.clientHeight + canvas.clientTop) - player.size;
        player.accY = 0;
    }
}

function moverPolicia() {
    for (var i = 0; i < policiais.length; i++) {
        if (policiais[i].x < player.x) {
            policiais[i].x++;
        } else if (policiais[i].x > player.x) {
            policiais[i].x--;
        }
        if (policiais[i].y < player.y) {
            policiais[i].y++;
        } else if (policiais[i].y > player.y) {
            policiais[i].y--;
        }
    }
}

function coletarMoeda() {
    if ((moeda.x <= player.x + player.size && moeda.x >= player.x && moeda.y <= player.y + player.size && moeda.y >= player.y) ||
        (moeda.x + moeda.size >= player.x && moeda.x + moeda.size <= player.x + player.size && moeda.y >= player.y && moeda.y <= player.y + player.size) ||
        (moeda.x + moeda.size >= player.x && moeda.x + moeda.size <= player.x + player.size && moeda.y + moeda.size >= player.y && moeda.y + moeda.size <= player.y + player.size) ||
        (moeda.x <= player.x + player.size && moeda.x >= player.x && moeda.y + moeda.size >= player.y && moeda.y + moeda.size <= player.y + player.size)) {
        player.score++;
        audio(2);
        moeda = new Moeda();
    }
}

function colidirPolicia() {
    for (var i = 0; i < policiais.length; i++) {
        if (i < policiais.length - 1) {
            for (var j = i + 1; j < policiais.length; j++) {
                if ((policiais[i].x <= policiais[j].x + policiais[j].size && policiais[i].x >= policiais[j].x && policiais[i].y <= policiais[j].y + policiais[j].size && policiais[i].y >= policiais[j].y) ||
                    (policiais[i].x + policiais[i].size >= policiais[j].x && policiais[i].x + policiais[i].size <= policiais[j].x + policiais[j].size && policiais[i].y >= policiais[j].y && policiais[i].y <= policiais[j].y + policiais[j].size) ||
                    (policiais[i].x + policiais[i].size >= policiais[j].x && policiais[i].x + policiais[i].size <= policiais[j].x + policiais[j].size && policiais[i].y + policiais[i].size >= policiais[j].y && policiais[i].y + policiais[i].size <= policiais[j].y + policiais[j].size) ||
                    (policiais[i].x <= policiais[j].x + policiais[j].size && policiais[i].x >= policiais[j].x && policiais[i].y + policiais[i].size >= policiais[j].y && policiais[i].y + policiais[i].size <= policiais[j].y + policiais[j].size)) {
                    player.PoliciaDestruida++;
                    audio(4);
                    policiais[i] = new Policia();
                    policiais[j] = new Policia();
                }
            }
        }
    }
}

function colidirPlayer() {
    if (player.accX <= 5 && player.accX >= -5 && player.accY <= 5 && player.accY >= -5) {
        for (var i = 0; i < policiais.length; i++) {
            if ((policiais[i].x <= player.x + player.size && policiais[i].x >= player.x && policiais[i].y <= player.y + player.size && policiais[i].y >= player.y) ||
                (policiais[i].x + policiais[i].size >= player.x && policiais[i].x + policiais[i].size <= player.x + player.size && policiais[i].y >= player.y && policiais[i].y <= player.y + player.size) ||
                (policiais[i].x + policiais[i].size >= player.x && policiais[i].x + policiais[i].size <= player.x + player.size && policiais[i].y + policiais[i].size >= player.y && policiais[i].y + policiais[i].size <= player.y + player.size) ||
                (policiais[i].x <= player.x + player.size && policiais[i].x >= player.x && policiais[i].y + policiais[i].size >= player.y && policiais[i].y + policiais[i].size <= player.y + player.size)) {
                player.vida--;
                audio(4);
                if (player.vida == 0) {
                    clearIntervalo();
                    mostrarResultado();
                    setup();
                } else {
                    policiais[i] = new Policia();
                }
            }
        }
    }
}

function addPolicia() {
    var policia = new Policia();
    policiais.push(policia);
}

function draw() {
    drawRect(canvas.clientTop, canvas.clientLeft, canvas.clientWidth, canvas.clientHeight, "#000000"); //Fundo
    drawRect(moeda.x, moeda.y, moeda.size, moeda.size, moeda.color); //Moeda
    var color = player.color;
    if (player.accX > 5 || player.accX < -5 || player.accY < -5 || player.accY > 5) {
        color = "#ffff00" //Cor do Player => Desh
    }
    drawRect(player.x, player.y, player.size, player.size, color); //Player
    for (var i = 0; i < policiais.length; i++) {
        drawRect(policiais[i].x, policiais[i].y, policiais[i].size, policiais[i].size, policiais[i].color); //Policiais
    }
    drawScore();
    drawCooldownDesh();
}

function drawRect(x, y, w, h, c) {
    ctx.fillStyle = c;
    ctx.fillRect(x, y, w, h);
}

function drawScore() {
    ctx.fillStyle = "#fff";
    ctx.font = "30px -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif";
    var tempo;
    if (tempoM > 0) {
        tempo = tempoM + "m" + tempoS + "s";
    } else {
        tempo = tempoS + "s";
    }
    ctx.fillText("Tempo: " + tempo, 0, 25); //Tempo
    ctx.fillText("Score: " + player.score, 0, 55); //Score
    ctx.fillText("Carros Destruidos: " + player.PoliciaDestruida, 0, 85); //Carros Destruidos
    ctx.fillText("Vidas: " + player.vida, 0, 115); //Vidas
}

function drawCooldownDesh() {
    ctx.font = "20px sans-serif";
    if (player.cooldownDesh != 0) {
        ctx.fillText("Cooldown Desh: " + player.cooldownDesh, 5, window.innerHeight - 20);
    }
}

window.addEventListener("load", setup);