package view.handler.rentbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business_layer.RentBike_BL;
import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class RentBikeInfoHandler extends BaseScreenHandler implements Initializable {

    private Bike bike;
    private String barcode;
    private Label bikeType,brand,licensePlate,deposit,barcodelb;
    private static RentBike_BL rentBike_BL = new RentBike_BL();
    public RentBikeInfoHandler(String screenPath, Stage stage,Bike bike,String Barcode) throws IOException {
        super(screenPath, stage);
        this.bike = bike;
        this.barcode = Barcode;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        bikeType.setText(Integer.toString(bike.getBikeType()));
        brand.setText(bike.getBrand());
        licensePlate.setText(bike.getLicensePlate());
        deposit.setText(Integer.toString(rentBike_BL.caculateDeposit(bike)));
        barcodelb.setText(this.barcode);
    }

}
