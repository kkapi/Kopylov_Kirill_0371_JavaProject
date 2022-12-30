package client;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    public AdminPanel() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        tabbedPane.addTab("Экипировка", new EquipmentPane());
        tabbedPane.addTab("Клиенты", new UsersPane());

        add(tabbedPane);
    }
}
