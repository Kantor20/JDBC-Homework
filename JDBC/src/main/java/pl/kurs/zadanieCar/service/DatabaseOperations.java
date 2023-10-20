package pl.kurs.zadanieCar.service;

import pl.kurs.zadanieCar.connection.Config;
import pl.kurs.zadanieCar.model.Car;

import java.sql.*;

public class DatabaseOperations {
    public static void main(String[] args) throws SQLException {
        Config connection = new Config();

        Car myCar = new Car("Audi", "A4", 103014);
        Car myCar2 = new Car("Bmw", "520", 75621);
        Car myCar3 = new Car("Mercedes", "Eklass", 98452);
        Car myCar4 = new Car("Mercedes", "Eklass", 52452);

        insertCar(myCar, connection.getConnection());
        insertCar(myCar2,connection.getConnection());
        insertCar(myCar3,connection.getConnection());
        insertCar(myCar4,connection.getConnection());
        deleteCar(myCar4, connection.getConnection());

//        Statement statement = connection.createStatement();
//        String delete = "DELETE FROM cars";
//        statement.executeUpdate(delete);

    }

    public static boolean carExist(Car car, Connection connection) throws SQLException {
        String check = "SELECT count(*) FROM cars WHERE brand = ? AND model = ? AND price = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(check)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }
    }

    public static void addCarToDataBase(Car car, Connection connection) throws SQLException {
        String insert = "INSERT INTO cars(brand, model, price) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Samochód dodany.");
            }
        }
    }


    public static void insertCar(Car car, Connection connection) throws SQLException {
        if (!carExist(car, connection)) {
            addCarToDataBase(car, connection);
        } else {
            System.out.println("Samochod marki " + car.getBrand() + " znajduje się już w bazie danych!");
        }
    }

    public static void deleteCar(Car car, Connection connection) throws SQLException {
        String deleteQuery = "DELETE FROM cars WHERE brand = '"
                + car.getBrand() + "' AND model = '"
                + car.getModel() + "' AND price = "
                + car.getPrice() + ";";

        try (Statement statement = connection.createStatement()) {
            int affectedRows = statement.executeUpdate(deleteQuery);
            if (affectedRows > 0) {
                System.out.println("Samochod marki " + car.getBrand() + " zostal usuniety z bazy danych!");
            }
            else {
                System.out.println("Nie znaleziono samochodu marki " + car.getBrand() + " w bazie danych!");
            }
        }

    }
}