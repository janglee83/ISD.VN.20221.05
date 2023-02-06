package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import data_access_layer.database.Database;
import entity.bike.Bike;
import entity.dock.Dock;

public class Bike_DAL {
    // public ArrayList<Bike> getListBike() throws SQLException
    // {
    //     Statement statement = Database.getConnection().createStatement();
    //     ResultSet resultSet = statement.execute("select * from bike");
    //     ArrayList<Bike> bikesList = new ArrayList<Bike>();
    //     while(resultSet.next())
    //     {
    //         Bike bike = new Bike();
    //         bike.setBikeId(resultSet.getInt("id"));
    //         bike.setBikeName(resultSet.getString("name"));
    //         bike.setBikeValue(resultSet.getInt("bikeValue"));
    //         bike.setBikeImageUrl(resultSet.getString("bike_image_url"));
    //         bike.setBrand(resultSet.getString("brand"));
    //         bike.
    //     }
    // }
}
