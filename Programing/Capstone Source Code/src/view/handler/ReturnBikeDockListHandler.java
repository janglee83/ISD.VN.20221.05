package view.handler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import common.exception.CapstoneException;
import controller.ReturnBikeController;
import data_access_layer.dock.dock_DAL;
import entity.dock.Dock;
import entity.dock.DockList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class ReturnBikeDockListHandler extends BaseScreenHandler implements Initializable {

    private static Logger LOGGER = utlis.Helper.getLogger(ReturnBikeDockListHandler.class.getName());

    @FXML
    private VBox listDockVBox;

    public ReturnBikeDockListHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // gennerate list dock
        final dock_DAL dock_DAL = new dock_DAL();
        final DockList dockList = new DockList();

        try {
            // get docklist
            dockList.setDocksList(dock_DAL.getListDock());

            // clear all old data
            listDockVBox.getChildren().clear();

            // display each dock data
            for (Dock dock : dockList.getDocksList()) {
                // display attr
                ReturnBikeDockCompHandler returnBikeDockHandler = new ReturnBikeDockCompHandler(Configs.RETURN_BIKE_DOCK_COMP_SCREEN_PATH, this);
                returnBikeDockHandler.setDock(dock);
                returnBikeDockHandler.setDockInfo();

                // add spinner
                listDockVBox.getChildren().add(returnBikeDockHandler.getContent());
            }

        } catch (SQLException | IOException exception) {
            throw new CapstoneException(exception.getMessage());
        }
    }

    public void returnBikeDockInfoHandler(Dock dock) throws IOException {
        // initialize controller
        ReturnBikeController returnBikeController = new ReturnBikeController();

        //display return bike dock info screen
        ReturnBikeDockInfoHandler returnBikeDockInfoHandler = new ReturnBikeDockInfoHandler(Configs.RETURN_BIKE_DOCK_INFO_SCREEN_PATH, this.stage, dock);
        //configs
        returnBikeDockInfoHandler.setPreviousScreen(this);
        returnBikeDockInfoHandler.setBaseController(returnBikeController);
        returnBikeDockInfoHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeDockInfoHandler.setScreenTitle("Return bike - Dock info");
        returnBikeDockInfoHandler.show();
    }


}
