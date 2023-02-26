package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import provide.strategy.PaymentMethod;
import provide.strategy.implement_strategy.PaymentAmountVer1Strategy;

public class CaculateAmountTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @ParameterizedTest
    @CsvSource({
        "0,0,1,1,0",
        "0,0,59,1,0",
        "0,1,0,1,0",
        "0,10,59,1,10000",
        "0,10,0,1,0",
        "0,10,1,1,10000",
        "0,30,0,1,10000",
        "0,30,59,1,13000",
        "0,29,59,1,10000",
        "0,40,0,1,13000",
        "1,23,30,1,22000",

        "0,0,1,2,0",
        "0,0,59,2,0",
        "0,1,0,2,0",
        "0,10,59,2,15000",
        "0,10,0,2,0",
        "0,10,1,2,15000",
        "0,30,0,2,15000",
        "0,30,59,2,19500",
        "0,29,59,2,15000",
        "0,40,0,2,19500",
        "1,23,30,2,33000",

        "0,0,1,3,0",
        "0,0,59,3,0",
        "0,1,0,3,0",
        "0,10,59,3,15000",
        "0,10,0,3,0",
        "0,10,1,3,15000",
        "0,30,0,3,15000",
        "0,30,59,3,19500",
        "0,29,59,3,15000",
        "0,40,0,3,19500",
        "1,23,30,3,33000",
    })

    public void test(String hour, String minut, String second, String bikeType, String value) {
        // set up bike
        BikeRentInfo bikeRentInfo = new BikeRentInfo();
        bikeRentInfo.setBike(new Bike());
        setUpBikeRentInfoData(Integer.parseInt(hour), Integer.parseInt(minut), Integer.parseInt(second), bikeRentInfo);
        setUpBikeType(bikeRentInfo, Integer.parseInt(bikeType));

        // set up payment method
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setBikeRentInfo(bikeRentInfo);
        paymentMethod.setPaymentMethod(new PaymentAmountVer1Strategy());
        int amount = paymentMethod.caculateAmount();

        assertEquals(amount, Integer.parseInt(value));
    }

    private void setUpBikeType(BikeRentInfo bikeRentInfo, int bikeType) {
        bikeRentInfo.getBike().setBikeType(bikeType);
    }

    private void setUpBikeRentInfoData(int hour, int minut, int second, BikeRentInfo bikeRentInfo) {
        bikeRentInfo.setHours(hour);
        bikeRentInfo.setSeconds(second);
        bikeRentInfo.setMinutes(minut);
    }
}
