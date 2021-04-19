import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MyHW4 {
    public static void main(String[] args) {
        //Задание 4.1 На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.

        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Олег",37));
        personStack.push(new Person("Коля", 56));
        personStack.push(new Person("Вася", 34));
        personStack.push(new Person("Петя", 28));
        System.out.println("Stack из объектов Person: " + personStack);

        System.out.println("Просмотрим последний элемент стэка: " + personStack.peek());

        personStack.pop();
        System.out.println("Удалили последний элемент стэка: " + personStack);

        System.out.println("****************");

        //Задание 4.2 На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        // Реализуйте вспомогательные методы.
        Queue<Person> personQueue = new ArrayBlockingQueue<Person>(10);
        personQueue.add(new Person("Коля", 56));
        personQueue.add(new Person("Вася", 34));
        personQueue.add(new Person("Петя", 28));
        System.out.println("Queue из объектов Person: " + personQueue);
        System.out.println("Вернем (удалим) первый элемент в голове: " + personQueue.remove());
        System.out.println("Смотрим какой элемент стоит первый в очереди: " + personQueue.peek());
        System.out.println("Queue из объектов Person: " + personQueue);
        System.out.println("Смотрим пустой ли массив: " + personQueue.isEmpty());
        System.out.println("Проверяем размер массива: " + personQueue.size());
        System.out.println("****************");

        //Задание 4.3
        //На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        Deque<Person> personDeque = new ArrayDeque<>();
        personDeque.add(new Person("Коля", 56));
        personDeque.add(new Person("Вася", 34));
        personDeque.add(new Person("Петя", 28));
        System.out.println("Deque из объектов Person: " + personDeque);
        personDeque.addFirst(new Person("Гена", 32));
        personDeque.addLast(new Person("Оля", 36));
        System.out.println("Deque из объектов Person: " + personDeque);
        personDeque.pollFirst();
        System.out.println("Deque из объектов Person: " + personDeque);
        System.out.println("****************");

        //Задание 4.4
        //Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(8);
        priorityQueue.add(10);
        priorityQueue.add(12);
        priorityQueue.offer(2);
        System.out.println(priorityQueue);












    }
}
