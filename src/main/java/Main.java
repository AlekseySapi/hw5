import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int[] bigArr;
    private static int[] copyBigArr;
    private static long startTime;
    private static int n;

    public static void main(String[] args) {

//        Задание 5.2
        n = 100;
//        countdownInf(n);
        countdown(n);


/*
        Задание 5.3
        Пример стека вызова: стопка тарелок - полодить тарелку можно только наверх и взять только сверху.
        Пример стека вызова с рекурсией: факториал, поиск.
 */

//        Задание 5.4
        n = 100;
        startTime = System.nanoTime();
        while (n > 0) {
            System.out.println(n);
            n--;
        }
        System.out.println("Печать чисел через цикл прошла за " + (System.nanoTime() - startTime) + " нс");

        System.out.println();

        n = 100;
        startTime = System.nanoTime();
        countdown(n);
        System.out.println("Печать чисел через рекурсию прошла за " + (System.nanoTime() - startTime) + " нс");

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
