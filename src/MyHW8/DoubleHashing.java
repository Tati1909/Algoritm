package MyHW8;

import java.util.Random;

class HashTableDouble {
    private ItemDouble[] hashArr;
    private int arrSize;
    private ItemDouble nonItem;//элемента не существует

    public HashTableDouble(int size) {
        this.arrSize = size;
        hashArr = new ItemDouble[arrSize];
        nonItem = new ItemDouble(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public int hashFuncDouble(int key) {
        return 5 - key % 5;//наша константа, которая больше нуля
    }

    public void insertDouble(ItemDouble item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arrSize;//перебор к началу таблицы
        }
        hashArr[hashVal] = item;
    }

    public ItemDouble delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                ItemDouble temp = hashArr[hashVal];//существующее значение
                hashArr[hashVal] = nonItem;//заменяем существующее значение на nonItem
                return temp;//возвращаем то, что удалили
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public ItemDouble find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arrSize;//перебор к началу таблицы
        }
        return null;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++)
            if (isPrime(i))
                return i;
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++)
            if (n % j == 0)
                return false;
        return true;
    }
}

class ItemDouble {
    private int data;

    public ItemDouble(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}


public class DoubleHashing {
    public static void hashFunc2(int k, int size) {
        System.out.println(k % size);
    }

    public static void main(String[] args) {
        ItemDouble aDataItem;
        int aKey;
        int size = 30;

        HashTableDouble hTable = new HashTableDouble(size);
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = rand.nextInt(999);
            aDataItem = new ItemDouble(aKey);
            hTable.insertDouble(aDataItem);
        }

        hTable.insertDouble(new ItemDouble(584));
        hTable.insertDouble(new ItemDouble(149));

        hTable.display();

        System.out.println("Ключ числа 584: ");
        hashFunc2(584, 30);

        System.out.println(hTable.find(584).getKey());

        hTable.delete(149);

        hTable.display();

    }
}

