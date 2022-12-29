package client;

import javax.swing.*;
import java.awt.*;

public class HorsesPane extends JPanel {
    //todo дописать лошади

    public HorsesPane() {
        super(new BorderLayout());
         JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new HorsesListPane(), new HorsePane());
         splitPane.setDividerLocation(200);
         add(splitPane);

    }
}
