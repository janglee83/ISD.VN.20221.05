package view.handler.returnbike;

import java.io.IOException;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import entity.bike.Bike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import view.FXMLScreenHandler;

public class ReturnBikeDockCompHandler extends FXMLScreenHandler {

    private static Logger LOGGER = utlis.Helper.getLogger(ReturnBikeDockCompHandler.class.getName());

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

    public ReturnBikeDockCompHandler(String screenPath, ReturnBikeDockListHandler returnBikeChooseDockHandler) throws IOException {
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
        title2.setText(Integer.toString(dock.getDockArea()));

        // set image
        // File file = new File(dock.getDockImageUrl());
        // Image imageLink = new Image(file.toURI().toString());
        // image.setImage(imageLink);
        // image.setPreserveRatio(false);
        // image.setFitHeight(110);
		// image.setFitWidth(92);

        // set number empty dock point REFACTORRRRRRRRRRRRRRRRR
        String text1 = new String("Number of " + Bike.STANDARD_BICYCLE_STRING + "is: " + dock.getNumberOfEmptyDockPoint().get(Bike.STANDARD_BICYCLE_STRING));
        emptyDockPoint1.setText(text1);
        String text2 = new String("Number of " + Bike.STANDARD_E_BIKE_STRING + "is: " + dock.getNumberOfEmptyDockPoint().get(Bike.STANDARD_E_BIKE_STRING));
        emptyDockPoint2.setText(text2);
        String text3 = new String("Number of " + Bike.TWIN_BIKE_STRING + "is: " + dock.getNumberOfEmptyDockPoint().get(Bike.TWIN_BIKE_STRING));
        emptyDockPoint3.setText(text3);

        //handler button event
        returnBikeButton.setOnMouseClicked(event -> {
            // Display return dock info screen
            LOGGER.info("Confirm to return bike");
            try {
                returnBikeChooseDockHandler.returnBikeDockInfoHandler(dock);
            } catch (IOException exception) {
                throw new CapstoneException(exception.getMessage());
            }
        });

    }

}
