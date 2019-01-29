import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Search {

    private Punkt best1, best2;
    private int bestDistance = Integer.MAX_VALUE;


    public int sort(Punkt [] punkte){
        printArray(punkte);
        int n = punkte.length;
        if (n <= 1) return 0;
        // sort by x-coordinate (breaking ties by y-coordinate)
        Punkt[] pointsByX = new Punkt[n];
        for (int i = 0; i < n; i++) pointsByX[i] = punkte[i];
        Arrays.sort(pointsByX, Punkt.X_ORDER);

        // sort by y-coordinate (breaking ties by x-coordinate)
        Punkt[] pointsByY= new Punkt[n];
        for (int i = 0; i < n; i++) pointsByY[i] = punkte[i];
        Arrays.sort(pointsByY, Punkt.Y_ORDER);

        Punkt[] aux = new Punkt[n];

        return closest(pointsByX,pointsByY,aux,0,n-1);

        }

    private int closest(Punkt[] pointsByX, Punkt[] pointsByY, Punkt[] aux, int lo, int hi) {
        if (hi <= lo) return Integer.MAX_VALUE;

        int mid = lo + (hi - lo) / 2;
        Punkt median = pointsByX[mid];

        int delta1 = closest(pointsByX, pointsByY, aux, lo, mid);
        int delta2 = closest(pointsByX, pointsByY, aux, mid+1, hi);
        int delta;

        if (delta1 < delta2){
            delta = delta1;
        }else{
            delta = delta2;
        }

        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsByY[i].x - median.x) < delta)
                aux[m++] = pointsByY[i];
        }

        // compare each point to its neighbors with y-coordinate closer than delta
        for (int i = 0; i < m; i++) {
            // a geometric packing argument shows that this loop iterates at most 7 times
            for (int j = i+1; (j < m) && (aux[j].y - aux[i].y < delta); j++) {
                int distance = dist(aux[i],aux[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = delta;
                        best1 = aux[i];
                        best2 = aux[j];
                    }
                }
            }
        }
        return delta;

    }

    public int dist(Punkt p1, Punkt p2){

        return (int) Math.sqrt(Math.pow((p1.x-p2.x),2) + Math.pow((p1.y -p2.y),2));
    }

    public Punkt either() {
        return best1;
    }

    public Punkt other() {
        return best2;
    }

    /* A utility function to print array of size n */
    static void printArray(Punkt arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i].toString() + " ");
        System.out.println();
    }
}
