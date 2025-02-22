document.getElementById("start").addEventListener("click", () => {
    document.querySelector(".menu").classList.toggle("off");
    document.querySelector(".table").classList.toggle("on");
    init();
});

addEventListener("keydown", (ev) => {
    if (play) {
        switch (ev.keyCode) {
            case 87: //W
                mover.cima();
                break;
            case 83: //S
                mover.baixo();
                break;
            case 65: //A
                mover.esquerda();
                break;
            case 68: //D
                mover.direita();
                break;
        }
    }
});

const map = [
    [
        document.getElementById("e1"),
        document.getElementById("e2"),
        document.getElementById("e3")
    ],
    [
        document.getElementById("e4"),
        document.getElementById("e5"),
        document.getElementById("e6")
    ],
    [
        document.getElementById("e7"),
        document.getElementById("e8"),
        document.getElementById("e9")
    ],
];

let table;
let score;
let play;

const mover = {
    cima() {
        for (let j = 0; j < table.length; j++) {
            let x = 4,
                y = 4;

            for (let i = 0; i < table.length; i++) {
                console.log("cima1 " + i, j)
                if (table[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (table[x][y] == table[i][j]) {
                            table[x][y] += table[i][j];
                            score += table[i][j];
                            table[i][j] = 0;
                        }
                        i--;
                        x = y = 4;
                    }
                }
            }
            x = y = 4;
            for (let i = 0; i < table.length; i++) {
                console.log("cima2 " + i, j)
                if (table[i][j] == 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    table[x][y] = table[i][j];
                    table[i][j] = 0;
                    x = y = 4;
                    i = 0;
                }
            }
        }
        agregarValor();
    },

    baixo() {
        for (let j = table.length - 1; j >= 0; j--) {
            let x = 4,
                y = 4;

            for (let i = table.length - 1; i >= 0; i--) {
                console.log("baixo1 " + i, j)
                if (table[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (table[x][y] == table[i][j]) {
                            table[x][y] += table[i][j];
                            score += table[i][j];
                            table[i][j] = 0;
                        }
                        i++;
                        x = y = 4;
                    }
                }
            }
            x = y = 4;
            for (let i = table.length - 1; i >= 0; i--) {
                console.log("baixo2 " + i, j)

                if (table[i][j] == 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    table[x][y] = table[i][j];
                    table[i][j] = 0;
                    x = y = 4;
                    i = table.length - 1;
                }
            }
        }
        agregarValor();
    },

    direita() {
        for (let i = table.length - 1; i >= 0; i--) {
            let x = 4,
                y = 4;

            for (let j = table.length - 1; j >= 0; j--) {
                console.log("direita1 " + i, j)

                if (table[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (table[x][y] == table[i][j]) {
                            table[x][y] += table[i][j];
                            score += table[i][j];
                            table[i][j] = 0;
                        }
                        j++;
                        x = y = 4;
                    }
                }
            }
            x = y = 4;
            for (let j = table.length - 1; j >= 0; j--) {
                console.log("direita1 " + i, j)

                if (table[i][j] == 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    table[x][y] = table[i][j];
                    table[i][j] = 0;
                    x = y = 4;
                    j = table.length - 1;
                }
            }
        }
        agregarValor();
    },

    esquerda() {
        for (let i = 0; i < table.length; i++) {
            let x = 4,
                y = 4;

            for (let j = 0; j < table.length; j++) {
                console.log("esquerda1 " + i, j)

                if (table[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (table[x][y] == table[i][j]) {
                            table[x][y] += table[i][j];
                            score += table[i][j];
                            table[i][j] = 0;
                        }
                        j--;
                        x = y = 4;
                    }
                }
            }
            x = y = 4;
            for (let j = 0; j < table.length; j++) {
                console.log("esquerda2 " + i, j)

                if (table[i][j] == 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    table[x][y] = table[i][j];
                    table[i][j] = 0;
                    x = y = 4;
                    j = 0;
                }
            }
        }
        agregarValor();
    }
};

function init() {
    table = [
        [0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]
    ];
    imprimir();
    play = true;
    score = 0;
}

function imprimir() {
    for (let i = 0; i < table.length; i++) {
        for (let j = 0; j < table[i].length; j++) {
            map[i][j].innerHTML = table[i][j];
        }
    }
}

function agregarValor() {
    let gerarValor = false;
    for (let i = 0; i < table.length; i++) {
        for (let j = 0; j < table[i].length; j++) {
            if (table[i][j] == 0) {
                gerarValor = true;
                break;
            } else if (i == table.length - 1 && j == table[i].length - 1) {
                gameOver();
            }
        }
    }

    if (gerarValor) {
        let x = 0,
            y = 0;

        do {
            x = Math.floor(Math.random() * 3);
            y = Math.floor(Math.random() * 3);
        } while (table[x][y] != 0);

        table[x][y] = 2;
        imprimir();
    }
}

function gameOver() {
    document.getElementById("score-total").innerHTML = score;
    document.querySelector(".menu").classList.toggle("off");
    document.querySelector(".table").classList.toggle("on");
    play = false;
}