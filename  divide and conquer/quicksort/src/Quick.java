public class Quick {

    public static void main(String[] args) {

        int array [] = {1,2,11,5};
        printArray(array);
        Sort s = new Sort();
        s.quicksort(array, 0, array.length-1);
       printArray(array);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }




}
