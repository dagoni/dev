package src.ru.rtk.java.garbage;

import java.util.Scanner;

import static java.lang.System.exit;

public class dz2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите строку: ");
            String s = scanner.nextLine();
            if (s.length() > 106) {
                System.out.print("Строка слишком длинная, выходим из программы");
                exit(0);
            }

            int count = 0;
            for (int i = 0;
                 i <= s.length() - 5;
                 i++) {
                char c = s.charAt(i);
                if (c == '>') {
                    if (s.charAt(i + 1) == '>' &&
                            s.charAt(i + 2) == '-' &&
                            s.charAt(i + 3) == '-' &&
                            s.charAt(i + 4) == '>') {
                        count++;
                    }
                } else if (c == '<') {
                    if (s.charAt(i + 1) == '-' &&
                            s.charAt(i + 2) == '-' &&
                            s.charAt(i + 3) == '<' &&
                            s.charAt(i + 4) == '<') {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

