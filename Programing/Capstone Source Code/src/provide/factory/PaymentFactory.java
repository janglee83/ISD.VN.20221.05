package provide.factory;

import java.util.HashMap;

import entity.bike.BikeRentInfo;
import entity.bike.StandardBike;
import provide.strategy.PaymentAmountStrategy;
import provide.strategy.implement_strategy.PaymentAmountVer1Strategy;
import provide.strategy.implement_strategy.PaymentAmountVer2Strategy;

public class PaymentFactory {
    static HashMap<Integer, PaymentAmountStrategy> factory = new HashMap<>();
    static {
        factory.put(StandardBike.BIKE_TYPE_VALUE, new PaymentAmountVer1Strategy());
        factory.put(StandardBike.BIKE_TYPE_VALUE, new PaymentAmountVer2Strategy());
    }

    public static PaymentAmountStrategy getPaymentAmountStrategy(int bikeType) {
        return factory.get(bikeType);
    }

    public int paymentUsingFactory(BikeRentInfo bikeRentInfo) {
        PaymentAmountStrategy paymentAmountStrategy = PaymentFactory
                .getPaymentAmountStrategy(bikeRentInfo.getBike().getBikeType());
        return paymentAmountStrategy.caculateAmount(bikeRentInfo);
    }
}
