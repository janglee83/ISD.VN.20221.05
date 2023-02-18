package provide.factory;

import entity.bike.Bike;
import entity.bike.StandardEBike;

public class StandardEBikeFactory implements BikeFactory {

    @Override
    public Bike createBike() {
        return new StandardEBike();
    }
}
