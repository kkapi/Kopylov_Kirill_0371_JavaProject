package client;

import javax.swing.*;
import java.awt.*;

public class EquipmentPane extends JPanel {
    private  OneEquipmentPane oneEquipmentPane = new OneEquipmentPane();
    private  EquipmentListPane equipmentListPane = new EquipmentListPane(oneEquipmentPane);
    public EquipmentPane() {
        super(new BorderLayout());

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, equipmentListPane, oneEquipmentPane);
        splitPane.setDividerLocation(200);
        add(splitPane);
    }
}
