package view.handler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import business_layer.RentBike_BL;
import data_access_layer.bike.Bike_DAL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.rentbike.RentBikeInfoHandler;
import view.handler.returnbike.ReturnBikeHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {

    private static RentBike_BL rentBike_BL = new RentBike_BL();
    private static Bike_DAL bike_DAL = new Bike_DAL();

    public HomeScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

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

    @FXML
    void dockDetailHandler(MouseEvent event) throws SQLException {
        try {
            TextInputDialog td = new TextInputDialog();
            td.setTitle("Enter bar code");
            td.setHeaderText("Nhập barcode để thuê xe:");
            td.setContentText("Barcode");

            Optional<String> result = td.showAndWait();
            if (result.isPresent()) {
                System.out.println(result.get());
                RentBikeInfoHandler rentBikeInfoHandler = new RentBikeInfoHandler(Configs.RENT_BIKE_INFO_SCREEN_PATH,
                        this.stage, bike_DAL.getBikeInDock(rentBike_BL.convertToRentalCode(result.get()), 3),
                        result.get());
                rentBikeInfoHandler.setPreviousScreen(this);
                rentBikeInfoHandler.setHomeScreenHandler(homeScreenHandler);
                rentBikeInfoHandler.setScreenTitle("Rent bike info");
                rentBikeInfoHandler.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
