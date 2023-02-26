package view.handler.payment;

import java.io.IOException;
import java.sql.SQLException;

import controller.RentBikeController;
import controller.ReturnBikeController;
import entity.bike.BikeRentInfo;
import entity.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.rentbike.BikeRentDataHandler;
import view.handler.view.HomeScreenHandler;

public class PaymentTransactionHandler extends BaseScreenHandler {

    private String typePayment;

    private Transaction transaction;

    private BikeRentInfo bikeRentInfo;

    private final RentBikeController rentBikeController = new RentBikeController();

    private final ReturnBikeController returnBikeController = new ReturnBikeController();

    @FXML
    private Button returnButton;

    @FXML
    private Label transactionCodeLabel, bikeTypeLabel, amountLabel, timeLabel, contentLabel,
            licensePlateLabel;

    public PaymentTransactionHandler(String screenPath, Stage stage, String typePayment, Transaction transaction,
            BikeRentInfo bikeRentInfo) throws IOException {
        super(screenPath, stage);
        this.typePayment = typePayment;
        this.transaction = transaction;
        this.bikeRentInfo = bikeRentInfo;
        this.initialize();
    }

    @FXML
    public void handleReturnPayment(MouseEvent event) throws IOException, SQLException {
        if (typePayment.equals(Transaction.RETURN)) {
            // update point
            returnBikeController.returnBikeUpdateDatabase(bikeRentInfo.getBike(),
                    bikeRentInfo.getReturnedDock().getDockId());

            HomeScreenHandler homeScreenHandler = new HomeScreenHandler(Configs.HOME_SCREEN_PATH, this.stage);
            homeScreenHandler.setScreenTitle("Home Screen");
            homeScreenHandler.setHomeScreenHandler(homeScreenHandler);
            homeScreenHandler.show();
        } else {
            rentBikeController.updateAfterRentBike(bikeRentInfo.getBike().getBikeId(),
                    bikeRentInfo.getBike().getBikeType());
            BikeRentDataHandler bikeRentDataHandler = new BikeRentDataHandler(Configs.BIKE_RENT_DATA_SCREEN_PATH,
                    this.stage, bikeRentInfo);
            // configs
            bikeRentDataHandler.setPreviousScreen(this);
            bikeRentDataHandler.setHomeScreenHandler(homeScreenHandler);
            bikeRentDataHandler.setScreenTitle("Bike rent data");
            bikeRentDataHandler.show();
        }
    }

    private void initialize() {
        if (typePayment.equals(Transaction.RENT)) {
            returnButton.setText(Transaction.RENT);
        }

        transactionCodeLabel.setText(typePayment);
        bikeTypeLabel.setText(utlis.Helper.convertToStringBikeType(bikeRentInfo.getBike().getBikeType()));
        amountLabel.setText(new String(transaction.getAmount() + " VND"));
        timeLabel.setText(transaction.getTime());
        contentLabel.setText(transaction.getContent());
        licensePlateLabel.setText(bikeRentInfo.getBike().getLicensePlate());
    }

}
