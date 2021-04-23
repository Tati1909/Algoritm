package MyHW6;

public class Node {
    public Person person;
    //наши потомки
    public Node leftChild;
    public Node rightChild;
    public void display() {
        System.out.println("Id: " + person.id + " Имя: " + person.name + " Возраст: " + person.age);
    }
}
