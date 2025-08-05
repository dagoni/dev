package src.ru.rtk.java.Homework.Homework5;
import java.util.Scanner;

import static java.lang.System.exit;

public class Dz5_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите строку из символов: ‘>’, ‘<’ и ‘-‘");
            String s = scanner.next();
            System.out.println("Введенная строка: " + s);
            int n = s.length();
            System.out.println("Длина строки: " + n);

            if (s.length() > 106) {
                System.out.print("Строка слишком длинная, более 106 символов, выходим из программы");
                exit(0);
            }

            int count = 0;

            for (int i = 0; i <= n - 5; i++) {
                String sub = s.substring(i, i + 5);
                System.out.println("Проверяем позицию " + i + ": " + sub);
                if (sub.equals(">>-->") || sub.equals("<--<<")) {
                    count++;
                    System.out.println(" Найдена стрелка! Текущий счет: " + count);
                }
            }
            System.out.println("Всего стрелок: " + count);
            //scanner.close();
        }
    }
}

