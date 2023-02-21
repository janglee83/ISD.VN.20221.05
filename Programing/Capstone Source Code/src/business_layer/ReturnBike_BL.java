package business_layer;
import java.sql.SQLException;

import data_access_layer.bike.bike_DAL;
import data_access_layer.bike.Bike_Type_DAL;
import data_access_layer.dock.dock_DAL;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardEBike;
import entity.dock.Dock;
import entity.dock.DockList;

public class ReturnBike_BL {

    private final bike_DAL bike_DAL = new bike_DAL();

    private final dock_DAL dock_DAL = new dock_DAL();

    private final Bike_Type_DAL bike_Type_DAL = new Bike_Type_DAL();

    public void getListDock(DockList dockList) throws Exception {
        // gennerate Dock_DAL
        dock_DAL dock_DAL = new dock_DAL();

        // get docklist
        dockList.setDocksList(dock_DAL.getListDock());

        // get list bike type
        BikeType bikeType = new BikeType();
        bikeType.setListBikeType(bike_Type_DAL.getListBikeType());

        for (Dock dock : dockList.getDocksList()) {
            // get number empty dock point
            dock.setNumberOfEmptyDockPoint(dock_DAL.getNumberOfEmptyDockPoint(dock.getDockId(), bikeType));
        }

    }

    public void returnBikeUpdateDatabase(Bike bike, int returnedDockId) throws SQLException {
        bike_DAL.returnBikeUpdateBikeIsUsed(bike);
        dock_DAL.updateReturnBikeDockPoint(bike, returnedDockId);
    }

    public void getListBikeType(BikeType listBikeType) throws SQLException {
        listBikeType.setListBikeType(bike_Type_DAL.getListBikeType());
    }

    public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
        return bike_DAL.getEBikeAttr(bike);
    }

}
