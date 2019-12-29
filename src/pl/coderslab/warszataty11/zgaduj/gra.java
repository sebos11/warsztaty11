package pl.coderslab.warszataty11.zgaduj;

import java.util.Random;
import java.util.Scanner;

public class gra {
    public static void main(String[] args) {
        System.out.println("zadanie 1");
        Random losowa = new Random();
        int zakres = 10;
        int licznik = 0;
        int limit = 1;
        System.out.print("Ustal górną granicę przedziału liczbowego z którego mam wylosować liczbę <1 , X>  X=  ");
        zakres = wczytajLiczbe();
        System.out.print("Podaj w ilu próbach odgadniesz wylosowaną liczbę - Liczba prób = ");
        limit = wczytajLiczbe();

        int wylosowanaLiczba = losowa.nextInt(zakres) + 1;

        System.out.println("wylosowałem liczbę zgadnij jaką ? MASZ  " + limit +"  prób");

        boolean win = false;
        while (!win) {
            System.out.print("podaj liczbę = ");
            int liczba = wczytajLiczbe();
            licznik++;
            if (liczba > wylosowanaLiczba) {
                System.out.println("podana liczba jest za duża - Twoja próba nr  " + licznik + "  z " + limit+"  prób ");
            }
             if (liczba < wylosowanaLiczba) {
                 System.out.println("podana liczba jest za mała - Twoja próba nr " + licznik + " z "+ limit +"  prób");
             }
              if (liczba == wylosowanaLiczba) {
                      System.out.println("zgadłeś!!!!  w próbie nr " + licznik);
                       win = true;
                   }
              if (licznik == limit && !win) {
                  System.out.println("wyczerpałeś limit prób - KONIEC GRY");
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
