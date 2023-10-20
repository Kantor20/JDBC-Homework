package pl.kurs.zadanieCar.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter@EqualsAndHashCode@ToString
public class Car {
    private Integer id;
    private final String brand;
    private final String model;
    private final int price;

    public Car(String brand, String model, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
