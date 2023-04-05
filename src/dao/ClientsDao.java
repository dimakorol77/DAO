package dao;

import model.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDao {

    private Connection connection;

    public ClientsDao(Connection connection) {
        this.connection = connection;
    }

    public List<Clients> getAllClients() throws SQLException {
        List<Clients> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Clients client = new Clients(id, name, email, phone);
                clients.add(client);
            }
        }
        return clients;
    }

    public Clients getClientById(int id) throws SQLException {
        Clients client = null;
        String query = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                client = new Clients(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email"), resultSet.getString("phone"));
            }
        }
        return client;
    }

    public void insertClient(Clients client) throws SQLException {
        String query = "INSERT INTO clients (id, name, email, phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPhone());
            statement.executeUpdate();
        }
    }

    public void deleteClient(Clients client) throws SQLException {
        String query = "DELETE FROM clients WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getId());
            statement.executeUpdate();
        }
    }
}
