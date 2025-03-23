
import java.text.DecimalFormat;
import java.util.Random;

public class Item {

    private final Specters specter;
    private final Player player;
    private final Casa casa;
    private String chat;
    private boolean apareDigitais, apareOrbes, escreLivro, tempNega, digitais,
            radioEspirito, orbes, escrita, emf5; //Evidências

    public Item(Specters s, Player play, Casa cas) {
        player = play;
        specter = s;
        casa = cas;
    }

    //Evidências
    public void impressaoDigital() { //Aparecer Impressão Digital
        if ((specter.getEspirito()[0]) || (specter.getEspirito()[1]) || (specter.getEspirito()[7]) || (specter.getEspirito()[8]) || (specter.getEspirito()[11])) {
            setApareDigitais(true);
            casa.setDigital(true);
        }
    }

    public void responderRadio(String text) { //Responder Rádio
        boolean a = false;
        if (casa.getComodo1()[casa.getComodoGhostA()]) {
            if (casa.getComodo1()[casa.getComodoGhostC()]) {
                a = true;
            }
        } else if (casa.getComodo2()[casa.getComodoGhostA()]) {
            if (casa.getComodo2()[casa.getComodoGhostC()]) {
                a = true;
            }
        } else if (casa.getComodoP()[casa.getComodoGhostA()]) {
            if (casa.getComodoP()[casa.getComodoGhostC()]) {
                a = true;
            }
        }
        if (a) {
            if ((specter.getEspirito()[0]) || (specter.getEspirito()[2]) || (specter.getEspirito()[3]) || (specter.getEspirito()[4]) || (specter.getEspirito()[5]) || (specter.getEspirito()[7]) || (specter.getEspirito()[11])) {
                Random alea = new Random();
                switch (text) {
                    case "Where_are_you?":
                        int mensagem = alea.nextInt(100);
                        if (mensagem < 50) {
                            if (mensagem < 25) {
                                System.out.println("Window!");
                            } else if (mensagem < 35) {
                                System.out.println("Behind you!");
                            } else {
                                System.out.println("Near!");
                            }
                            if ((specter.getEspirito()[0]) || (specter.getEspirito()[7]) || (specter.getEspirito()[11])) {
                                setApareDigitais(true);
                                casa.setDigital(true);
                            }
                        }
                        break;
                    case "Are_you_here?":
                        switch (alea.nextInt(6)) {
                            case 0:
                                System.out.println("Behind!");
                                break;
                            case 1:
                                System.out.println("Near!");
                                break;
                            case 2:
                                System.out.println("Near you!");
                                break;
                            case 3:
                                System.out.println("Window!");
                                break;
                            case 4:
                                System.out.println("Hello!");
                                break;
                            case 5:
                                System.out.println("Door!");
                                break;
                        }
                        if ((specter.getEspirito()[0]) || (specter.getEspirito()[7])) {
                            setApareDigitais(true);
                            casa.setDigital(true);
                        }
                        break;
                    case "How_old_are_you?":
                        if (alea.nextInt(100) > 50) {
                            System.out.println((alea.nextInt(89) + 10) + " years old!");
                        }
                        break;
                    case "Are_you_a_boy?":
                        if (alea.nextInt(100) > 50) {
                            System.out.println("Man!");
                        } else {
                            System.out.println("Girl!");
                        }
                        break;
                    case "Are_you_a_girl?":
                        if (alea.nextInt(100) < 50) {
                            System.out.println("Man!");
                        } else {
                            System.out.println("Girl!");
                        }
                        break;
                    case "Whats_your_name?":
                        System.out.println(specter.getNome());
                        break;
                }
            }
        }
    }

    public void escreverLivro() { //Escrever no Livro
        boolean a = false;
        if (casa.getComodo1()[casa.getComodoGhostA()]) {
            if (casa.getComodo1()[casa.getComodoGhostC()]) {
                a = true;
            }
        } else if (casa.getComodo2()[casa.getComodoGhostA()]) {
            if (casa.getComodo2()[casa.getComodoGhostC()]) {
                a = true;
            }
        } else if (casa.getComodoP()[casa.getComodoGhostA()]) {
            if (casa.getComodoP()[casa.getComodoGhostC()]) {
                a = true;
            }
        }
        if (a) {
            if ((specter.getEspirito()[0]) || (specter.getEspirito()[2]) || (specter.getEspirito()[5]) || (specter.getEspirito()[8]) || (specter.getEspirito()[9]) || (specter.getEspirito()[10])) {
                Random alea = new Random();
                if (alea.nextInt(100) < 50) {
                    setEscreLivro(true);
                }
            }
        }
    }

    public void aparecerOrbes() { //Aparecer Orbes
        if ((specter.getEspirito()[3]) || (specter.getEspirito()[4]) || (specter.getEspirito()[6]) || (specter.getEspirito()[7]) || (specter.getEspirito()[9]) || (specter.getEspirito()[10])) {
            setApareOrbes(true);
            Random alea = new Random();
            int bO = 2, aO = alea.nextInt(3);
            switch (alea.nextInt(3)) {
                case 0:
                    bO = alea.nextInt(5) + 2;
                    break;
                case 1:
                    bO = alea.nextInt(4) + 1;
                    break;
                case 2:
                    bO = alea.nextInt(3) + 1;
                    break;
            }
            casa.setComodoOrbeA(aO);
            casa.setComodoOrbeC(bO);
        }
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String text) {
        chat = text;
    }

    public boolean isApareDigitais() {
        return apareDigitais;
    }

    public void setApareDigitais(boolean digitais) {
        apareDigitais = digitais;
    }

    public boolean isApareOrbes() {
        return apareOrbes;
    }

    public void setApareOrbes(boolean orbes) {
        apareOrbes = orbes;
    }

    public boolean isEscreLivro() {
        return escreLivro;
    }

    public void setEscreLivro(boolean escrever) {
        escreLivro = escrever;
    }

    public boolean isTempNega() {
        return tempNega;
    }

    public void setTempNega(boolean temp) {
        tempNega = temp;
    }

    public boolean isDigitais() {
        return digitais;
    }

    public void setDigitais(boolean digital) {
        digitais = digital;
    }

    public boolean isRadioEspirito() {
        return radioEspirito;
    }

    public void setRadioEspirito(boolean radio) {
        radioEspirito = radio;
    }

    public boolean isOrbes() {
        return orbes;
    }

    public void setOrbes(boolean orb) {
        orbes = orb;
    }

    public boolean isEscrita() {
        return escrita;
    }

    public void setEscrita(boolean escr) {
        escrita = escr;
    }

    public boolean isEmf5() {
        return emf5;
    }

    public void setEmf5(boolean emf) {
        emf5 = emf;
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("0.00");

        int pos = -1, and = 3;
        for (int i = 0; i < casa.getComodo1().length; i++) {
            if (casa.getComodo1()[i]) {
                pos = i;
                and = 0;
                break;
            }
        }
        if (pos < 0) {
            for (int i = 0; i < casa.getComodo2().length; i++) {
                if (casa.getComodo2()[i]) {
                    pos = i;
                    and = 1;
                    break;
                }
            }
        }
        if (pos < 0) {
            for (int i = 0; i < casa.getComodoP().length; i++) {
                if (casa.getComodoP()[i]) {
                    pos = i;
                    and = 2;
                    break;
                }
            }
        }
        for (int i = 0; i < player.getEquiparSlot().length; i++) {
            if (player.getEquiparSlot()[i]) {
                switch (player.getSlot()[i]) {
                    case "T":
                        if (player.getEquiparItem()[3]) {
                            Random alea = new Random();
                            double temp;
                            if ((casa.getComodo1()[casa.getComodoGhostC()]) || (casa.getComodo2()[casa.getComodoGhostC()]) || (casa.getComodoP()[casa.getComodoGhostC()])) {
                                if ((specter.getEspirito()[1]) || (specter.getEspirito()[2]) || (specter.getEspirito()[4]) || (specter.getEspirito()[6]) || (specter.getEspirito()[10]) || (specter.getEspirito()[11])) { //Temperatura Negativa
                                    do {
                                        temp = alea.nextDouble() * (-5);
                                    } while (temp > -1);
                                } else { //Temperatura do Quarot do Fantasma
                                    do {
                                        temp = alea.nextDouble() * 5;
                                    } while (temp >= 4);
                                }
                            } else { //Temperatura Normal
                                do {
                                    temp = alea.nextDouble() * 12;
                                } while (temp < 7);
                            }
                            switch (and) {
                                case 0:
                                    return "Termômetro: " + dF.format(temp) + "ºC";
                                case 1:
                                    return "Termômetro: " + dF.format(temp) + "ºC";
                                case 2:
                                    return "Termômetro: " + dF.format(temp) + "ºC";
                            }
                        }
                        return "Termômetro - Desligado.";
                    case "R":
                        if (player.getEquiparItem()[4]) {
                            return "Rádio - Ativado.";
                        }
                        return "Rádio - Desligado.";
                    case "E":
                        if (player.getEquiparItem()[1]) {
                            switch (and) {
                                case 0:
                                    return "EMF: " + casa.getEmfComodo1()[pos];
                                case 1:
                                    return "EMF: " + casa.getEmfComodo2()[pos];
                                case 2:
                                    return "EMF: " + casa.getEmfComodoP()[pos];
                            }
                        } else {
                            return "EMF - Desligado.";
                        }
                    case "O":
                        if (player.getEquiparItem()[2]) {
                            return "Óculos: Ligado";
                        }
                        return "Óculos - Desligado";
                    case "L":
                        if (player.getEquiparItem()[0]) {
                            String esc = "|    |    |\n"
                                    + "|    |    |\n"
                                    + "|    |    |\n";
                            if (isEscreLivro()) {
                                esc = "|│ ╽╎|╽ ┇|\n"
                                        + "|﹏ ﹋|╿ ║|\n"
                                        + "|┊ ┋|╵〡 |\n";
                            }
                            return "Livro - Aberto\n"
                                    + "+----+----+\n"
                                    + esc
                                    + "+----+----+";
                        }
                        return "Livro - Fechado";
                    default:
                        return "Nenhum";
                }
            }
        }
        return "";
    }
}
