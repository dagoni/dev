package src.ru.rtk.java.Homework.homework06;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>(); // Список продуктов
        ArrayList<Person> people = new ArrayList<>(); // Список покупателей

        // Создание продуктов
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 50);
        //Product hot_dog = new Product("Хот-дог", 500);


        Product test1 = new Product("", 50); // Пустая название
        Product test2 = new Product("Пе", 50); // Вводимая строка меньше 3 символов

        DiscountProduct coffee = new DiscountProduct("Кофе", 879, 20, LocalDate.of(2025, 12, 31));
        DiscountProduct cookie = new DiscountProduct("Печенье", 50, 30, LocalDate.of(2025, 12, 31));

        DiscountProduct hot_dog1= new DiscountProduct("Хот-дог1", 0, 10, LocalDate.of(2025, 12, 31));
        DiscountProduct hot_dog2 = new DiscountProduct("Хот-дог2", 50, 0, LocalDate.of(2025, 12, 31));


        // Создание покупателя
        Person person = new Person("Павел Андреевич", 10000);

        // Выполнение покупок
        person.buy_groceries(bread);     // 40 руб
        person.buy_groceries(coffee);    // 703.20 руб (скидка 20%)
        person.buy_groceries(cookie);
        person.buy_groceries(hot_dog1);
        //person.buy_groceries(hot_dog2);

        System.out.println(person);
        //System.out.println("Остаток: " + person.getMoney() + " руб");
        //System.out.println(coffee.name,person.toString() );

        // Выводим информацию о нем
        System.out.println(coffee);
        System.out.println(bread);

   }



}
