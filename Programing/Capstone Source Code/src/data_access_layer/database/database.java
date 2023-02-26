package data_access_layer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import utlis.Configs;

public class Database {
    //connection
    private static Connection connect = null;

    private static final String className = "com.mysql.cj.jdbc.Driver";

    //logger
    private static Logger LOGGER = utlis.Helper.getLogger(Connection.class.getName());

    public static Connection getConnection() {
        if (connect != null)
            return connect;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName(className);

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
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new CapstoneException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Database.getConnection();
    }
}
