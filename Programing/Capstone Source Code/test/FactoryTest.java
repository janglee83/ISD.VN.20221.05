package test;

import org.junit.jupiter.api.BeforeEach;

import provide.factory.BikeGenerate;

public class FactoryTest {

    private BikeGenerate bikeGenerate;

    @BeforeEach
    void setUp() throws Exception {
        bikeGenerate = new BikeGenerate();
    }
}
