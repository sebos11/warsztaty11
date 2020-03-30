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


public class wyszukiwarka {
    public static void main(String[] args) {
        Path path1 = Paths.get("path1.txt");
        List<String> outList = new ArrayList<>();
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                System.out.println(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
