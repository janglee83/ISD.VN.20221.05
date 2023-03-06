package provide.factory;

import entity.bike.Bike;

public class BikeGenerate {

    private BikeFactory bikeFactory;

    public void setTypeBikeFactory(BikeFactory bikeFactory) {
        this.bikeFactory = bikeFactory;
    }

    public Bike createBike() {
        return bikeFactory.createBike();
    }
}
