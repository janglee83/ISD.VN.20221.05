package view.handler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.ReturnBikeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class ReturnBikeHandler extends BaseScreenHandler implements Initializable {

    public ReturnBikeHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    @FXML
    void returnBikeChooseDockHandler(MouseEvent event) throws IOException {
        // initialize controller
        ReturnBikeController returnBikeController = new ReturnBikeController();
        // display Return bike screen
        ReturnBikeDockListHandler returnBikeChooseDockHandler = new ReturnBikeDockListHandler(Configs.RETURN_BIKE_DOCK_LIST_SCREEN_PATH, this.stage);

        // configs
        returnBikeChooseDockHandler.setPreviousScreen(this);
        returnBikeChooseDockHandler.setBaseController(returnBikeController);
        returnBikeChooseDockHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeChooseDockHandler.setScreenTitle("Return bike - Choose dock");
        returnBikeChooseDockHandler.show();
    }

}
