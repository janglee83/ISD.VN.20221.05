package entity.bike;
public class StandardBike extends Bike {
   
    public static final int BIKE_TYPE_VALUE = 1;

    public StandardBike(int bikeId, int bikeType, String rentalCode, int bikeValue, boolean isBeingUsed,
            String licensePlate, String brand, String bikeImageUrl) {
        super(bikeId, bikeType, rentalCode, bikeValue, isBeingUsed, licensePlate, brand, bikeImageUrl);
    }

    public StandardBike() {
        super();
    }

}
