package data_access_layer.bikeType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import data_access_layer.database.Database;
import entity.bike.Bike;

public class BikeType_DAL {

    public String getNameBikeType(Bike bike) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format("select name from(bike_type) where id =  %d", bike.getBikeType());
        ResultSet result = statement.executeQuery(query);
        result.next();
        String name = result.getString("name");


        return name;
    }

    public HashMap<Integer, String> getListBikeType() throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format("select * from(bike_type)");
        ResultSet result = statement.executeQuery(query);

        HashMap<Integer, String> listbikeType = new HashMap<>();
        while (result.next()) {
            listbikeType.put(result.getInt("value"), result.getString("name"));
        }

        return listbikeType;
    }
}
