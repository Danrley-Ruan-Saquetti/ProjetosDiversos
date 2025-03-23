
import java.util.Random;

public class Specters {

    private final boolean espirito[]; //Índice com o fantasma escolhido
    private final String fantasma, nome; //Tipo e nome do fantasma escolhido

    public Specters() {
        Random alea = new Random();
        espirito = new boolean[12];
        int a = alea.nextInt(12);
        espirito[a] = true;
        switch (a) {
            case 0:
                fantasma = "Spirit";
                break;
            case 1:
                fantasma = "Banshee";
                break;
            case 2:
                fantasma = "Demon";
                break;
            case 3:
                fantasma = "Jinn";
                break;
            case 4:
                fantasma = "Mare";
                break;
            case 5:
                fantasma = "Oni";
                break;
            case 6:
                fantasma = "Phantom";
                break;
            case 7:
                fantasma = "Poltergeist";
                break;
            case 8:
                fantasma = "Revenant";
                break;
            case 9:
                fantasma = "Shade";
                break;
            case 10:
                fantasma = "Yurei";
                break;
            case 11:
                fantasma = "Wendigo";
                break;
            default:
                fantasma = "???";
                break;
        }
        switch (alea.nextInt(15)) {
            case 0:
                nome = "Zogoir Vuvon";
                break;
            case 1:
                nome = "Nakar Waela";
                break;
            case 2:
                nome = "Luhepifa Hoxeo";
                break;
            case 3:
                nome = "Kumore Cife";
                break;
            case 4:
                nome = "Riuvu Entoa";
                break;
            case 5:
                nome = "Gutoce Dyous";
                break;
            case 6:
                nome = "Befou Timue";
                break;
            case 7:
                nome = "Sebal Xuzil";
                break;
            case 8:
                nome = "Hiqua Woavi";
                break;
            case 9:
                nome = "Vuxael Sime";
                break;
            case 10:
                nome = "Kiblowa Taiwui";
                break;
            case 11:
                nome = "Lavyu Xiziflu";
                break;
            case 12:
                nome = "Beusr Zimya";
                break;
            case 13:
                nome = " Vaoti Cegan";
                break;
            case 14:
                nome = "Soibi Isvauba";
                break;
            default:
                nome = "???";
        }
    }

    public boolean[] getEspirito() {
        return espirito;
    }

    public String getFantasma() {
        return fantasma;
    }

    public String getNome() {
        return nome;
    }
}
