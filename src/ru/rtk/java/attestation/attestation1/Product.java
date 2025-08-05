package src.ru.rtk.java.attestation.attestation1;


class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name.isEmpty() || name.length() < 3) {
            System.out.println("Название продукта не может быть пустым или короче 3 символов");
            return;
        }
        if (price < 0) {  // проверка на отрицательное значение цены
            System.out.println("Цена не может быть отрицательной"); // вывод сообщения
            return;
        }

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name; // возвращает название продукта
    }

    public int getPrice() {
        return price;  // возвращает цену продукта
    }

    @Override
    public String toString() {
        return name; // возвращает название продукта
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;    // приведение типа
        return name.equals(product.name);    // сравнивает название продукта
    }

    @Override
    public int hashCode() {
        return name.hashCode();      // возвращает хэш-код
    }
}

