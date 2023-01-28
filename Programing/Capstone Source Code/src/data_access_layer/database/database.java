package data_access_layer.database;

import java.sql.Connection;
import java.sql.DriverManager;
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

            //logger
            LOGGER.info("Connect database successfully");
        } catch (Exception exception) {
            LOGGER.info(exception.getMessage());
        }
        return connect;
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

    public static void main(String[] args) {
        database.getConnection();
    }
}
