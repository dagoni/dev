package src.ru.rtk.java.Homework.homework06;
import java.time.LocalDate;


class DiscountProduct extends Product {

    private int discount;
    private LocalDate validUntil;

    public DiscountProduct(String name, int price, int discount, LocalDate validUntil) {
        super(name, price);

        if (discount <= 0 || discount > 100) {
            System.out.println("Размер скидки должен быть больше 0 и меньше 100%");
            return;
        }

//        if (price <= 0 ) {
//            System.out.println("Цена должна быть больше 0");
//            return;
//        }

        this.discount = discount;
        this.validUntil = validUntil;


    }

    // геттеры
    public int getDiscount() {
        return discount;
    }

    public LocalDate getValidUntil() { //
        return validUntil;
    }

    // сеттеры
    public void setDiscount(int discount) {

        this.discount = discount;
    }

    public void setValidUntil(LocalDate validUntil) {

        this.validUntil = validUntil;
    }

    // метод для получения текущей цены
    public int getCurrentPrice() {

        if (validUntil == null) {
            System.out.println("Дата окончания скидки не задана");
            return getPrice(); // Возвращаем обычную цену
        }

        if (LocalDate.now().isBefore(validUntil)) {
            return (int) (getPrice() * (100 - discount) / 100);
        } else {
            return getPrice(); // если скидка закончилась
        }
    }

    @Override
    public String toString() {

        return name + " (скидка " + discount + "% до " + validUntil + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountProduct)) return false;

        DiscountProduct that = (DiscountProduct) o;

        if (!super.equals(o)) return false;
        if (discount != that.discount) return false;
        return validUntil != null ? validUntil.equals(that.validUntil) : that.validUntil == null;
    }

    @Override
    public int hashCode() {

        return super.hashCode() ^ discount ^ validUntil.hashCode();
    }
}
