package client;

import api.services.TestService;
import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.client.HessianRuntimeException;

import java.net.MalformedURLException;

public class ServiceManager {

    private static ServiceManager sm;
    private TestService testService;

    private ServiceManager() throws MalformedURLException {
        String url = "http://localhost:8080/TestService";

        HessianProxyFactory factory = new HessianProxyFactory();
        testService = (TestService) factory.create(TestService.class, url);

    }

    public static ServiceManager getInstance() {
        if (sm == null) {
            try {
                sm = new ServiceManager();
                sm.testService.ping();
            } catch (MalformedURLException | HessianRuntimeException e) {
                throw new ConnectionException();
            }
        }
        return sm;
    }

    public TestService getTestService() {
        return testService;
    }
}
