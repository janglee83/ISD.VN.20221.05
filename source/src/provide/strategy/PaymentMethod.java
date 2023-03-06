package provide.strategy;

import entity.bike.BikeRentInfo;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;

public class PaymentMethod {

    private PaymentAmountStrategy paymentAmountStrategy;

    private BikeRentInfo bikeRentInfo;

    public void setPaymentMethod(PaymentAmountStrategy paymentAmountStrategy) {
        this.paymentAmountStrategy = paymentAmountStrategy;
    }

    public void setBikeRentInfo(BikeRentInfo bikeRentInfo) {
        this.bikeRentInfo = bikeRentInfo;
    }

    public int caculateAmount() {
        int amount = paymentAmountStrategy.caculateAmount(bikeRentInfo);
        switch (bikeRentInfo.getBike().getBikeType()) {
            case StandardBike.BIKE_TYPE_VALUE:
                return amount;
            case StandardEBike.BIKE_TYPE_VALUE:
                return amount *= 1.5;
            case TwinBike.BIKE_TYPE_VALUE:
                return amount *= 1.5;
            default:
                return amount;
        }
    }
}
