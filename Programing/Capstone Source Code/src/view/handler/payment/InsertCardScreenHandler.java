package view.handler.payment;

import java.io.IOException;

import controller.ReturnBikeController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class InsertCardScreenHandler extends BaseScreenHandler {

    public InsertCardScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @FXML
    public void handlePayment(MouseEvent event) throws IOException {
        //display return bike dock info screen
        PaymentTransactionHandler paymentTransactionHandler = new PaymentTransactionHandler(Configs.PAYMENT_TRANSACTION_SCREEN_PATH, this.stage);

        //configs
        paymentTransactionHandler.setPreviousScreen(this);
        paymentTransactionHandler.setHomeScreenHandler(homeScreenHandler);
        paymentTransactionHandler.setScreenTitle("Payment - Payment transaction");
        paymentTransactionHandler.show();
    }

}
