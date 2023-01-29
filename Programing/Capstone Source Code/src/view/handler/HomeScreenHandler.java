package view.handler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.BaseScreenHandler;
import view.handler.bike.RentBikeScreenHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {
    @FXML
    private Button rentBikeButton;

    public HomeScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
        rentBikeButton.setOnMouseClicked(e->{
        DockInfoScreenHandler DockInfoScreen = new DockInfoScreenHandler(this.stage, Configs.DOCK_INFOR_PATH);
		DockInfoScreen.setBController(new BaseController());
		DockInfoScreen.setPreviousScreen(this);
		DockInfoScreen.setScreenTitle("DockInfo Screen");
		DockInfoScreen.show();      
        });
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        

    }

}
