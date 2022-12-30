package client;

import javax.swing.*;
import java.awt.*;

public class UsersPane extends JPanel {
    private OneUserPane oneUserPane = new OneUserPane();
    private UsersListPane usersListPane = new UsersListPane(oneUserPane);
    public UsersPane() {
        super(new BorderLayout());

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, usersListPane, oneUserPane);
        splitPane.setDividerLocation(200);
        add(splitPane);
    }
}
