package MyHW8;

import java.util.Random;

class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;//элемента не существует

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
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

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal%=arrSize;//перебор к началу таблицы
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];//существующее значение
                hashArr[hashVal] = nonItem;//заменяем существующее значение на nonItem
                return temp;//возвращаем то, что удалили
            }
            ++hashVal;
            hashVal%=arrSize;
        }
        return null;
    }
    public Item find(int key) {
        int hashVal =hashFunc(key);
        while (hashArr[hashVal] != null) {
            if(hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal%=arrSize;//перебор к началу таблицы
        }
        return null;
    }
}

public class LinearProbing {
    public static void hashFunc2(int k, int size) {
        System.out.println(k % size);
    }

    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 30;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Item(584));
        hTable.insert(new Item(149));

        hTable.display();

        System.out.println("Ключ числа 584: ");
        hashFunc2(584,30);

        System.out.println(hTable.find(584).getKey());

        hTable.delete(149);

        hTable.display();

    }
}
