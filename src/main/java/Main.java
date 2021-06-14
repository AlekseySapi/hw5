import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int[] arr, copyArr, newArr, copyNewArr;
    private static long startTime, sortTime, sortMergeTime;
    private static int n;

    public static void main(String[] args) {

//        Задание 5.2
        n = 100;
//        countdownInf(n);
        countdown(n);


/*
        Задание 5.3
        Пример стека вызова: стопка тарелок - положить тарелку можно только наверх и взять только сверху.
        Пример стека вызова с рекурсией: факториал, поиск.
 */

        System.out.println("\n");

//        Задание 5.4
        n = 100;
        startTime = System.nanoTime();
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println("\nПечать чисел через цикл прошла за " + (System.nanoTime() - startTime) + " нс");

        System.out.println();

        n = 100;
        startTime = System.nanoTime();
        countdown(n);
        System.out.println("\nПечать чисел через рекурсию прошла за " + (System.nanoTime() - startTime) + " нс");

        System.out.println("");

//        Задание 5.5
        arr = new int[30];
        copyArr = new int[30];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(20);
        }
        copyArr = Arrays.copyOf(arr, arr.length);

        System.out.println("\nМассив:");
        System.out.println(Arrays.toString(arr));
        System.out.println();


        startTime = System.nanoTime();
        Arrays.sort(arr);
        binarySearch(arr, 7, 0, arr.length - 1);
        System.out.println("Двоичный поиск занял: " + (System.nanoTime() - startTime) + " нс");

        System.out.println();

        startTime = System.nanoTime();
        recBinarySearch(7, 0, copyArr.length - 1, copyArr);
        System.out.println("Рекурсивный двоичный поиск занял: " + (System.nanoTime() - startTime) + " нс");

        System.out.println("\n");

//        Задание 5.6
        newArr = new int[100];
        copyNewArr = new int[100];
        Random rand2 = new Random();
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = rand2.nextInt(20);
        }
        copyNewArr = Arrays.copyOf(newArr, newArr.length);

        startTime = System.nanoTime();
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
        sortTime = System.nanoTime() - startTime;
        System.out.println("Сортировка методом sort: " + sortTime + " нс");

        startTime = System.nanoTime();
        System.out.println(Arrays.toString(sortMerge(copyNewArr)));
        sortMergeTime = System.nanoTime() - startTime;
        System.out.println("Сортировка методом слияния: " + sortMergeTime + " нс");
        if (sortTime < sortMergeTime) {
            System.out.println("\nСортировка методом sort быстрее!");
        } else System.out.println("\nСортировка методом слияния быстрее!");

    }

    public static int countdownInf(int n) {
        System.out.println(n);
        return countdownInf(n - 1);
    }

    public static int countdown(int n) {
        System.out.print(n + " ");
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


    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int mid = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, mid)), sortMerge(Arrays.copyOfRange(arr, mid, len)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }


}
