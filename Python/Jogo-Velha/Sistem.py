import os
import pygame
import neat
from pygame.locals import *


def checkPosition(x, y):
    # print(x, y, table[x][y] == 0)
    if table[x][y] != 0:
        return True
    else:
        return False


def aggregateValue(x, y, value):
    print(x, y, value)
    table[x][y] = value


BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
RED = (255, 0, 0)

WIDTH_WINDOW = 400
HEIGHT_WINDOW = 400

TEXT_POSITION = WIDTH_WINDOW / 3
TEXT_MARGIN = (35, 25)

pygame.init()
SCREEN = pygame.display.set_mode((WIDTH_WINDOW, HEIGHT_WINDOW))
pygame.display.set_caption('Jogo da Velha')

WIDTH_GRIND = 5
ON_GRID_Y = pygame.Surface((WIDTH_GRIND, HEIGHT_WINDOW))
ON_GRID_Y.fill(BLACK)
ON_GRID_X = pygame.Surface((WIDTH_WINDOW, WIDTH_GRIND))
ON_GRID_X.fill(BLACK)

FONT_TEXT = pygame.font.Font('freesansbold.ttf', 100)

TEXT_X = FONT_TEXT.render('X', True, BLACK)
TEXT_Y = FONT_TEXT.render('Y', True, BLACK)

FPS = 1

table = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

ia_playing = False
geracao = 0


def main(gen, config):
    global geracao
    geracao += 1

    rounds = 0

    if ia_playing:
        networks = []
        genomes = []

        for _, geno in gen:
            net = neat.nn.FeedForwardNetwork.create(geno, config)
            networks.append(net)
            geno.fitness = 0
            genomes.append(geno)

    running = True
    while running:
        pygame.time.Clock().tick(FPS)

        SCREEN.fill(WHITE)

        for ev in pygame.event.get():
            if ev.type == pygame.QUIT:
                pygame.quit()
                quit()

        i = 0
        while i < 3:
            x = 0
            y = 0
            if ia_playing:
                acept = False
                while not acept:
                    output = networks[i].activate(
                        (table[0][0], table[0][1], table[0][2], table[1][0], table[1][1], table[1][2], table[2][0], table[2][1], table[2][2]))
                    j = 0
                    while j < 4:
                        if output[j] > 0.5:
                            if j < 3:
                                x = j
                            else:
                                y = j
                            break
                        j += 1
                    acept = checkPosition(x, y)

                    if not acept:
                        genomes[i].fitness -= 1
                print(x, y)
            if rounds % 2 == 0:
                aggregateValue(x, y, 1)
            else:
                aggregateValue(x, y, 2)
        i += 1

        end_game = True
        for i in range(0, 3):
            for j in range(0, 3):
                if table[i][j] == 1:
                    SCREEN.blit(TEXT_X, (TEXT_POSITION * i +
                                TEXT_MARGIN[0], TEXT_POSITION * j + TEXT_MARGIN[1]))
                elif table[i][j] == 2:
                    SCREEN.blit(TEXT_Y, (TEXT_POSITION * i +
                                TEXT_MARGIN[0], TEXT_POSITION * j + TEXT_MARGIN[1]))
                else:
                    end_game = True

        running = end_game
        i = 1
        while i < 4:
            SCREEN.blit(ON_GRID_Y, (TEXT_POSITION * i, 0))
            SCREEN.blit(ON_GRID_X, (0, TEXT_POSITION * i))
            i += 1

        print(rounds)
        rounds += 1
        pygame.display.update()


def rodar(local_config):
    config = neat.config.Config(neat.DefaultGenome, neat.DefaultReproduction,
                                neat.DefaultSpeciesSet, neat.DefaultStagnation, local_config)

    population = neat.Population(config)
    population.add_reporter(neat.StdOutReporter(True))
    population.add_reporter(neat.StatisticsReporter())

    if ia_playing:
        population.run(main, 2)
    else:
        main(None, None)


if __name__ == "__main__":
    local = os.path.dirname(__file__)
    local_config = os.path.join(local, "config_IA.txt")
    rodar(local_config)
