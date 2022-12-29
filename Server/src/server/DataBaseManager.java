package server;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static DataBaseManager dm;

    private Connection conn;

    private DataBaseManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String userHome = System.getProperty("user.home");
        String configPath = userHome + "/KSK/database.xml";
        File file = new File(configPath);

        DataBaseConfiguration dbConf;
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.alias("DataBaseConfiguration", DataBaseConfiguration.class);

        if (file.exists()) {
            dbConf = (DataBaseConfiguration) xStream.fromXML(file);
        } else {
            file.getParentFile().mkdirs();

            dbConf = new DataBaseConfiguration();
            try {
                xStream.toXML(dbConf, new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String host= dbConf.getHost();
        int port=dbConf.getPort();
        String base= dbConf.getBase();
        String login= dbConf.getLogin();
        String password= dbConf.getPassword();

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + base, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static synchronized DataBaseManager getInstance() {
        if (dm == null) {
            dm = new DataBaseManager();
        }
        return  dm;
    }

    public Connection getConnection() {
        return conn;
    }

    public static void main(String[] args) {
        new DataBaseManager();
    }
}
