import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Créditos
        System.out.println("Este é um minigame inspirado no primeiro jogo de Fiv"
                + "e Nights at Freddy's. Maximize a janela de execução para uma "
                + "melhor experiencia!");

        int play = 0;

        //Menu do game
        do {
            Game game = new Game();
            Escritorio escritorio = new Escritorio(game);
            Animatronic animatronic = new Animatronic(game, escritorio);

            //Campo do menu
            String start = "";
            do {
                do {
                    System.out.print("\n+-----MENU-----+\n|1 - New Game  |\n|2 -"
                            + " Instruções|\n|3 - Quit Game |\n+--------------+"
                            + "\n-> Exucutar comando: ");
                    game.tentarPlay();
                    if ((game.getVerifPlay() < 1) || (game.getVerifPlay() > 3)) {
                        System.out.println("SISTEMA: Valor inválido!");
                    }
                } while ((game.getVerifPlay() < 1) || (game.getVerifPlay() > 3));

                play = game.getVerifPlay();
                switch (play) {
                    case 1:
                        do {
                            do { //Virificar noite
                                System.out.print("-> Defina a noite que deseja jogar: ");
                                game.tentarNoite();
                                if ((game.getNoite() < 1) || (game.getNoite() > 7)) {
                                    System.out.println("SISTEMA: Noite inacessível! Informe uma noite de 1 à 7!");
                                }
                            } while ((game.getNoite() < 1) || (game.getNoite() > 7));
                        } while (!game.isPlay());
                        do { //Verificar início do game
                            System.out.print("-> Deseja começar o jogo? (S/N): ");
                            start = s.next();
                            if (("s".equals(start)) || ("n".equals(start))) {
                                game.setPlay(true);
                            } else {
                                game.setPlay(false);
                                System.out.println("SISTEMA: Valor inválido! Informe apenas S - para sim ou N - para não!");
                            }
                        } while (!game.isPlay());
                        break;
                    case 2:
                        System.out.println(game.toString());
                        break;
                    case 3:
                        System.out.println("SISTEMA: BYE");
                        System.exit(0);
                }
            } while (("n".equals(start)) || (play != 1));

            //Configuração da partida
            int cont = 0, A = 0, D = 0, S = 0, coe = 0, coe2 = 0, pir = 0, chi = 0, chi2 = 0, fre = 0, horaPi = 7, horaFr = 7;

            switch (game.getNoite()) { //Hora em que os animatrônics entram na noite
                case 2: {
                    horaPi = 3;
                    break;
                }
                case 3: {
                    horaPi = 2;
                    break;
                }
                case 4: {
                    horaPi = 2;
                    horaFr = 4;
                    break;
                }
                case 5: {
                    horaPi = 1;
                    horaFr = 3;
                    break;
                }
                case 6: {
                    horaFr = 2;
                    break;
                }
                case 7: {
                    horaPi = 2;
                    horaFr = 2;
                }
            }

            //Comandos
            System.out.print("\nCOMANDOS:\nA - Abrir/Fechar porta esquerda\nD - "
                    + "Abrir/Fechar porta direita\nQ - Ligar/Desligar luz da por"
                    + "ta esquerda\nE - Ligar/Desligar luz da porta direita\nS -"
                    + " Abrir/Fechar câmera\nesc - Para encerrar o jogo\n\nGAME "
                    + "START!");

            //Início do game
            do {
                //Campo dos comandos
                System.out.println(animatronic.toString());
                System.out.print("-> Exucutar comando: ");
                switch (s.next()) {
                    case "a": //Porta Esquerda
                        if (escritorio.isPortaEsq()) {
                            escritorio.abrirPortaEsq();
                            A = 0;
                        } else {
                            escritorio.fecharPortaEsq();
                            A++;
                        }
                        break;
                    case "d": //Porta Direita
                        if (escritorio.isPortaDir()) {
                            escritorio.abrirPortaDir();
                            D = 0;
                        } else {
                            escritorio.fecharPortaDir();
                            D++;
                        }
                        break;
                    case "q": //Luz Esquerda
                        if (escritorio.isLuzE()) {
                            escritorio.desligarLuzE();
                        } else {
                            escritorio.ligarLuzE();
                        }
                        break;
                    case "e": //Luz Direita
                        if (escritorio.isLuzD()) {
                            escritorio.desligarLuzD();
                        } else {
                            escritorio.ligarLuzD();
                        }
                        break;
                    case "s": //Câmera
                        if (escritorio.isCamera()) {
                            escritorio.fecharCamera();
                            S = 0;
                            if ((escritorio.isAnimaPortaDirFr()) && (fre == 0)) {
                                fre++;
                            }
                        } else {
                            escritorio.abrirCamera();
                            S++;
                            fre = 0;
                            if ((escritorio.isAnimaPortaEsqPi()) && (escritorio.getContRuidoEP() == 0)) {
                                escritorio.setContRuidoEP(escritorio.getContRuidoEP() + 1);
                            }
                        }
                        break;
                    case "esc":
                        System.out.println("SISTEMA: BYE");
                        System.exit(0);
                }
                escritorio.setContRuidoEC(false);
                escritorio.setContRuidoDC(false);
                escritorio.setContRuidoDF(false);

                //Movimento dos animatronics
                animatronic.estagioTresCoelhao(coe);
                if (game.isStatus()) {
                    animatronic.estagioTresChiquinha(chi);
                }
                if (game.getHoras() >= horaPi) {
                    if (game.isStatus()) {
                        animatronic.estagioTresPirata(escritorio.getContRuidoEP(), pir);
                    }
                    if (pir == 0) {
                        animatronic.estagioDoisPirata();
                    }
                }
                if (game.getHoras() >= horaFr) {
                    if (game.isStatus()) {
                        animatronic.estagioTresFredao(fre);
                    }
                    if (fre == 0) {
                        animatronic.estagioDoisFredao();
                    }
                }
                if (chi2 == 0) {
                    animatronic.estagioDoisChiquinha();
                }
                if (coe2 == 0) {
                    animatronic.estagioDoisCoelhao();
                }

                //Controle de ruído dos animatronics
                if (escritorio.isAnimaPortaEsqCo()) {
                    if (!escritorio.isPortaEsq()) {
                        coe += 10;
                    } else {
                        coe -= 10;
                    }
                    coe2++;
                } else {
                    coe = 0;
                    coe2 = 0;
                }
                if (escritorio.isAnimaPortaDirCh()) {
                    if (!escritorio.isPortaDir()) {
                        chi += 10;
                    } else {
                        chi -= 10;
                    }
                    chi2++;
                } else {
                    chi = 0;
                    chi2 = 0;
                }
                if (escritorio.isAnimaPortaEsqPi()) {
                    pir++;
                } else {
                    pir = 0;
                    escritorio.setContRuidoEP(0);
                }
                if (escritorio.getContRuidoEP() > 0) {
                    escritorio.setContRuidoEP(escritorio.getContRuidoEP() + 1);
                }
                if (escritorio.isAnimaPortaDirFr()) {
                    if (fre > 0) {
                        fre++;
                    }
                } else {
                    fre = 0;
                }

                //Controle de contagem
                cont++;
                if (cont % 3 == 0) {
                    escritorio.setBateria(escritorio.getBateria() - 3);
                }
                if (cont % 6 == 0) {
                    game.passarHora();
                }

                if (escritorio.getBateria() > 0) {
                    if ((S % 2 == 1) || (A % 2 == 1) || (D % 2 == 1)) {
                        escritorio.setBateria(escritorio.getBateria() - 2);
                    }
                }
                if (escritorio.getBateria() > 0) {
                    if ((S > 4) || (A > 4) || (D > 4)) {
                        escritorio.setBateria(escritorio.getBateria() - 1);
                    }
                }
                if (S > 0) {
                    S++;
                }
                if (A > 0) {
                    A++;
                }
                if (D > 0) {
                    D++;
                }
            } while ((game.isStatus()) && (game.getHoras() <= 5));
        } while (play == 1);
    } //Saída do game
}
