package data;

import java.util.NoSuchElementException;

public enum Option {
    ADD(0, "Dodaj kontakt"),
    REMOVE(1, "Usuń kontakt"),
    ELEMENTS(2, "Wypisz kontakty"),
    SEARCH(3, "Wyszukaj kontakt"),
    EXPORT(4,"Eksportuj do pliku tekstowego"),
    IMPORT(5, "Importuj z pliku"),
    EXIT(6, "Wyjdź z programu");





    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;

    }

    public static Option getByDescription(String description) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].description.equals(description)) {
                System.out.println(description);
                return values()[i];
            }
        }

        throw new NoSuchElementException("No option available");
    }

    public String getDescription(){return description;}



}
