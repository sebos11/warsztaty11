package pl.coderslab.warszataty11;

import java.util.Random;
import java.util.Scanner;

public class gra {
    public static void main(String[] args) {
        System.out.println("zadanie 1");
        Random losowa = new Random();
        int wylosowanaLiczba = losowa.nextInt(100) + 1;

        System.out.println("wylosowałem liczbę zgadnij jaką ?");
        Boolean win = false;
        while   (!win) {
            System.out.println("podaj liczbę");
            int liczba = wczytajLiczbe();

            if (liczba > wylosowanaLiczba) {
                System.out.println("podana liczba jest za duża");
            } else if (liczba < wylosowanaLiczba) {
                System.out.println("wylosowana liczba jest za mała");
            } else {
                System.out.println("zgadłeś!!!!");
                win = true;
            }
        }

    }
    public static int wczytajLiczbe(){
        Scanner wczytaj = new Scanner(System.in);
        while (!wczytaj.hasNextInt()){
            System.out.println("musisz podac liczbe");
            wczytaj.next();
        }
        return wczytaj.nextInt();
    }
}
