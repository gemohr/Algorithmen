public class Maximum {

    public int max(int [] array, int l, int r ) {
        if(l < r) {
            int m = (r + l) / 2;
            return max(array, l, m) > max(array, m + 1, r) ? max(array, l, m) : max(array, m + 1, r);
        }
        return 0 <= l && l < array.length ? array[l] : 0;
    }


}
