public class HW1 {

    /* Примеры:
    Алгоритм «Купить билет на поезд»:
сесть в автобус
приехать на вокзал
пойти в кассу
купить билет

Структуры данных:
Линейная структура данных — список домов на улице.
Примером иерархической структуры может служить книга, как иерархическая последовательность букв, которые объединяются в слова, слова – в предложения, предложения - в параграфы, затем в главы и т. д.
Табличная структура данных — школьный журнал (номер ученик и его ФИО).
*/
    public static void main(String[] args) {
        int a = 5;
        String text = "Hello world!!";
        Person person = new Person("Вася", 35);

        String text2 = "Hello world!!";
        Person person2 = new Person("Вася", 40);

        long start = System.currentTimeMillis();
        //выводим на экран
        System.out.println(a + " " + text + " " + person);
        // сравниваем текст
        System.out.println(text.equals(text2));
        //сравниваем объекты только по имени
        System.out.println(person.equals(person2));
        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }

}
