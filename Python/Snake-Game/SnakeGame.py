import pygame
import random
from pygame.locals import *


class Snake:
    def __init__(self, position, dimension, skin):
        self.position = position
        self.dimension = dimension
        self.skin = skin
        self.direction = LEFT

    def draw(self):
        screen.blit(
            self.skin, (self.position[0] + RETREAT, self.position[1] + RETREAT))

    def update(self, i, j):
        if i != 0:
            self.position = (snakes[j].position[0], snakes[j].position[1])
        else:
            if snakes[i].direction == UP:
                snakes[i].position = (snakes[i].position[i],
                                      snakes[i].position[1] - DIMENSION)
            elif snakes[i].direction == DOWN:
                snakes[i].position = (snakes[i].position[i],
                                      snakes[i].position[1] + DIMENSION)
            elif snakes[i].direction == RIGHT:
                snakes[i].position = (snakes[i].position[i] +
                                      DIMENSION, snakes[i].position[1])
            elif snakes[i].direction == LEFT:
                snakes[i].position = (snakes[i].position[i] -
                                      DIMENSION, snakes[0].position[1])


class Apple:
    def __init__(self, position, dimension, skin):
        self.position = position
        self.dimension = dimension
        self.skin = skin
        self.direction = LEFT

    def draw(self):
        screen.blit(
            self.skin, (self.position[0] + RETREAT, self.position[1] + RETREAT))


# FUNÇÕES DO JOGO
# Spawnar uma nova parte da cobra
def spawnSnake(i):
    x = 0
    y = 0
    color = ()
    if i == 0:
        x = (WIDTH_WINDOW / 2) // DIMENSION * DIMENSION
        y = (HEIGHT_WINDOW / 2) // DIMENSION * DIMENSION
        skin = pygame.Surface((DIMENSION - RETREAT, DIMENSION - RETREAT))
        color = (200, 200, 255)
    elif i == 1:
        x = DIMENSION * (-1)
        y = DIMENSION * (-1)
        color = (255, 255, 255)

    skin = pygame.Surface((DIMENSION - RETREAT, DIMENSION - RETREAT))
    skin.fill(color)

    return Snake((x, y), DIMENSION, skin)

# Spawnar maçã


def spawnApple():
    x = random.randint(0, HEIGHT_WINDOW - DIMENSION) // DIMENSION * DIMENSION
    y = random.randint(0, HEIGHT_WINDOW - DIMENSION) // DIMENSION * DIMENSION
    while checkColisionApple_Snake(x, y):
        x = random.randint(0, HEIGHT_WINDOW -
                           DIMENSION) // DIMENSION * DIMENSION
        y = random.randint(0, HEIGHT_WINDOW -
                           DIMENSION) // DIMENSION * DIMENSION
    skin = pygame.Surface((DIMENSION - RETREAT, DIMENSION - RETREAT))
    skin.fill((255, 0, 0))

    return Apple((x, y), DIMENSION, skin)

# Verificar a se a posição selecionada para spawnar a a maçã esta ocupada com uma parte do corpo da cobra


def checkColisionApple_Snake(x, y):
    for snake in snakes:
        if snake.position[0] == x and snake.position[1] == y:
            return True

# Verificar a colisão entre A cabeça da cobra com o resto do corpo


def checkColisionSnake_Snake(i):
    return (snakes[0].position[0] == snakes[i].position[0] and snakes[0].position[1] == snakes[i].position[1])

# Verificar a colisão ca cabeça da cobra com as bordas


def checkColisionSnake_Edge():
    return ((snakes[0].position[0] == WIDTH_WINDOW - DIMENSION and snakes[0].direction == RIGHT) or (snakes[0].position[0] == 0 and snakes[0].direction == LEFT) or (snakes[0].position[1] == HEIGHT_WINDOW - DIMENSION and snakes[0].direction == DOWN) or (snakes[0].position[1] == 0 and snakes[0].direction == UP))

# Verificar a colisão entre a Cabeça da cobra e a maçã


def checkColisionSnake_Apple():
    return (apple.position[0] == snakes[0].position[0]) and (apple.position[1] == snakes[0].position[1])


# CONSTANTES
# Tamanho da tela
WIDTH_WINDOW = 600
HEIGHT_WINDOW = WIDTH_WINDOW

# Keys
UP = 0
RIGHT = 1
DOWN = 2
LEFT = 3

# Tamanho dos Objetos
DIMENSION = 40  # 40x40

# Recuo grade
RETREAT = DIMENSION / 10

# FPS
FPS = 4

# Criar tela
pygame.init()
screen = pygame.display.set_mode((WIDTH_WINDOW, HEIGHT_WINDOW))
pygame.display.set_caption('Snake Game')

# Criar a cobra
snakes = [spawnSnake(0)]

# Criar a maçã
apple = spawnApple()

# Rodando o jogo
TIME_RUNNING = pygame.time.Clock()
running = True
while running:
    keysValid = True
    # Definindo o FPS
    TIME_RUNNING.tick(FPS)

    # Limpar a tela
    screen.fill((0, 0, 0))

    # Pegar os eventos
    for ev in pygame.event.get():
        if ev.type == pygame.QUIT:  # Fechar o jogo
            pygame.quit()
        if ev.type == KEYDOWN:
            if ev.key == K_w and snakes[0].direction != DOWN and keysValid:  # Cima
                snakes[0].direction = UP
                keysValid = False
            if ev.key == K_d and snakes[0].direction != LEFT and keysValid:  # Direita
                snakes[0].direction = RIGHT
                keysValid = False
            if ev.key == K_s and snakes[0].direction != UP and keysValid:  # Baixo
                snakes[0].direction = DOWN
                keysValid = False
            if ev.key == K_a and snakes[0].direction != RIGHT and keysValid:  # Esquerda
                snakes[0].direction = LEFT
                keysValid = False

    # Verificar se a cobra comeu a maça
    if checkColisionSnake_Apple():
        apple = spawnApple()
        snakes.append(spawnSnake(1))

    # Verificar colisão com a borda
    if checkColisionSnake_Edge():
        running = False

    # MOVER COBRA
    i = len(snakes) - 1
    while i >= 1:
        if i > 3:
            if checkColisionSnake_Snake(i):
                running = False
                break
        snakes[i].update(i, i - 1)
        i -= 1
    snakes[0].update(0, None)

    if (WIDTH_WINDOW * HEIGHT_WINDOW) / (DIMENSION * 2) == len(snakes):
        running = False

    # DESENHAR NA TELA
    # Desenhar maçã
    if running:
        apple.draw()

        # Desenhar cobra
        for snake in snakes:
            snake.draw()

    pygame.display.update()
