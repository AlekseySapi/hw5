import org.w3c.dom.ls.LSOutput;

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

        System.out.println();

//        Задание 5.5
        bigArr = new int[20];
        copyBigArr = new int[20];
        Random rand = new Random();
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = rand.nextInt(20);
        }

        copyBigArr = Arrays.copyOf(bigArr, bigArr.length);

        System.out.println("\nМассив:");
        System.out.println(Arrays.toString(bigArr));
        System.out.println();



        int i;
        startTime = System.nanoTime();
        Arrays.sort(bigArr);
        i = binarySearch(bigArr, 7, 0, bigArr.length - 1);
        System.out.println("i: " + i);
        System.out.println("Двоичный поиск занял: " + (System.nanoTime() - startTime) + " нс");

        System.out.println();

        startTime = System.nanoTime();
        i = recBinarySearch(7, 0, copyBigArr.length - 1, copyBigArr);
        System.out.println("i: " + i);
        System.out.println("Рекурсивный двоичный поиск занял: " + (System.nanoTime() - startTime) + " нс");

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


    private static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static int recBinarySearch(int searchKey, int low, int high, int[] arr) {
        if (low > high) {
            return arr.length;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == searchKey) {
            return mid;
        } else if (arr[mid] < searchKey) {
            return recBinarySearch(searchKey, mid + 1, high, arr);
        } else {
            return recBinarySearch(searchKey, low, mid - 1, arr);
        }
    }


}
