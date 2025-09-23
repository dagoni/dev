package src.ru.rtk.java.Homework.Homework7.Task2;
import java.util.*;


public class Anagram {

    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Получаем первую строку от пользователя
        System.out.println("Введите первую строку:");
        String firstString = scanner.nextLine();

        // Получаем вторую строку от пользователя
        System.out.println("Введите вторую строку:");
        String secondString = scanner.nextLine();

        // Проверяем, являются ли строки анаграммами
        boolean result = isAnagram(firstString, secondString);

        // Выводим результат
        System.out.println("Результат: " + result);

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }

    // Метод для проверки, являются ли две строки анаграммами
    public static boolean isAnagram(String s, String t) {
        // Если строки разной длины, они не могут быть анаграммами
        if (s.length() != t.length()) {
            return false;
        }

        // Приводим обе строки к нижнему регистру для регистронезависимого сравнения
        s = s.toLowerCase();
        t = t.toLowerCase();

        // Создаем HashMap для подсчета количества каждого символа в первой строке
        // Character - тип ключа (символы), Integer - тип значения (количество повторений)
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Проходим по каждому символу первой строки
        for (char c : s.toCharArray()) {
            // Если символ уже есть в карте, увеличиваем его счетчик на 1
            // Если символа нет, добавляем его со значением 1
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Проходим по каждому символу второй строки
        for (char c : t.toCharArray()) {

            // Получаем количество текущего символа в карте
            // Если символа нет в карте, getOrDefault вернет 0
            int count = charCountMap.getOrDefault(c, 0);

            if (count == 0) {
                return false;
            }

            charCountMap.put(c, count - 1);
        }

        // Если дошли до этой точки, значит, все символы совпали
        return true;
    }



}
