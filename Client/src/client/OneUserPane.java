package client;

import api.data.User;

import javax.swing.*;
import java.awt.*;

public class OneUserPane extends JPanel {
    private User user;
    private JTextField idText = new JTextField(20);
    private JTextField loginText = new JTextField(20);
    private JTextField roleText = new JTextField(20);
    private JTextField nameText = new JTextField(20);
    private JTextField phoneText = new JTextField(20);

    public OneUserPane() {
        super(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("id:"));
        add(idText);
        add(new JLabel("login:"));
        add(loginText);
        add(new JLabel("role:"));
        add(roleText);
        add(new JLabel("name:"));
        add(nameText);
        add(new JLabel("phone:"));
        add(phoneText);

        idText.setEnabled(false);
        loginText.setEnabled(false);
        roleText.setEnabled(false);
        nameText.setEnabled(false);
        phoneText.setEnabled(false);
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            idText.setText(user.getId());
            loginText.setText(user.getLogin());
            roleText.setText(user.getStringRole());
            nameText.setText(user.getName());
            phoneText.setText(user.getPhone());

        } else {
            idText.setText("");
            loginText.setText("");
            roleText.setText("");
            nameText.setText("");
            phoneText.setText("");
        }
    }
}
