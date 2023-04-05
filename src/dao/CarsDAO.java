package dao;

import model.Cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsDAO {

    private Connection connection;

    public CarsDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cars> getAllCars() throws SQLException {
        List<Cars> cars = new ArrayList<>();
        String query = "SELECT * FROM cars";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String make = resultSet.getString("mark");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                Cars car = new Cars(make, model, year);
                cars.add(car);
            }
        }
        return cars;
    }

    public void insertCar(Cars car) throws SQLException {
        String query = "INSERT INTO cars (mark, model, year) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getMark());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.executeUpdate();
        }
    }

    public void deleteCar(Cars car) throws SQLException {
        String query = "DELETE FROM cars WHERE mark=? AND model=? AND year=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getMark());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.executeUpdate();
        }
    }
}
