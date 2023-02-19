package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TwinBike extends Bike{
    public TwinBike() {

    }

    public TwinBike createTwinBike(ResultSet result) throws SQLException{
        TwinBike twinBike = new TwinBike();
        twinBike.setBikeId(result.getInt("id"));
        twinBike.setBikeImageUrl(result.getString("bike_image_url"));
        twinBike.setBikeName(result.getString("name"));
        twinBike.setBikeType(result.getInt("bike_type_id"));
        twinBike.setBikeValue(result.getInt("bikeValue"));
        twinBike.setBrand(result.getString("brand"));
        twinBike.setLicensePlate(result.getString("licence_plate"));
        return twinBike;
    }
}
