public class Sort {

    int count = 0;

    public void quicksort(int [] array, int l, int r){

        if(l< r){
            int index = partition(array,l,r);
            quicksort(array,l,index-1);
            quicksort(array,index+1,r);
        }
    }


    public int partition(int array [] ,int l, int r){
        int i = l -1;

        int pivot = array[r];

        for (int x = l; x < r; x ++) {
            if(array[x]<= pivot){
                i++;
                array = swap(array, i, x);
            }
        }

        array = swap(array,i+1,r);

        return i+1;
    }

    public int [] swap( int arr [], int i, int j){
        System.out.println(++count);
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
        return arr;
    }
}
