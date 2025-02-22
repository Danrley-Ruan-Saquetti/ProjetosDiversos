const canvas = document.querySelector(".canvas");
canvas.width = innerWidth;
canvas.height = innerHeight;
const ctx = canvas.getContext("2d");

let player,
    projeteis,
    enemies,
    particulas;

let temp, timer;

document.getElementById("start-game").addEventListener("click", () => {
    document.getElementById("game-UI").style.display = "none";

    init();
});

function init() {
    document.getElementById("score").innerHTML = 0;
    player = new Player(canvas.clientWidth / 2, canvas.clientHeight / 2, 15, "#fff");
    projeteis = [];
    enemies = [];
    particulas = [];

    timer = 0;
    speedSpawnEnemy = 1000;
    temp = setInterval(() => {
        timer++;
        if (timer % 10 == 0) {
            if (speedSpawnEnemy >= 100) {
                speedSpawnEnemy -= 100;
            }
        }
    }, 1000);

    spawnEnemies();
    animate();

    setTimeout(() => {
        clearInterval(timerSpawn);
        spawnEnemies();
    }, 10000);

    addEventListener("click", (ev) => {
        const angulo = Math.atan2(ev.clientY - canvas.height / 2, ev.clientX - canvas.width / 2)
        const speed = { x: Math.cos(angulo) * 5, y: Math.sin(angulo) * 5 };

        projeteis.push(new Projetil(canvas.clientWidth / 2, canvas.clientHeight / 2, 5, "#fff", speed));
    });
}

let timerSpawn, speedSpawnEnemy;

function spawnEnemies() {
    timerSpawn = setInterval(() => {
        const radius = Math.random() * (30 - 10) + 5;

        let x, y;
        if (Math.random() < 0.5) {
            x = Math.random() < 0.5 ? 0 - radius : canvas.width + radius;
            y = Math.random() * canvas.height;
        } else {
            x = Math.random() * canvas.width;
            y = Math.random() < 0.5 ? 0 - radius : canvas.height + radius;
        }

        const color = `hsl(${Math.random() * 360}, 50%, 50%)`,
            angulo = Math.atan2(canvas.height / 2 - y, canvas.width / 2 - x),
            speed = { x: Math.cos(angulo), y: Math.sin(angulo) };
        enemies.push(new Enemy(x, y, radius, color, speed));
    }, speedSpawnEnemy);
}

let animateId;

function animate() {
    animateId = requestAnimationFrame(animate);
    ctx.fillStyle = "rgba(0, 0, 0, 0.1)";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    player.draw(); //Player

    particulas.forEach((p, index) => {
        if (p.alpha <= 0) {
            particulas.splice(index, 1);
        } else {
            p.update();
        }
    });

    projeteis.forEach((p, index) => {
        p.update(); //Projétil

        if (p.x + p.radius < 0 ||
            p.x - p.radius > canvas.width ||
            p.y + p.radius < 0 ||
            p.y - p.radius > canvas.height) {
            setTimeout(() => {
                projeteis.splice(index, 1);
            }, 0);
        }
    });

    enemies.forEach((e, index) => {
        e.update(); //Inimigos

        const dist = Math.hypot(player.x - e.x, player.y - e.y);

        if (dist - e.radius - player.radius < 1) {
            cancelAnimationFrame(animateId);
            clearInterval(temp);
            document.querySelector("h1").innerHTML = player.score;
            document.getElementById("game-UI").style.display = "block";
        }

        projeteis.forEach((p, pIndex) => {
            const dist = Math.hypot(p.x - e.x, p.y - e.y);

            if (dist - e.radius - p.radius < 1) {
                for (let i = 0; i < e.radius * 2; i++) {
                    particulas.push(new Particula(p.x, p.y, Math.random() * 2, e.color, { x: (Math.random() - 0.5) * (Math.random() * 8), y: (Math.random() - 0.5) * (Math.random() * 8) }));
                }

                if (e.radius - 10 > 5) {
                    player.score += 100;
                    document.getElementById("score").innerHTML = player.score;

                    gsap.to(e, { radius: e.radius - 10 })
                    setTimeout(() => {
                        projeteis.splice(pIndex, 1);
                    }, 0);
                } else {
                    player.score += 250;
                    document.getElementById("score").innerHTML = player.score;

                    setTimeout(() => {
                        enemies.splice(index, 1);
                        projeteis.splice(pIndex, 1);
                    }, 0);
                }
            }
        });
    });
}