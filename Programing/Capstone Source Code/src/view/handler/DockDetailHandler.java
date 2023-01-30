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

public class DockDetailHandler extends BaseScreenHandler implements Initializable {

    public DockDetailHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
    @FXML
    void rentBikeHandler(MouseEvent event) throws IOException {
        //initialize controller
        RentBikeController rentBikeController = new RentBikeController();

        // display Return bike screen
        RentBikeHandler rentBikeHandler = new RentBikeHandler(Configs.RENT_BIKE_SCREEN_PATH, this.stage);
        // configs
        rentBikeHandler.setPreviousScreen(this);
        rentBikeHandler.setBaseController(rentBikeController);
        rentBikeHandler.setHomeScreenHandler(homeScreenHandler);
        rentBikeHandler.setScreenTitle("Rent Bike");
        rentBikeHandler.show();
    }
}

