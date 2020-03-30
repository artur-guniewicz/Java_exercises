public abstract class Abstract {
    double a, b, dx, n;

    abstract double function(double x);
    double getValue(){
        double result = 0;

        for(double i=1;i<n-1;i++){
           result=result+function(a+i*dx);
        }

        result=(result+((function(a)-function(b)/2)))*dx;
        return result;
    }
}
