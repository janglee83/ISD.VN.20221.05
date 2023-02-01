package view.handler.rentbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business_layer.RentBike_BL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utlis.Configs;
import view.BaseScreenHandler;

public class RentBikeHandler extends BaseScreenHandler implements Initializable {
    @FXML
    private TextField barcode;
    private String Barcode;
    private RentBike_BL rentBike_BL;
    public RentBikeHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath, stage);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
    @FXML
    void submitBarcode(MouseEvent event) throws IOException{
        try{
            Barcode = barcode.getText();
            System.out.println(Barcode);
            rentBike_BL.convertToRentalCode(Barcode);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void exitEnterBarcode(MouseEvent event) throws IOException {
        this.getPreviousScreen().show();
    }
}
