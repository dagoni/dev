package src.ru.rtk.java.Homework.Homework8.test;
import src.ru.rtk.java.Homework.Homework8.model.Car;
import src.ru.rtk.java.Homework.Homework8.repository.CarsRepository;
import src.ru.rtk.java.Homework.Homework8.repository.CarsRepositoryImpl;
import java.util.List;          // Для работы с интерфейсом List (списки)
import java.util.stream.Collectors; // Для операций с потоками данных (Stream API)
import java.util.ArrayList;     // Для использования реализации списка на основе массива
import java.io.FileWriter;      // Для записи символов в файл
import java.io.PrintWriter;     // Для записи форматированных данных в файл
import java.io.IOException;     // Для обработки исключений ввода-вывода

public class Main {

    public static void main(String[] args) {
        // Путь к файлу с данными
        String filePath = "C:/Users/dago/IdeaProjects/dev/src/ru/rtk/java/Homework/Homework8/data/input_cars.txt";
        // Инициализация репозитория
        CarsRepository repository = new CarsRepositoryImpl(filePath);
        // Загрузка автомобилей из файла
        List<Car> cars = repository.getAllCars();
        // Список для хранения результатов
        List<String> results = new ArrayList<>();
        // Вывод всех автомобилей
        results.add("Автомобили в базе:");
        results.add("Number Model Color Mileage Cost");
        for (Car car : cars) {
            results.add(car.toString());
        }

        // Параметры для фильтрации
        String colorToFind = "Black";
        long mileageToFind = 0;
        long priceRangeStart = 700_000;
        long priceRangeEnd = 800_000;
        String modelToFind = "Toyota";
        String modelToFindVolvo = "Volvo";

        // Номера автомобилей по цвету или пробегу
        List<String> filteredNumbers = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        results.add("Номера автомобилей по цвету или пробегу: " + String.join(" ", filteredNumbers));

        // Уникальные модели в ценовом диапазоне
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= priceRangeStart && car.getCost() <= priceRangeEnd)
                .map(Car::getModel)
                .distinct()
                .count();
        results.add("Уникальные автомобили: " + uniqueModelsCount + " шт.");

        // Цвет автомобиля с минимальной стоимостью
        String minCostColor = cars.stream()
                .min((c1, c2) -> Long.compare(c1.getCost(), c2.getCost()))
                .map(Car::getColor)
                .orElse("Не найдено");
        results.add("Цвет автомобиля с минимальной стоимостью: " + minCostColor);

        // Средняя стоимость модели Toyota
        double avgToyotaCost = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind))
                .mapToDouble(Car::getCost)
                .average()
                .orElse(0.0);
        results.add(String.format("Средняя стоимость модели Toyota: %.2f", avgToyotaCost));

        // Средняя стоимость модели Volvo
        double avgVolvoCost = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFindVolvo))
                .mapToDouble(Car::getCost)
                .average()
                .orElse(0.0);
        results.add(String.format("Средняя стоимость модели Volvo: %.2f", avgVolvoCost));

        // Вывод результатов
        for (String line : results) {
            System.out.println(line);
        }

        // Сохранение результатов
        String resultsFilePath = "C:/Users/dago/IdeaProjects/dev/src/ru/rtk/java/Homework/Homework8/data/cars.txt";
        saveResultsToFile(resultsFilePath, results);
        System.out.println("Результаты сохранены в файл: " + resultsFilePath);
    }


    private static void saveResultsToFile(String filePath, List<String> lines) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи результатов в файл: " + e.getMessage());
        }
    }

}
