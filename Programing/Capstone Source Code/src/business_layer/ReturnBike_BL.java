package business_layer;
import java.sql.SQLException;

import data_access_layer.bike.Bike_DAL;
import data_access_layer.bikeType.BikeType_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardEBike;
import entity.dock.Dock;
import entity.dock.DockList;

public class ReturnBike_BL {

    private final Bike_DAL bike_DAL = new Bike_DAL();

    private final Dock_DAL dock_DAL = new Dock_DAL();

    private final BikeType_DAL BikeType_DAL = new BikeType_DAL();

    public void getListDock(DockList dockList) throws Exception {
        // gennerate Dock_DAL
        Dock_DAL dock_DAL = new Dock_DAL();

        // get docklist
        dockList.setDocksList(dock_DAL.getListDock());

        // get list bike type
        BikeType bikeType = new BikeType();
        bikeType.setListBikeType(BikeType_DAL.getListBikeType());

        for (Dock dock : dockList.getDocksList()) {
            // get number empty dock point
            dock.setNumberOfEmptyDockPoint(dock_DAL.getNumberOfEmptyDockPoint(dock.getDockId(), bikeType));
        }

    }

    public void returnBikeUpdateDatabase(Bike bike, int returnedDockId) throws SQLException {
        bike_DAL.returnBikeUpdateBikeIsUsed(bike);
        dock_DAL.updateReturnBikeDockAvailablePosition(bike, returnedDockId);
        dock_DAL.updateReturnBikeDockPoint(bike, returnedDockId);
    }

    public void getListBikeType(BikeType listBikeType) throws SQLException {
        listBikeType.setListBikeType(BikeType_DAL.getListBikeType());
    }

    public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
        return bike_DAL.getEBikeAttr(bike);
    }

}
