package view.handler.returnbike;

import java.io.IOException;
import java.sql.SQLException;

import common.exception.CapstoneException;
import controller.ReturnBikeController;
import entity.bike.BikeRentInfo;
import entity.bike.BikeType;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
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

    private final ReturnBikeController returnBikeController = new ReturnBikeController();

    public ReturnBikeDockInfoHandler(String screenPath, Stage stage, Dock dock, BikeRentInfo bikeRentInfo)
            throws IOException {
        super(screenPath, stage);
        this.dock = dock;
        this.bikeRentInfo = bikeRentInfo;
        this.bikeRentInfo.setReturnedDock(dock);
        this.initialize();
    }

    private void initialize() {
        // set up data
        dockName.setText(dock.getDockName());
        dockAddress.setText(dock.getDockAddress());
        dockArea.setText(Integer.toString(dock.getDockArea()));


        // get list bike type
        BikeType bikeType = new BikeType();
        utlis.Helper.getListBikeType(bikeType);

        availableStandardBikePoint.setText(getNumberPointString(bikeType, StandardBike.BIKE_TYPE_VALUE));
        availableStandardEBikePoint.setText(getNumberPointString(bikeType, StandardEBike.BIKE_TYPE_VALUE));
        availableTwinBikePoint.setText(getNumberPointString(bikeType, TwinBike.BIKE_TYPE_VALUE));

        // set image
        Image imageLink = new Image(dock.getDockImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);
    }

    @FXML
    public void confirmToReturn(MouseEvent event) throws IOException {
        // display return bike dock info screen
        ReturnBikeInfoHandler returnBikeInfoHandler = new ReturnBikeInfoHandler(
                Configs.RETURN_BIKE_INFO_SCREEN_PATH, this.stage, bikeRentInfo);
        // configs
        returnBikeInfoHandler.setPreviousScreen(this);
        returnBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeInfoHandler.setScreenTitle("Return bike - Bike Info");
        returnBikeInfoHandler.show();
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }

    private String getNumberPointString(BikeType bikeType, int bikeTypeValue) {
        return Integer.toString(dock.getNumberOfEmptyDockPoint().get(bikeType.getNameBikeType(bikeTypeValue)));
    }
}
