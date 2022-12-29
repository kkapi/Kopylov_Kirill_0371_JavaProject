package server;

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
    public void ping() {}

    @Override
    public List<Horse> getAllHorses() {
        return DatabaseTest.getHorses();
    }

    @Override
    public void addHorse(String id, String name) {
        DatabaseTest.addHorse(id, name);
    }
}
