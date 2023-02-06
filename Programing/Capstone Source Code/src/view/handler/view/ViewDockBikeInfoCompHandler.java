package view.handler.view;

import java.io.IOException;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import entity.bike.Bike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.print.PrintColor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import view.FXMLScreenHandler;

public class ViewDockBikeInfoCompHandler extends FXMLScreenHandler{

    private static Logger LOGGER = utlis.Helper.getLogger(ViewDockBikeInfoCompHandler.class.getName());
    @FXML
    private HBox hboxBike;
    @FXML
    private ImageView image;
    @FXML
    private Button displayBikeInfoButton;
    private ViewDockInfoHandler viewDockChooseBikeHandler;
    private Bike bike;
    public ViewDockBikeInfoCompHandler(String screenPath, ViewDockInfoHandler viewDockChooseBikeHandler) throws IOException {
        super(screenPath);
        this.viewDockChooseBikeHandler = viewDockChooseBikeHandler;
        hboxBike.setAlignment(Pos.CENTER);
    }
    public void setBike(Bike bike)
    {
        this.bike = bike;
    }
    public void setBikeInfo()
    {
        displayBikeInfoButton.setOnMouseClicked(event ->
        {
            LOGGER.info("Comfirm to view Bike info");
            try{
                viewDockChooseBikeHandler.viewDockBikeInfoHandler(bike);
            } catch (IOException exception)
            {
                throw new CapstoneException(exception.getMessage());
            }
        });
    }
}
