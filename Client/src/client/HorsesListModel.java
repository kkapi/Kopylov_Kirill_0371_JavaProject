package client;

import api.data.Horse;

import javax.swing.*;
import java.util.ArrayList;

public class HorsesListModel extends AbstractListModel {

    private ArrayList<Horse> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    public void addHorse(Horse horse) {
        list.add(horse);
        fireIntervalAdded(horse, list.size() - 1, list.size() - 1);
    }

    public void delete(int index) {
        Horse removeHorse = list.remove(index);
        fireIntervalRemoved(removeHorse, index, index);
    }
}
