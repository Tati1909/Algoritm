import java.util.Arrays;
import java.util.Random;

class ArrayC {
    private long[] a; //ссылка на массив
    private int elems; //кол-во элементов в массиве

    public ArrayC(int max){
        a = new long[max]; //создание массива размером max
        elems = 0; //размер массива увеличивается
    }
    public void into(long value) {  //метод вставки элемента в массив
        a[elems] = value; //вставка value в массив а
        elems++;
    }
    public void printer() {
        for(int i =0; i < elems; i++ ) {
            System.out.println(a[i] + " ");
            System.out.println(" ");
        }
        System.out.println("Вывод массива закончен");
    }

    public void swapM(int first, int last) {
        long buff = a[first];
        a[first] = a[last];
        a[last] = buff;
    }
    public void bubbleSort() {
        for(int i = elems-1; i >= 1; i-- ) {
            for(int j =0; i < i; j++ ) {
                if (a[j] > a[j+1])
                    swapM(j,j+1);
            }
        }
    }
}
public class MyHW2_4 {
    public static void main(String[] args) {
        int[] sArray = new int[400];
        int[] sArrayCopy;
        int buff;
        boolean sorted;
        sArray = new int[400];

        ArrayC ar = new ArrayC(400);

        Random rand = new Random();

        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = rand.nextInt(500);
            ar.into(rand.nextInt(500));

        }
        sArrayCopy = Arrays.copyOf(sArray,sArray.length);
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sArray.length-1; i++) {
                if (sArray[i] > sArray[i+1]) {
                    sorted = false;
                    buff = sArray[i];
                    sArray[i] = sArray[i+1];
                    sArray[i+1] = buff;
                }

            }
        }

        ar.bubbleSort();

        ar.printer();
        System.out.println("Длина массива: " + sArray.length);
        System.out.println("Отсортированный массив: " + Arrays.toString(sArray));
        System.out.println("Неотсортированный массив: " + Arrays.toString(sArrayCopy));


    }

}
