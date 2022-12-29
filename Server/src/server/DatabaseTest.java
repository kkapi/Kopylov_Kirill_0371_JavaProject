package server;

import api.Error.ApiError;
import api.data.Equipment;
import api.data.Horse;
import api.data.Role;
import api.data.User;
import com.sun.tools.jconsole.JConsoleContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseTest {
    public static void main(String[] args) {
        List<Equipment> equipmentList = new ArrayList<>();

        Connection conn = DataBaseManager.getInstance().getConnection();

        try {
            String sql = "SELECT id, name, price, description, type FROM equipment";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");

                System.out.println(id + "\t " + name);

                Equipment equipment = new Equipment();

                equipment.setName(name);
                equipment.setId(id);
                equipment.setPrice(price);
                equipment.setDescription(description);

                equipmentList.add(equipment);
            }

            System.out.println(equipmentList);


        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String horseName = "";
//
//        String url = "jdbc:postgresql://localhost:5432/ksk";
//        String user = "postgres";
//        String password = "2175446";
//
//        Connection conn = null;
//        try {
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
//
////            String sql = "CREATE TABLE horse (\n" +
////                    "id varchar(30) NOT NULL,\n" +
////                    "name VARCHAR (50) NOT NULL,\n" +
////                    "PRIMARY KEY (id)\n" +
////                    ");";
//
////            String sql = "INSERT INTO horse(id, name) VALUES (\'id\',\'name\')";
//
//
//
//            String sql = "SELECT id, name FROM horse";
//
////            String sql = "UPDATE horse SET name=\'Ромашка\' WHERE id=\'id\' ";
//
//            Statement statement = conn.createStatement();
////
////            int i = statement.executeUpdate(sql);
////
////            statement.execute(sql);
////
////            System.out.println(i);
//
//
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String name = resultSet.getString("name");
//                System.out.println(id + "\t" + name);
//                Horse horse = new Horse();
//                horse.setName(name);
//                horse.setId(id);
//                horseName = name;
//            }
//
//            statement.close();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

    }
    public static List<Horse> getHorses() {

        System.out.println("THIS IS GET HORSES");
        List<Horse> horses = new ArrayList<>();

        Connection conn = DataBaseManager.getInstance().getConnection();

        try {
            String sql = "SELECT id, name FROM horse";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println(id + "\t bup" + name);
                Horse horse = new Horse();
                horse.setName(name);
                horse.setId(id);
                horses.add(horse);
            }

            System.out.println(horses);

            return horses;

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return horses;
    }

    public static void addHorse(String id, String name) {
        Connection conn = DataBaseManager.getInstance().getConnection();
        Statement statement = null;
        String sql = "INSERT INTO horse(id, name) VALUES (\'" + id + "\',\'" + name + "\')";
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDb() {
        Connection conn = DataBaseManager.getInstance().getConnection();



        try {
            String sql = "CREATE TABLE users (\n" +
                    "id varchar(50) NOT NULL,\n" +
                    "login VARCHAR (50) NOT NULL,\n" +
                    "password VARCHAR (100) NOT NULL,\n" +
                    "phone VARCHAR (15),\n" +
                    "name VARCHAR (50),\n" +
                    "role VARCHAR (20) DEFAULT \'USER\',\n" +
                    "PRIMARY KEY (id)\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            throw new ApiError("Test");
        }

        try {
            String sql = "CREATE TABLE baskets (\n" +
                    "id varchar(50) NOT NULL,\n" +
                    "PRIMARY KEY (id),\n" +
                    "user_id VARCHAR(30) REFERENCES users (id)" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "CREATE TABLE equipment (\n" +
                    "id varchar(50) NOT NULL,\n" +
                    "name varchar(50) NOT NULL,\n" +
                    "price INT,\n" +
                    "description varchar(80),\n" +
                    "type varchar(20),\n" +
                    "PRIMARY KEY (id)\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "CREATE TABLE baskets_equipment (\n" +
                    "id varchar(50) NOT NULL,\n" +
                    "amount INT NOT NULL,\n" +
                    "baskets_id VARCHAR(50) REFERENCES baskets (id),\n" +
                    "equipment_id VARCHAR(50) REFERENCES equipment (id),\n" +
                    "PRIMARY KEY (id)\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String getNameById(String id) {
        Connection conn = DataBaseManager.getInstance().getConnection();
        String name = "";

        try {
            String sql = "SELECT name FROM horse WHERE id = \'" + id + "\'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            name = resultSet.getString("name");
            System.out.println("---" + id + "\t" + name + "----");

            System.out.println(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static User auth(String username, String password) {
        System.out.println(username);
        User user = new User();

        Connection conn = DataBaseManager.getInstance().getConnection();

        try {
            String sql = "SELECT id, password, phone, name, role FROM users WHERE login = \'" + username + "\'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String pass = resultSet.getString("password");
                String role = resultSet.getString("role");
                String phone = resultSet.getString("phone");
                String name = resultSet.getString("name");
                System.out.println("====id" + id + "====");
                System.out.println("====bdpas== (" + pass + ") ====");
                System.out.println("====formpass== (" + password + ") ====");


                if (!BCrypt.checkpw(password, pass)) {
                    throw new ApiError("Неверный пароль");
                }

                user.setId(id);
                user.setLogin(username);
                user.setName(name);
                user.setPhone(phone);

                if (role.equals("USER")) {
                    user.setRole(Role.USER);
                } else {
                    user.setRole(Role.ADMIN);
                }
            } else {
                System.out.println("Пусто");
                throw new ApiError("Пользователя с таким login не существует");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(user);

        return user;

    }

    public static void registration(String username, String password) {
        try {
            Connection conn = DataBaseManager.getInstance().getConnection();
            String sql = "SELECT id, password, phone, name, role FROM users WHERE login = \'" + username + "\'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("Уже существует");
                throw new ApiError("Пользователь с таким login уже существует");
            } else {
                String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
                System.out.println(hashPass);
                sql = "INSERT INTO users (id, login, password)\n" +
                        "VALUES(\'"+ UUID.randomUUID() + "\', \'" + username +"\', \'" + hashPass +"\')";
                statement.execute(sql);
                System.out.println("SUCCESS REGISTR" + username + " " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static User getUserById(String id) {
        Connection conn = DataBaseManager.getInstance().getConnection();

        User user = new User();

        try {
            String sql = "SELECT login, password, phone, name, role FROM users WHERE id = \'" + id + "\'";
            Statement statement = null;
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String login = resultSet.getString("login");
                String role = resultSet.getString("role");
                String phone = resultSet.getString("phone");
                String name = resultSet.getString("name");

                user.setLogin(login);
                user.setName(name);
                user.setPhone(phone);
                user.setId(id);

                if (role.equals("USER")) {
                    user.setRole(Role.USER);
                } else {
                    user.setRole(Role.ADMIN);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<Equipment> getAllEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();

        Connection conn = DataBaseManager.getInstance().getConnection();

        try {
            String sql = "SELECT id, name, price, description, type FROM equipment";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");

                System.out.println(id + "\t " + name);

                Equipment equipment = new Equipment();

                equipment.setName(name);
                equipment.setId(id);
                equipment.setPrice(price);
                equipment.setDescription(description);

                equipmentList.add(equipment);
            }

            System.out.println(equipmentList);


        } catch (SQLException e) {
            e.printStackTrace();
        }



        return equipmentList;
    }

    public Horse getHorseById(String id) {
        return null;
    }
}
