package business_layer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.CapstoneException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.dock.DockList;
import entity.dock.DockBikeList;
public class View_BL {
    public ArrayList<Bike> dockBikesList;
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
    public void getListBike(DockBikeList dockBikeList) throws IOException
    {
        
        try {
            dockBikeList.setDockBikeList(dockBikesList);
        }catch(IOException exception){
            throw new CapstoneException(exception.getMessage());
        }
    }
}
