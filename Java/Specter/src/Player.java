
public class Player {

    private boolean equiparSlot[], equiparItem[]; //Equipar/Desequipar Slot/Ítem
    private boolean encerrarGame; //Encerrar partida
    private boolean livro, emf, oculos, termometro, radio; //itens que estao ou não no chão
    private int sanidade; //Sanidade do jogador
    private String slot[]; //Slot do jogador

    public Player() {
        equiparItem = new boolean[5];
        equiparSlot = new boolean[3];
        slot = new String[3];
        slot[0] = " ";
        slot[1] = " ";
        slot[2] = " ";
        equiparSlot[0] = true;
        sanidade = 100;
    }

    //Controle de pegar/largar ítens
    public void pegarTermometro() {
        if (" ".equals(slot[0])) {
            slot[0] = "T";
            setTermometro(true);
        } else if (" ".equals(slot[1])) {
            slot[1] = "T";
            setTermometro(true);
        } else if (" ".equals(slot[2])) {
            slot[2] = "T";
            setTermometro(true);
        } else {
            System.out.println("SISTEMA: Bolso cheio!");
        }
    }

    public void pegarRadio() {
        if (" ".equals(slot[0])) {
            slot[0] = "R";
            setRadio(true);
        } else if (" ".equals(slot[1])) {
            slot[1] = "R";
            setRadio(true);
        } else if (" ".equals(slot[2])) {
            slot[2] = "R";
            setRadio(true);
        } else {
            System.out.println("SISTEMA: Bolso cheio!");
        }
    }

    public void pegarLivro() {
        if (" ".equals(slot[0])) {
            slot[0] = "L";
            setLivro(true);
        } else if (" ".equals(slot[1])) {
            slot[1] = "L";
            setLivro(true);
        } else if (" ".equals(slot[2])) {
            slot[2] = "L";
            setLivro(true);
        } else {
            System.out.println("SISTEMA: Bolso cheio!");
        }
    }

    public void pegarOculos() {
        if (" ".equals(slot[0])) {
            slot[0] = "O";
            setOculos(true);
        } else if (" ".equals(slot[1])) {
            slot[1] = "O";
            setOculos(true);
        } else if (" ".equals(slot[2])) {
            slot[2] = "O";
            setOculos(true);
        } else {
            System.out.println("SISTEMA: Bolso cheio!");
        }
    }

    public void pegarEMF() {
        if (" ".equals(slot[0])) {
            slot[0] = "E";
            setEmf(true);
        } else if (" ".equals(slot[1])) {
            slot[1] = "E";
            setEmf(true);
        } else if (" ".equals(slot[2])) {
            slot[2] = "E";
            setEmf(true);
        } else {
            System.out.println("SISTEMA: Bolso cheio!");
        }
    }

    public void largarItem(int a) {
        switch (getSlot()[a]) {
            case "T":
                setTermometro(false);
                break;
            case "R":
                setRadio(false);
                break;
            case "E":
                setEmf(false);
                break;
            case "L":
                setLivro(false);
                break;
            case "O":
                setOculos(false);
                break;
        }
        slot[a] = " ";
    }

    public void equiparLivro() {
        equiparItem[0] = true;
    }

    public void equiparEmf() {
        equiparItem[1] = true;
    }

    public void equiparOculos() {
        equiparItem[2] = true;
    }

    public void equiparTermometro() {
        equiparItem[3] = true;
    }

    public void equiparRadio() {
        equiparItem[4] = true;
    }

    public void desequiparLivro() {
        equiparItem[0] = false;
    }

    public void desequiparEmf() {
        equiparItem[1] = false;
    }

    public void desequiparOculos() {
        equiparItem[2] = false;
    }

    public void desequiparTermometro() {
        equiparItem[3] = false;
    }

    public void desequiparRadio() {
        equiparItem[4] = false;
    }

    public void equiparSlot1() {
        equiparSlot[0] = true;
        equiparSlot[1] = false;
        equiparSlot[2] = false;
        for (int i = 0; i < getEquiparItem().length; i++) {
            if (getEquiparItem()[i]) {
                equiparItem[i] = false;
                break;
            }
        }
    }

    public void equiparSlot2() {
        equiparSlot[0] = false;
        equiparSlot[1] = true;
        equiparSlot[2] = false;
        for (int i = 0; i < getEquiparItem().length; i++) {
            if (getEquiparItem()[i]) {
                equiparItem[i] = false;
                break;
            }
        }
    }

    public void equiparSlot3() {
        equiparSlot[0] = false;
        equiparSlot[1] = false;
        equiparSlot[2] = true;
        for (int i = 0; i < getEquiparItem().length; i++) {
            if (getEquiparItem()[i]) {
                equiparItem[i] = false;
                break;
            }
        }
    }

    public boolean[] getEquiparSlot() {
        return equiparSlot;
    }

    public void setEquiparSlot(boolean[] equipar) {
        equiparSlot = equipar;
    }

    public boolean[] getEquiparItem() {
        return equiparItem;
    }

    public void setEquiparItem(boolean[] equipar) {
        equiparItem = equipar;
    }

    public boolean isEncerrarGame() {
        return encerrarGame;
    }

    public void setEncerrarGame(boolean encerrar) {
        encerrarGame = encerrar;
    }

    public boolean isLivro() {
        return livro;
    }

    public void setLivro(boolean livr) {
        livro = livr;
    }

    public boolean isEmf() {
        return emf;
    }

    public void setEmf(boolean em) {
        emf = em;
    }

    public boolean isOculos() {
        return oculos;
    }

    public void setOculos(boolean ocu) {
        oculos = ocu;
    }

    public boolean isTermometro() {
        return termometro;
    }

    public void setTermometro(boolean ter) {
        termometro = ter;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean rad) {
        radio = rad;
    }

    public int getSanidade() {
        return sanidade;
    }

    public void setSanidade(int sani) {
        sanidade = sani;
        if (getSanidade() <= 0) {
            setEncerrarGame(true);
        }
    }

    public String[] getSlot() {
        return slot;
    }

    public void setSlot(String[] slo) {
        slot = slo;
    }

    @Override
    public String toString() {
        String t[] = new String[3];

        for (int i = 0; i < getEquiparSlot().length; i++) {
            if (getEquiparSlot()[i]) {
                t[i] = "^";
            } else {
                t[i] = " ";
            }
        }

        return "\nBolso do Player:\n"
                + "+-----+-----+-----+\n"
                + "|  " + getSlot()[0] + "  |  " + getSlot()[1] + "  |  " + getSlot()[2] + "  |\n"
                + "+-----+-----+-----+\n"
                + "   " + t[0] + "     " + t[1] + "     " + t[2];
    }
}
