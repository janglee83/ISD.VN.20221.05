package data_access_layer.bikeType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.database.Database;
import entity.bike.Bike;

public class BikeType_DAL {
    public String getNameBikeType(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select name from(bike_type) where id =  %d", bike.getBikeType());
        ResultSet result = statement.executeQuery(query);
        result.next();
        return result.getString("name");
    }
}
