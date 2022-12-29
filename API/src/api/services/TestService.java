package api.services;

import api.data.Equipment;
import api.data.Horse;
import api.data.User;

import java.util.List;

public interface TestService {
    int plus(int a, int b);

    int minus(int a, int b);

    void ping();

    List<Horse> getAllHorses();

    List<Equipment> getAllEquipment();

    void addHorse(String id, String name);

    void createDB();

    String getNameById(String id);

    User auth(String username, String password);

    void registration(String username, String password);

    User getUserById(String id);

    Equipment createEquipment(String name);

}
