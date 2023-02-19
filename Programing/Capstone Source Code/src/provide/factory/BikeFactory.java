package provide.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;

public class BikeFactory {

    public BikeFactory() {

    }

    public final Bike getBike(ResultSet result) throws SQLException {
        switch (result.getInt("bike_type_id")) {
            case 1:
                StandardBike standardBike = new StandardBike();
                return standardBike.createStandardBike(result);
            case 2:
                StandardEBike standardEBike = new StandardEBike();
                return standardEBike.createStandardEBike(result);
            case 3:
                TwinBike twinBike = new TwinBike();
                return twinBike.createTwinBike(result);
            default:
                throw new IllegalArgumentException("This bike type is unsupported");
        }
    }
}
