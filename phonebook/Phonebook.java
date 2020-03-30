import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {

    Map<String, Integer> phoneBook;

    Phonebook() {
        phoneBook = new TreeMap<>(); //TreeMap sortuje klucze
    }

    void load() {
        String name, nr;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("ksiazkatelefoniczna.txt"));
            while(scanner.hasNextLine()){
                name = scanner.nextLine();
                nr = scanner.nextLine();
                phoneBook.put(name, Integer.parseInt(nr)); //wstawiamy do mapy pary klucz wartość
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void save(){
        try{
            PrintWriter output = new PrintWriter("ksiazkatelefoniczna.txt");

            for(Map.Entry<String, Integer> entry : phoneBook.entrySet()){
                output.println(entry.getKey());
                output.println(entry.getValue());
                output.flush();
            }
            output.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void print(){
        //phoneBook.forEach((k, v) -> System.out.println("imie: " + k + ", numer: " + v));
        System.out.println(phoneBook);
    }

    public int search(String imie){
        if(phoneBook.containsKey(imie)) return phoneBook.get(imie);
        return 0;
    }
    public void add(String imie, Integer nr){ phoneBook.put(imie, nr); }

    public void delete(String imie){ phoneBook.remove(imie); }




    public static void main(String[] args) throws FileNotFoundException {

        Phonebook p = new Phonebook();
        p.load();
        p.print();
        System.out.println(p.search("Anna"));

        p.save();
    }


}
