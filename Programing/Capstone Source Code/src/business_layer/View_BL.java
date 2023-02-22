package business_layer;
import java.sql.SQLException;

import common.exception.CapstoneException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.bikeType.BikeType_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.bike.BikeType;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import entity.dock.DockList;
public class View_BL {

    private final BikeType_DAL BikeType_DAL = new BikeType_DAL();

    public void getListDock(DockList dockList) {
		// gennerate Dock_DAL
        final Dock_DAL dock_DAL = new Dock_DAL();

		try {
            // get docklist
            dockList.setDocksList(dock_DAL.getListDock());

            // get list bike type
            BikeType bikeType = new BikeType();
            bikeType.setListBikeType(BikeType_DAL.getListBikeType());

            for (Dock dock : dockList.getDocksList()) {
                // get number empty dock point
                dock.setNumberOfEmptyDockPoint(dock_DAL.getNumberOfEmptyDockPoint(dock.getDockId(), bikeType));;
            }

        } catch (SQLException exception) {
            throw new CapstoneException(exception.getMessage());
        }
	}
    public void getListBike(DockBikeList bikeList, Dock dock)
    {
        final Bike_DAL bike_DAL = new Bike_DAL();
        try {
            bikeList.setDockBikeList(bike_DAL.getBikeListInDock(dock.getDockId()));
        } catch (SQLException exception)
        {
            throw new CapstoneException(exception.getMessage());
        }
    }
}
