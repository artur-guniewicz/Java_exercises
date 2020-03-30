import static java.lang.Math.pow;

public class PierwiastekStopniaN {

    public static final double precision = 1.0e-5;

    public static double getPower(double number, double power){
        if(number == 0){return 1;}
        double temp = number;

        for(int i=0;i<power-1;i++){
            number=number*temp;
        }

        return number;
     }


    public static double getRoot(int n,double number){
        double root = number;

        do{
            root = ((n-1)*root + (number/pow(root,n-1)))/n;

        }while((getPower(root,n)>number+precision)||((getPower(root,n))<number-precision));

        return root;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double number = Double.parseDouble(args[1]);

        double wynik = getRoot(n,number);
        System.out.println("Wynik wynosi: " + wynik);


    }
}
