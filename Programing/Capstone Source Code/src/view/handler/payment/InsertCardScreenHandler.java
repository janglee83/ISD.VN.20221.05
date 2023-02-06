package view.handler.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class InsertCardScreenHandler extends BaseScreenHandler implements Initializable{

    public InsertCardScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @FXML
    private TextField nameTextField, numberTextField, codeTextField;

    @FXML
    private ChoiceBox<String> monthChoiceBox, yearChoiceBox;

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

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
