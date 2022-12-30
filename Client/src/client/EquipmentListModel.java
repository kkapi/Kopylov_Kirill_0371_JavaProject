package client;

import api.data.Equipment;

import javax.swing.*;
import java.util.ArrayList;

public class EquipmentListModel extends AbstractListModel {
    private ArrayList<Equipment> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    public void addEquipment(Equipment equipment) {
        list.add(equipment);
        fireIntervalAdded(equipment, list.size() - 1, list.size() - 1);
    }

    public void delete(int index) {
        Equipment removeEquipment = list.remove(index);
        fireIntervalRemoved(removeEquipment, index, index);
    }

    public void clearEquipment() {
        list.clear();
    }

}
