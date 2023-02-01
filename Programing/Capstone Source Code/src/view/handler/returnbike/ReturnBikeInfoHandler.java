package view.handler.returnbike;

import java.io.IOException;

import controller.ReturnBikeController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.payment.InsertCardScreenHandler;

public class ReturnBikeInfoHandler extends BaseScreenHandler {

    public ReturnBikeInfoHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @FXML
    public void confirmToPayment(MouseEvent event) throws IOException {
        // initialize controller
        ReturnBikeController returnBikeController = new ReturnBikeController();

        //display return bike dock info screen
        InsertCardScreenHandler insertCardScreenHandler = new InsertCardScreenHandler(Configs.INSERT_CARD_SCREEN_PATH, this.stage);

        //configs
        insertCardScreenHandler.setPreviousScreen(this);
        insertCardScreenHandler.setBaseController(returnBikeController);
        insertCardScreenHandler.setHomeScreenHandler(homeScreenHandler);
        insertCardScreenHandler.setScreenTitle("Payment - Confirm to pay");
        insertCardScreenHandler.show();
    }
}
