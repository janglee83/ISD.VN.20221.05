package provide.strategy;

import entity.bike.BikeRentInfo;

public class PaymentAmountVer2Strategy implements PaymentAmountStrategy {

    @Override
    public int caculateAmount(int depositeAmount, BikeRentInfo bikeRentInfo) {
        return 0;
    }

}
