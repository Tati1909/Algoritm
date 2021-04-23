package MyHW6;

public class Main {
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.insert(new Person(5, "Вася", 47));
        theTree.insert(new Person(7, "Олег", 32));
        theTree.insert(new Person(3, "Петя", 15));
        theTree.insert(new Person(9, "Женя", 25));

        System.out.println("Максимальный ключ:");
        theTree.max().display();
        System.out.println("Минимальный ключ:");
        theTree.min().display();
        System.out.println("Поиск по ключу 3:");
        theTree.find(3).display();
//удаляем узел с id 9
        theTree.delete(9);

        System.out.println();

        theTree.displayTree();


    }
}
