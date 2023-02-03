package view.handler.rentbike;

import java.io.IOException;
import business_layer.RentBike_BL;
import data_access_layer.bike.Bike_DAL;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class RentBikeHandler extends BaseScreenHandler {
    @FXML
    private TextField barcode;
    private String Barcode;
    private static RentBike_BL rentBike_BL = new RentBike_BL();
    private static Bike_DAL bike_DAL = new Bike_DAL();

    public RentBikeHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }

    @FXML
    void submitBarcode(MouseEvent event) throws IOException {
        try {
            Barcode = barcode.getText();
            System.out.println(Barcode);
            System.out.println(rentBike_BL.convertToRentalCode(Barcode));
            System.out.println(bike_DAL.getBikeInDock(9, 3).getBikeId());
            RentBikeInfoHandler rentBikeHandler = new RentBikeInfoHandler(Configs.RENT_BIKE_INFO_SCREEN_PATH, this.stage,bike_DAL.getBikeInDock(rentBike_BL.convertToRentalCode(Barcode), 3),this.Barcode);
            // configs
            rentBikeHandler.setPreviousScreen(this);
            rentBikeHandler.setHomeScreenHandler(homeScreenHandler);
            rentBikeHandler.setScreenTitle("Rent bike info");
            rentBikeHandler.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void exitEnterBarcode(MouseEvent event) throws IOException {
        this.getPreviousScreen().show();
    }
}
