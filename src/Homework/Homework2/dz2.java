package src.ru.rtk.java.Homework.Homework2;

import java.util.Scanner;

public class dz2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.nextLine().charAt(0);
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        int index = keyboard.indexOf(input);
        int prevIndex = (index - 1 + keyboard.length()) % keyboard.length();
        System.out.println(keyboard.charAt(prevIndex));
    }





}
