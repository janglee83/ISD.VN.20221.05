package provide.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import data_access_layer.bike.Bike_DAL;
import entity.bike.Bike;

public class BikeFactory {
    public static Bike_DAL bike_DAL = new Bike_DAL();

    public static final Bike getBike(ResultSet res) throws SQLException {
        switch (res.getInt("bike_type_id")) {
            case 1:
            case 3:
                return bike_DAL.createBike(res);
            case 2:
                // return new Bike();
            default:
                throw new IllegalArgumentException("This bike type is unsupported");
        }
    }

}
