public class SortAndCount {

    public int sort(int a [], int l, int r){
        int count1 = 0 ,  count2 = 0 , count3 = 0 ;
        if(l<r){ // abbruch des teile schrittes wenn rechts kleiner links

            int m = (l+r)/2; // halbiere das zu sortierende feld (teile schritt)

            count1 = sort(a,m+1, r); //rechtes teilarray
            count2 =  sort(a,l,m); //linkes teilarray

            count3 = mergeAndCount(a,l,m,r); //(herrsche schritt)

        }
        //addieren der einzelnen Vertauschungen
        return count1+count2+count3;
    }


    public int mergeAndCount (int a [], int l, int m, int r){

        int n1 = m -l +1;// länge des linken teilarrays
        int n2 = r - m; // länge des rechten teilarrays

        int linkesArray [] = new int[n1];
        int rechtesArray [] = new int[n2];

        //befüllen der arrays linkes --> vom anfang bis zur mitte des arrays
        //                    rechtes von mitte bis ende
        for (int i = 0; i < n1; i++){
            linkesArray[i] = a [l + i];
        } for (int i = 0; i < n2; i++){
            rechtesArray[i] = a [m + 1 + i];
        }

        int count = 0;

        int i = 0, j = 0; // indizes für linkes array(i) und rechtes array (j)

        int k = l; // index für das array in das die sortierten elemente eingefügt werden

        while (i < n1 && j < n2){
            // vergleich der array inhalte
            if(linkesArray[i] <= rechtesArray [j]){
                //wenn linkes element kleiner oder gleich dem des rechten elements dann kein tauschen nötig
                a[k] = linkesArray[i];
                i++;
            } else {
                // wenn rechtes element kleiner dann wird ein tausch der elemente vorgenommen
                a[k] = rechtesArray[j];
                j++;
                count+=m-i+1;
            }
            k++;
        }


        //wenn teilarrays sortiert füge die elemente in das sortierte array ein
        while( i < n1){
            a[k] = linkesArray[i];
            i++;
            k++;
        }

        while( j < n2){
            a[k] = rechtesArray[j];
            j++;
            k++;
        }
        return count;
    }
}
