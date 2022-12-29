package client;

import api.data.Equipment;
import api.data.Horse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EquipmentListPane extends JPanel {
    public EquipmentListPane(OneEquipmentPane oneEquipmentPane) {
        super(new BorderLayout());
        JButton addButton = new JButton("Добавить");
        JButton delButton = new JButton("Удалить");
        EquipmentListModel equipmentListModel = new EquipmentListModel();
        JList<Equipment> list = new JList<>(equipmentListModel);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((Equipment)value).getName());
                return  this;
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(
                        EquipmentListPane.this,
                        "Введите название",
                        "Создание",
                        JOptionPane.PLAIN_MESSAGE
                );
                System.out.println(name);
                if (name != null) {
                    Equipment equipment = new Equipment();
                    equipment.setName(name);
                    equipmentListModel.addEquipment(equipment);
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                equipmentListModel.delete(selectedIndex);
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Object selectedValue = list.getSelectedValue();
                    Equipment equipment = (Equipment) selectedValue;
                    System.out.println(equipment.getName());
                    oneEquipmentPane.setEquipment(equipment);
                }
            }
        });

        JPanel buttonPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);

        List<Equipment> allEquipment = ServiceManager.getInstance().getTestService().getAllEquipment();
        for(Equipment equipment: allEquipment) {
            equipmentListModel.addEquipment(equipment);
        }
    }
}
