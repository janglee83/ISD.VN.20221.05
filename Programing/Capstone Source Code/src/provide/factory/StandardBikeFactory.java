package provide.factory;

import entity.bike.Bike;
import entity.bike.StandardBike;

public class StandardBikeFactory implements BikeFactory {

    @Override
    public Bike createBike() {
        return new StandardBike();
    }

}
