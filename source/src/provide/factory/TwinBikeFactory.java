package provide.factory;

import entity.bike.Bike;
import entity.bike.TwinBike;

public class TwinBikeFactory implements BikeFactory {

    @Override
    public Bike createBike() {
        return new TwinBike();
    }

}
