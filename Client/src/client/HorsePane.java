package client;

import api.data.Horse;

import javax.swing.*;
import java.awt.*;

public class HorsePane extends JPanel {

    private Horse horse;

    private  JTextField textField = new JTextField(20);

    public HorsePane() {
        super(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Кличка:"));
        add(textField);

        textField.setEnabled(false);
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
        if (horse != null) {
            textField.setText(horse.getName());
            textField.setEnabled(true);
        } else {
            textField.setText("");
            textField.setEnabled(false);
        }
    }
}
