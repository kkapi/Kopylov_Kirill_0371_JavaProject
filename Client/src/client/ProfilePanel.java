package client;

import api.data.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JTextField textName = new JTextField(20);
    private JTextField textPhone = new JTextField(20);


    public ProfilePanel(User user, JButton exit) {
        super();

        User userInfo = ServiceManager.getInstance().getTestService().getUserById(user.getId());
        textName.setText(userInfo.getName());
        textPhone.setText(userInfo.getPhone());

        setLayout(new FlowLayout());
        add(new JLabel("ID: " + user.getId()));
        add(new JLabel("login: "+ user.getLogin()));
        add(new JLabel("Роль: " + user.getStringRole()));

        add(new JLabel("Имя:"));
        add(textName);
        add(new JLabel("Телефон:"));
        add(textPhone);
        add(exit);

    }
}
