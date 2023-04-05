
import dao.CarsDAO;
import dao.ClientsDao;
import model.Cars;
import model.Clients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class Main1 {
        public static void main(String[] args) throws SQLException {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            CarsDAO carsDAO = new CarsDAO(connection);
            ClientsDao clientsDao = new ClientsDao(connection);

            // Получение всех машин из базы данных
            List<Cars> cars = carsDAO.getAllCars();
            for (Cars car : cars) {
                System.out.println(car.getMark() + " " + car.getModel() + " " + car.getYear());
            }

            // Добавление новой машины в базу данных
            Cars newCar = new Cars("Audi", "A3", 2022);
            carsDAO.insertCar(newCar);



            // Получение всех клиентов из базы данных
            List<Clients> clients = clientsDao.getAllClients();
            for (Clients client : clients) {
                System.out.println(client.getId() + " " + client.getName() + " " + client.getEmail() + " " + client.getPhone());
            }

            // Добавление нового клиента в базу данных
            Clients clientById = clientsDao.getClientById(1);
            if (clientById != null) {
                System.out.println(clientById.getName() + " " + clientById.getEmail() + " " + clientById.getPhone());
            }


            // Удаление клиента из базы данных
            Clients clientToDelete = new Clients(4, "", "", "");
            clientsDao.deleteClient(clientToDelete);
        }
    }

