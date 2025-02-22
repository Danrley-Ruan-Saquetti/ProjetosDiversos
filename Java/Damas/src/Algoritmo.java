
public class Algoritmo {

    private boolean tabuleiro[][], encerrarPartida;
    private String jogador1[][], jogador2[][];
    private int proximoX, proximoY;

    public Algoritmo(boolean[][] tabuleiro, String[][] jogador1, String[][] jogador2) {
        this.tabuleiro = tabuleiro;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        proximoX = 0;
        proximoY = 0;
    }

    public boolean verificarMovimento1(int x, int y) {
        if ("O".equals(getJogador1()[x][y])) {
            if ((y > 0) && (y < 7)) {
                if ((" ".equals(getJogador1()[x - 1][y - 1])) || (" ".equals(getJogador1()[x - 1][y + 1]))) {
                    if ((" ".equals(getJogador2()[x - 1][y - 1])) || (" ".equals(getJogador2()[x - 1][y + 1]))) {
                        setProximoX(x - 1);
                        setProximoY(x - 1);
                        return true;
                    } else {
                        if ((y > 1) && (y < 6)) {
                            if ((" ".equals(getJogador1()[x - 2][y - 2])) || (" ".equals(getJogador1()[x - 2][y + 2])) || (" ".equals(getJogador2()[x - 2][y - 2])) || (" ".equals(getJogador2()[x - 2][y + 2]))) {
                                setProximoX(x - 2);
                                setProximoY(x - 2);
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            if (y == 1) {
                                if ((" ".equals(getJogador1()[x - 2][y + 2])) || (" ".equals(getJogador2()[x - 2][y + 2]))) {
                                    setProximoX(x - 2);
                                    setProximoY(x + 2);
                                    return true;
                                } else {
                                    return false;
                                }
                            } else if (y == 6) {
                                if ((" ".equals(getJogador1()[x - 2][y - 2])) || (" ".equals(getJogador2()[x - 2][y - 2]))) {
                                    setProximoX(x - 2);
                                    setProximoY(x - 2);
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                } else {
                    return false;
                }
            } else if (y == 0) {
                if (" ".equals(getJogador1()[x - 1][y + 1])) {
                    if (" ".equals(getJogador2()[x - 1][y + 1])) {
                        setProximoX(x - 1);
                        setProximoY(x + 1);
                        return true;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else if (y == 7) {
                if (" ".equals(getJogador1()[x - 1][y - 1])) {
                    if (" ".equals(getJogador2()[x - 1][y - 1])) {
                        setProximoX(x - 1);
                        setProximoY(x - 1);
                        return true;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else if ("♕".equals(getJogador1()[x][y])) {

        }
        return false;
    }

    public boolean verificarMovimento2(int x, int y) {
        if ((y > 0) && (y < 7)) {
            if ((" ".equals(getJogador2()[x - 1][y - 1])) || (" ".equals(getJogador2()[x - 1][y + 1]))) {
                if ((" ".equals(getJogador2()[x - 1][y - 1])) || (" ".equals(getJogador2()[x - 1][y + 1]))) {
                    setProximoX(x - 1);
                    setProximoY(x - 1);
                    return true;
                } else {
                    if ((y > 1) && (y < 6)) {
                        if ((" ".equals(getJogador2()[x - 2][y - 2])) || (" ".equals(getJogador2()[x - 2][y + 2])) || (" ".equals(getJogador1()[x - 2][y - 2])) || (" ".equals(getJogador1()[x - 2][y + 2]))) {
                            setProximoX(x - 2);
                            setProximoY(x - 2);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (y == 1) {
                            if ((" ".equals(getJogador2()[x - 2][y + 2])) || (" ".equals(getJogador1()[x - 2][y + 2]))) {
                                setProximoX(x - 2);
                                setProximoY(x + 2);
                                return true;
                            } else {
                                return false;
                            }
                        } else if (y == 6) {
                            if ((" ".equals(getJogador2()[x - 2][y - 2])) || (" ".equals(getJogador1()[x - 2][y - 2]))) {
                                setProximoX(x - 2);
                                setProximoY(x - 2);
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        } else if (y == 0) {
            if (" ".equals(getJogador2()[x - 1][y + 1])) {
                if (" ".equals(getJogador1()[x - 1][y + 1])) {
                    setProximoX(x - 1);
                    setProximoY(x + 1);
                    return true;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else if (y == 7) {
            if (" ".equals(getJogador2()[x - 1][y - 1])) {
                if (" ".equals(getJogador1()[x - 1][y - 1])) {
                    setProximoX(x - 1);
                    setProximoY(x - 1);
                    return true;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public void mover1(int x2, int y2, int x, int y) {
        if (x2 == 0) {
            jogador1[x2][y2] = "♕";
        } else {
            jogador1[x2][y2] = "O";
        }
        jogador1[x][y] = " ";
        if (Math.abs(x - x2) == 2) {

        }
    }

    public void mover2(int x2, int y2, int x, int y) {
        if (x2 == 0) {
            jogador2[x2][y2] = "♔";
        } else {
            jogador2[x2][y2] = "X";
        }
        jogador2[x][y] = " ";
    }

    public boolean[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(boolean[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public String[][] getJogador1() {
        return jogador1;
    }

    public void setJogador1(String[][] jogador1) {
        this.jogador1 = jogador1;
    }

    public String[][] getJogador2() {
        return jogador2;
    }

    public void setJogador2(String[][] jogador2) {
        this.jogador2 = jogador2;
    }

    public boolean isEncerrarPartida() {
        return encerrarPartida;
    }

    public void setEncerrarPartida(boolean encerrarPartida) {
        this.encerrarPartida = encerrarPartida;
    }

    public int getProximoX() {
        return proximoX;
    }

    public void setProximoX(int proximoX) {
        this.proximoX = proximoX;
    }

    public int getProximoY() {
        return proximoY;
    }

    public void setProximoY(int proximoY) {
        this.proximoY = proximoY;
    }
}
