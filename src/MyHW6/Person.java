package MyHW6;

public class Person {
    public String name;
    public int age;
    public int id;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public String toString() {
        return id + " " + name + " " + age;
    }


}
