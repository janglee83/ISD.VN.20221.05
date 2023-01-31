package view.handler;

import java.io.IOException;

import entity.dock.Dock;
import javafx.stage.Stage;
import view.BaseScreenHandler;

public class ReturnBikeDockInfoHandler extends BaseScreenHandler {

    private Dock dock; // selected dock

    public ReturnBikeDockInfoHandler(String screenPath, Stage stage, Dock dock) throws IOException {
        super(screenPath, stage);
        this.dock = dock;
    }

}
