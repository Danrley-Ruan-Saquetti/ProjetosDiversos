
import java.util.Random;

public class Casa {

    private final Specters spec;
    private final Player player;
    private boolean comodoP[], comodo1[], comodo2[], andar[]; //Posição do Player
    private final int comodoGhostA, comodoGhostC; //Quarto do Fantasma
    private int comodoOrbeA, comodoOrbeC; //Quarto com orbe
    private int emfComodo1[], emfComodo2[], emfComodoP[]; //EMF de cada Cômodo
    private String vanItem[]; //Slot para guardar os ítens
    private boolean digital; //atributo para verificar se há impressão digital

    public Casa(Specters s, Player play) {
        Random alea = new Random();
        player = play;
        spec = s;
        comodoP = new boolean[4];
        comodo1 = new boolean[7];
        comodo2 = new boolean[5];
        emfComodoP = new int[4];
        emfComodo1 = new int[7];
        emfComodo2 = new int[5];
        andar = new boolean[3];
        vanItem = new String[5];
        andar[0] = true;
        comodo1[0] = true;
        int b, a = alea.nextInt(3);
        switch (a) {
            case 0:
                b = alea.nextInt(5) + 2;
                break;
            case 1:
                b = alea.nextInt(4) + 1;
                break;
            case 2:
                b = alea.nextInt(3) + 1;
                break;
            default:
                b = 2;
                break;
        }
        comodoGhostA = a;
        comodoGhostC = b;
        comodoOrbeA = 3;
        comodoOrbeC = 8;
    }

    //Controle de entrar/sair do cômodo
    public void entrarAndar1() { //Entra no 1º Andar
        andar[0] = true;
        andar[1] = false;
        andar[2] = false;
    }

    public void entrarAndar2() { //Entra no 2º Andar
        andar[0] = false;
        andar[1] = true;
        andar[2] = false;
    }

    public void entrarPorao() { //Entra no Porão
        andar[0] = false;
        andar[1] = false;
        andar[2] = true;
    }

    //Entrar/Sair dos cômodos do 1º Andar
    public void entrarVan() { //Entra na Van
        comodo1[0] = true;
    }

    public void sairVan() { //Sair da Van
        comodo1[0] = false;
    }

    public void entrarCorredor1() { //Entra no Corredor1
        comodo1[1] = true;
    }

    public void sairCorredor1() { //Sair do Corredor1
        comodo1[1] = false;
    }

    public void entrarSala() { //Entra na Sala de Estar
        comodo1[2] = true;
    }

    public void sairSala() { //Sair da Sala de Estar
        comodo1[2] = false;
    }

    public void entrarJantar() { //Entra na Sala de Jantar
        comodo1[3] = true;
    }

    public void sairJantar() { //Sair da Sala de Jantar
        comodo1[3] = false;
    }

    public void entrarCozinha() { //Entra na Cozinha
        comodo1[4] = true;
    }

    public void sairCozinha() { //Sair da Cozinha
        comodo1[4] = false;
    }

    public void entrarBanheiro1() { //Entra no Banheiro1
        comodo1[5] = true;
    }

    public void sairBanheiro1() { //Sair do Banheiro1
        comodo1[5] = false;
    }

    public void entrarGaragem() { //Entra na Garagem
        comodo1[6] = true;
    }

    public void sairGaragem() { //Sair da Garagem
        comodo1[6] = false;
    }

    //Entrar/Sair dos cômodos do 2º Andar
    public void entrarCorredor2() { //Entra no COrredor2
        comodo2[0] = true;
    }

    public void sairCorredor2() { //Sair do Corredor2
        comodo2[0] = false;
    }

    public void entrarBanheiro2() { //Entra no Banheiro2
        comodo2[1] = true;
    }

    public void sairBanheiro2() { //Sair do Banheiro2
        comodo2[1] = false;
    }

    public void entrarQuartoPais() { //Entra no Quarto dos Pais
        comodo2[2] = true;
    }

    public void sairQuartoPais() { //Sair do Quarto dos Pais
        comodo2[2] = false;
    }

    public void entrarQuartoFilho() { //Entra no Quarto dos Filhos
        comodo2[3] = true;
    }

    public void sairQuartoFilho() { //Sair do Quarto dos Filhos
        comodo2[3] = false;
    }

    public void entrarLavanderia() { //Entra na Lavanderia
        comodo2[4] = true;
    }

    public void sairLavanderia() { //Sair da Lavanderia
        comodo2[4] = false;
    }

    //Entrar/Sair dos cômodos do Porão
    public void entrarCorredor3() { //Entra no Corredor3
        comodoP[0] = true;
    }

    public void sairCorredor3() { //Sair do Corredor3
        comodoP[0] = false;
    }

    public void entrarAcademia() { //Entra na Academia
        comodoP[1] = true;
    }

    public void sairAcademia() { //Sair da Academia
        comodoP[1] = false;
    }

    public void entrarCinema() { //Entra cno Cinema
        comodoP[2] = true;
    }

    public void sairCinema() { //Sair do Cinema
        comodoP[2] = false;
    }

    public void entrarEscritorio() { //Entra no Escritório
        comodoP[3] = true;
    }

    public void sairEscritorio() { //Sair do Escritório
        comodoP[3] = false;
    }

    public void emfComodo() { //Gerar um EMF aleatório para cada cômodo
        int em[] = new int[7];

        for (int i = 0; i < em.length; i++) { //Gerar um EMF aleatória para cada cômodo do 1º Andar
            if ((getComodoGhostA() == 0) && (getComodoGhostC() == i)) {
                if ((spec.getEspirito()[1]) || (spec.getEspirito()[3]) || (spec.getEspirito()[5]) || (spec.getEspirito()[6]) || (spec.getEspirito()[8]) || (spec.getEspirito()[9])) { //EMF disparado
                    em[i] = 5;
                } else { //EMF do Quarto do fantasma
                    em[i] = 2;
                }
            } else { //EMF normal
                em[i] = 1;
            }
        }
        setEmfComodo1(em);

        em = new int[5];
        for (int i = 0; i < em.length; i++) { //Gerar um EMF aleatória para cada cômodo do 2º Andar
            if ((getComodoGhostA() == 1) && (getComodoGhostC() == i)) {
                if ((spec.getEspirito()[1]) || (spec.getEspirito()[3]) || (spec.getEspirito()[5]) || (spec.getEspirito()[6]) || (spec.getEspirito()[8]) || (spec.getEspirito()[9])) { //EMF disparado
                    em[i] = 5;
                } else { //EMF do Quarto do fantasma
                    em[i] = 2;
                }
            } else { //EMF normal
                em[i] = 1;
            }
        }
        setEmfComodo2(em);

        em = new int[4];
        for (int i = 0; i < em.length; i++) { //Gerar um EMF aleatória para cada cômodo do Porão
            if ((getComodoGhostA() == 2) && (getComodoGhostC() == i)) {
                if ((spec.getEspirito()[1]) || (spec.getEspirito()[3]) || (spec.getEspirito()[5]) || (spec.getEspirito()[6]) || (spec.getEspirito()[8]) || (spec.getEspirito()[9])) { //EMF disparado
                    em[i] = 5;
                } else { //EMF do Quarto do fantasma
                    em[i] = 2;
                }
            } else { //EMF normal
                em[i] = 1;
            }
        }
        setEmfComodoP(em);
    }

    public boolean[] getComodoP() {
        return comodoP;
    }

    public void setComodoP(boolean[] quarto) {
        comodoP = quarto;
    }

    public boolean[] getComodo1() {
        return comodo1;
    }

    public void setComodo1(boolean[] quarto) {
        comodo1 = quarto;
    }

    public boolean[] getComodo2() {
        return comodo2;
    }

    public void setComodo2(boolean[] quarto) {
        comodo2 = quarto;
    }

    public boolean[] getAndar() {
        return andar;
    }

    public void setAndar(boolean[] floor) {
        andar = floor;
    }

    public int getComodoOrbeA() {
        return comodoOrbeA;
    }

    public void setComodoOrbeA(int orbe) {
        comodoOrbeA = orbe;
    }

    public int getComodoOrbeC() {
        return comodoOrbeC;
    }

    public void setComodoOrbeC(int orbe) {
        comodoOrbeC = orbe;
    }

    public int[] getEmfComodo1() {
        return emfComodo1;
    }

    public void setEmfComodo1(int[] emf) {
        emfComodo1 = emf;
    }

    public int[] getEmfComodo2() {
        return emfComodo2;
    }

    public void setEmfComodo2(int[] emf) {
        emfComodo2 = emf;
    }

    public int[] getEmfComodoP() {
        return emfComodoP;
    }

    public void setEmfComodoP(int[] emf) {
        emfComodoP = emf;
    }

    public String[] getVanItem() {
        return vanItem;
    }

    public void setVanItem(String[] item) {
        vanItem = item;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digitais) {
        digital = digitais;
    }

    public int getComodoGhostA() {
        return comodoGhostA;
    }

    public int getComodoGhostC() {
        return comodoGhostC;
    }

    @Override
    public String toString() {
        System.out.print("\nSanidade: " + player.getSanidade() + "\t");
        if (andar[0]) {
            String pos[] = new String[7], orbe[] = new String[6], digital[] = new String[5],
                    and2 = " ", por = " ", l = " ", r = " ", o = " ", e = " ", t = " ", comodo = " ";
            int and = 0;

            if (!player.isLivro()) {
                l = "L";
            }
            if (!player.isRadio()) {
                r = "R";
            }
            if (!player.isOculos()) {
                o = "O";
            }
            if (!player.isEmf()) {
                e = "E";
            }
            if (!player.isTermometro()) {
                t = "T";
            }

            for (int i = 0; i < comodo1.length; i++) {
                if (i != 0) {
                    orbe[(i - 1)] = " ";
                    if (i > 1) {
                        digital[(i - 2)] = " ";
                    }
                }
                if (comodo1[i] == true) {
                    pos[i] = "+";
                    and = i;
                    if ((getComodoGhostA() == 0) && (getComodoGhostC() == i) && (isDigital())) {
                        digital[(i - 2)] = "◌";
                    }
                    if (player.getEquiparItem()[2]) {
                        if ((getComodoOrbeA() == 0) && (i == getComodoOrbeC()) && (i != 0)) {
                            orbe[(i - 1)] = "◆";
                        }
                    }
                } else {
                    pos[i] = " ";
                }
            }

            switch (and) {
                case 0:
                    pos[1] = "R";
                    comodo = "*Van*";
                    break;
                case 1:
                    pos[2] = "A";
                    pos[4] = "W";
                    pos[0] = "S";
                    and2 = "D";
                    comodo = "*Corredor*";
                    break;
                case 2:
                    pos[3] = "W";
                    pos[1] = "D";
                    comodo = "*Sala de Estar*";
                    break;
                case 3:
                    pos[2] = "S";
                    pos[4] = "D";
                    comodo = "*Sala de Jantar*";
                    break;
                case 4:
                    pos[3] = "A";
                    pos[1] = "S";
                    pos[5] = "R";
                    pos[6] = "D";
                    por = "X";
                    comodo = "*Cozinha*";
                    break;
                case 5:
                    pos[4] = "A";
                    por = "S";
                    pos[6] = "X";
                    comodo = "*Banheiro*";
                    break;
                case 6:
                    pos[5] = "W";
                    pos[4] = "A";
                    por = "S";
                    comodo = "*Garagem*";
                    break;
            }

            return comodo + "\n+---------+-------------+---------+\n"
                    + "|   " + orbe[2] + "     |" + digital[2] + "     " + orbe[3] + "      | " + orbe[4] + "  " + pos[5] + "   " + digital[3] + "|\n"
                    + "|" + digital[1] + "        |             +---|  |--+--------+\n"
                    + "|    " + pos[3] + "           " + pos[4] + "                |        |\n"
                    + "|                                          |\n"
                    + "|         |                       |        |\n"
                    + "+---   ---+-+      +--+--|  |-+---+        |\n"
                    + "|           | " + orbe[0] + "    |  |//|" + por + " |/|       " + pos[6] + "    |\n"
                    + "|           |      |  |//|  |/|            |\n"
                    + "|     " + pos[2] + "     |       " + and2 + " |///////|" + digital[4] + "         " + orbe[5] + " |\n"
                    + "|                  +--+-------+------------+\n"
                    + "| " + orbe[1] + "    " + digital[0] + "    |  " + pos[1] + "   |\n"
                    + "+-----------+|   |-+\n"
                    + "+----------+\n"
                    + "| " + l + "      " + o + " |\n"
                    + "| " + r + "  " + pos[0] + "     \n"
                    + "| " + t + "      " + e + " |\n"
                    + "+----------+";
        } else if (andar[1]) {
            String pos[] = new String[5], and1 = " ", orbe[] = new String[5],
                    digital[] = new String[4], comodo = " ";
            int and = 0;

            for (int i = 0; i < comodo2.length; i++) {
                orbe[i] = " ";
                if (i > 0) {
                    digital[(i - 1)] = " ";
                }
                if (comodo2[i] == true) {
                    pos[i] = "+";
                    and = i;
                    if ((getComodoGhostA() == 1) && (getComodoGhostC() == i) && (isDigital())) {
                        digital[(i - 1)] = "◌";
                    }
                    if (player.getEquiparItem()[2]) {
                        if ((getComodoOrbeA() == 1) && (i == getComodoOrbeC())) {
                            orbe[i] = "◆";
                        }
                    }
                } else {
                    pos[i] = " ";
                }
            }

            switch (and) {
                case 0:
                    pos[4] = "W";
                    pos[1] = "A";
                    and1 = "S";
                    pos[3] = "D";
                    pos[2] = "X";
                    comodo = "*Corredor*";
                    break;
                case 1:
                    pos[0] = "D";
                    comodo = "*Banheiro*";
                    break;
                case 2:
                    pos[0] = "W";
                    comodo = "*Quarto dos Pais*";
                    break;
                case 3:
                    pos[4] = "W";
                    pos[0] = "A";
                    comodo = "*Quarto dos Filhos*";
                    break;
                case 4:
                    pos[0] = "S";
                    pos[3] = "X";
                    comodo = "*Lavanderia*";
                    break;
            }

            return comodo + "\n+-----------+--------------------+\n"
                    + "| " + orbe[1] + "        " + digital[0] + "| " + orbe[4] + "                  |\n"
                    + "|           |         " + pos[4] + "        " + digital[3] + " |\n"
                    + "|     " + pos[1] + "     +--------|  |--------|\n"
                    + "|              " + pos[0] + " " + orbe[0] + "               |\n"
                    + "+-----------+     +  +----+      |\n"
                    + "|" + digital[1] + "          | " + orbe[3] + "   |" + and1 + " |           |\n"
                    + "|           |     |  |     " + pos[3] + "     |\n"
                    + "|     " + pos[2] + "           |  |           |\n"
                    + "| " + orbe[2] + "         |     |  | " + orbe[4] + "        " + digital[2] + "|\n"
                    + "+-----------+-----+--+-----------+\n";
        } else if (andar[2]) {
            String pos[] = new String[4], and1 = " ", orbe[] = new String[4],
                    digital[] = new String[3], comodo = " ";
            int and = 0;

            for (int i = 0; i < comodoP.length; i++) {
                orbe[i] = " ";
                if (i > 0) {
                    digital[(i - 1)] = " ";
                }
                if (comodoP[i] == true) {
                    pos[i] = "+";
                    and = i;
                    if ((getComodoGhostA() == 2) && (getComodoGhostC() == i) && (isDigital())) {
                        digital[(i - 1)] = "◌";
                    }
                    if (player.getEquiparItem()[2]) {
                        if ((getComodoOrbeA() == 2) && (i == getComodoOrbeC())) {
                            orbe[i] = "◆";
                        }
                    }
                } else {
                    pos[i] = " ";
                }
            }

            switch (and) {
                case 0:
                    pos[1] = "A";
                    pos[2] = "W";
                    pos[3] = "R";
                    and1 = "D";
                    comodo = "*Corredor*";
                    break;
                case 1:
                    pos[0] = "D";
                    pos[2] = "W";
                    comodo = "*Sala da Academia*";
                    break;
                case 2:
                    pos[3] = "D";
                    pos[1] = "S";
                    pos[0] = "X";
                    comodo = "*Cinema*";
                    break;
                case 3:
                    pos[0] = "S";
                    pos[2] = "A";
                    comodo = "*Escritório*";
                    break;
            }

            return comodo + "\n+--------------+-----+---------+\n"
                    + "| " + orbe[2] + "                    " + digital[2] + "       |\n"
                    + "|                    |    " + pos[3] + "    |\n"
                    + "|         " + pos[2] + "          |       " + orbe[3] + " |\n"
                    + "|" + digital[1] + "                   +--+------+\n"
                    + "+------|  |----+     |  |\n"
                    + "|" + digital[0] + "             |     |" + and1 + " |\n"
                    + "|       " + pos[1] + "         " + pos[0] + "  +  |\n"
                    + "| " + orbe[1] + "            | " + orbe[0] + "      |\n"
                    + "+--------------+--------+";
        }
        return "";
    }
}
