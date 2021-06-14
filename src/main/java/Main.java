public class Main {

    public static void main(String[] args) {

        int n = 100;
//        countdownInf(n);
        countdown(n);

    }

    public static int countdownInf(int n) {
        System.out.println(n);
        return countdownInf(n - 1);
    }

    public static int countdown(int n) {
        System.out.println(n);
        if (n == 1) {
            return 1;
        }
        return countdown(n - 1);
    }

}
