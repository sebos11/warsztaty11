package pl.coderslab.warszataty11.kostka;


import java.util.Random;


public class kostka {
    public static void main(String[] args) {

        System.out.println(rollDice("5D6-3"));
        System.out.println(rollDice("D10+2"));
        System.out.println(rollDice("5D3-2"));
        System.out.println(rollDice("20D999-100"));
        System.out.println(rollDice("D99-20"));
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
        return multiplyRoll(y,x) + z;
    }

    public static int rollD(int dimension){
        Random r = new Random();
        return r.nextInt(dimension)+1;
    }

    public static int multiplyRoll(int dimensionRoll, int countRoll){
        int sum = 0;
        for (int i = 1; i<=countRoll;i++){
            sum = sum + rollD(dimensionRoll);
        }
        return sum;
    }


}