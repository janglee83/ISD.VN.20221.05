package business_layer;
import java.sql.SQLException;

import common.exception.CapstoneException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import entity.dock.DockList;
public class View_BL {
    public void getListDock(DockList dockList) {
		// gennerate Dock_DAL
        final Dock_DAL dock_DAL = new Dock_DAL();

		try {
            // get docklist
            dockList.setDocksList(dock_DAL.getListDock());

            for (Dock dock : dockList.getDocksList()) {
                // get number empty dock point
                dock.setNumberOfEmptyDockPoint(dock_DAL.getNumberOfEmptyDockPoint(dock.getDockId()));;
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
