package view.handler.rentbike;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import common.exception.CapstoneException;
import controller.RentBikeController;
import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import entity.bike.StandardEBike;
import entity.dock.Dock;
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
    private static Logger LOGGER = utlis.Helper.getLogger(RentBikeInfoHandler.class.getName());
    private Bike bike;

    private String barcode;

    private BikeRentInfo bikeRentInfo = new BikeRentInfo();

    @FXML
    private ImageView image;

    @FXML
    private Label nameDock, address, bikeType, brand, licensePlate, deposit, barcodelb, bateryTitle, bateryPercent;

    private static RentBikeController rentBikeController = new RentBikeController();

    public RentBikeInfoHandler(String screenPath, Stage stage, Bike bike, String Barcode)
            throws IOException, SQLException {
        super(screenPath, stage);
        this.bike = bike;
        this.barcode = Barcode;
        bikeRentInfo.setBike(bike);
        this.initialize();
    }

    private void initialize() throws SQLException {
        
        Dock dock = rentBikeController.getDockInfo(bike.getBikeId());
        nameDock.setText(dock.getDockName());
        address.setText(dock.getDockAddress());
        bikeType.setText(utlis.Helper.convertToStringBikeType(bike.getBikeType()));
        brand.setText(bike.getBrand());
        licensePlate.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(rentBikeController.getDeposit(bike.getBikeType())));
        barcodelb.setText(this.barcode);

        // set image
        Image imageLink = new Image(bike.getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);

        bateryTitle.setVisible(false);
        bateryPercent.setVisible(false);

        switch (bike.getBikeType()) {
            case StandardEBike.BIKE_TYPE_VALUE:
                setEBikeAttrData();
                break;
            default:
                break;
        }
    }

    @FXML
    public void confirmToRentBike(MouseEvent event) throws IOException {
        LOGGER.info("Confirm to rent bike");
        InsertCardScreenHandler insertCardScreenHandler = new InsertCardScreenHandler(Configs.INSERT_CARD_SCREEN_PATH,
                this.stage, Transaction.RENT, bikeRentInfo);
        insertCardScreenHandler.setPreviousScreen(this);
        insertCardScreenHandler.setHomeScreenHandler(homeScreenHandler);
        insertCardScreenHandler.setScreenTitle("Payment - Confirm to pay");
        insertCardScreenHandler.show();
    }

    private void setEBikeAttrData() {
        StandardEBike eBike;
        bateryTitle.setVisible(true);
        bateryPercent.setVisible(true);
        try {
            eBike = rentBikeController.getEBikeAttr(bike);
            bateryPercent.setText(new String(eBike.getBateryPercent() + "%"));
        } catch (SQLException e) {
            throw new CapstoneException(e.getMessage());
        }
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}
