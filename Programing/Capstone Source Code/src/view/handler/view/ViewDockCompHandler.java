package view.handler.view;

import java.io.IOException;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import entity.bike.Bike;
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
    private Label title, title1, title2;

    @FXML
    private Label emptyDockPoint1, emptyDockPoint2, emptyDockPoint3;

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
        title.setText(dock.getDockName());
        title1.setText(dock.getDockAddress());
        title2.setText(new String(Integer.toString(dock.getDockArea()) + "m2"));

        // set image
        Image imageLink = new Image(dock.getDockImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);

        String text1 = new String("Number of "+ utlis.Helper.convertToStringBikeType(1) +" is: " + dock.getNumberOfEmptyDockPoint().get(1));
        emptyDockPoint1.setText(text1);
        String text2 = new String("Number of "+ utlis.Helper.convertToStringBikeType(2) +" is: " + dock.getNumberOfEmptyDockPoint().get(2));
        emptyDockPoint2.setText(text2);
        String text3 = new String("Number of " + utlis.Helper.convertToStringBikeType(3)+ "is: " + dock.getNumberOfEmptyDockPoint().get(3));
        emptyDockPoint3.setText(text3);

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
}
