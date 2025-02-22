
import java.util.Random;
import java.util.Scanner;

public class Classificar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int a[] = new int[5], repetida1 = 0, repetida2 = 0, par1 = -1, par2 = -1;

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(13);
            System.out.print(a[i] + "\t");
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (i != j) {
                    if (a[i] == a[j]) {
                        if (par1 == -1) {
                            par1 = a[i];
                            repetida1++;
                        } else {
                            if (par1 == a[i]) {
                                repetida1++;
                            } else {
                                if (par2 == -1) {
                                    par2 = a[i];
                                    repetida2++;
                                } else {
                                    repetida2++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("\nCartas repetidas " + repetida1 + "x " + par1 + "; " + repetida2 + "x " + par2);
    }
}
/*
01
02
03
04

*/