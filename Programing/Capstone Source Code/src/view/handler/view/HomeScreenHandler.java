package view.handler.view;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import business_layer.RentBike_BL;
import data_access_layer.bike.Bike_DAL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import business_layer.View_BL;
import common.exception.CapstoneException;
import controller.ViewController;
import entity.bike.BikeRentInfo;
import entity.dock.Dock;
import entity.dock.DockList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.rentbike.RentBikeInfoHandler;

public class HomeScreenHandler extends BaseScreenHandler {
    private static Logger LOGGER = utlis.Helper.getLogger(HomeScreenHandler.class.getName());

    private static ViewController viewController = new ViewController();

    private static View_BL view_BL = new View_BL();

    @FXML
    private VBox VBoxListDock;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    private static RentBike_BL rentBike_BL = new RentBike_BL();

    private static Bike_DAL bike_DAL = new Bike_DAL();
    //private BikeRentInfo bikeRentInfo;

    public HomeScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
        this.initialize();
    }

    private void initialize() {
        final DockList dockList = new DockList();
        view_BL.getListDock(dockList);
        VBoxListDock.getChildren().clear();

        try {
            displayDocks(dockList);
        } catch (IOException exception) {
            throw new CapstoneException(exception.getMessage());
        }
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            // display dock by it's name
            try {
                for (Dock dock : dockList.getDocksList()) {
                    if (dock.getDockName().equals(newValue)) {
                        // clear all old data
                        VBoxListDock.getChildren().clear();
                        displayDock(dock);
                        break;
                    }
                }

                if (newValue.equals("")) {
                    // clear all old data
                    VBoxListDock.getChildren().clear();
                    displayDocks(dockList);
                }
            } catch (IOException exception) {
                throw new CapstoneException(exception.getMessage());
            }
        });
    }
    public void viewDockInfoHandler(Dock dock) throws IOException
    {
        ViewDockInfoHandler viewDockInfoHandler = new ViewDockInfoHandler(Configs.DOCK_DETAIL_SCREEN_PATH, this.stage, dock);
        viewDockInfoHandler.setPreviousScreen(this);
        viewDockInfoHandler.setHomeScreenHandler(homeScreenHandler);
        viewDockInfoHandler.setScreenTitle("Home - Dock info");
        viewDockInfoHandler.show();
    }
    private void displayDock(Dock dock) throws IOException
    {
        // display each dock
        ViewDockCompHandler viewDockCompHandler = new ViewDockCompHandler(Configs.VIEW_DOCK_COMP_PATH, this);
        viewDockCompHandler.setDock(dock);
        viewDockCompHandler.setDockInfo();

        // add spinner
        VBoxListDock.getChildren().add(viewDockCompHandler.getContent());
    }

    private void displayDocks(DockList dockList) throws IOException {
        for (Dock dock : dockList.getDocksList()) {
            displayDock(dock);
        }
    }
    @FXML
    void enterBarcodeHandler(MouseEvent event) throws SQLException {
        try {
            TextInputDialog td = new TextInputDialog();
            td.setTitle("Enter bar code");
            td.setHeaderText("Nhập barcode để thuê xe:");
            td.setContentText("Barcode");

            Optional<String> result = td.showAndWait();
            if (result.isPresent()) {
                // System.out.println(result.get());
                RentBikeInfoHandler rentBikeInfoHandler = new RentBikeInfoHandler(Configs.RENT_BIKE_INFO_SCREEN_PATH,
                        this.stage, bike_DAL.getBikeInDock(rentBike_BL.convertToRentalCode(result.get())),
                        result.get());
                rentBikeInfoHandler.setPreviousScreen(this);
                rentBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
                rentBikeInfoHandler.setScreenTitle("Rent bike info");
                rentBikeInfoHandler.show();
            }
        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Barcode không hợp lệ");
            alert.showAndWait();
        }
    }

}
