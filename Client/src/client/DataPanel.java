package client;

import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
    public DataPanel() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        tabbedPane.addTab("Лошади", new HorsesPane());
        tabbedPane.addTab("Тренеры", new JButton("Тренеры")); //todo дописать тренеды
        tabbedPane.addTab("Клиенты", new JButton("Клиенты")); //todo дописать клиенты

        add(tabbedPane);
    }
}
