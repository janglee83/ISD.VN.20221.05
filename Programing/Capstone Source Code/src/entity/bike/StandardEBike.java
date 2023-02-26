package entity.bike;
public class StandardEBike extends Bike {

    public static final int BIKE_TYPE_VALUE = 2;

    private String bateryPercent;

    public StandardEBike(int bikeId, int bikeType, String rentalCode, int bikeValue,
            boolean isBeingUsed,
            String licensePlate, String brand, String bikeImageUrl, String bateryPercent) {
        super(bikeId, bikeType, rentalCode, bikeValue, isBeingUsed,
                licensePlate, brand, bikeImageUrl);
        this.bateryPercent = bateryPercent;
    }

    public StandardEBike() {
        super();
    }

    // getter setter operation
    public String getBateryPercent() {
        return bateryPercent;
    }

    public void setBateryPercent(String bateryPercent) {
        this.bateryPercent = bateryPercent;
    }
}
