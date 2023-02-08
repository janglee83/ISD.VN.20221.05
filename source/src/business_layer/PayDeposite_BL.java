package business_layer;

import entity.bike.BikeRentInfo;
import provide.strategy.PaymentMethod;
import provide.strategy.implement_strategy.PaymentAmountVer1Strategy;

public class PayDeposite_BL {

	public int caculateAmount(BikeRentInfo bikeRentInfo) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setBikeRentInfo(bikeRentInfo);
        paymentMethod.setPaymentMethod(new PaymentAmountVer1Strategy());
        int amount = paymentMethod.caculateAmount();
        return amount;
    }

}
