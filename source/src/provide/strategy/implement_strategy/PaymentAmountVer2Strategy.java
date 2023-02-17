package provide.strategy.implement_strategy;

import entity.bike.BikeRentInfo;
import provide.strategy.PaymentAmountStrategy;

public class PaymentAmountVer2Strategy implements PaymentAmountStrategy {

    @Override
    public int caculateAmount(BikeRentInfo bikeRentInfo) {
        return 0;
    }

}
