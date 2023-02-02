package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import data_access_layer.database.Database;
import entity.bike.Bike;

public class Bike_DAL {
    public Bike getBikeInDock(int bike_id, int dock_id) throws SQLException {
        java.sql.Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * " + "from(bike)" + "where bike_id =" + bike_id + "and dock_id = "
                + dock_id + "and isBeingUsed = 0" + ";");
        ResultSet result = statement.executeQuery(query);
        Bike bike = new Bike();
        bike.setBikeName(result.getString("name"));
        bike.setBikeValue(result.getInt("bikeValue"));
        // bike.setBikeImageUrl(result.getString("bike_image_url"));
        bike.setBikeType(result.getInt("bike_type_id"));
        bike.setBrand(result.getString("brand"));
        bike.setBikeId(result.getInt("bike_id"));
        return bike;
    }
}
