public class Mergesort {



    public static void main(String[] args) {
        int [] array  = {2,11,1,5};
        int [] array2 = {2,11,1,5};
        int [] array3 = {2,11,1,5};
        printArray(array);
        Sort s = new Sort();
        s.sort(array, 0, array.length -1);
        printArray(array);
        SortAndCount sac = new SortAndCount();
        System.out.println("Vertauschungen: " + sac.sort(array2, 0, array.length -1));

    }


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



}
