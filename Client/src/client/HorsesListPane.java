package client;

import api.data.Horse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class HorsesListPane extends JPanel {
    public HorsesListPane() {
        super(new BorderLayout());
        JButton addButton = new JButton("Добавить");
        JButton delButton = new JButton("Удалить");
        HorsesListModel horsesListModel = new HorsesListModel();
        JList<Horse> list = new JList<>(horsesListModel);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((Horse)value).getName());
                return  this;
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(
                        HorsesListPane.this,
                        "Введите кличку",
                        "Создание",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(name);
                if (name!= null) {
                    Horse horse = new Horse();
                    horse.setName(name);
                    horsesListModel.addHorse(horse);
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                horsesListModel.delete(selectedIndex);
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Object selectedValue = list.getSelectedValue();
                    Horse horse = (Horse) selectedValue;
                    System.out.println(horse.getName());
                }
            }
        });

        JPanel buttonPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);

        List<Horse> allHorses = ServiceManager.getInstance().getTestService().getAllHorses();
        for(Horse horse: allHorses) {
            horsesListModel.addHorse(horse);
        }
    }
}
