package view.handler.view;

import java.io.IOException;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.BaseScreenHandler;

public class ViewDockBikeInfoHandler extends BaseScreenHandler {

    @FXML
    private Label typeBike, brandBike, licensePlates, deposit;

    @FXML
    private ImageView image;

    @FXML
    private Button returnButton;

    private Bike bike;

    public ViewDockBikeInfoHandler(String screenPath, Stage stage, Bike bike) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
        this.initialize();
    }

    private void initialize()
    {
        typeBike.setText(Integer.toString(bike.getBikeType()));
        brandBike.setText(bike.getBrand());
        licensePlates.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(bike.getBikeValue()));

        // set image
        Image imageLink = new Image(bike.getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}