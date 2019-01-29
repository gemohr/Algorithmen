public class Fits {

    String [] container = new String[10];

    public int fits(int [] gewicht, int c){

        int bin_rem = c, res=1;
        String gewichte="";

        for (int i=0; i<gewicht.length;i++){

            if(gewicht[i]<=bin_rem){
                bin_rem-=gewicht[i];
                gewichte +=""+gewicht[i]+" ";
            }else{
                container[res] = gewichte;
                gewichte="";
                res++;
                bin_rem = c-gewicht[i];
                gewichte+=""+gewicht[i]+" ";
            }

        }
        container[res]=gewichte;

        return res;
    }

}
