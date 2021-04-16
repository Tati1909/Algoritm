public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }

    //сравниваем объекты только по имени
    public boolean equals(Object obj) {
        Person otherPerson = (Person) obj;
        return this.name == otherPerson.name;
    }
}
