package view.handler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.RentBikeController;
import controller.ViewController;
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
    @FXML
    void dockDetailHandler(MouseEvent event) throws IOException {
        //initialize controller
        ViewController viewController = new ViewController();

        // display Return bike screen
        DockDetailHandler dockDetailHandler = new DockDetailHandler(Configs.DOCK_DETAIL_SCREEN_PATH, this.stage);
        // configs
        dockDetailHandler.setPreviousScreen(this);
        dockDetailHandler.setBaseController(viewController);
        dockDetailHandler.setHomeScreenHandler(homeScreenHandler);
        dockDetailHandler.setScreenTitle("Dock Detail");
        dockDetailHandler.show();
    }

}
