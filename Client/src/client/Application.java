package client;

import api.Error.ApiError;
import api.data.Horse;

import javax.swing.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            ServiceManager.getInstance();

            String name = ServiceManager.getInstance().getTestService().getNameById("id");
            System.out.println("AAAAAAAAAAAAAAAAA" + name);

            ServiceManager.getInstance().getTestService().createDB();



        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, "Сервер не отвечает!", "Ошибка подключения", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ApiError e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка подключения", JOptionPane.ERROR_MESSAGE);

        }

        AuthFrame authFrame = new AuthFrame();
        authFrame.setSize(1200, 800);
        authFrame.setLocationRelativeTo(null);
        authFrame.setVisible(true);

    }
}
