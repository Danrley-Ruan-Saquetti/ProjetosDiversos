
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu;
        do {
            do {
                System.out.print("\n+-\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
                menu = s.nextInt();
                if ((menu < 1) || (menu > 2)) {
                    System.out.println("SISTEMA: Valor inválido!");
                }
            } while ((menu < 1) || (menu > 2));
            if (menu == 1) {
                String palavras[] = {"amarelo", "amiga", "amor", "ave", "bolo", "branco", "bama",
                    "baneca", "belular", "blube", "bopo", "boce", "befante", "bscola", "bstojo", "baca",
                    "foto", "garfo", "geleia", "girafa", "janela", "limonada", "meia", "noite", "ovo",
                    "pai", "parque", "passarinho", "peixe", "pijama", "rato", "umbigo"};

                Algoritmo alg = new Algoritmo(palavras[r.nextInt(palavras.length)]);

                do {
                    System.out.print("\nSISTEMA: Vidas: " + alg.getVida() + "\n.");
                    for (int i = 0; i < alg.getLetra().length; i++) {
                        if (alg.getLetra()[i]) {
                            System.out.print(alg.getPalavra().substring(i, i + 1) + ".");
                        } else {
                            System.out.print("_.");
                        }
                    }
                    System.out.print("-> Informe uma letra: ");
                    alg.revelarLetra(s.next());
                } while ((!alg.verificarPalavra()) && (alg.getVida() > 0));
                if (alg.getVida() > 0) {
                    System.out.println("SISTEMA: Parabéns! Você Acertou a palavra");
                } else {
                    System.out.println("SISTEMA: A palavra era " + alg.getPalavra() + "! Game Over!");
                }
            }
        } while (menu == 1);
        System.out.println("Bye Bye");
    }
}
