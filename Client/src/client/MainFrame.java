package client;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        super("KSK");
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
        tabbedPane.addTab("Расписание", new JButton("Расписание")); //todo дописать расписание
        tabbedPane.addTab("База", new DataPanel());
        tabbedPane.addTab("Профиль", exit);



        add(tabbedPane);
    }
}
