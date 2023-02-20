package business_layer;

import java.sql.SQLException;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;
import entity.bike.Bike;
import entity.bike.StandardEBike;
import entity.dock.Dock;

public class RentBike_BL {

	private final Bike_DAL bike_DAL = new Bike_DAL();
	private final Dock_DAL dock_DAL = new Dock_DAL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return bike_DAL.convertBarcodeToBikeId(barcode);
	}

	public Bike getBikeByBikeId(int bikeId) throws SQLException {
		return bike_DAL.getBikeByBikeId(bikeId);
	}

	public Dock getDockInfo(int bikeId) throws SQLException {
		return dock_DAL.getInfoDock(bikeId);
	}

	public int deposit(Bike bike) {
		return utlis.Helper.getDepositeAmount(bike.getBikeType());
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		bike_DAL.updateAfterRentBike(bike);
	}

	public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
		return bike_DAL.getEBikeAttr(bike);
	}

}
