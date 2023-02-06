package view.handler.viewdock;

import java.io.IOException;

import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.BaseScreenHandler;

public class ViewDockInfoHandler extends BaseScreenHandler{

    @FXML
    private Label dockName, dockAddress, dockArea, availableBike;
    @FXML
    private VBox bikeListVBox;
    @FXML
    private Button returnButton;
    
    private Dock dock;
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
