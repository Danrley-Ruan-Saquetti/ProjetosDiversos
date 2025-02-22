
import java.util.Random;

public class Esboco {

    public static void main(String[] args) {
        Random r = new Random();
        String setOfCharacters = "abcdefghxyz1234567-/@";

        char randomChar = setOfCharacters.charAt(r.nextInt(26));

        System.out.println(randomChar);
    }
}
