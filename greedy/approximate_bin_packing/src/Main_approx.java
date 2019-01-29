public class Main_approx {

    public static void main(String[] args) {

        int [] gewichte = {1,4,6,3,2,6,7};
        int capacity = 10;

        Fits fits = new Fits();

        System.out.println("Es werden " + fits.fits(gewichte,capacity) +" Container benötigt");
        for(int i=0;i<fits.container.length;i++){
            if(fits.container[i]!=null)
            System.out.println(fits.container[i]);
        }
    }
}
