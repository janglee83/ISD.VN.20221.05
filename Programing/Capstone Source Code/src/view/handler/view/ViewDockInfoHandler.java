package view.handler.view;

import java.io.IOException;

import business_layer.View_BL;
import common.exception.CapstoneException;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class ViewDockInfoHandler extends BaseScreenHandler {
    // available Bike in dock count
    private int availableValue = 0;
    private View_BL view_BL = new View_BL();

    @FXML
    private Label dockName, dockAddress, dockArea;

    @FXML
    private Label availableBike;

    @FXML
    private VBox bikeListVbox;

    @FXML
    private Button returnButton;
    
    private Dock dock;

    public ViewDockInfoHandler(String screenPath, Stage stage, Dock dock) throws IOException {
        super(screenPath, stage);
        this.dock = dock;
        this.initialize();
    }

    private void initialize() {
        dockName.setText(dock.getDockName());
        dockAddress.setText(dock.getDockAddress());
        dockArea.setText(Integer.toString(dock.getDockArea()));
        // todo 
        final DockBikeList bikeList = new DockBikeList();
        view_BL.getListBike(bikeList, dock);
        bikeListVbox.getChildren().clear();
        try {
            displayBikes(bikeList);
        } catch (IOException exception) {
            throw new CapstoneException(exception.getMessage());
        }
        availableBike.setText(new String("" + availableValue));
    }


    public void viewDockBikeInfoHandler(Bike bike) throws IOException {
        ViewDockBikeInfoHandler viewDockBikeInfoHandler = new ViewDockBikeInfoHandler(Configs.BIKE_DETAIL_SCREEN_PATH,this.stage, bike);
        viewDockBikeInfoHandler.setPreviousScreen(this);
        viewDockBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
        viewDockBikeInfoHandler.setScreenTitle("Bike Info");
        viewDockBikeInfoHandler.show();
    }

    private void displayBike(Bike bike) throws IOException {
        ViewDockBikeInfoCompHandler viewDockBikeInfoCompHandler = new ViewDockBikeInfoCompHandler(
                Configs.VIEW_DOCK_BIKE_COMP_PATH, this);
        viewDockBikeInfoCompHandler.setBike(bike);
        viewDockBikeInfoCompHandler.setBikeInfo();
        bikeListVbox.getChildren().add(viewDockBikeInfoCompHandler.getContent());
    }

    private void displayBikes(DockBikeList bikeList) throws IOException {
        for (Bike bike : bikeList.getBikesList()) {
            displayBike(bike);
            availableValue ++;
        }
    }

    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }
}
