package view.handler.rentbike;

import java.io.IOException;
import java.sql.SQLException;

import business_layer.RentBike_BL;
import data_access_layer.bikeType.BikeType_DAL;
import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import entity.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView image;

    @FXML
    private Label bikeType, brand, licensePlate, deposit, barcodelb;

    private static RentBike_BL rentBike_BL = new RentBike_BL();
    private static BikeType_DAL bikeType_DAL = new BikeType_DAL();

    public RentBikeInfoHandler(String screenPath, Stage stage, Bike bike, String Barcode)
            throws IOException, SQLException {
        super(screenPath, stage);
        this.bike = bike;
        this.barcode = Barcode;
        bikeRentInfo.setBike(bike);
        this.initialize();
    }

    private void initialize() throws SQLException {
        bikeType.setText(bikeType_DAL.getNameBikeType(bike));
        brand.setText(bike.getBrand());
        licensePlate.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(rentBike_BL.deposit(bike)));
        barcodelb.setText(this.barcode);

        // set image
        Image imageLink = new Image(bike.getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);
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

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}
