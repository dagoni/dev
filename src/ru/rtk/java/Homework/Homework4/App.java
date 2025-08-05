package src.ru.rtk.java.Homework.Homework4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. Телевизор с фиксированными параметрами
        TV tv1 = new TV("Samsung", "QN90A", 55.0, "4K", "QLED", 120, "Tizen");
        System.out.println("Телевизор 1 (фиксированный):");
        System.out.println(tv1);

        // 2. Телевизор со случайными параметрами
        TV tv2 = TV.createRandomTV();
        System.out.println("\nТелевизор 2 (случайный):");
        System.out.println(tv2);

        // 3. Телевизор с вводом параметров с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nСоздание телевизора 3:");

        System.out.print("Бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Диагональ (дюймы): ");
        double diagonal = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Разрешение: ");
        String resolution = scanner.nextLine();

        System.out.print("Тип матрицы: ");
        String matrix = scanner.nextLine();

        System.out.print("Частота обновления (Гц): ");
        int refreshRate = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Smart система: ");
        String smartSystem = scanner.nextLine();


        System.out.print("Модель: ");
        String model = scanner.nextLine();

        TV tv3 = new TV(brand, model, diagonal, resolution, matrix, refreshRate, smartSystem);
        System.out.println("\nТелевизор 3 создан:");
        System.out.println(tv3);

        scanner.close();
    }
}