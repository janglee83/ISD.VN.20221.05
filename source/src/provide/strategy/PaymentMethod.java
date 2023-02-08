package provide.strategy;

import entity.bike.BikeRentInfo;

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
        return paymentAmountStrategy.caculateAmount(bikeRentInfo);
    }
}
