import java.util.Locale;
import java.util.Scanner;

public class DefiniteIntegral extends Abstract {

    public double function(double x){
        return (x*x); //funkcja x^2
    }

    public DefiniteIntegral(double a, double b, double n){ //początek, koniec, ilość podziałów - konstruktor
        this.b=b;
        this.a=a;
        this.n=n;
        dx=(b-a)/n;
    }



    public static void main(String[] args) {
        Scanner parameters = new Scanner(System.in);
        parameters.useLocale(Locale.US);

        System.out.println("Podaj poczatek przedzialu:");
        double a = parameters.nextDouble();

        System.out.println("Podaj koniec przedzialu:");
        double b = parameters.nextDouble();

        System.out.println("Podaj ilosc podzalow przedzialu:");
        double n = parameters.nextDouble();

        DefiniteIntegral integral = new DefiniteIntegral(a,b,n);
        System.out.println("Wartosc tej calki w przyblizeniu wynosi: " + integral.getValue());


    }
}
