
import java.util.Random;

public class Animatronic {

    private final Game game;
    private final Escritorio escritorio;
    private final String coelhao = "Coelhão", chiquinha = "Chiquinha", fredao = "Fredão", pirata = "Pirata";

    public Animatronic(Game jogo, Escritorio escr) {
        game = jogo;
        escritorio = escr;
    }

    //Mecanismo dos animatrônics
    //Coelhao
    public void estagioUmCoelhao() {
        escritorio.setAnimaPortaEsqCo(false);
    }

    public void estagioDoisCoelhao() {
        if ((!escritorio.isAnimaPortaEsqCo()) && (!escritorio.isPortaEsq())) {
            Random valor = new Random();
            int avancar = valor.nextInt(100);
            if (avancar < game.getNivelCoelhao()) {
                escritorio.setAnimaPortaEsqCo(true);
                escritorio.setContRuidoEC(true);
            }
        }
    }

    public void estagioTresCoelhao(int a) {
        if (escritorio.isAnimaPortaEsqCo()) {
            Random valor = new Random();
            if (escritorio.isPortaEsq()) {
                int fugir = valor.nextInt(100);
                if (fugir > game.getNivelCoelhao()) {
                    escritorio.setAnimaPortaEsqCo(false);
                }
            } else if ((a >= 50) || (escritorio.isCamera())) {
                int atacar = valor.nextInt(100);
                if (atacar < game.getNivelCoelhao()) {
                    System.out.print("\nSISTEMA: O Coelhão te matou!");
                    game.setStatus(false);
                    if (escritorio.isCamera()) {
                        game.setDica(2);
                    } else if (a >= 50) {
                        game.setDica(3);
                    }
                }
            }
        }
    }

    //Chiquinha
    public void estagioUmChiquinha() {
        escritorio.setAnimaPortaDirCh(false);
    }

    public void estagioDoisChiquinha() {
        if ((!escritorio.isAnimaPortaDirCh()) && (!escritorio.isPortaDir())) {
            Random valor = new Random();
            int avancar = valor.nextInt(100);
            if (avancar < game.getNivelChiquinha()) {
                escritorio.setAnimaPortaDirCh(true);
                escritorio.setContRuidoDC(true);
            }
        }
    }

    public void estagioTresChiquinha(int a) {
        if (escritorio.isAnimaPortaDirCh()) {
            Random valor = new Random();
            if (escritorio.isPortaDir()) {
                int fugir = valor.nextInt(100);
                if (fugir > game.getNivelChiquinha()) {
                    escritorio.setAnimaPortaDirCh(false);
                }
            } else if ((a >= 50) || (escritorio.isCamera())) {
                int atacar = valor.nextInt(100);
                if (atacar < game.getNivelChiquinha()) {
                    System.out.print("\nSISTEMA: A Chiquinha te matou!");
                    game.setStatus(false);
                    if (escritorio.isCamera()) {
                        game.setDica(2);
                    } else if (a >= 50) {
                        game.setDica(3);
                    }
                }
            }
        }
    }

    //Pirata
    public void estagioUmPirata() {
        escritorio.setAnimaPortaEsqPi(false);
    }

    public void estagioDoisPirata() {
        if (!escritorio.isAnimaPortaEsqPi()) {
            Random valor = new Random();
            int avancar = valor.nextInt(100);
            if (avancar < game.getNivelPirata()) {
                escritorio.setAnimaPortaEsqPi(true);
            }
        }
    }

    public void estagioTresPirata(int a, int b) {
        if (escritorio.isAnimaPortaEsqPi()) {
            Random valor = new Random();
            if (escritorio.isPortaEsq()) {
                escritorio.setAnimaPortaEsqPi(false);
            } else {
                if (a == 0) {
                    if (b > 4) {
                        int atacar = valor.nextInt(100);
                        if (atacar < game.getNivelPirata()) {
                            System.out.print("\nSISTEMA: O Pirata te matou!");
                            game.setStatus(false);
                            game.setDica(4);
                        }
                    }
                } else if (a == 3) {
                    System.out.print("\nSISTEMA: O Pirata te matou!");
                    game.setStatus(false);
                    game.setDica(5);
                }
            }
        }
    }

    //Fredão
    public void estagioUmFredao() {
        escritorio.setAnimaPortaDirFr(false);
    }

    public void estagioDoisFredao() {
        if (!escritorio.isAnimaPortaDirFr()) {
            Random valor = new Random();
            int avancar = valor.nextInt(100);
            if (avancar <= game.getNivelFredao()) {
                escritorio.setAnimaPortaDirFr(true);
                escritorio.setContRuidoDF(true);
            }
        }
    }

    public void estagioTresFredao(int a) {
        if (escritorio.isAnimaPortaDirFr()) {
            Random valor = new Random();
            if (escritorio.isCamera()) {
                int fugir = valor.nextInt(100);
                if (fugir >= game.getNivelFredao()) {
                    escritorio.setAnimaPortaDirFr(false);
                }
            } else {
                if (a > 5) {
                    int atacar = valor.nextInt(100);
                    if (atacar <= game.getNivelFredao()) {
                        System.out.print("\nSISTEMA: O Fredão te matou!");
                        game.setStatus(false);
                        game.setDica(6);
                    }
                }
            }
        }
    }

    //Animatronics
    public String getCoelhao() {
        return coelhao;
    }

    public String getChiquinha() {
        return chiquinha;
    }

    public String getFredao() {
        return fredao;
    }

    public String getPirata() {
        return pirata;
    }

    //Interface do usuário
    @Override
    public String toString() {
        String porD = " Aberto", porE = " Aberto", lD = "Desligado", lE = "Desligado",
                pD = "   ???   ", pE = "  ???  ", ruidoD = "", ruidoE = "",
                cam = "Fechado", hora = "12am",
                bateria = (Integer.toString(escritorio.getBateria()));

        if (escritorio.isPortaDir()) {
            porD = "Fechado";
        }
        if (escritorio.isPortaEsq()) {
            porE = "Fechado";
        }
        if (escritorio.isLuzE()) {
            lE = "  Ligado ";
            if (escritorio.isAnimaPortaEsqCo()) {
                pE = getCoelhao();
            } else {
                pE = " Limpo ";
            }
        }
        if (escritorio.isLuzD()) {
            lD = "  Ligado ";
            if (escritorio.isAnimaPortaDirCh()) {
                pD = getChiquinha();
            } else {
                pD = "  Limpo  ";
            }
        }
        if (escritorio.isCamera()) {
            cam = "Aberto ";
            if (escritorio.isAnimaPortaEsqPi()) {
                pE = " " + getPirata();
            } else {
                pE = " Limpo ";
            }
            if (escritorio.isAnimaPortaDirFr()) {
                pD = "  " + getFredao() + " ";
            } else {
                pD = "  Limpo  ";
            }
        }
        if (game.getHoras() != 0) {
            hora = (Integer.toString(game.getHoras())) + "am ";
        }
        if (escritorio.getBateria() == 100) {
            bateria += "%";
        } else if (escritorio.getBateria() >= 10) {
            bateria += "% ";
        } else {
            bateria += "%  ";
        }
        if (escritorio.getContRuidoEC()) {
            ruidoE = "*Ruído";
        }
        switch (escritorio.getContRuidoEP()) {
            case 2:
                ruidoE = "*Ruído!";
                break;
            case 3:
                ruidoE = "*RUÍDO!";
                break;
        }
        if (escritorio.getContRuidoDC()) {
            ruidoD = "*Ruído";
        }
        if (escritorio.getContRuidoDF()) {
            ruidoD = "*Ruído!";
        }
        return "\n\t+-----------------+--|ESCRITÓRIO|--+----------------+\n"
                + "\t| CÂMERA: " + cam + " |  BATERIA: " + bateria + " |   HORA: " + hora + "   |\n"
                + "\t+-----------------+----------------+----------------+\n"
                + ruidoE + "\t|      LADO       |    Esquerda    |    Direita     | " + ruidoD + "\n"
                + "\t+-----------------+----------------+----------------+\n"
                + "\t|      PORTA      |    " + porE + "     |    " + porD + "     |\n"
                + "\t+-----------------+----------------+----------------+\n"
                + "\t|       LUZ       |   " + lE + "    |   " + lD + "    |\n"
                + "\t+-----------------+----------------+----------------+\n"
                + "\t|   ANIMATRÔNIC   |    " + pE + "     |   " + pD + "    |\n"
                + "\t+-----------------+----------------+----------------+";
    }
}
