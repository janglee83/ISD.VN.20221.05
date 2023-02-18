package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StandardEBike extends Bike {

    private int bateryPercent;

    public StandardEBike() {

    }
    public StandardEBike createStandardEBike(ResultSet result) throws SQLException{
        StandardEBike standardEBike = new StandardEBike();
        standardEBike.setBikeId(result.getInt("id"));
        standardEBike.setBikeImageUrl(result.getString("bike_image_url"));
        standardEBike.setBikeName(result.getString("name"));
        standardEBike.setBikeType(result.getInt("bike_type_id"));
        standardEBike.setBikeValue(result.getInt("bikeValue"));
        standardEBike.setBrand(result.getString("brand"));
        standardEBike.setLicensePlate(result.getString("licence_plate"));
        standardEBike.setIsBeingUsed(result.getBoolean("isBeingUsed"));
        return standardEBike;
    }
}
