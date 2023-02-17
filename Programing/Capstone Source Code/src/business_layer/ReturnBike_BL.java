package business_layer;

import java.sql.SQLException;

import common.exception.CapstoneException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.dock.DockList;

public class ReturnBike_BL {

    private Bike_DAL bike_DAL = new Bike_DAL();

    private Dock_DAL dock_DAL = new Dock_DAL();

    public void getListDock(DockList dockList) throws Exception {
        // gennerate Dock_DAL
        Dock_DAL dock_DAL = new Dock_DAL();
        // get docklist
        dockList.setDocksList(dock_DAL.getListDock());

        for (Dock dock : dockList.getDocksList()) {
            // get number empty dock point
            dock.setNumberOfEmptyDockPoint(dock_DAL.getNumberOfEmptyDockPoint(dock.getDockId()));
        }

    }

    public void returnBikeUpdateDatabase(Bike bike) throws SQLException {
        bike_DAL.returnBikeUpdateBikeIsUsed(bike);
        dock_DAL.updateReturnBikeDockPoint(bike);
    }

}
