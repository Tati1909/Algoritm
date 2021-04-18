import java.util.*;

public class MyHW3 {
    public static void main(String[] args) {

        //1.преобразовали массив в коллекцию ArrayList
        String[] mArray = {"1","2","3","4","5"};
        List<String> listString = new ArrayList<>(Arrays.asList(mArray));
        System.out.println("ArrayList: " + listString);

        //2.На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения
        // объекта или элемента из списка.
        listString.add("6");
        listString.add("7");
        listString.add("8");
        System.out.println("Добавили элементы: " + listString);
        listString.remove(3);
        listString.remove("6");
        System.out.println("Удалили элементы: " + listString);
        System.out.println("Получаем элементы с помощью метода get: ");
        for (int i = 0; i < listString.size(); i++) {
            System.out.print(listString.get(i));
        }
        System.out.println(" ");

        //3.Реализуйте простой односвязный список и его базовые методы.
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove(3);
        linkedList.remove(6);
        System.out.println("Удалили элементы: " + linkedList);
        System.out.println("Получаем элементы с помощью метода get: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i));
        }
        System.out.println(" ");

        //4. На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        //Реализуйте список заполненный объектами из вашего класса из задания 1.3
        LinkedList<String> linkedList2 = new LinkedList<>(Arrays.asList(mArray));
        System.out.println("Двусвязный LinkedList: " + linkedList2);
        linkedList2.addFirst("0");
        linkedList2.addLast("6");
        System.out.println("Добавили элементы в двусвязный LinkedList: " + linkedList2);
        System.out.println("Смотрим первый элемент: " + linkedList2.peekFirst());
        System.out.println("Смотрим последний элемент: " + linkedList2.peekLast());

        List<Person> linkedListPerson = new LinkedList<>();
        linkedListPerson.add(new Person("Коля", 56));
        linkedListPerson.add(new Person("Вася", 34));
        linkedListPerson.add(new Person("Петя", 28));
        System.out.println("LinkedList из объектов Person: " + linkedListPerson);

        // 5. Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        Iterator<String> iterator = linkedList2.iterator();

        int idx = 0;
        //удалим второй элемент и выведем наш список
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
            if(idx == 1)
                iterator.remove();
            idx++;
        }
        System.out.println(" ");
        System.out.println("Удалили второй элемент: " + linkedList2);









    }
}
