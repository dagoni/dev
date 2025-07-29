package src.ru.rtk.java.garbage;
import java.util.Scanner;

public class dz_1_test {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку из символов: ‘>’, ‘<’ и ‘-‘");
            String s = scanner.next();
            System.out.println("Введенная строка: " + s);
            int n = s.length();
            System.out.println("Длина строки: " + n);
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

            //canner.close();
        }


    }
}


