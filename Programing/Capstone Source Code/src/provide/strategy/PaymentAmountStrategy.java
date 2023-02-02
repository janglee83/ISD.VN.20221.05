package provide.strategy;

import entity.bike.BikeRentInfo;

public interface PaymentAmountStrategy {

    public int caculateAmount(int depositeAmount, BikeRentInfo bikeRentInfo);
}
