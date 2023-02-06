package view.handler.view;

import java.io.IOException;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.BaseScreenHandler;

public class ViewDockBikeInfoHandler extends BaseScreenHandler {

    @FXML
    private Label typeBike, companyBike, licensePlates, battery, availableTime, deposit;

    @FXML
    private Image image;

    @FXML
    private Button returnButton;

    private Bike bike;
    public ViewDockBikeInfoHandler(String screenPath, Stage stage, Bike bike) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
        this.initialize();
        //TODO Auto-generated constructor stub
    }
    public void initialize()
    {
        typeBike.setText(Integer.toString(bike.getBikeType()));
        companyBike.setText(bike.getBrand());
        licensePlates.setText(Integer.toString(bike.getBikeId()));
    }

}
