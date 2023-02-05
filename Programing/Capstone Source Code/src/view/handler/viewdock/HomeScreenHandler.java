package view.handler.viewdock;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import business_layer.View_BL;
import common.exception.CapstoneException;
import controller.ViewController;
import entity.dock.Dock;
import entity.dock.DockList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.returnbike.ReturnBikeDockCompHandler;
import view.handler.returnbike.ReturnBikeHandler;


public class HomeScreenHandler extends BaseScreenHandler implements Initializable {
    private static Logger LOGGER = utlis.Helper.getLogger(HomeScreenHandler.class.getName());

    private static ViewController viewController = new ViewController();

    private static View_BL view_BL = new View_BL();
    @FXML 
    private VBox listDockVBox;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchButton;
    public HomeScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }
    @Override 
    public void initialize(URL location, ResourceBundle resource)
    {
        final DockList dockList = new DockList();
        view_BL.getListDock(dockList);
        listDockVBox.getChildren().clear();
        try{
            displayDocks(dockList);
        } catch (IOException exception)
        {
            throw new CapstoneException(exception.getMessage());
        }
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        // display dock by it's name
            try {
                for (Dock dock : dockList.getDocksList()) {
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
            } catch (IOException exception) {
                throw new CapstoneException(exception.getMessage());
            }
        });
    }
    private void displayDock(Dock dock) throws IOException
    {
        // display each dock
        ViewDockCompHandler viewDockCompHandler = new ViewDockCompHandler(Configs.VIEW_DOCK_COMP_PATH, this);
        viewDockCompHandler.setDock(dock);
        viewDockCompHandler.setDockInfo();

        // add spinner
        listDockVBox.getChildren().add(viewDockCompHandler.getContent());
    }
    private void displayDocks(DockList dockList) throws IOException {
        for (Dock dock: dockList.getDocksList()){
            displayDock(dock);
        }
    }
    @FXML
    void returnBikeHandler(MouseEvent event) throws IOException {
        // display Return bike screen
        ReturnBikeHandler returnBikeHandler = new ReturnBikeHandler(Configs.BIKE_RENT_DATA_SCREEN_PATH, this.stage);
        // configs
        returnBikeHandler.setPreviousScreen(this);
        returnBikeHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeHandler.setScreenTitle("Return bike");
        returnBikeHandler.show();
    }
}
