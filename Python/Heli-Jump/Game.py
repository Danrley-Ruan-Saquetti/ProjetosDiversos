import random
import pygame


class Base:
    def __init__(self, position, dimension):
        self.position = position
        self.dimension = dimension

    def update(self):
        pass


class Plataform:
    def __init__(self, position, dimension, speed, skin):
        self.position = position
        self.dimension = dimension
        self.speed = speed
        self.skin = skin

    def draw(self):
        screen.blit(self.skin, (self.position[0], self.position[1]))

    def update(self):
        self.speed = 0
        if self.position[0] < 10:
            self.speed = 5
        elif self.position[0] > WIDTH_WINDOW - 10:
            self.speed = -5

        self.position[0] += self.speed


class Player:
    def __init__(self, position, dimension, speed, skin):
        self.position = position
        self.dimension = dimension
        self.speed = speed
        self.skin = skin
        self.dropDown = False
        self.jumpTime = 5
        self.jump()

    def draw(self):
        screen.blit(self.skin, (self.position[0], self.position[1]))

    def jump(self):
        self.dropDown = False
        self.jumpTime = 5

    def update(self, ):
        self.speed = [0, 0]
        if not self.dropDown:
            pass
            # for i in range(0, len(plataforms)):
            #     if self.checkColision_Plataform(i):
            #         self.jump()
            #         break
        else:
            if self.jumpTime != 0:
                self.jumpTime -= 0.01

    def checkColision_Plataform(i):
        return False


class Camera:
    def __init__(self):
        pass


WIDTH_WINDOW = 500
HEIGHT_WINDOW = 600

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

FPS = 60
TIME_RUNNING = pygame.time.Clock()

pygame.font.init()
screen = pygame.display.set_mode((WIDTH_WINDOW, HEIGHT_WINDOW))
pygame.display.set_caption('Heli Jump')

dimensionPlayer = [20, 30]
positionPlayer = [(WIDTH_WINDOW - dimensionPlayer[0]) /
                  2, HEIGHT_WINDOW - dimensionPlayer[1]]
speedPlayer = [0, 0]
skinPlayer = pygame.Surface((dimensionPlayer[0], dimensionPlayer[1]))
skinPlayer.fill(BLACK)

player = Player(positionPlayer, dimensionPlayer, speedPlayer, skinPlayer)

dimensionBase = [500, 3000]
positionBase = [0, dimensionBase[1] - HEIGHT_WINDOW]

base = Base(positionBase, dimensionBase)


dimensionPlataforms = [40, 20]
skinPlataforms = pygame.Surface(
    (dimensionPlataforms[0], dimensionPlataforms[1]))
skinPlayer.fill(BLACK)

posBetween = 150

plataforms = [Plataform([random.randint(
    10, base.dimension[0] - 10), base.dimension[1] - posBetween], dimensionPlataforms, [0, 0], skinPlataforms)]
for i in range(0, round(base.dimension[1] / 150) * 2):
    positionPlataforms = [random.randint(
        10, base.dimension[0] - 10), base.dimension[1] - posBetween]

    if i % 2 == 1:
        posBetween *= 2

    plataforms.append(Plataform(positionPlataforms,
                      dimensionPlataforms, [0, 0], skinPlataforms))

running = True
while running:
    screen.fill(WHITE)

    for ev in pygame.event.get():
        if ev.type == pygame.QUIT:
            pygame.quit()
            quit()

    player.update()
    player.draw()

    base.update()

    i = 0
    while i < len(plataforms) - 1:
        plataforms[i].update()

        i += 1

    pygame.display.update()
