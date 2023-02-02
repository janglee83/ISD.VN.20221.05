package business_layer;

import java.sql.SQLException;

import common.exception.CapstoneException;
import data_access_layer.dock.Dock_DAL;
import entity.dock.Dock;
import entity.dock.DockList;

public class ReturnBike_BL {

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

}
