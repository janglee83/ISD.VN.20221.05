package view.handler.payment;

import java.io.IOException;
import java.sql.SQLException;

import business_layer.RentBike_BL;
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

public class PaymentTransactionHandler extends BaseScreenHandler {

    private String typePayment;

    private Transaction transaction;

    private BikeRentInfo bikeRentInfo;

    private static RentBike_BL rentBike_BL = new RentBike_BL();

    @FXML
    private Button returnButton;

    @FXML
    private Label transactionCodeLabel, dockAddressLabel, bikeTypeLabel, amountLabel, timeLabel, contentLabel,
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
            homeScreenHandler.show();
        } else {
            BikeRentDataHandler bikeRentDataHandler = new BikeRentDataHandler(Configs.BIKE_RENT_DATA_SCREEN_PATH,
                    this.stage, bikeRentInfo);
            // configs
            bikeRentDataHandler.setPreviousScreen(this);
            bikeRentDataHandler.setHomeScreenHandler(homeScreenHandler);
            bikeRentDataHandler.setScreenTitle("Bike rent data");
            bikeRentDataHandler.show();
            rentBike_BL.updateAfterRentBike(bikeRentInfo.getBike());
        }
    }

    private void initialize() {
        if (typePayment.equals(Transaction.RENT)) {
            returnButton.setText(Transaction.RENT);
        }
    }

}
