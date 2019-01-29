public class Main_BINZ {

    public static void main(String[] args) {
        binaerDivAndConq(5);
    }

    // a = 1, b = 2, f(n) = O(1)
    public static void binaerDivAndConq(int number){

        if(number > 0) {

            binaerDivAndConq(number / 2);
            System.out.print(number%2);
        }

    }
}
