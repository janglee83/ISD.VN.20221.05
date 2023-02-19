package view.handler.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.exception.CapstoneException;
import controller.PaymentController;
import entity.bike.BikeRentInfo;
import entity.card.Card;
import entity.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class InsertCardScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private TextField nameTextField, numberTextField, codeTextField, dateTextField;

    @FXML
    private Label invalidNameLabel, invalidCardNumberLabel, invalidTokenLabel, invalidDateLabel;

    @FXML
    private Label invalidField;

    private String typePayment;

    private Card card;

    private BikeRentInfo bikeRentInfo;

    private final PaymentController paymentController = new PaymentController();

    private Transaction transaction;

    public InsertCardScreenHandler(String screenPath, Stage stage, String typePayment, BikeRentInfo bikeRentInfo)
            throws IOException {
        super(screenPath, stage);
        this.typePayment = typePayment;
        this.bikeRentInfo = bikeRentInfo;
    }

    @FXML
    public void handlePayment(MouseEvent event) throws IOException {
        // create card object
        card = new Card(nameTextField.getText(), numberTextField.getText(), codeTextField.getText(),
                dateTextField.getText());

        handleValidatepaymentButton();

        handlePayment();

        // display return bike dock info screen
        PaymentTransactionHandler paymentTransactionHandler = new PaymentTransactionHandler(
                Configs.PAYMENT_TRANSACTION_SCREEN_PATH, this.stage, typePayment, transaction, bikeRentInfo);

        // configs
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
        // set error invisible
        invalidField.setVisible(false);
        handleValidate();
    }

    private void handleValidatepaymentButton() {
        // handle input exception refactor
        try {
            paymentController.validateCardData(card);
            invalidField.setVisible(false);
        } catch (Exception exception) {
            invalidField.setVisible(true);
            throw new CapstoneException(exception.getMessage());
        }
    }

    private void handleValidate() {
        handleDisplayValidateStringException(nameTextField, invalidNameLabel);
        handleDisplayValidateStringNumberException(numberTextField, invalidCardNumberLabel);
        handleDisplayValidateStringNumberException(codeTextField, invalidTokenLabel);
        handleDisplayValidateStringNumberException(dateTextField, invalidDateLabel);
    }

    private void handleDisplayValidateStringException(TextField textField, Label label) {
        // set error invisible
        label.setVisible(false);

        // add listener to text field
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                label.setVisible(false);
                paymentController.validateString(newValue);
            } catch (Exception exception) {
                label.setVisible(true);
                throw new CapstoneException(exception.getMessage());
            }
        });
    }

    private void handleDisplayValidateStringNumberException(TextField textField, Label label) {
        // set error invisible
        label.setVisible(false);

        // add listener to text field
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                label.setVisible(false);
                paymentController.validateStringNumber(newValue);
            } catch (Exception exception) {
                label.setVisible(true);
                throw new CapstoneException(exception.getMessage());
            }
        });
    }

    private void handlePayment() {
        int depositeAmount = utlis.Helper.getDepositeAmount(bikeRentInfo.getBike().getBikeType());
        String transactionContent = new String("Process to payment");

        if (typePayment.equals(Transaction.RETURN)) {
            depositeAmount = depositeAmount - paymentController.caculateAmount(bikeRentInfo);
            depositeAmount = depositeAmount * (-1);
        }

        try {
            transaction = paymentController.payDeposite(card, depositeAmount, transactionContent);
        } catch (Exception exception) {
            throw new CapstoneException(exception.getMessage());
        }
    }
}
