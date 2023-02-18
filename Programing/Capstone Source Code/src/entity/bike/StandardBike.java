package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StandardBike extends Bike {
    public StandardBike(){
        
    }

    public StandardBike createStandardBike(ResultSet result) throws SQLException{
        StandardBike standardBike = new StandardBike();
        standardBike.setBikeId(result.getInt("id"));
        standardBike.setBikeImageUrl(result.getString("bike_image_url"));
        standardBike.setBikeName(result.getString("name"));
        standardBike.setBikeType(result.getInt("bike_type_id"));
        standardBike.setBikeValue(result.getInt("bikeValue"));
        standardBike.setBrand(result.getString("brand"));
        standardBike.setLicensePlate(result.getString("licence_plate"));
        standardBike.setIsBeingUsed(result.getBoolean("isBeingUsed"));
        return standardBike;
    }
}
