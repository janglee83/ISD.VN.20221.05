package provide.factory;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardBike;
import entity.bike.TwinBike;

public class BikeFactory {

    private BikeFactory(){

    }
    public static final Bike getBike(int bikeType){
        switch(bikeType){
            case 1:
                return new StandardBike();
            case 2:
                return new StandardBike();
            case 3:
                return new TwinBike();
            default:
                throw new IllegalArgumentException("This bike type is unsupported");
        }
    }
}
