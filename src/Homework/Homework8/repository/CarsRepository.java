package src.ru.rtk.java.Homework.Homework8.repository;
import src.ru.rtk.java.Homework.Homework8.model.Car;
import java.util.List;

public interface CarsRepository {
    List<Car> getAllCars();
    void saveCars(List<Car> cars);
}
