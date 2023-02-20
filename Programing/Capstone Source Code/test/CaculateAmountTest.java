package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.ReturnBikeController;

public class CaculateAmountTest {

    private ReturnBikeController returnBikeController;

    @BeforeEach
    void setUp() throws Exception {
        returnBikeController = new ReturnBikeController();
    }

    @ParameterizedTest
    @CsvSource({
        ""
    })

    public void test(String name, boolean expected) {
    }
}
