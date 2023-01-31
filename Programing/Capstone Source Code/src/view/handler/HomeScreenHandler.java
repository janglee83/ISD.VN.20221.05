package view.handler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.RentBikeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {

    public HomeScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    @FXML
    void returnBikeHandler(MouseEvent event) throws IOException {
        //initialize controller
        RentBikeController rentBikeController = new RentBikeController();

        // display Return bike screen
        ReturnBikeHandler returnBikeHandler = new ReturnBikeHandler(Configs.BIKE_RENT_DATA_SCREEN_PATH, this.stage);
        // configs
        returnBikeHandler.setPreviousScreen(this);
        returnBikeHandler.setBaseController(rentBikeController);
        returnBikeHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeHandler.setScreenTitle("Return bike");
        returnBikeHandler.show();
    }

}
