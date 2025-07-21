package src.ru.rtk.java;
import java.util.Arrays;
import java.util.Random;



//Ожидаемый результат:
//        1. Создан класс Телевизор;
//2. У класса есть поля, свойства и методы. Поля желательно сделать
//private. Задать новые значения полям класса можно через конструктор.
//        4. Создан класс App с методом main.
//        5. В методе main класса App создано несколько экземпляров класса
//Телевизор.
//6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры
//или случайным числом.
//Формат представления работы:
//        1. Ссылка на программу и отчёт (постановка задачи, код задачи и
//        результат в консоли IDE Intellij Idea) в GitHub;
//2. Архив с выполненным заданием, прикрепленный на платформу
//Иннополис. В архиве должны быть:
//a. Программный код задачи;
//b. Отчёт со скринами выполнения задач (постановка задачи, код
//        задачи и результат в консоли IDE Intellij Idea).
//Описания плана работы:
//Выполнение задания в соответствии с формулировкой требований к
//задаче. Задание является первым шагом к объектному моделированию
//предметной области с последующей реализацией на Java.



public class TV {

    // Основные характеристики
    private String brand;            // Бренд (Samsung, LG, Sony и т.д.)
    private double diagonal;        // Диагональ экрана в дюймах
    private String resolution;      // Разрешение ("Full HD", "4K", "8K")
    private String matrixType;      // Тип матрицы ("OLED", "QLED", "IPS", "VA")
    private int refreshRate;        // Частота обновления (Гц)

    // Дополнительные характеристики
    private String smartSystem;     // Smart TV система ("Android TV", "webOS", "Tizen")
    private String model;           // Модель телевизора
    private int guarantee;          // Гарантия

    // Основной конструктор
    public TV(
            String brand,
            double diagonal,
            String resolution,
            String matrixType,
            int refreshRate,
            String smartSystem,
            String model,
            int guarantee
    ) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.matrixType = matrixType;
        this.refreshRate = refreshRate;
        this.smartSystem = smartSystem;
        this.model = model;
        this.guarantee = 1;
    }

    // Конструктор с минимальными параметрами
    public TV(String samsung, double v, String s, String brand, double diagonal, String tizen, String resolution) {
        this( brand,
                diagonal,
                resolution,
                "IPS",
                60,
                "Basic OS",
                "Standard",
                1);
    }
    // Сеттеры
    public void SetBrand(String brand){
        this.brand = brand;
    }

    public void SetDiagonal(double diagonal){
        this.diagonal = diagonal;
    }

    public void SetResolution(String resolution){
        this.resolution = resolution;
    }

    public void SetMatrixType(String matrixType){
        this.matrixType = matrixType;
    }

    public void SetRefreshRate(int refreshRate){
        this.refreshRate = refreshRate;
    }

    public void SetSmartSystem(String smartSystem){
        this.smartSystem = smartSystem;
    }

    public void SetModel(String model){
        this.model = model;
    }



    // Гетеры
    public String GetBrand(){
        if (brand == null){
            return "Неизвестно";
        }else {
            return brand;
        }
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String GetResolution(){
        if (resolution == null){
            return "Неизвестно";
        }else {
            return resolution;
        }
    }

    public String GetMatrixType(){
        if (matrixType == null){
            return "Неизвестно";
        }else {
            return matrixType;
        }
    }

    public int GetRefreshRate(){
       return refreshRate;
    }

    public String GetSmartSystem(){
        if (smartSystem == null){
            return "Неизвестно";
        }else {
            return smartSystem;
        }
    }

    public String Getmodel(){
        if (model == null){
            return "Неизвестно";
        }else {
            return model;
        }
    }

    public int GetQuarantee(){
        return guarantee;

    }


    public String toString() {
        return "Телевизор: " + brand + ", \n Модель:  " + model +
                ", \n Диагональ: " + diagonal + " дюймов, " + " \n Разрешение: " + resolution + ", \n Матрица " + matrixType + ", \n Частота обновления " + refreshRate + " ГЦ " + ", \n Система " + smartSystem + ", \n Гарантия " + guarantee + " лет ";
    }




//
//
//    int guarantee


    // Статический метод для создания случайного телевизора
    public static TV createRandomTV() {
        Random rand = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Philips", "Panasonic"};
        String[] models = {"Q80A", "C1", "X90J", "OLED806", "HZ2000"};
        String[] resolutions = {"Full HD", "4K", "8K"};
        String[] matrices = {"OLED", "QLED", "IPS", "VA"};
        String[] systems = {"Tizen", "webOS", "Android TV", "Google TV"};
        //System.out.println(Arrays.toString(brands));

        return new TV(
                brands[rand.nextInt(brands.length)],
                32 + rand.nextDouble() * 73, // Диагональ 32-105"
                resolutions[rand.nextInt(resolutions.length)],
                matrices[rand.nextInt(matrices.length)],
                60 + rand.nextInt(18) * 10,  // Частота 60-240 Гц
                systems[rand.nextInt(systems.length)],
                models[rand.nextInt(models.length)]
        );
    }




}
