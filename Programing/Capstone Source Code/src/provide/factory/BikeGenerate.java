package provide.factory;

import java.util.HashMap;

import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;

public class BikeGenerate {

    private BikeFactory bikeFactory;

    public void setTypeBikeFactory(BikeFactory bikeFactory) {
        this.bikeFactory = bikeFactory;
    }

    public Bike createBike() {
        return bikeFactory.createBike();
    }

    // static HashMap<Integer, Bike> factory = new HashMap<>();
    // static{
    //    factory.put(StandardBike.BIKE_TYPE_VALUE,new StandardBike() );
    //    factory.put(StandardEBike.BIKE_TYPE_VALUE,new StandardEBike() );
    // }
    // public static Bike getBike(int bikeType){
    //     return factory.get(bikeType);
    // } 

    // public Bike getBikeFactory(int bikeType){
    //     Bike bike = BikeGenerate.getBike(bikeType);
    //     return bike;
    // }
}
