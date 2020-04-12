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

public class searchPopularWords {
    public static void main(String[] args) {
        String[] omittedWords = {"już","tylko","przez","JEGO","TWÓJ","tak","jak","pod","czy","raz","oraz","oto","nie","ponieważ","lecz","może","być","sam","się","lub","dla","ws."};

        Path path1 = Paths.get("popular_words.txt");
        Path path2 = Paths.get("filtered_popular_words.txt");
        List<String> lines = new ArrayList<>();
        List<String> outList = new ArrayList<>();

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                lines.add(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(path1, lines);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }



        try {
            for (String line : Files.readAllLines(path1)) {
                String[] parts = line.split(" ");
                for (int i =0; i<parts.length;i++){
                    String temp1 = parts[i];
                   temp1 = ommitsCharInString(temp1);
                    if (isPopular(temp1,omittedWords)) {

                        outList.add(temp1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(path2, outList);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }



    }
    public static boolean isPopular(String wordToTest, String[] omittedWords) {

        if (wordToTest.length() < 3) {
            return false;
        } else {
            for (int i = 0; i < omittedWords.length; i++) {

                if (wordToTest.toLowerCase().equals(omittedWords[i].toLowerCase())){
                    return false;
                }
            }
        }

        return true;
    }

public static boolean isOmittedChar(char c,char[] omittedChar){
        for (int i =0; i< omittedChar.length;i++){
            if (c == omittedChar[i]) {

                return true;
            }
        }
        return false;
}

public static String ommitsCharInString(String s){
    char[] omittedChar ={',','.','?',':',';','!','-','"','#','\''};
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<s.length();i++){
            if (!isOmittedChar(s.charAt(i),omittedChar)) {
                temp.append(s.charAt(i));
            }
        }
    return temp.toString();
}

}
