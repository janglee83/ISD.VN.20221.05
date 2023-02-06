package view.handler.rentbike;

import java.io.IOException;
import business_layer.RentBike_BL;
import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import entity.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.payment.InsertCardScreenHandler;

public class RentBikeInfoHandler extends BaseScreenHandler {

    private Bike bike;

    private String barcode;

    private BikeRentInfo bikeRentInfo = new BikeRentInfo();

    @FXML
    private Label bikeType, brand, licensePlate, deposit, barcodelb;

    private static RentBike_BL rentBike_BL = new RentBike_BL();

    public RentBikeInfoHandler(String screenPath, Stage stage, Bike bike, String Barcode) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
        this.barcode = Barcode;
        bikeRentInfo.setBike(bike);
        this.initialize();
    }

    private void initialize() {
        bikeType.setText(Integer.toString(bike.getBikeType()));
        brand.setText(bike.getBrand());
        licensePlate.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(rentBike_BL.Deposit(bike)));
        barcodelb.setText(this.barcode);
    }

    @FXML
    public void confirmToRentBike(MouseEvent event) throws IOException {
        InsertCardScreenHandler insertCardScreenHandler = new InsertCardScreenHandler(Configs.INSERT_CARD_SCREEN_PATH,
                this.stage, Transaction.RENT, bikeRentInfo);
        insertCardScreenHandler.setPreviousScreen(this);
        insertCardScreenHandler.setHomeScreenHandler(homeScreenHandler);
        insertCardScreenHandler.setScreenTitle("Payment - Confirm to pay");
        insertCardScreenHandler.show();
    }
}
