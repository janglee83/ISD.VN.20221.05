package provide.strategy.implement_strategy;

import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import provide.strategy.PaymentAmountStrategy;

public class PaymentAmountVer1Strategy implements PaymentAmountStrategy {

    // first caculate amount
    @Override
    public int caculateAmount(BikeRentInfo bikeRentInfo) {
        int amount = 0;

        int totalMinus = bikeRentInfo.getMinutes();
        totalMinus += bikeRentInfo.getHours() * 60;
        if (bikeRentInfo.getSeconds() > 0)
            totalMinus += 1;

        if (totalMinus > 30) {
            amount += 10000;
            totalMinus -= 30;
            long roundedQuotient = Math.round((double)totalMinus / 15);
            amount += roundedQuotient*3000;
        } else {
            amount = 10000;
        }

        if (bikeRentInfo.getBike().getBikeType() != Bike.STANDARD_BICYCLE_VALUE)
            amount *= 1.5;

        return amount;
    }
}
