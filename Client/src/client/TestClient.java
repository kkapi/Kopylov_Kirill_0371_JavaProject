package client;

import api.data.Horse;
import api.services.TestService;
import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;
import java.util.List;

public class TestClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8080/TestService";

        HessianProxyFactory factory = new HessianProxyFactory();
        TestService service = (TestService) factory.create(TestService.class, url);

        System.out.println(service.plus(9, 5));
        System.out.println(service.getAllHorses().size());
        List<Horse> allHorses = service.getAllHorses();
        for (Horse horse: allHorses) {
            System.out.println(horse.getId() + "\t" + horse.getName());
        }
    }
}
