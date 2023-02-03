package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;

import data_access_layer.database.Database;
import entity.bike.Bike;

public class Bike_DAL {
    public Bike getBikeInDock(int bike_id, int dock_id) throws SQLException {
        java.sql.Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(bike) where id =  %d and dock_id = %d and isBeingUsed = 0", bike_id,
                dock_id);
        ResultSet result = statement.executeQuery(query);
        Bike bike = new Bike();
        result.next();
        bike.setBikeName(result.getString("name"));
        bike.setBikeValue(result.getInt("bikeValue"));
        bike.setBikeImageUrl(result.getString("bike_image_url"));
        bike.setBikeType(result.getInt("bike_type_id"));
        bike.setBrand(result.getString("brand"));
        bike.setBikeId(result.getInt("id"));
        bike.setLicensePlate(result.getString("licence_plate"));
        return bike;
    }
}
