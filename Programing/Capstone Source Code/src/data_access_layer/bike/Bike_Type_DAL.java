package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import data_access_layer.database.Database;

public class Bike_Type_DAL {

    public HashMap<Integer, String> getListBikeType() throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(bike_type)");
        ResultSet result = statement.executeQuery(query);

        HashMap<Integer, String> listbikeType = new HashMap<>();
        while (result.next()) {
            listbikeType.put(result.getInt("value"), result.getString("name"));
        }
        return listbikeType;
    }

}
