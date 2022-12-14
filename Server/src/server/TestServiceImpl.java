package server;

import api.data.Equipment;
import api.data.Horse;
import api.data.User;
import api.services.TestService;
import com.caucho.hessian.server.HessianServlet;

import java.util.List;

public class TestServiceImpl extends HessianServlet implements TestService {
    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public void createDB() {
        DatabaseTest.createDb();
    }

    @Override
    public String getNameById(String id) {
        return DatabaseTest.getNameById(id);
    }

    @Override
    public User auth(String username, String password) {
        return DatabaseTest.auth(username, password);
    }

    @Override
    public void registration(String username, String password) {
        DatabaseTest.registration(username, password);
    }

    @Override
    public User getUserById(String id) {
        return DatabaseTest.getUserById(id);
    }

    @Override
    public Equipment createEquipment(String name) {
        return DatabaseTest.createEquipment(name);
    }

    @Override
    public void deleteEquipment(String id) {
        DatabaseTest.deleteEquipment(id);
    }

    @Override
    public void setEquipmentInfo(Equipment equipment) {
        DatabaseTest.setEquipmentInfo(equipment);
    }

    @Override
    public void ping() {}

    @Override
    public List<Horse> getAllHorses() {
        return DatabaseTest.getHorses();
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return DatabaseTest.getAllEquipment();
    }

    @Override
    public List<User> getAllUsers() {
        return DatabaseTest.getAllUsers();
    }

    @Override
    public void addHorse(String id, String name) {
        DatabaseTest.addHorse(id, name);
    }
}
