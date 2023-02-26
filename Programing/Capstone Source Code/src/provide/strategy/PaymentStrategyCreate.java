package provide.strategy;

import java.util.HashMap;

import entity.bike.BikeRentInfo;
import entity.bike.StandardBike;
import provide.strategy.implement_strategy.PaymentAmountVer1Strategy;
import provide.strategy.implement_strategy.PaymentAmountVer2Strategy;

public class PaymentStrategyCreate {
    static HashMap<Integer, PaymentAmountStrategy> strategy = new HashMap<>();

    static {
        strategy.put(StandardBike.BIKE_TYPE_VALUE, new PaymentAmountVer1Strategy());
        strategy.put(StandardBike.BIKE_TYPE_VALUE, new PaymentAmountVer2Strategy());
    }

    private PaymentAmountStrategy getPaymentAmountStrategy(int bikeType) {
        return strategy.get(bikeType);
    }

    public int paymentUsingFactory(BikeRentInfo bikeRentInfo) {
        PaymentAmountStrategy paymentAmountStrategy = getPaymentAmountStrategy(bikeRentInfo.getBike().getBikeType());
        return paymentAmountStrategy.caculateAmount(bikeRentInfo);
    }
}
