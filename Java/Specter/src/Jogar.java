
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Créditos
        System.out.println("Este é um minigame inspirado no jogo Phasmophobia. "
                + "Maximize a tela de execução para uma melhor experiência!");

        int play;

        //Menu do game
        do {
            Specters specter = new Specters();
            Player player = new Player();
            Casa casa = new Casa(specter, player);
            Item item = new Item(specter, player, casa);
            Diario diario = new Diario(specter, casa, item);

            //Campo do menu
            do {
                System.out.print("\n+-\n|MENU:\n|1 - New Game\n|2 - Quit Game\n+-"
                        + "\n-> Exucutar comando: ");
                play = s.nextInt();

                switch (play) {
                    case 2:
                        System.out.println("SISTEMA: BYE");
                        System.exit(0);
                    default:
                        if (play != 1) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                }
            } while (play != 1);

            //Configuração da partida
            casa.emfComodo();
            if ((!specter.getEspirito()[0]) && (!specter.getEspirito()[7]) || (specter.getEspirito()[11])) {
                item.impressaoDigital();
            }
            int cont = 0;

            //Comandos
            System.out.println("\n(n/ do autor: Recomendado que leia as Instruções"
                    + " no Diário antes de jogar o jogo.)\n+- \n|COMANDOS:\n|1 -"
                    + " Equipar Slot 1\n|2 - Equipar Slot 2\n|3 - Equipar Slot 3"
                    + "\n|E - Equipar/Desequipar Ítem\n|F - Pegar Ítem\n|G - Lar"
                    + "gar Ítem\n|J - Abrir/Fechar Diário\n|ESC - Encerrar Parti"
                    + "da\n|WASDRX - Se Locomover\n+-\n\nGAME START!");

            //Início do game
            do {
                //Campo de execução
                System.out.println(casa.toString() + "\n" + player.toString()
                        + "\nSISTEMA: Usando ítem: " + item.toString());
                System.out.print("-> Executar comando: ");
                switch (s.next()) {
                    case "1": //Equipar slot 1
                        player.equiparSlot1();
                        break;
                    case "2"://Equipar slot 2
                        player.equiparSlot2();
                        break;
                    case "3"://Equipar slot 2
                        player.equiparSlot3();
                        break;
                    case "e": //Equipar ítem
                        for (int i = 0; i < player.getEquiparSlot().length; i++) {
                            if (player.getEquiparSlot()[i]) {
                                switch (player.getSlot()[i]) { //Verificar qual ítem está no slot equipado
                                    case "T": //Equipar Termômetro
                                        if (!player.getEquiparItem()[3]) {
                                            player.equiparTermometro();
                                        } else {
                                            player.desequiparTermometro();
                                        }
                                        break;
                                    case "E": //Equipar EMF
                                        if (!player.getEquiparItem()[1]) {
                                            player.equiparEmf();
                                        } else {
                                            player.desequiparEmf();
                                        }
                                        break;
                                    case "R": //Equipar Rádio
                                        if (!player.getEquiparItem()[4]) {
                                            player.equiparRadio();
                                        } else {
                                            player.desequiparRadio();
                                        }
                                        break;
                                    case "O": //Equipar Óculos
                                        if (!player.getEquiparItem()[2]) {
                                            player.equiparOculos();
                                        } else {
                                            player.desequiparOculos();
                                        }
                                        break;
                                    case "L": //Equipar Livro
                                        if (!player.getEquiparItem()[0]) {
                                            player.equiparLivro();
                                        } else {
                                            player.desequiparLivro();
                                        }
                                        break;
                                }
                                break;
                            }
                        }
                        break;
                    case "f": //Pegar ítem do chão
                        String e = "";
                        do {
                            if (casa.getComodo1()[0]) { //Verificar quais ítens tem disponível para pagar
                                System.out.println("\n+-\n|PEGAR ÍTEM:");
                                if (!player.isLivro()) {
                                    System.out.println("|0 - Livro");
                                }
                                if (!player.isEmf()) {
                                    System.out.println("|1 - EMF");
                                }
                                if (!player.isOculos()) {
                                    System.out.println("|2 - Óculos");
                                }
                                if (!player.isTermometro()) {
                                    System.out.println("|3 - Termômetro");
                                }
                                if (!player.isRadio()) {
                                    System.out.println("|4 - Rádio");
                                }
                                System.out.println("|F - Voltar\n+-");
                                do { //Campo para pegar ítem
                                    System.out.print("-> Executar comando: ");
                                    e = s.next();
                                    switch (e) {
                                        case "0": //Pegar Livro
                                            if (!player.isLivro()) {
                                                player.pegarLivro();
                                            }
                                            break;
                                        case "1": //Pegar EMF
                                            if (!player.isEmf()) {
                                                player.pegarEMF();
                                            }
                                            break;
                                        case "2": //Pegar Óculos
                                            if (!player.isOculos()) {
                                                player.pegarOculos();
                                            }
                                            break;
                                        case "3": //Pegar Termômetro
                                            if (!player.isTermometro()) {
                                                player.pegarTermometro();
                                            }
                                            break;
                                        case "4": //Pegar Rádio
                                            if (!player.isRadio()) {
                                                player.pegarRadio();
                                            }
                                            break;
                                        default:
                                            if (!"f".equals(e)) {
                                                System.out.println("SISTEMA: Valor Inválido!");
                                            }
                                    }
                                    System.out.println(player.toString() + "\nSISTEMA: Usando ítem: " + item.toString());
                                } while ((!"f".equals(e)) && (!"0".equals(e)) && (!"1".equals(e)) && (!"2".equals(e)) && (!"3".equals(e)) && (!"4".equals(e)));
                            } else {
                                System.out.println("SISTEMA: Não há nenhum ítem para pegar!");
                            }
                        } while (!"f".equals(e));
                        break;
                    case "g": //Dropar ítem do slot eqipado
                        if (casa.getComodo1()[0]) {
                            for (int i = 0; i < player.getEquiparSlot().length; i++) {
                                if (player.getEquiparSlot()[i]) {
                                    player.largarItem(i);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("SISTEMA: Impossível dropar o ítem!");
                        }
                        break;
                    case "j": //Abrir Diário
                        diario.abrirDiario();
                        break;
                    case "a": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 1: //Entrar na Sala de Estar
                                            casa.sairCorredor1();
                                            casa.entrarSala();
                                            break;
                                        case 4: //Entrar na Sala de Jantar
                                            casa.sairCozinha();
                                            casa.entrarJantar();
                                            break;
                                        case 5: //Entrar na Cozinha
                                            casa.sairBanheiro1();
                                            casa.entrarCozinha();
                                            break;
                                        case 6: //Entrar na Cozinha
                                            casa.sairGaragem();
                                            casa.entrarCozinha();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[1]) { //Verificar se o jagador está no 2º andar
                            for (int j = 0; j < casa.getComodo2().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo2()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Banheiro1
                                            casa.sairCorredor2();
                                            casa.entrarBanheiro2();
                                            break;
                                        case 3: //Entrar no Corredor2
                                            casa.sairQuartoFilho();
                                            casa.entrarCorredor2();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 0: //Entrar na Academia
                                            casa.sairCorredor3();
                                            casa.entrarAcademia();
                                            break;
                                        case 3: //Entrar no Cinema
                                            casa.sairEscritorio();
                                            casa.entrarCinema();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "d": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 1: //Entrar no 2º andar
                                            casa.sairCorredor1();
                                            casa.entrarAndar2();
                                            casa.entrarCorredor2();
                                            break;
                                        case 2: //Entrar no Corredor1
                                            casa.sairSala();
                                            casa.entrarCorredor1();
                                            break;
                                        case 3: //Entrar na Cozinha
                                            casa.sairJantar();
                                            casa.entrarCozinha();
                                            break;
                                        case 4: //Entrar na Garagem
                                            casa.sairCozinha();
                                            casa.entrarGaragem();
                                            break;
                                        case 5: //Entrar na Garagem
                                            casa.sairBanheiro1();
                                            casa.entrarGaragem();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[1]) { //Verificar se o jagador está no 2º andar
                            for (int j = 0; j < casa.getComodo2().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo2()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Quarto do Filho
                                            casa.sairCorredor2();
                                            casa.entrarQuartoFilho();
                                            break;
                                        case 1: //Entrar no Corredor2
                                            casa.sairBanheiro2();
                                            casa.entrarCorredor2();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no 1ºAndar
                                            casa.sairCorredor3();
                                            casa.entrarAndar1();
                                            casa.entrarCozinha();
                                            break;
                                        case 1: //Entrar no Corredor3
                                            casa.sairAcademia();
                                            casa.entrarCorredor3();
                                            break;
                                        case 2: //Entrar no Escritório
                                            casa.sairCinema();
                                            casa.entrarEscritorio();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "w": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 1: //Entrar na Cozinha
                                            casa.sairCorredor1();
                                            casa.entrarCozinha();
                                            break;
                                        case 2: //Entrar na Sala de Jantar
                                            casa.sairSala();
                                            casa.entrarJantar();
                                            break;
                                        case 6: //Entrar no Banheiro1
                                            casa.sairGaragem();
                                            casa.entrarBanheiro1();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[1]) { //Verificar se o jagador está no 2º andar
                            for (int j = 0; j < casa.getComodo2().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo2()[j]) {
                                    switch (j) {
                                        case 0: //Entrar na Lavanderia
                                            casa.sairCorredor2();
                                            casa.entrarLavanderia();
                                            break;
                                        case 2: //Entrar no Corredor2
                                            casa.sairQuartoPais();
                                            casa.entrarCorredor2();
                                            break;
                                        case 3: //Entrar na Lavanderia
                                            casa.sairQuartoFilho();
                                            casa.entrarLavanderia();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Cinema
                                            casa.sairCorredor3();
                                            casa.entrarCinema();
                                            break;
                                        case 1: //Entrar no Cinema
                                            casa.sairAcademia();
                                            casa.entrarCinema();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "s": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 1: //Entrar na Van
                                            casa.sairCorredor1();
                                            casa.entrarVan();
                                            break;
                                        case 3: //Entrar na Sala de Estar
                                            casa.sairJantar();
                                            casa.entrarSala();
                                            break;
                                        case 4: //Entrar no Corredor1
                                            casa.sairCozinha();
                                            casa.entrarCorredor1();
                                            break;
                                        case 5: //Entrar no Porão
                                            casa.sairBanheiro1();
                                            casa.entrarPorao();
                                            casa.entrarCorredor3();
                                            break;
                                        case 6: //Entrar no Corredor3
                                            casa.sairGaragem();
                                            casa.entrarPorao();
                                            casa.entrarCorredor3();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[1]) { //Verificar se o jagador está no 2º andar
                            for (int j = 0; j < casa.getComodo2().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo2()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no 1º Andar
                                            casa.sairCorredor2();
                                            casa.entrarAndar1();
                                            casa.entrarCorredor1();
                                            break;
                                        case 4: //Entrar no Corredor2
                                            casa.sairLavanderia();
                                            casa.entrarCorredor2();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 2: //Entrar na Academia
                                            casa.sairCinema();
                                            casa.entrarAcademia();
                                            break;
                                        case 3: //Entrar no Corredor3
                                            casa.sairEscritorio();
                                            casa.entrarCorredor3();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "r": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Corredor1
                                            casa.sairVan();
                                            casa.entrarCorredor1();
                                            break;
                                        case 4: //Entrar no Banheiro1
                                            casa.sairCozinha();
                                            casa.entrarBanheiro1();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Escritório
                                            casa.sairCorredor3();
                                            casa.entrarEscritorio();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "x": //Locomover
                        if (casa.getAndar()[0]) { //Verificar se o jagador está no 1º andar
                            for (int j = 0; j < casa.getComodo1().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo1()[j]) {
                                    switch (j) {
                                        case 4: //Entrar no Corredor3
                                            casa.sairCozinha();
                                            casa.entrarPorao();
                                            casa.entrarCorredor3();
                                            break;
                                        case 5: //Entrar na Garagem
                                            casa.sairBanheiro1();
                                            casa.entrarGaragem();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[1]) { //Verificar se o jagador está no 2º andar
                            for (int j = 0; j < casa.getComodo2().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodo2()[j]) {
                                    switch (j) {
                                        case 0: //Entrar no Quarto dos Pais
                                            casa.sairCorredor2();
                                            casa.entrarQuartoPais();
                                            break;
                                        case 4: //Entrar no Quarto do Filho
                                            casa.sairLavanderia();
                                            casa.entrarQuartoFilho();
                                            break;
                                    }
                                    break;
                                }
                            }
                        } else if (casa.getAndar()[2]) { //Verificar se o jagador está no porão
                            for (int j = 0; j < casa.getComodoP().length; j++) { //Verificar em qual quarto o jogador está
                                if (casa.getComodoP()[j]) {
                                    switch (j) {
                                        case 2: //Entrar no Corredor3
                                            casa.sairCinema();
                                            casa.entrarCorredor3();
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "esc": //Encerrar partida
                        player.setEncerrarGame(true);
                        break;
                }
                while (diario.isDiario()) { //Diáro
                    //Campo do Diário
                    System.out.print("\n+-\n|1 - Instruções\n|2 - Evidências\n|"
                            + "J - Fechar Diário\n+-\n-> Executar comando: ");
                    switch (s.next()) {
                        case "1": //Instruções
                            System.out.print(diario.instrucoes());
                            break;
                        case "2": //Evidência
                            System.out.print(diario.toString() + "\n+-\n|REGISTRAR:\n|1 - Evidência 1\n"
                                    + "|2 - Evidência 2\n|3 - Evidência 3\n|4 - "
                                    + "Fantasma\n|J - Voltar\n+-\n-> Executar comando: ");
                            String exe = s.next();
                            String ev = "";
                            if ((!"j".equals(exe)) && (!"4".equals(exe))) { //Opcões para evidências
                                System.out.print("\n+-\n|1 - Escrita\n|2 - EMF nível 5\n"
                                        + "|3 - Temperatura Negativa\n|4 - Rádio\n"
                                        + "|5 - Orbe\n|6 - Impressão Digital\n|"
                                        + "0 - Nenhum\n|J - Voltar\n+-\n-> Executar comando: ");
                                ev = s.next();
                            }
                            switch (exe) { //Registrar no diário a 1ª evidência escolhida
                                case "1":
                                    switch (ev) {
                                        case "0": //Registrar Nenhum
                                            diario.setEv1("Nenhum");
                                            break;
                                        case "1": //Registrar Escrita
                                            diario.setEv1("Escrita");
                                            break;
                                        case "2": //Registrar EMF nível 5
                                            diario.setEv1("EMF nível 5");
                                            break;
                                        case "3": //Registrar Temperatura Negativa
                                            diario.setEv1("Temperatura Negativa");
                                            break;
                                        case "4": //Registrar Rádio
                                            diario.setEv1("Rádio");
                                            break;
                                        case "5": //Registrar Orbe
                                            diario.setEv1("Orbe");
                                            break;
                                        case "6": //Registrar Impressão Digital
                                            diario.setEv1("Impressão Digital");
                                            break;
                                        case "j":
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                        default:
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                    }
                                    break;
                                case "2": //Registrar no diário a 2ª evidência escolhida
                                    switch (ev) {
                                        case "0": //Registrar Nenhuma
                                            diario.setEv2("Nenhum");
                                            break;
                                        case "1": //Registrar Escrita
                                            diario.setEv2("Escrita");
                                            break;
                                        case "2": //Registrar EMF nível 5
                                            diario.setEv2("EMF nível 5");
                                            break;
                                        case "3": //Registrar Temperatura Negativa
                                            diario.setEv2("Temperatura Negativa");
                                            break;
                                        case "4": //Registrar Rádio
                                            diario.setEv2("Rádio");
                                            break;
                                        case "5": //Registrar Orbe
                                            diario.setEv2("Orbe");
                                            break;
                                        case "6": //Registrar Impressão Digital
                                            diario.setEv2("Impressão Digital");
                                            break;
                                        case "j":
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                        default:
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                    }
                                    break;
                                case "3": //Registrar no diário a 3ª evidência escolhida
                                    switch (ev) {
                                        case "0": //Registrar Nenhuma
                                            diario.setEv3("Nenhum");
                                            break;
                                        case "4": //Registrar Rádio
                                            diario.setEv3("Rádio");
                                            break;
                                        case "1": //Registrar Escrita
                                            diario.setEv3("Escrita");
                                            break;
                                        case "6": //Registrar Impressão Digital
                                            diario.setEv3("Impressão Digital");
                                            break;
                                        case "2": //Registrar EMF nível 5
                                            diario.setEv3("EMF nível 5");
                                            break;
                                        case "3": //Registrar Temperatura Negativa
                                            diario.setEv3("Temperatura Negativa");
                                            break;
                                        case "5": //Registrar Orbe
                                            diario.setEv3("Orbe");
                                            break;
                                        case "j":
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                        default:
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                    }
                                    break;
                                case "4": //Registrar no diário o fantasma
                                    System.out.print("\n+-\n" + diario.opcoes()
                                            + "\n|-\n|12 - Nenhum\n|J - Voltar\n+-\n"
                                            + "Executar comando: "); //Opções de possíveis fantasmas
                                    switch (s.next()) {
                                        case "0": //Registrar Spirit
                                            diario.setFantasma("Spirit");
                                            break;
                                        case "1": //Registrar Banshee
                                            diario.setFantasma("Banshee");
                                            break;
                                        case "2": //Registrar Demon
                                            diario.setFantasma("Demon");
                                            break;
                                        case "3": //Registrar Jinn
                                            diario.setFantasma("Jinn");
                                            break;
                                        case "4": //Registrar Mare
                                            diario.setFantasma("Mare");
                                            break;
                                        case "5": //Registrar Oni
                                            diario.setFantasma("Oni");
                                            break;
                                        case "6": //Registrar Phantom
                                            diario.setFantasma("Phantom");
                                            break;
                                        case "7": //Registrar Poltergeist
                                            diario.setFantasma("Poltergeist");
                                            break;
                                        case "8": //Registrar Revenant
                                            diario.setFantasma("Revenant");
                                            break;
                                        case "9": //Registrar Shade
                                            diario.setFantasma("Shade");
                                            break;
                                        case "10": //Registrar Yurei
                                            diario.setFantasma("Yurei");
                                            break;
                                        case "11": //Registrar Wendigo
                                            diario.setFantasma("Wendigo");
                                            break;
                                        case "12": //Registrar Nenhum
                                            diario.setFantasma("Nenhum");
                                            break;
                                        case "j":
                                            diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                            break;
                                    }
                                    break;
                                case "J":
                                    diario.abrirDiario(); //Voltar na 1ª aba do Diário
                                    break;
                            }
                            break;
                        case "j":
                            diario.fecharDiario(); //Fechar Diário
                            break;
                    }
                }
                cont--;
                if (player.getEquiparItem()[2]) { //Verificar se o Óculos está equipado
                    item.aparecerOrbes(); //Aparecer Orbes
                }
                if (player.getEquiparItem()[0]) { //Verificar se o Livro está equipado
                    item.escreverLivro(); //Escrever no Livro
                }
                if (player.getEquiparItem()[4]) { //Verificar se o Rádio está equipado
                    cont = 0;
                    String text;
                    System.out.println("SISTEMA: Informe a pergunta que deseja fazer ao fantasma / E - Para fechar o chat");
                    do {
                        System.out.print("-> Chat: ");
                        text = s.next(); //Escrever a pergunta no chat
                        if (cont < 5) {
                            if (!"e".equals(text)) {
                                item.responderRadio(text); //Contactar o fantasma
                                cont++;
                            } else {
                                player.desequiparRadio(); //Fechar o chat
                            }
                        } else {
                            System.out.println("SISTEMA: Você não poderá perguntar mais perguntar nas próximas jogadas!");
                        }
                    } while (!"e".equals(text));
                    player.desequiparRadio();
                }
                if (!casa.getComodo1()[0]) { //Diminuir a sanidade do jogador apenas se estiver dentro da casa
                    if (!specter.getEspirito()[11]) {
                        player.setSanidade(player.getSanidade() - 2);
                    } else {
                        player.setSanidade(player.getSanidade() - 4);
                    }
                }
            } while (!player.isEncerrarGame()); //Fim da partida
            if (player.getSanidade() > 0) { //Verificar se o jogador está vivo
                if (diario.getFantasma().equals(specter.getFantasma())) { //Verificar se o fantasma escolhido pelo jogador é o fantasma que está assombrando a casa
                    System.out.println("SISTEMA: Fantasma correto! Você Ganhou!"); //O jagador acertou o fantasma
                } else {
                    System.out.println("SISTEMA: Fantasma incorreto! O fantasma era "
                            + specter.getFantasma() + "! Game Over!"); //O jagador errou o fantasma
                }
            } else {
                System.out.println("SISTEMA: Você morreu! Game Over!"); //O jofgador morreu
            }
        } while (play == 1); //Quit game
    }
}
