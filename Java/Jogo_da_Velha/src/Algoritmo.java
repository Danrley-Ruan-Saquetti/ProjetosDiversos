
public class Algoritmo {

    private int tabela[][], ganhador;

    public Algoritmo() {
        tabela = new int[3][3];
        ganhador = 0; //0 - Partida em andamento; 1 - Vitória do jogador 1; 2 - Vitória do jogador 2
    }
    
    public void mostrarTabela() {
        System.out.println("\n  0   1   2\n+---+---+---+");
        for (int i = 0; i < getTabela().length; i++) {
            for (int j = 0; j < getTabela()[i].length; j++) {
                switch (getTabela()[i][j]) {
                    case 0:
                        System.out.print("|   ");
                        break;
                    case 1:
                        System.out.print("| X ");
                        break;
                    case 2:
                        System.out.print("| O ");
                        break;
                }
            }
            System.out.print("| " + i + "\n+---+---+---+\n");
        }
    }

    public void jogar(int x, int y, int j) {
        tabela[x][y] = j; //Agregar valor ao índice fornecido
        verificarVitoria(j);
    }

    public boolean verificarVitoria(int j) {
        for (int i = 0; i < getTabela().length; i++) {
            if (verificarLinha(i, j)) {
                return true;
            }
        }
        for (int i = 0; i < getTabela()[0].length; i++) {
            if (verificarColum(i, j)) {
                return true;
            }
        }
        if ((verificarDiagonalP(j)) || (verificarDiagonalS(j))) {
            return true;
        }
        return false;
    }

    public boolean verificarColum(int y, int j) {
        for (int i = 0; i < getTabela()[y].length; i++) {
            if (getTabela()[i][y] != j) {
                return false;
            }
        }
        if (j == 1) {
            setGanhador(1);
        } else {
            setGanhador(2);
        }
        return true;
    }

    public boolean verificarLinha(int x, int j) {
        for (int i = 0; i < getTabela()[x].length; i++) {
            if (getTabela()[x][i] != j) {
                return false;
            }
        }
        if (j == 1) {
            setGanhador(1);
        } else {
            setGanhador(2);
        }
        return true;
    }

    public boolean verificarDiagonalP(int j) {
        if ((getTabela()[0][0] != j) || (getTabela()[1][1] != j) || (getTabela()[2][2] != j)) {
            return false;
        }
        if (j == 1) {
            setGanhador(1);
        } else {
            setGanhador(2);
        }
        return true;
    }

    public boolean verificarDiagonalS(int j) {
        if ((getTabela()[0][2] != j) || (getTabela()[1][1] != j) || (getTabela()[2][0] != j)) {
            return false;
        }
        if (j == 1) {
            setGanhador(1);
        } else {
            setGanhador(2);
        }
        return true;
    }

    public String verificarJogada() { //Verificar as possíveis jogadas da CPU
        String valor = verificarAtaque();
        if (valor == null) {
            valor = verificarDefesa();
        }
        return valor; //Retorna a coordenada (x e y)
    }

    public String verificarAtaque() { //Preferência 1: Verificar se há uma chance de ganhar
        for (int i = 0; i < getTabela().length; i++) {
            int verificar1 = 0, verificar2 = 0;
            for (int j = 0; j < getTabela()[i].length; j++) {
                if (getTabela()[i][j] == 2) {
                    verificar1++;
                }
                if (getTabela()[j][i] == 2) {
                    verificar2++;
                }
            }
            if (verificar1 == 2) { //Verificar se falta um bloco para completar a trinca da linha
                for (int j = 0; j < getTabela().length; j++) {
                    if (getTabela()[i][j] == 0) { //Procurar qual o índice que falta para completar a trinca
                        return Integer.toString(i) + Integer.toString(j); //Retorna as coordenadas
                    }
                }
            } else if (verificar2 == 2) { //Verificar se falta um bloco para completar a trinca da coluna
                for (int j = 0; j < getTabela().length; j++) {
                    if (getTabela()[j][i] == 0) { //Procurar qual o índice que falta para completar a trinca
                        return Integer.toString(j) + Integer.toString(i); //Retorna as coordenadas
                    }
                }
            }
        }

        //Verificar se falta um bloco para completar a trinca na diagonal principal
        if (((getTabela()[0][0] == 2) && (getTabela()[1][1] == 2) && (getTabela()[2][2] == 0)) || ((getTabela()[0][0] == 2) && (getTabela()[1][1] == 0) && (getTabela()[2][2] == 2)) || ((getTabela()[0][0] == 0) && (getTabela()[1][1] == 2) && (getTabela()[2][2] == 2))) {
            //Procurar qual o índice que falta para completar a trinca
            if (getTabela()[0][0] == 2) {
                if (getTabela()[1][1] == 2) {
                    return "22"; //Retorna as coordenadas
                } else {
                    return "11"; //Retorna as coordenadas
                }
            } else {
                return "00"; //Retorna as coordenadas
            }
        }

        //Verificar se falta um bloco para completar a trinca na diagonal secundária
        if (((getTabela()[0][2] == 2) && (getTabela()[1][1] == 2) && (getTabela()[2][0] == 0)) || ((getTabela()[0][2] == 2) && (getTabela()[1][1] == 0) && (getTabela()[2][0] == 2)) || ((getTabela()[0][2] == 0) && (getTabela()[1][1] == 2) && (getTabela()[2][0] == 2))) {
            //Procurar qual o índice que falta para completar a trinca
            if (getTabela()[0][2] == 2) {
                if (getTabela()[1][1] == 2) {
                    return "20"; //Retorna as coordenadas
                } else {
                    return "11"; //Retorna as coordenadas
                }
            } else {
                return "02"; //Retorna as coordenadas
            }
        }
        return null;
    }

    public String verificarDefesa() { //Preferência 2: Verificar se há uma ameaça do adversário
        for (int i = 0; i < getTabela().length; i++) {
            int verificar1 = 0, verificar2 = 0;
            for (int j = 0; j < getTabela()[i].length; j++) {
                if (getTabela()[i][j] == 1) {
                    verificar1++;
                }
                if (getTabela()[j][i] == 1) {
                    verificar2++;
                }
            }
            if (verificar1 == 2) { //Verificar se falta um bloco para completar a trinca da linha
                for (int j = 0; j < getTabela().length; j++) {
                    if (getTabela()[i][j] == 0) { //Procurar qual o índice que falta para completar a trinca
                        return Integer.toString(i) + Integer.toString(j); //Retorna as coordenadas
                    }
                }
            } else if (verificar2 == 2) { //Verificar se falta um bloco para completar a trinca da coluna
                for (int j = 0; j < getTabela().length; j++) {
                    if (getTabela()[j][i] == 0) { //Procurar qual o índice que falta para completar a trinca
                        return Integer.toString(j) + Integer.toString(i); //Retorna as coordenadas
                    }
                }
            }
        }

        //Verificar se falta um bloco para completar a trinca na diagonal principal
        if (((getTabela()[0][0] == 1) && (getTabela()[1][1] == 1) && (getTabela()[2][2] == 0)) || ((getTabela()[0][0] == 1) && (getTabela()[1][1] == 0) && (getTabela()[2][2] == 1)) || ((getTabela()[0][0] == 0) && (getTabela()[1][1] == 1) && (getTabela()[2][2] == 1))) {
            //Procurar qual o índice que falta para completar a trinca
            if (getTabela()[0][0] == 1) {
                if (getTabela()[1][1] == 1) {
                    return "22"; //Retorna as coordenadas
                } else {
                    return "11"; //Retorna as coordenadas
                }
            } else {
                return "00"; //Retorna as coordenadas
            }
        }

        //Verificar se falta um bloco para completar a trinca na diagonal principal
        if (((getTabela()[0][2] == 1) && (getTabela()[1][1] == 1) && (getTabela()[2][0] == 0)) || ((getTabela()[0][2] == 1) && (getTabela()[1][1] == 0) && (getTabela()[2][0] == 1)) || ((getTabela()[0][2] == 0) && (getTabela()[1][1] == 1) && (getTabela()[2][0] == 1))) {
            //Procurar qual o índice que falta para completar a trinca
            if (getTabela()[0][2] == 1) {
                if (getTabela()[1][1] == 1) {
                    return "20"; //Retorna as coordenadas
                } else {
                    return "11"; //Retorna as coordenadas
                }
            } else {
                return "02"; //Retorna as coordenadas
            }
        }
        return null;
    }

    public int[][] getTabela() {
        return tabela;
    }

    public void setTabela(int[][] tabela) {
        this.tabela = tabela;
    }

    public int getGanhador() {
        return ganhador;
    }

    public void setGanhador(int ganhador) {
        this.ganhador = ganhador;
    }
}
