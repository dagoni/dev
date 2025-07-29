package src.ru.rtk.java.dz.dz5;
import java.util.Scanner;

public class dz5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите только маленькую букву английского алфавита: ");
            String input = scanner.next();
            char l = input.charAt(0);
            System.out.println("Введенная буква английского алфавита: " + l);
            String keyboard = "qwertyuiopasdfghjklzxcvbnm";
            int index = keyboard.indexOf(l);
            System.out.println("Индекс введенной буквы: " + index);
            if (index == -1) {
                System.out.println("Ошибка! Нужно вводить только буквы английского алфавита.");
            } else {
                //Индекс левой буквы
                int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
                System.out.println("Индекс левой буквы: " + leftIndex);
                char leftNeighbor = keyboard.charAt(leftIndex);
                System.out.println("Буква слева на клавиатуре: " + leftNeighbor);
            }
            //Проверка на заглавную букву
            if (Character.isUpperCase(Integer.hashCode(l))) {
                System.out.println("Это заглавная буква, нужно вводить маленькую.");
            }
            //Считываем дальше
            scanner.next();
        }
    }
}




