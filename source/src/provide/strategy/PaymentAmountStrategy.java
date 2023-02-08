package provide.strategy;

import entity.bike.BikeRentInfo;

public interface PaymentAmountStrategy {

    // nhieu bike type thi sao???
    public int caculateAmount(BikeRentInfo bikeRentInfo);
}
