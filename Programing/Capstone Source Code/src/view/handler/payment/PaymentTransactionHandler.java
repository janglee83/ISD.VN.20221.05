package view.handler.payment;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.returnbike.ReturnBikeInfoHandler;

public class PaymentTransactionHandler extends BaseScreenHandler {

    public PaymentTransactionHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @FXML
    public void returnBikeInfoHandler(MouseEvent event) throws IOException {
        ReturnBikeInfoHandler returnBikeInfoHandler = new ReturnBikeInfoHandler(Configs.RETURN_BIKE_INFO_SCREEN_PATH, this.stage);
        //configs
        returnBikeInfoHandler.setPreviousScreen(this);
        returnBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeInfoHandler.setScreenTitle("Bike rent data");
        returnBikeInfoHandler.show();
    }

}
