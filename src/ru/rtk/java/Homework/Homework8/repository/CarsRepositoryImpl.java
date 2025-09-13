package src.ru.rtk.java.Homework.Homework8.repository;
import src.ru.rtk.java.Homework.Homework8.model.Car;
import java.io.*;               // Импорт всех классов пакета java.io для работы с вводом-выводом
import java.util.ArrayList;     // Импорт класса ArrayList для работы с динамическими массивами
import java.util.List;          // Импорт интерфейса List для работы со списками

public class CarsRepositoryImpl implements CarsRepository {
    private final String filePath;

    public CarsRepositoryImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Пропустить первую строку (заголовок)
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 5) {
                    cars.add(new Car(
                            data[0],
                            data[1],
                            data[2],
                            Long.parseLong(data[3]),
                            Long.parseLong(data[4])
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return cars;
    }

    @Override
    public void saveCars(List<Car> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Car car : cars) {
                writer.println(String.format("%s|%s|%s|%d|%d",
                        car.getNumber(),
                        car.getModel(),
                        car.getColor(),
                        car.getMileage(),
                        car.getCost()));
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
