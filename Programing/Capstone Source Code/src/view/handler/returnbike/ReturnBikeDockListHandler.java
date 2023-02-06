package view.handler.returnbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import controller.ReturnBikeController;
import entity.bike.BikeRentInfo;
import entity.dock.Dock;
import entity.dock.DockList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class ReturnBikeDockListHandler extends BaseScreenHandler implements Initializable {

    private static Logger LOGGER = utlis.Helper.getLogger(ReturnBikeDockListHandler.class.getName());

    private static ReturnBikeController returnBikeController = new ReturnBikeController();

    @FXML
    private VBox listDockVBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label invalidText;

    private BikeRentInfo bikeRentInfo;

    public ReturnBikeDockListHandler(String screenPath, Stage stage, BikeRentInfo bikeRentInfo) throws IOException {
        super(screenPath, stage);
        this.bikeRentInfo = bikeRentInfo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set error invisible
        invalidText.setVisible(false);

        // gennerate list dock
        final DockList dockList = new DockList();

        // get list dock from bussiness layer
        returnBikeController.getListDock(dockList);

        // clear all old data
        listDockVBox.getChildren().clear();

        // display each dock data
        try {
            displayDocks(dockList);
        } catch (IOException exception) {
            throw new CapstoneException(exception.getMessage());
        }

        // add listener to text field
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            // display dock by it's name
            try {
                for (Dock dock : dockList.getDocksList()) {
                    invalidText.setVisible(false);
                    returnBikeController.validateName(newValue);
                    if (dock.getDockName().equals(newValue)) {
                        // clear all old data
                        listDockVBox.getChildren().clear();
                        displayDock(dock);
                        break;
                    }
                }
                if (newValue.equals("")) {
                    // clear all old data
                    listDockVBox.getChildren().clear();
                    displayDocks(dockList);
                }
            } catch (Exception exception) {
                System.out.println("BUG");
                invalidText.setVisible(true);
                throw new CapstoneException(exception.getMessage());
            }
        });
    }

    public void returnBikeDockInfoHandler(Dock dock) throws IOException {
        // display return bike dock info screen
        ReturnBikeDockInfoHandler returnBikeDockInfoHandler = new ReturnBikeDockInfoHandler(
                Configs.RETURN_BIKE_DOCK_INFO_SCREEN_PATH, this.stage, dock, bikeRentInfo);
        // configs
        returnBikeDockInfoHandler.setPreviousScreen(this);
        returnBikeDockInfoHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeDockInfoHandler.setScreenTitle("Return bike - Dock info");
        returnBikeDockInfoHandler.show();
    }

    private void displayDock(Dock dock) throws IOException {
        // display each dock
        ReturnBikeDockCompHandler returnBikeDockHandler = new ReturnBikeDockCompHandler(
                Configs.RETURN_BIKE_DOCK_COMP_SCREEN_PATH, this);
        returnBikeDockHandler.setDock(dock);
        returnBikeDockHandler.setDockInfo();

        // add spinner
        listDockVBox.getChildren().add(returnBikeDockHandler.getContent());
    }

    private void displayDocks(DockList dockList) throws IOException {
        for (Dock dock : dockList.getDocksList()) {
            displayDock(dock);
        }
    }

    // return to previous screen
    @FXML
    public void handleReturn(MouseEvent event) {
        getPreviousScreen().show();
    }

}
