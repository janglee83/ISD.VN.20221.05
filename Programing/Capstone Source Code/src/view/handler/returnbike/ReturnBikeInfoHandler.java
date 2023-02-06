package view.handler.returnbike;

import java.io.IOException;

import entity.bike.BikeRentInfo;
import entity.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.payment.InsertCardScreenHandler;

public class ReturnBikeInfoHandler extends BaseScreenHandler {

    private BikeRentInfo bikeRentInfo;

    public ReturnBikeInfoHandler(String screenPath, Stage stage, BikeRentInfo bikeRentInfo) throws IOException {
        super(screenPath, stage);
        this.bikeRentInfo = bikeRentInfo;
    }

    @FXML
    public void confirmToPayment(MouseEvent event) throws IOException {
        // display return bike dock info screen
        InsertCardScreenHandler insertCardScreenHandler = new InsertCardScreenHandler(Configs.INSERT_CARD_SCREEN_PATH,
                this.stage, Transaction.RETURN, bikeRentInfo);

        // configs
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
