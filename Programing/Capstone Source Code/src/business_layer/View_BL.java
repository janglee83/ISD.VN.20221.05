package business_layer;
import java.sql.SQLException;

import common.exception.CapstoneException;
import data_access_layer.bike.bike_DAL;
import data_access_layer.bike.Bike_Type_DAL;
import data_access_layer.dock.dock_DAL;
import entity.bike.BikeType;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import entity.dock.DockList;
public class View_BL {

    private final Bike_Type_DAL bike_Type_DAL = new Bike_Type_DAL();

    public void getListDock(DockList dockList) {
		// gennerate Dock_DAL
        final dock_DAL dock_DAL = new dock_DAL();

		try {
            // get docklist
            dockList.setDocksList(dock_DAL.getListDock());

            // get list bike type
            BikeType bikeType = new BikeType();
            bikeType.setListBikeType(bike_Type_DAL.getListBikeType());

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
        final bike_DAL bike_DAL = new bike_DAL();
        try {
            bikeList.setDockBikeList(bike_DAL.getBikeListInDock(dock.getDockId()));
        } catch (SQLException exception)
        {
            throw new CapstoneException(exception.getMessage());
        }
    }
}
