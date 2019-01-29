public class Berechnung {

    float eps;
    public Berechnung(float eps){
        this.eps=eps;

    }

    public double f(double x){
        return (1/(1 + x*x));
    }

    public double berechne(double a, double b){

        if( (b - a) > eps ){
            double c = (b+a)/2;
            return berechne(a,c) +  berechne(c,b);

        }else{
            return (b-a)*((f(b)-f(a))/2);
        }
    }


}
