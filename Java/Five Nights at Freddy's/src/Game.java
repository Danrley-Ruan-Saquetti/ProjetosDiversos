
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private int nivelCoelhao, nivelPirata, nivelChiquinha, nivelFredao;
    private int horas, noite, verifPlay;
    private boolean status, play, vencer;

    public Game() {
        horas = 0;
        status = true;
        vencer = false;
        play = true;
    }

    //Controle de entrada do menu
    public void tentarPlay() {
        Scanner s = new Scanner(System.in);
        try {
            setVerifPlay(s.nextInt());
        } catch (InputMismatchException e) {
        }
    }

    //Controle de entrada da noite
    public void tentarNoite() {
        Scanner s = new Scanner(System.in);
        try {
            setNoite(s.nextInt());
        } catch (InputMismatchException e) {
        }
    }

    //Hora
    public void passarHora() {
        horas++;
        if (getHoras() == 6) {
            setVencer(true);
        }
    }

    public int getHoras() {
        return horas;
    }

    //Dificuldade dos animatronics
    public int getNivelCoelhao() {
        return nivelCoelhao;
    }

    public void setNivelCoelhao(int nB) {
        nivelCoelhao = nB;
    }

    public int getNivelPirata() {
        return nivelPirata;
    }

    public void setNivelPirata(int nF) {
        nivelPirata = nF;
    }

    public int getNivelChiquinha() {
        return nivelChiquinha;
    }

    public void setNivelChiquinha(int nC) {
        nivelChiquinha = nC;
    }

    public int getNivelFredao() {
        return nivelFredao;
    }

    public void setNivelFredao(int nF) {
        nivelFredao = nF;
    }

    //Controle de dificuldade da noite
    public int getNoite() {
        return noite;
    }

    public void setNoite(int n) {
        Scanner s = new Scanner(System.in);
        noite = n;
        switch (noite) {
            case 1: {
                setNivelCoelhao(10);
                setNivelChiquinha(10);
                setPlay(true);
                break;
            }
            case 2: {
                setNivelCoelhao(20);
                setNivelChiquinha(20);
                setNivelPirata(10);
                setPlay(true);
                break;
            }
            case 3: {
                setNivelCoelhao(30);
                setNivelChiquinha(30);
                setNivelPirata(15);
                setPlay(true);
                break;
            }
            case 4: {
                setNivelCoelhao(40);
                setNivelChiquinha(40);
                setNivelPirata(20);
                setNivelFredao(20);
                setPlay(true);
                break;
            }
            case 5: {
                setNivelCoelhao(50);
                setNivelChiquinha(50);
                setNivelPirata(30);
                setNivelFredao(30);
                setPlay(true);
                break;
            }
            case 6: {
                setNivelCoelhao(60);
                setNivelChiquinha(60);
                setNivelPirata(40);
                setNivelFredao(40);
                setPlay(true);
                break;
            }
            case 7: {
                int nivel = 0;
                System.out.println("SISTEMA: Selecione o nível de dificuldade de"
                        + " cada animatronic, que vai de 0 há 20, do mais fácil "
                        + "para o mais difícil, respectivamente");
                try {
                    do {
                        System.out.print("-> Coelhão: ");
                        nivel = s.nextInt();
                        if ((nivel < 0) || (nivel > 20)) {
                            System.out.println("SISTEMA: Valor inválido! Informe"
                                    + " apenas valores de 0 à 20!");
                        }
                    } while ((nivel < 0) || (nivel > 20));
                    setNivelCoelhao(nivel * 3);
                    setPlay(true);
                } catch (InputMismatchException e) {
                    System.out.println("SYSTEMA: Valor inválido! Informe"
                            + " apenas valores de 0 à 20!");
                    setPlay(false);
                    break;
                }
                try {
                    do {
                        System.out.print("-> Chiquinha: ");
                        nivel = s.nextInt();
                        if ((nivel < 0) || (nivel > 20)) {
                            System.out.println("SISTEMA: Valor inválido! Informe"
                                    + " apenas valores de 0 à 20!");
                        }
                    } while ((nivel < 0) || (nivel > 20));
                    setNivelChiquinha(nivel * 3);
                    setPlay(true);
                } catch (InputMismatchException e) {
                    System.out.println("SYSTEMA: Valor inválido! Informe"
                            + " apenas valores de 0 à 20!");
                    setPlay(false);
                    break;
                }
                try {
                    do {
                        System.out.print("-> Pirata: ");
                        nivel = s.nextInt();
                        if ((nivel < 0) || (nivel > 20)) {
                            System.out.println("SYSTEMA: Valor inválido! Informe"
                                    + " apenas valores de 0 à 20!");
                        }
                    } while ((nivel < 0) || (nivel > 20));
                    setNivelPirata(nivel * 2);
                    setPlay(true);
                } catch (InputMismatchException e) {
                    System.out.println("SYSTEMA: Valor inválido! Informe"
                            + " apenas valores de 0 à 20!");
                    setPlay(false);
                    break;
                }
                try {
                    do {
                        System.out.print("-> Fredão: ");
                        nivel = s.nextInt();
                        if ((nivel < 0) || (nivel > 20)) {
                            System.out.println("SYSTEMA: Valor inválido! Informe"
                                    + " apenas valores de 0 à 20!");
                        }
                    } while ((nivel < 0) || (nivel > 20));
                    setNivelFredao(nivel * 2);
                    setPlay(true);
                } catch (InputMismatchException e) {
                    System.out.println("SYSTEMA: Valor inválido! Informe"
                            + " apenas valores de 0 à 20!");
                    setPlay(false);
                    break;
                }
                break;
            }
            default: {
                setPlay(false);
                break;
            }
        }
    }

    //Início do game
    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean jogar) {
        play = jogar;
    }

    //Entrada do menu
    public int getVerifPlay() {
        return verifPlay;
    }

    public void setVerifPlay(int play) {
        verifPlay = play;
    }

    //Status do personagem (Vivo/Morto)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean alive) {
        status = alive;
        if (!isStatus()) {
            setVencer(false);
        }
    }

    //Conclusão da partida
    public boolean isVencer() {
        return vencer;
    }

    public void setVencer(boolean pasNoi) {
        vencer = pasNoi;
        if (isVencer()) {
            System.out.println("\nSISTEMA: 6am! PARABÉNS! Você"
                    + " concluiu a noite!");
        } else {
            System.out.print(" GAME OVER!\n");
        }
    }

    //Dicas
    public void setDica(int dic) {
        switch (dic) {
            case 1:
                System.out.println("Economize a bateria evitando deixar as porta"
                        + "s fechadas, luzes acesas ou a câmera aberta desnecess"
                        + "ariamente!");
                break;
            case 2:
                System.out.println("Cuidade ao abrir a câmera quando a porta est"
                        + "iver aberta e o animatrônic estiver na porta!");
                break;
            case 3:
                System.out.println("Se demorar muito para fechar a porta quando "
                        + "o animatrônic estiver lá, ele irá entrar no escritóri"
                        + "o para te matar!");
                break;
            case 4:
                System.out.println("O Pirata é sorrateiro! Feche a porta de vez "
                        + "em quando para evita-lo!");
                break;
            case 5:
                System.out.println("Muito lento! Fique mais esperto na hora de f"
                        + "echar a porta quando o Pirata aparecer na câmera!");
                break;
            case 6:
                System.out.println("Não se esqueça de olhar o Fredão pela câmera!");
                break;
        }
    }

    //Instruções
    @Override
    public String toString() {
        return "\n--------------------------------------------------------------"
                + "------------------|ORIENTAÇÕES|------------------------------"
                + "---------------------------------------------------\nENREDO: "
                + "Você é um guarda de segurança do turno da noite de uma pizzar"
                + "ia, chamada Freddy Fazbear Pizzaria. Os Animatrônics da pizza"
                + "ria são robôs de atração e entretenimento ao \npúblico, e são"
                + " eles: Coelhao, Chiquinha, Fredão e Pirata, mas a noite eles "
                + "ganham vida própria e vão te caçar, então tome cuidado!\n\nIN"
                + "STRUÇÕES: Seu escritório é composta por uma porta na direita "
                + "e uma na esquerda, junto com um sistema de luz em cada porta,"
                + " uma câmera de segurança e um sistema de bateria.\n\nA mecâni"
                + "ca dos animatrônics são:\n- Coelhao e Chiquinha: Aparecem nas"
                + " portas e, para evita-los, você deve fechar a porta;\n- Pirat"
                + "a: Aparece na porta esquerda, mas tome cuidado, pois ele é so"
                + "rrateiro e pode te atacar a qualquer hora; caso ele esteja se"
                + " aproximando e você abrir a câmera, ele irá \ncorrendo para o"
                + " seu escritório te atacar, por isso, feche a porta o mais ráp"
                + "ido possível (ele não irá aparecer caso a porta estiver fecha"
                + "da);\n- Fredão: Aparece na porta direita e, para evita-lo, vo"
                + "cê deve olhar para ele pela câmera periodicamente até que ele"
                + " vai embora.\n\nHá um padrão no comportamento dos animatrônic"
                + "s, que são divididos em três estágios:\n1º - Quando os animat"
                + "rônics estão em um estado de 'repouso';\n2º - Quando os anima"
                + "trônics aparecem na sua porta;\n3º - Se por acaso não consegu"
                + "ir impedi-los, eles irão entrar no seu escritório e irão te a"
                + "tacar, caso consiga, eles voltaram para o 1º estágio.\n\nA ba"
                + "teria do seu escritório vai diminuindo conforme a noite passa"
                + " e também quando as portas estiverem fechadas, as luzes ligad"
                + "as ou a câmera aberta. Se a bateria acabar, o \nFredão irá te"
                + " matar!\n\nVocê deve sobreviver das 12am até 6am e pode escol"
                + "her a noite que deseja jogar, que vai da primeira até a sexta"
                + " noite, do mais fácil ao mais difícil, respectivamente, e há "
                + "\na noite sete, que é uma noite customizada, onde você pode d"
                + "efinir o nível de dificuldade de cada animatrônic.\n---------"
                + "-------------------------------------------------------------"
                + "-------------------------------------------------------------"
                + "-------------------------------------------";
    }
}
