package client;

import api.data.Equipment;
import api.data.User;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UsersListPane extends JPanel {
    public UsersListPane(OneUserPane oneUserPane) {
        super(new BorderLayout());
        UsersListModel usersListModel = new UsersListModel();
        JList<User> list = new JList<>(usersListModel);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((User)value).getLogin());
                return  this;
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Object selectedValue = list.getSelectedValue();
                    User user = (User) selectedValue;
                    oneUserPane.setUser(user);
                }
            }
        });

        add(list, BorderLayout.CENTER);

        List<User> allUsers = ServiceManager.getInstance().getTestService().getAllUsers();
        for(User user: allUsers) {
            System.out.println(user.getId() + "HI");
            usersListModel.addUser(user);
        }

    }
}
