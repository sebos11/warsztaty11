package pl.coderslab.warszataty11.wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class tester {
    public static void main(String[] args) {

        Path path1 = Paths.get("popular_words.txt");
        Path path2 = Paths.get("filtered_popular_words.txt");
        List<String> lines = new ArrayList<>();
        String temp;


        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                lines.add(elem.text());
                //System.out.println(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(path1, lines);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        try {
            for (String line : Files.readAllLines(path1)) {
                String[] parts = line.split(" ");
                for (int i =0; i<parts.length;i++){
                    System.out.println(parts[i]);
                }

               // System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
   /* Wywołaj pobieranie dla wybranych serwisów internetowych.
        Pomiń wszystkie elementy krótsze niż 3-znakowe.
        Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
        Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
        filtered_popular_words.txt, który zawierać będzie wszystkie znalezione słowa,
        pomijając słowa wykluczone.*/