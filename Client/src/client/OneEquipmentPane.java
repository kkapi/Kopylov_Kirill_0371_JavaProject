package client;

import api.data.Equipment;
import api.data.Horse;

import javax.swing.*;
import java.awt.*;

public class OneEquipmentPane extends JPanel {
    private Equipment equipment;

    private JTextField nameText = new JTextField(20);
    private JTextField priceText = new JTextField(20);
    private JTextField descriptonText = new JTextField(20);
    private JTextField idText = new JTextField(20);


    public OneEquipmentPane() {
        super(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Название:"));
        add(nameText);
        add(new JLabel("Цена:"));
        add(priceText);
        add(new JLabel("Описание:"));
        add(descriptonText);
        add(new JLabel("id:"));
        add(idText);

        nameText.setEnabled(false);
        priceText.setEnabled(false);
        descriptonText.setEnabled(false);
        idText.setEnabled(false);
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        if (equipment != null) {
            String strPrice = Integer.toString(equipment.getPrice());

            nameText.setText(equipment.getName());
            descriptonText.setText(equipment.getDescription());
            idText.setText(equipment.getId());
            priceText.setText(strPrice);

            nameText.setEnabled(true);
            descriptonText.setEnabled(true);
            priceText.setEnabled(true);
        } else {
            nameText.setText("");
            descriptonText.setText("");
            idText.setText("");
            priceText.setText("");

            nameText.setEnabled(false);
            descriptonText.setEnabled(false);
            priceText.setEnabled(false);
        }
    }
}
