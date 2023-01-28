package data_access_layer.databasae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Logger;

import utlis.Configs;

public class database {
    //connection
    private static Connection connect = null;

    //logger
    private static Logger LOGGER = utlis.Helper.getLogger(Connection.class.getName());

    public static Connection getConnection() {
        if (connect != null)
            return connect;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/" + Configs.DATABASE_NAME + "?" + "user=" + Configs.DATABASE_USER +"&password=" + Configs.DATABASE_PASSWORD);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    // You need to close the resultSet
    private void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
