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

public class RentBikeHandler extends BaseScreenHandler implements Initializable {

    public RentBikeHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    @FXML
    void exitEnterBarcode(MouseEvent event) throws IOException {
        this.getPreviousScreen().show();
    }

}
