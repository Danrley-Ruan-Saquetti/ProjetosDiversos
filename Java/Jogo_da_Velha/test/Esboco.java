/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danrs
 */
public class Esboco {
    public static void main(String[] args) {
        
        String valor = "654";
        int valorX = Integer.parseInt(valor.substring(0, 1)), valorY = Integer.parseInt(valor.substring(1, 2));
        System.out.println("X: " + valorX + " - Y: " + valorY);
    }
}
