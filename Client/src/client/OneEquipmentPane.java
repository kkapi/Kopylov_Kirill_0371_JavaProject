package client;

import api.data.Equipment;
import api.data.Horse;

import javax.swing.*;
import java.awt.*;

public class OneEquipmentPane extends JPanel {
    private Equipment equipment;

    private JTextField textField = new JTextField(20);

    public OneEquipmentPane() {
        super(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Название:"));
        add(textField);

        textField.setEnabled(false);
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        if (equipment != null) {
            textField.setText(equipment.getName());
            textField.setEnabled(true);
        } else {
            textField.setText("");
            textField.setEnabled(false);
        }
    }
}
