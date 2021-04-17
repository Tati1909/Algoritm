import java.util.Arrays;
import java.util.Random;

public class MyHW2 {
    public static void main(String[] args) {
        int[] mArray;
        mArray = new int[1_000_000];
        int key = 5;

        Random rand = new Random();

        for(int i =0; i < mArray.length; i++ ) {
            mArray[i] = rand.nextInt(1000000);
        }
        //System.out.println("Неотсортированный массив: " + Arrays.toString(mArray));
        Arrays.sort(mArray);
        //System.out.println("Отсортированный массив методом sort: " + Arrays.toString(mArray));

        //Задание 2

        //Линейный поиск
        long start = System.currentTimeMillis();
        System.out.println("****Линейный поиск****");
        for(int i =0; i < mArray.length; i++ ) {
            if (mArray[i] == key) {
                System.out.println("Ключ (значение 5) находится в отсортированном массиве под индексом: " + i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end-start));


        //Двоичный поиск
        long start2 = System.currentTimeMillis();

        System.out.println("****Двоичный  поиск****");
        System.out.println("Ключ (значение 5) находится в отсортированном массиве под индексом: " + (binarySearch(mArray, key)));
        long end2 = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end2-start2));
    }
        //Реализация двоичного поиска
    public static int binarySearch(int arr[], int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex)/2;

            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }
}
