package view.handler.returnbike;

import java.io.IOException;

import entity.bike.Bike;
import entity.bike.BikeRentInfo;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class ReturnBikeDockInfoHandler extends BaseScreenHandler {

    @FXML
    private Label dockName, dockAddress, dockArea, availableStandardBikePoint, availableStandardEBikePoint,
            availableTwinBikePoint;

    private Dock dock; // selected dock

    private BikeRentInfo bikeRentInfo;

    @FXML
    private ImageView image;

    public ReturnBikeDockInfoHandler(String screenPath, Stage stage, Dock dock, BikeRentInfo bikeRentInfo)
            throws IOException {
        super(screenPath, stage);
        this.dock = dock;
        this.bikeRentInfo = bikeRentInfo;
        this.initialize();
    }

    private void initialize() {
        // set up data
        dockName.setText(dock.getDockName());
        dockAddress.setText(dock.getDockAddress());
        dockArea.setText(Integer.toString(dock.getDockArea()));
        availableStandardBikePoint
                .setText(Integer.toString(dock.getNumberOfEmptyDockPoint().get(1)));
        availableStandardEBikePoint
                .setText(Integer.toString(dock.getNumberOfEmptyDockPoint().get(2)));
        availableTwinBikePoint.setText(Integer.toString(dock.getNumberOfEmptyDockPoint().get(3)));

        // set image
        Image imageLink = new Image(dock.getDockImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);
    }

    @FXML
    public void confirmToReturn(MouseEvent event) throws IOException {
        // display return bike dock info screen
        ReturnBikeInfoHandler returnBikeDockInfoHandler = new ReturnBikeInfoHandler(
                Configs.RETURN_BIKE_INFO_SCREEN_PATH, this.stage, bikeRentInfo);
        // configs
        returnBikeDockInfoHandler.setPreviousScreen(this);
        returnBikeDockInfoHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeDockInfoHandler.setScreenTitle("Return bike - Bike Info");
        returnBikeDockInfoHandler.show();
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}
