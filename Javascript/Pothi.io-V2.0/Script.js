const canvas = document.getElementById("canvas");
canvas.width = innerWidth;
canvas.height = innerHeight;

const ctx = canvas.getContext("2d");

let player = new Player(((canvas.clientWidth - 30) / 2), (canvas.clientHeight - 30) / 2, 30, "#ff0000"),
    projeteis = [],
    policiais = [],
    moeda;

document.getElementById("start").addEventListener("click", () => {
    document.getElementById("menu").classList.toggle("on");
    document.getElementById("tela-game").classList.toggle("on");
    init();
});

function init() {
    player = new Player(((canvas.clientWidth - 30) / 2), (canvas.clientHeight - 30) / 2, 30, "#ff0000");
    projeteis = [];
    policiais = [];
    for (let i = 0; i < 4; i++) {
        spawn.spawnPolicia();
    }
    spawn.spawnMoeda();
    animate();
}

addEventListener("click", (ev) => {
    const angulo = Math.atan2(ev.clientY - (player.y + (player.size / 2)), ev.clientX - (player.x + (player.size / 2))),
        speed = { x: Math.cos(angulo) * 5, y: Math.sin(angulo) * 5 };

    projeteis.push(new Projetil(player.x + (player.size / 2), player.y + (player.size / 2), 5, "red", speed));
});

addEventListener("keydown", (ev) => {
    if (player.cooldownDesh == 0 && ev.keyCode == 32) {
        if (player.acc.x > 0) {
            player.acc.x = 8;
            player.acc.y = 0;
            player.cooldownDesh = 3;
            document.getElementById("cooldawn").classList.toggle("on");
        } else if (player.acc.x < 0) {
            player.acc.x = -8;
            player.acc.y = 0;
            player.cooldownDesh = 3;
            document.getElementById("cooldawn").classList.toggle("on");
        } else if (player.acc.y > 0) {
            player.acc.y = 8;
            player.acc.x = 0;
            player.cooldownDesh = 3;
            document.getElementById("cooldawn").classList.toggle("on");
        } else if (player.acc.y < 0) {
            player.acc.y = -8;
            player.acc.x = 0;
            player.cooldownDesh = 3;
            document.getElementById("cooldawn").classList.toggle("on");
        }
    } else {
        switch (ev.keyCode) {
            case 68:
                if (player.acc.y > 4 || player.acc.y < -4) {
                    if (player.acc.y > 0) {
                        player.acc.y = 4;
                    } else if (player.acc.y < 0) {
                        player.acc.y = -4;
                    }
                }
                player.acc.x = 4;
                break;
            case 83:
                if (player.acc.x > 4 || player.acc.x < -4) {
                    if (player.acc.x > 4 || player.acc.x < -4) {
                        if (player.acc.x > 0) {
                            player.acc.x = 4;
                        } else if (player.acc.x < 0) {
                            player.acc.x = -4;
                        }
                    }
                }
                player.acc.y = 4;
                break;
            case 65:
                if (player.acc.y > 4 || player.acc.y < -4) {
                    if (player.acc.y > 4 || player.acc.y < -4) {
                        if (player.acc.y > 0) {
                            player.acc.y = 4;
                        } else if (player.acc.y < 0) {
                            player.acc.y = -4;
                        }
                    }
                }
                player.acc.x = -4;
                break;
            case 87:
                if (player.acc.x > 4 || player.acc.x < -4) {
                    if (player.acc.x > 4 || player.acc.x < -4) {
                        if (player.acc.x > 4 || player.acc.x < -4) {
                            if (player.acc.x > 0) {
                                player.acc.x = 4;
                            } else if (player.acc.x < 0) {
                                player.acc.x = -4;
                            }
                        }
                    }
                }
                player.acc.y = -4;
                break;
        }
    }
});

addEventListener("keyup", (ev) => {
    switch (ev.keyCode) {
        case 68:
            player.acc.x = 0;
            break;
        case 83:
            player.acc.y = 0;
            break;
        case 65:
            player.acc.x = 0;
            break;
        case 87:
            player.acc.y = 0;
            break;
    }
});

const colisao = {
    colisaoPlayer_Parede() {
        if (player.x + player.size > canvas.width + canvas.clientLeft) {
            player.x = canvas.width + canvas.clientLeft - player.size;
        } else if (player.x < canvas.clientLeft) {
            player.x = canvas.clientLeft;
        }
        if (player.y + player.size > canvas.height + canvas.clientTop) {
            player.y = canvas.height + canvas.clientTop - player.size;
        } else if (player.y < canvas.clientTop) {
            player.y = canvas.clientTop;
        }
    },

    colisaoPlayer_Moeda() {
        if ((moeda.x <= player.x + player.size && moeda.x >= player.x && moeda.y <= player.y + player.size && moeda.y >= player.y) ||
            (moeda.x + moeda.size >= player.x && moeda.x + moeda.size <= player.x + player.size && moeda.y >= player.y && moeda.y <= player.y + player.size) ||
            (moeda.x + moeda.size >= player.x && moeda.x + moeda.size <= player.x + player.size && moeda.y + moeda.size >= player.y && moeda.y + moeda.size <= player.y + player.size) ||
            (moeda.x <= player.x + player.size && moeda.x >= player.x && moeda.y + moeda.size >= player.y && moeda.y + moeda.size <= player.y + player.size)) {
            player.score += 50;
            spawn.spawnMoeda();

            document.getElementById("score").innerHTML = player.score;
        }
    },

    colisaoPolice_Police() {
        let cont = { a: 0, b: 0 };
        policiais.forEach((policeA, indexA) => {
            policiais.forEach((policeB, indexB) => {
                if (cont.a < cont.b) {
                    if ((policeA.x <= policeB.x + policeB.size && policeA.x >= policeB.x && policeA.y <= policeB.y + policeB.size && policeA.y >= policeB.y) ||
                        (policeA.x + policeA.size >= policeB.x && policeA.x + policeA.size <= policeB.x + policeB.size && policeA.y >= policeB.y && policeA.y <= policeB.y + policeB.size) ||
                        (policeA.x + policeA.size >= policeB.x && policeA.x + policeA.size <= policeB.x + policeB.size && policeA.y + policeA.size >= policeB.y && policeA.y + policeA.size <= policeB.y + policeB.size) ||
                        (policeA.x <= policeB.x + policeB.size && policeA.x >= policeB.x && policeA.y + policeA.size >= policeB.y && policeB.y + policeA.size <= policeB.y + policeB.size)) {
                        player.score += 10;
                        policiais.splice(indexB, 1);
                        policiais.splice(indexA, 1);
                        spawn.spawnPolicia();
                        spawn.spawnPolicia();
                        document.getElementById("score").innerHTML = player.score;
                    }
                }
                cont.b++;
            });
            cont.a++;
            cont.b = 0;
        });

        // for (var i = 0; i < policiais.length - 1; i++) {
        //     for (var j = i + 1; j < policiais.length; j++) {
        //         if ((policiais[i].x <= policiais[j].x + policiais[j].size && policiais[i].x >= policiais[j].x && policiais[i].y <= policiais[j].y + policiais[j].size && policiais[i].y >= policiais[j].y) ||
        //             (policiais[i].x + policiais[i].size >= policiais[j].x && policiais[i].x + policiais[i].size <= policiais[j].x + policiais[j].size && policiais[i].y >= policiais[j].y && policiais[i].y <= policiais[j].y + policiais[j].size) ||
        //             (policiais[i].x + policiais[i].size >= policiais[j].x && policiais[i].x + policiais[i].size <= policiais[j].x + policiais[j].size && policiais[i].y + policiais[i].size >= policiais[j].y && policiais[i].y + policiais[i].size <= policiais[j].y + policiais[j].size) ||
        //             (policiais[i].x <= policiais[j].x + policiais[j].size && policiais[i].x >= policiais[j].x && policiais[i].y + policiais[i].size >= policiais[j].y && policiais[i].y + policiais[i].size <= policiais[j].y + policiais[j].size)) {
        //             player.score += 10;
        //             policiais.splice(i, 1);
        //             policiais.splice(j, 1);
        //             spawn.spawnPolicia();
        //             spawn.spawnPolicia();
        //             document.getElementById("score").innerHTML = player.score;
        //         }
        //     }
        // }
    },

    colisaoPolice_Player() {
        if (player.acc.x < 4 && player.acc.x > -4 && player.acc.y < 4 && player.acc.y > -4) {
            policiais.forEach((police, index) => {
                if ((police.x <= player.x + player.size && police.x >= player.x && police.y <= player.y + player.size && police.y >= player.y) ||
                    (police.x + police.size >= player.x && police.x + police.size <= player.x + player.size && police.y >= player.y && police.y <= player.y + player.size) ||
                    (police.x + police.size >= player.x && police.x + police.size <= player.x + player.size && police.y + police.size >= player.y && police.y + police.size <= player.y + player.size) ||
                    (police.x <= player.x + player.size && police.x >= player.x && police.y + police.size >= player.y && police.y + police.size <= player.y + player.size)) {
                    if (player.vidas > 1) {
                        player.vidas--;
                        policiais.splice(index, 1);
                        spawn.spawnPolicia();
                        document.getElementById("vidas").innerHTML = player.vidas
                    } else {
                        gameOver();
                    }
                }
            })
        }
    }
}

function verificarColisao() {
    colisao.colisaoPlayer_Parede();
    colisao.colisaoPlayer_Moeda();
    colisao.colisaoPolice_Player();
    colisao.colisaoPolice_Police();
};

const spawn = {
    spawnPolicia() {
        let x = 0,
            y = 0,
            size = 30,
            color = "#fff";

        do {
            x = Math.floor(Math.random() * (canvas.width - size));
        } while ((x + 200 > player.x && x + 200 < player.x + player.size) ||
            (x - 200 > player.x && x - 200 < player.x + player.size));

        do {
            y = Math.floor(Math.random() * (canvas.height - size));
        } while ((y + 200 > player.y && y + 200 < player.y + player.size) ||
            (y - 200 > player.y && y - 200 < player.y + player.size));

        policiais.push(new Policia(x, y, size, color));
    },

    spawnMoeda() {
        let size = 10,
            x = Math.random() * (canvas.width - size),
            y = Math.random() * (canvas.height - size),
            color = "yellow";

        moeda = new Moeda(x, y, size, color);
    }
};

setInterval(() => {
    if (player.cooldownDesh != 0) {
        player.cooldownDesh--;
        if (player.cooldownDesh == 0) {
            document.getElementById("cooldawn").classList.toggle("on");
        }
    }
}, 1000);

let animateFrame;

function animate() {
    animateFrame = requestAnimationFrame(animate);
    ctx.fillStyle = "black";
    ctx.fillRect(canvas.clientLeft, canvas.clientTop, canvas.clientWidth, canvas.clientHeight);

    verificarColisao();

    moeda.draw();
    player.update();

    projeteis.forEach((projetil, index) => {
        projetil.update();

        if (projetil.x + projetil.radius < 0 ||
            projetil.x - projetil.radius > canvas.width ||
            projetil.y + projetil.radius < 0 ||
            projetil.y - projetil.radius > canvas.height) {
            setTimeout(() => {
                projeteis.splice(index, 1);
            }, 0);
        }
    });

    policiais.forEach((police) => {
        police.update();
    });

    if (player.cooldownDesh != 0) {
        document.getElementById("cooldawn-desh").innerHTML = player.cooldownDesh;
    }
}

function gameOver() {
    cancelAnimationFrame(animateFrame);
    document.getElementById("score-total").innerHTML = player.score;
    document.getElementById("score").innerHTML = 0;
    document.getElementById("vidas").innerHTML = 3;
    document.getElementById("menu").classList.toggle("on");
    document.getElementById("tela-game").classList.toggle("on");
    if (player.cooldownDesh != 0) {
        document.getElementById("cooldawn").classList.toggle("on");
    }
}