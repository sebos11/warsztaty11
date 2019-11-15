package pl.coderslab.warszataty11.kostka;

import java.util.function.DoubleToIntFunction;

public class kostka {
    public static void main(String[] args) {
        int wynik = rollDice("10D10+20");
    }

    public static int rollDice(String dice) {
        int xStr;
        String xD = "";
        int x, y, z = 0;
        int dIndex = dice.indexOf("D");
        xD = dice.substring(0, dIndex);
        if (xD.equals("")) {
            x = 1;
        } else {
            x = Integer.parseInt(xD);
        }


        if (dice.contains("+")) {
            int plusIndex = dice.indexOf("+");
            y = Integer.parseInt(dice.substring(dIndex + 1, plusIndex));
            z = Integer.parseInt(dice.substring(plusIndex + 1));

        } else if (dice.contains("-")) {
            int minusIndex = dice.indexOf("-");
            y = Integer.parseInt(dice.substring(dIndex + 1, minusIndex));
            z = Integer.parseInt(dice.substring(minusIndex));

        } else {


            String yStr = dice.substring(dIndex + 1);
            y = Integer.parseInt(yStr);
            z = 0;

        }
        System.out.println(x + ",  " + y +", " + z);
        return -1;
    }

}