package client;

import api.data.User;

import javax.swing.*;
import java.util.ArrayList;

public class UsersListModel extends AbstractListModel {
    private ArrayList<User> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    public void addUser(User user) {
        list.add(user);
        fireIntervalAdded(user, list.size()-1,list.size()-1);
    }

    public void delete(int index) {
        User removeUser = list.remove(index);
        fireIntervalRemoved(removeUser, index, index);
    }
}
