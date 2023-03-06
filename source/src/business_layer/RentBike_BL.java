package business_layer;

import java.sql.SQLException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;

public class RentBike_BL {

	private final Bike_DAL bike_DAL = new Bike_DAL();
	private final Dock_DAL dock_DAL = new Dock_DAL();

	public void updateAfterRentBike(int bikeId, int bikeType) throws SQLException {
		bike_DAL.updateBikeStatus(bikeId, utlis.Constants.IS_BEING_USED);
		dock_DAL.updateDockPoint(bikeId, bikeType, 1);
	}

}
