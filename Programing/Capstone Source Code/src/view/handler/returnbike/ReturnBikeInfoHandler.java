package view.handler.returnbike;

import java.io.IOException;

import controller.PaymentController;
import controller.ReturnBikeController;
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

public class ReturnBikeInfoHandler extends BaseScreenHandler {

    private BikeRentInfo bikeRentInfo;

    private PaymentController paymentController = new PaymentController();

    @FXML
    private Label bikeTypeLabel, brandLabel, licensePlateLabel, timeRentLabel, payAmountLabel, payDepositeLabel,
            totalAmount;

    @FXML
    private ImageView image;

    public ReturnBikeInfoHandler(String screenPath, Stage stage, BikeRentInfo bikeRentInfo) throws IOException {
        super(screenPath, stage);
        this.bikeRentInfo = bikeRentInfo;
        this.initData();
    }

    private void initData() {
        // bike attr
        bikeTypeLabel.setText(utlis.Helper.convertToStringBikeType(bikeRentInfo.getBike().getBikeType()));
        brandLabel.setText(bikeRentInfo.getBike().getBrand());
        licensePlateLabel.setText(bikeRentInfo.getBike().getLicensePlate());

        // time rent
        String timeRentString = new String(Integer.toString(bikeRentInfo.getHours()) + ":"
                + Integer.toString(bikeRentInfo.getMinutes()) + ":" + Integer.toString(bikeRentInfo.getSeconds()));
        timeRentLabel.setText(timeRentString);
        payAmountLabel.setText(timeRentString);

        // caculate amount
        int amount = paymentController.caculateAmount(bikeRentInfo);
        payAmountLabel.setText(Integer.toString(amount));

        // set image
        Image imageLink = new Image(bikeRentInfo.getBike().getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);
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
