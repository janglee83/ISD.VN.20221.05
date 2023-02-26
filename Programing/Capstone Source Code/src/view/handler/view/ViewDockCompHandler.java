package view.handler.view;

import java.io.IOException;
import java.util.logging.Logger;

import common.exception.CapstoneException;
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
public class ViewDockCompHandler extends FXMLScreenHandler{
    private static Logger LOGGER = utlis.Helper.getLogger(ViewDockCompHandler.class.getName());
    
    @FXML
    private HBox hboxDock;
    
    @FXML
    private Label dockName, dockAddress, dockArea;

    @FXML
    private Label emptyStandardBike, emptyStandardEBike, emptyTwinBike;

    @FXML
    private ImageView image;

    @FXML
    private Button viewDockDetailButton;

    private HomeScreenHandler homeScreenChooseDockHandler;
    private Dock dock;

    public ViewDockCompHandler(String screenPath, HomeScreenHandler homeScreenChooseDockHandler) throws IOException {
        super(screenPath);
        this.homeScreenChooseDockHandler = homeScreenChooseDockHandler;
        hboxDock.setAlignment(Pos.CENTER);
    }

    public void setDock(Dock dock)
    {
        this.dock = dock;
    }

    public void setDockInfo()
    {
        dockName.setText(dock.getDockName());
        dockAddress.setText(dock.getDockAddress());
        dockArea.setText(new String(Integer.toString(dock.getDockArea()) + "m2"));

        // set image
        Image imageLink = new Image(dock.getDockImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);


        // get list bike type
        BikeType bikeType = new BikeType();
        utlis.Helper.getListBikeType(bikeType);

        // set number empty dock point REFACTOR
        String text1 = setTextDockPoint(StandardBike.BIKE_TYPE_VALUE, bikeType);
        emptyStandardBike.setText("");
        emptyStandardBike.setText(text1);
        String text2 = setTextDockPoint(StandardEBike.BIKE_TYPE_VALUE, bikeType);
        emptyStandardEBike.setText(text2);
        String text3 = setTextDockPoint(TwinBike.BIKE_TYPE_VALUE, bikeType);
        emptyTwinBike.setText(text3);

        viewDockDetailButton.setOnMouseClicked(event -> {
            // todo
            LOGGER.info("Confirm to view dock");
            try {
                homeScreenChooseDockHandler.viewDockInfoHandler(dock);
            } catch (IOException exception)
            {
                throw new CapstoneException(exception.getMessage());
            }
        });
    }

    private String setTextDockPoint(int bikeTypeValue, BikeType bikeType) {
        return new String("Number of " + bikeType.getNameBikeType(bikeTypeValue) + " is: " + dock.getNumberOfEmptyDockPoint().get(bikeType.getNameBikeType(bikeTypeValue)));
    }
}