package view.handler.view;

import java.io.IOException;
import java.sql.SQLException;

import common.exception.CapstoneException;
import controller.ViewController;
import entity.bike.Bike;
import entity.bike.StandardEBike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.BaseScreenHandler;
import entity.bike.BikeType;
public class ViewDockBikeInfoHandler extends BaseScreenHandler {

    @FXML
    private Label typeBike, brandBike, licensePlates, deposit;

    @FXML
    private Label availableTime, battery, tgkd, batteryLabel; 

    @FXML
    private ImageView image;

    @FXML
    private Button returnButton;

    private final ViewController viewController = new ViewController();
    private Bike bike;
    
    //private StandardEBike standardEBike;
    public ViewDockBikeInfoHandler(String screenPath, Stage stage, Bike bike) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
        this.initialize();
    }

    private void initialize()
    {
        typeBike.setText(utlis.Helper.convertToStringBikeType(bike.getBikeType()));
        brandBike.setText(bike.getBrand());
        licensePlates.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(bike.getBikeValue()));
        // set image
        Image imageLink = new Image(bike.getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);

        battery.setVisible(false);
        batteryLabel.setVisible(false);
        
        switch (bike.getBikeType()) {
            case StandardEBike.BIKE_TYPE_VALUE:
                setEBikeAttrData();
                break;
            default:
                break;
        }
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
    
    // E-bike display 
    private void setEBikeAttrData() {
        StandardEBike eBike;
        batteryLabel.setVisible(true);
        battery.setVisible(true);

        try {
            eBike = viewController.getEBikeAttr(bike);
            battery.setText(new String(eBike.getBateryPercent() + "%"));
        } catch (SQLException e) {
            throw new CapstoneException(e.getMessage());
        }
    }
}
