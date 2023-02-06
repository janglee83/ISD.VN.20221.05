package view.handler.view;

import java.io.IOException;
import java.util.logging.Logger;

import business_layer.View_BL;
import common.exception.CapstoneException;
import controller.ViewController;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import request_layer.View_RL;
import utlis.Configs;
import view.BaseScreenHandler;

public class ViewDockInfoHandler extends BaseScreenHandler{

    private static Logger LOGGER = utlis.Helper.getLogger(ViewDockInfoHandler.class.getName());
    private static ViewController viewController = new ViewController();
    private View_RL view_RL = new View_RL();
    private View_BL view_BL = new View_BL();
    @FXML
    private Label dockName, dockAddress, dockArea, availableBike;
    @FXML
    private VBox listBikeVBox;
    @FXML
    private Button returnButton;

    private Dock dock;
    private Bike bike;
    public ViewDockInfoHandler(String screenPath, Stage stage, Dock dock) throws IOException {
        super(screenPath, stage);
        this.dock = dock;
        this.initialize();
        //TODO Auto-generated constructor stub
    }
    private void initialize()
    {
        dockName.setText(dock.getDockName());
        dockAddress.setText(dock.getDockAddress());
        dockArea.setText(Integer.toString(dock.getDockArea()));
        //todo
        final DockBikeList bikeList = new DockBikeList();
        view_BL.getListBike(bikeList, dock);
        listBikeVBox.getChildren().clear();
        try {
            displayBikes(bikeList);
        } catch (IOException exception)
        {
            throw new CapstoneException(exception.getMessage());
        }
    }
    public void viewDockBikeInfoHandler(Bike bike) throws IOException
    {
        ViewDockBikeInfoHandler viewDockBikeInfoHandler = new ViewDockBikeInfoHandler(Configs.BIKE_DETAIL_SCREEN_PATH, this.stage, bike);
        viewDockBikeInfoHandler.setPreviousScreen(this);
        viewDockBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
        viewDockBikeInfoHandler.setScreenTitle("Bike Info");
        viewDockBikeInfoHandler.show();
    }
    public void displayBike(Bike bike) throws IOException {
        ViewDockBikeInfoCompHandler viewDockBikeInfoCompHandler = new ViewDockBikeInfoCompHandler(Configs.VIEW_DOCK_BIKE_COMP_PATH, this);
        viewDockBikeInfoCompHandler.setBike(bike);
        viewDockBikeInfoCompHandler.setBikeInfo();
        listBikeVBox.getChildren().add(viewDockBikeInfoCompHandler.getContent());
    }
    public void displayBikes(DockBikeList bikeList) throws IOException {
        for(Bike bike : bikeList.getBikesList())
        {
            displayBike(bike);
        }
    }
    @FXML
    public void barcodeInsert(MouseEvent event) throws IOException
    {

    }
    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}
