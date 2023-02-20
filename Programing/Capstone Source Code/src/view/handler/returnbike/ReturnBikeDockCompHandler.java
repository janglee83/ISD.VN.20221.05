package view.handler.returnbike;

import java.io.IOException;
import java.sql.SQLException;

import common.exception.CapstoneException;
import controller.ReturnBikeController;
import entity.bike.BikeType;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import view.FXMLScreenHandler;

public class ReturnBikeDockCompHandler extends FXMLScreenHandler {

    @FXML
    private HBox hboxDock;

    @FXML
    private Label title, title1, title2;

    @FXML
    private Label emptyDockPoint1, emptyDockPoint2, emptyDockPoint3;

    @FXML
    private ImageView image;

    @FXML
    private Button returnBikeButton;

    private ReturnBikeDockListHandler returnBikeChooseDockHandler;

    private Dock dock; // selected dock

    private final ReturnBikeController returnBikeController = new ReturnBikeController();

    public ReturnBikeDockCompHandler(String screenPath, ReturnBikeDockListHandler returnBikeChooseDockHandler)
            throws IOException {
        super(screenPath);
        this.returnBikeChooseDockHandler = returnBikeChooseDockHandler;
        hboxDock.setAlignment(Pos.CENTER);
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public void setDockInfo() {
        // set title data
        title.setText(dock.getDockName());
        title1.setText(dock.getDockAddress());
        title2.setText(new String(Integer.toString(dock.getDockArea()) + "m2"));

        // set image
        Image imageLink = new Image(dock.getDockImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);

        // get list bike type
        BikeType bikeType = new BikeType();
        utlis.Helper.getListBikeType(bikeType);

        // set number empty dock point REFACTOR

        String text1 = setTextDockPoint(StandardBike.BIKE_TYPE_VALUE, bikeType);
        emptyDockPoint1.setText(text1);
        String text2 = setTextDockPoint(StandardEBike.BIKE_TYPE_VALUE, bikeType);
        emptyDockPoint2.setText(text2);
        String text3 = setTextDockPoint(TwinBike.BIKE_TYPE_VALUE, bikeType);
        emptyDockPoint3.setText(text3);

        // handler button event
        returnBikeButton.setOnMouseClicked(event -> {
            // Display return dock info screen
            try {
                returnBikeChooseDockHandler.returnBikeDockInfoHandler(dock);
            } catch (IOException exception) {
                throw new CapstoneException(exception.getMessage());
            }
        });
    }

    private String setTextDockPoint(int bikeTypeValue, BikeType bikeType) {
        return new String("Number of " + bikeType.getNameBikeType(bikeTypeValue) + "is: " + dock.getNumberOfEmptyDockPoint().get(bikeType.getNameBikeType(bikeTypeValue)));
    }

}
