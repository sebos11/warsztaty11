package pl.coderslab.warszataty11.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lotto {

    public static void main(String[] args) {
        int number = 0;
        int count = 0;
        boolean powtorka = false;
        Integer[] userArr = new Integer[6];
        Integer[] arr = new Integer[49];
        Integer[] arrRandom = new Integer[49];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        System.out.println("LOTTO - ");
        System.out.println("Podaj 6 liczb z zakresu od 1 do 49: ");
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            while (!(number >= 1 && number <= 49 && !powtorka)) {
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Podaj prawidłową liczbę od 1 do 49");
                }
                number = scan.nextInt();
                if (!(number >= 1 && number <= 49)){
                    System.out.println("podaj liczbę z prawidłowego zakresu (od 1 do 49)");
                }
                powtorka = jest(userArr, number);
                if (powtorka) {
                    System.out.println("liczba powtórzona - podaj jeszcze raz");

                }
            }
                userArr[i] = number;
                System.out.println("Podałeś liczbę nr " + (i + 1) + " = " + number);
                number = 0;
        }

        System.out.println("Podane przez Ciebie liczby " + Arrays.toString(userArr));
        System.out.print("wylosowane liczby: ");

        for (int i=0; i<6; i++) {
            System.out.print(arr[i] +"  " );
            if (jest(userArr, arr[i])) {
                count++;
            }
        }

        if (count >= 3) {
            System.out.println("trafiłeś co najmniej trójkę");
        }
    }

    public static boolean jest(Integer[] arr, Integer liczba){
        for (int i = 0; i<6;i++){
            if (arr[i] == liczba)
                return true;
            }
        return false;
    }
}
