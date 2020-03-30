package pl.coderslab.warszataty11.zgaduj2;


import java.util.Scanner;

public class zgaduj22 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int guess;
        int min = 0, max = 1000;
        boolean win = false;
        int count = 1;

        System.out.println("Pomyśl liczbę od 0 d0 1000,");
        System.out.println("a ja ją zgadnę w max. 10 próbach.");

        while (!win) {
            guess = (int) (((max - min) / 2) + min);
            System.out.println("Próba nr " + count+ " Zgaduję: " + guess);
            System.out.println("Wciśnij: 1 - jeśli za dużo");
            System.out.println("Wciśnij: 2 - jeśli za mało");
            System.out.println("Wciśnij: 3 - jeśli zgadłem");

            int userAnswer = scanner.nextInt();

            switch (userAnswer) {
                case 1: {
                    max = guess;
                    count++;
                    break;
                }
                case 2: {
                    min = guess;
                    count++;
                    break;
                }
                case 3:
                    System.out.println("WYGRAŁEM!!!");
                    win = true;
                    break;
                default: {
                    System.out.println("Wybierz właściwą liczbę");
                }
            }

            if (count > 10){
                System.out.println("NIE OSZUKUJ!!!");
                count = 1;
                min = 0;
                max = 1000;
            }
            System.out.println("MIN = " + min + " MAX = " + max);
        }
    }


}
