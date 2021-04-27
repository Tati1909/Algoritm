package MyHW8;

public class Main {

    public static void hash(char x) {
        System.out.println((x >> 15) ^ x);
    }

    public static void hashFunc(char key, int f) {
        System.out.println(key % f);
    }

    public static void main(String[] args) {
        String hashStr = "t";
        char hashChar = 't';
        //встроенный хеш
        System.out.println(hashStr.hashCode());

        hash(hashChar);
        //хеш до 10
        hashFunc(hashChar, 10);
    }
}

