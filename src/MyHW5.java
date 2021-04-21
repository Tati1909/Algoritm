import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class MyHW5 {
    public static void main(String[] args) {

        //Задание 5.2
        //Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.

        //someMethod();
        System.out.println("Рекурсия с условием выхода:");
        counter(3);

        //Задание 5.3
        //Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        method1();

        //Задание 5.4
        //Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        System.out.println(getFactorialNoRecursion(5));
        System.out.println(getFactorial(5));

        //Задание 5.5
        //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        int[] mArray;
        mArray = new int[20];
        Random rand = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = rand.nextInt(10);
        }
        Arrays.sort(mArray);
        System.out.println(Arrays.toString(mArray));
        //если 5 нету, то выведет размер массива 20
        System.out.println("Значение 5 есть под индексом: " + binSearch_r(mArray, 5, 0, mArray.length - 1));

    }

    private static void someMethod() {
        System.out.println("Hello!");
        someMethod();
    }

    private static void counter(int n) {
        System.out.println(n);
        if (n == 0)
            return;
        counter(n - 1);
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) {
            System.out.println(element.getMethodName());
        }
    }

    public static BigInteger getFactorial(int f) {
        if (f <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }

    public static int getFactorialNoRecursion(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static int binSearch_r(int[] arr, int searchKey, int low, int high) {
        if (low > high)
            return arr.length;
        int mid = (low + high) / 2;

        if (arr[mid] == searchKey)
            return mid;

        else if (arr[mid] < searchKey)

            return binSearch_r(arr, searchKey, low + 1, high);
        else {
            return binSearch_r(arr, searchKey, low, high - 1);
        }

    }
}
