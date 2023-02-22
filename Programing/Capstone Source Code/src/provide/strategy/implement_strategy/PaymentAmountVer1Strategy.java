package provide.strategy.implement_strategy;

import entity.bike.BikeRentInfo;
import entity.bike.StandardBike;
import provide.strategy.PaymentAmountStrategy;

public class PaymentAmountVer1Strategy implements PaymentAmountStrategy {

    // first caculate amount
    @Override
    public int caculateAmount(BikeRentInfo bikeRentInfo) {
        int amount = 0;

        int totalMinus = bikeRentInfo.getMinutes();
        totalMinus += bikeRentInfo.getHours() * 60;
        if (bikeRentInfo.getSeconds() > 0) {
            totalMinus += 1;
        }

        if (totalMinus <= 10) {
            amount = 0;
        } else if (totalMinus > 30) {
            amount += 10000;
            totalMinus -= 30;
            
            int quotient = totalMinus / 15;
            int remainder = totalMinus - quotient * 15;
            quotient = quotient + (remainder > 0 ? 1 : 0);

            amount += quotient*3000;
        } else {
            amount = 10000;
        }

        return amount;
    }
}
