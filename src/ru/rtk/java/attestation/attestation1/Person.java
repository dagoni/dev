package src.ru.rtk.java.attestation.attestation1;


import java.util.ArrayList;

class Person {
    private String name; // Имя покупателя
    private int money;   // Сколько денег он имеет
    private ArrayList<Product> grocerybag; // Список покупок
    // Конструктор
    public Person(String name, int money) {
        if (name.length() < 3 || name.isEmpty()) { // Проверка на пустое имя
            System.out.println("Имя не может быть пустым или короче 3 символов");
            return;
        }
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
            return;
        }

        this.name = name;
        this.money = money;
        this.grocerybag = new ArrayList<>(); // Создаем пустой список
    }

    public String getName() {
        return name; // Возвращаем имя
    }

    public int getMoney() {
        return money; // Возвращаем деньги
    }

    public ArrayList<Product> getGrocerybag() {
        return grocerybag;  // Возвращаем список покупок
    }

    public void buy_groceries(Product product) {
        if (money >= product.getPrice()) {  // Если денег достаточно
            money -= product.getPrice();   // Вычитаем из них деньги
            grocerybag.add(product);       // Добавляем в корзину
            System.out.println(name + " купил " + product.getName()); // Выводим сообщение
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());  // Выводим сообщение
        }
    }

    @Override
    public String toString() {
        if (grocerybag.isEmpty()) { // Если список покупок пуст
            return name + " - Ничего не куплено";
        }

        StringBuilder result = new StringBuilder(name + " - ");  // Строка для вывода
        for (int i = 0; i < grocerybag.size(); i++) {            // Цикл по всем покупкам
            result.append(grocerybag.get(i).getName());          // Добавляем в строку название
            if (i < grocerybag.size() - 1) {                     // Если это не последняя покупка
                result.append(", ");                             // Добавляем запятую
            }
        }
        return result.toString();                                // Возвращаем строку
    }

    @Override
    public boolean equals(Object o) {                            // Переопределение метода equals
        if (this == o) return true;                              // Если ссылки равны
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;                              // Преобразование объекта к типу Person
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {                                       // Переопределение метода hashCode
        return name.hashCode();                                  // Возвращаем хэш-код имени
    }
}

