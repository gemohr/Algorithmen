public class Main_p {
  static int n;
    public static void main(String[] args) {

         n = 5;
        int partitionen [] = new int[n+1];
        int summe [] = new int[n+1];
        int k = 1;
        boolean isSucc;
        partitionen[k]=0;
        summe[k]=0;
        while (k>0){
            do{
                isSucc = isSuccessor(partitionen[k]);
                if(isSucc){
                    partitionen[k]++;
                    summe[k] = summe[k-1] + partitionen[k];
                }
            }while (isSucc && !isCandidat(summe[k]));

            if(isSucc){
                if(summe[k]==n){
                    //Lösung gefunden
                    int i;
                    for(i = 0; i<partitionen.length;i++){
                        if(partitionen[i]==0 || partitionen[i]==5) continue;
                        if(i+1>n && partitionen[i] == 1) {
                            System.out.print(" + " + partitionen[i]);
                            continue;
                        }
                        if(i+1<n) {
                            if (partitionen[i + 1] == n) {
                                System.out.print(partitionen[i]);
                                break;
                            }else{
                                System.out.print(partitionen[i]+" + ");
                            }
                        } else {
                            System.out.print(partitionen[i]);
                        }
                    }
                        System.out.print(" = " + n);
                        System.out.println();
                }else{
                    k++;
                    partitionen[k] = partitionen[k-1]-1;
                }
            }else k--;
        }

    }


    public static boolean isSuccessor(int a){
        return a < n;
    }
    public static boolean isCandidat(int a){
        return a <= n;
    }
}
