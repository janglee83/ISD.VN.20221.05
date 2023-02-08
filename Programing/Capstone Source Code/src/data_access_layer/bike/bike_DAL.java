package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.database.Database;
import entity.bike.Bike;

public class Bike_DAL {
    public Bike getBike(int bike_id) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(bike) where id =  %d and isBeingUsed = 0", bike_id);
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

    public void updateRentBike(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("update bike set isBeingUsed = 1 where id = %d", bike.getBikeId());
        statement.execute(query);
        String query1 = String.format(
                "update dock_empty_point set empty_points = (select empty_points where dock_id = %d and bike_type_id = %d) + 1 where dock_id = %d and bike_type_id = %d",
                getDockIdOfBike(bike), bike.getBikeType(), getDockIdOfBike(bike), bike.getBikeType());
        statement.execute(query1);
    }

    public int getDockIdOfBike(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select dock_id from(bike) where id = %d", bike.getBikeId());
        ResultSet result = statement.executeQuery(query);
        result.next();
        return result.getInt("dock_id");
    }

    public Bike createBike(ResultSet res) throws SQLException{
        Bike bike = new Bike();
        bike.setBikeId(res.getInt("id"));
        bike.setBikeImageUrl(res.getString("bike_image_url"));
        bike.setBikeName(res.getString("name"));
        bike.setBikeType(res.getInt("bike_type_id"));
        bike.setBikeValue(res.getInt("bikeValue"));
        bike.setBrand(res.getString("brand"));
        bike.setLicensePlate(res.getString("licence_plate"));
        bike.setIsBeingUsed(res.getBoolean("isBeingUsed"));
        return bike;
    }
}
