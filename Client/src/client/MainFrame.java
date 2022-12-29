package client;

import api.data.Role;
import api.data.User;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(User user) throws HeadlessException {
        super("EtuSkiBase");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        JButton exit = new JButton("Выход");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AuthFrame authFrame = new AuthFrame();
                authFrame.setSize(1200, 800);
                authFrame.setLocationRelativeTo(null);
                authFrame.setVisible(true);
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("База", new DataPanel());
        tabbedPane.addTab("Профиль", new ProfilePanel(user, exit));
        if (user.getRole() == Role.ADMIN) {
            tabbedPane.addTab("Админка", new AdminPanel());
        }

        add(tabbedPane);
    }
}
