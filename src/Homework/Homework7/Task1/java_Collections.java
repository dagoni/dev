package src.ru.rtk.java.Homework.Homework7.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class java_Collections {

    // Метод принимает ArrayList с элементами типа T и возвращает Set с элементами типа T
    public static <T> Set <T> getUniqueElements(ArrayList<T> list) {

        return new HashSet<>(list); // Создаем новый HashSet
    }

    public static void main(String[] args) {
        // Создаем список чисел с дубликатами
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(1);
        numbers.add(3);

        // Получаем уникальные элементы
        Set<Integer> uniqueNumbers = getUniqueElements(numbers);

        // Выводим результат
        System.out.println("Cписок: " + numbers);
        System.out.println("Уникальные элементы, без дублей: " + uniqueNumbers);


    }

}

