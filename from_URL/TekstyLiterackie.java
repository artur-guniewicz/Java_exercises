import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.TreeMap;

public class TekstyLiterackie {


    public static void main(String[] args) throws IOException {

        //URL url = new URL("https://wolnelektury.pl/media/book/txt/baczynski-koleda.txt");
        URL url = new URL("http://mojinformatycznytest.cba.pl/test.txt");
        InputStream is = url.openStream();
        Scanner scanner = new Scanner(new InputStreamReader(is));
        TreeMap<Integer, Integer> mapa = new TreeMap<>();
        while (scanner.hasNext()) {
            String temp = scanner.next(); //zapisujemy aktualnie analizowany wyraz
            if (mapa.containsKey(temp.length())) //jeśli już mamy słowo o tej liczbie liter:
                mapa.put(temp.length(), mapa.get(temp.length()) + 1); //powiększamy liczbę wystąpień (value) o 1
            else
                mapa.put(temp.length(), 1); //jeśli nie, tworzymy nowy klucz z wartością 1
        }
        mapa.forEach((k,v) -> System.out.println("Ile liter: " + k + " Ile razy wystepuje: " + v));
    }
}


