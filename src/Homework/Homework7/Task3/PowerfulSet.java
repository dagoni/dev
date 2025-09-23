package src.ru.rtk.java.Homework.Homework7.Task3;

import java.util.HashSet;
import java.util.Set;


public class PowerfulSet {
    /**
     * Метод для нахождения пересечения двух множеств
     */
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        // Создаем копию первого множества, чтобы не изменять оригинал
        Set<T> result = new HashSet<>(set1);
        // Метод retainAll оставляет только те элементы, которые есть в обоих множествах
        result.retainAll(set2);
        return result;
    }

    /**
     * Метод для нахождения объединения двух множеств без дубликатов
     * @return новое множество, содержащее все элементы из обоих множеств
     */
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        // Создаем копию первого множества
        Set<T> result = new HashSet<>(set1);
        // Метод addAll добавляет все элементы из второго множества
        result.addAll(set2);

        return result;
    }

    /**
     * Метод для нахождения разности двух множеств (set1 без set2)
     * Разность - это элементы, которые есть в первом множестве, но нет во втором
     * @return новое множество, содержащее элементы из set1, которых нет в set2
     */
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        // Создаем копию первого множества
        Set<T> result = new HashSet<>(set1);

        // Метод removeAll удаляет все элементы, которые есть во втором множестве
        // Остаются только элементы, уникальные для первого множества
        result.removeAll(set2);

        return result;
    }

    // Метод main для тестирования нашего класса
    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();

        // Создаем два множества для тестирования
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(4);

        // метод intersection (пересечение)
        Set<Integer> intersectionResult = powerfulSet.intersection(set1, set2);
        System.out.println("Пересечение: " + intersectionResult);

        // метод union (объединение)
        Set<Integer> unionResult = powerfulSet.union(set1, set2);
        System.out.println("Объединение: " + unionResult);

        // метод relativeComplement (разность)
        Set<Integer> complementResult = powerfulSet.relativeComplement(set1, set2);
        System.out.println("Разность set1 \\ set2: " + complementResult);

        // разность set2 \\ set1
        Set<Integer> complementResult2 = powerfulSet.relativeComplement(set2, set1);
        System.out.println("Разность set2 \\ set1: " + complementResult2);
    }
}