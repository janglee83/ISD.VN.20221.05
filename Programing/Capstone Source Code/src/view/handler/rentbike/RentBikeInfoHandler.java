package view.handler.rentbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.bike.Bike;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import view.BaseScreenHandler;

public class RentBikeInfoHandler extends BaseScreenHandler implements Initializable {

    private Bike bike;
    public RentBikeInfoHandler(String screenPath, Stage stage,Bike bike) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

}
