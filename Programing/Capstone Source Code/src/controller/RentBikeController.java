package controller;

import java.sql.SQLException;
import business_layer.RentBike_BL;
import entity.bike.Bike;
import entity.dock.Dock;
import data_access_layer.bike.Bike_DAL;
import data_access_layer.dock.Dock_DAL;

public class RentBikeController extends BaseController {

	private RentBike_BL rentBike_BL = new RentBike_BL();

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

	public int getDeposit(int bikeValue) {
		return utlis.Helper.getDepositeAmount(bikeValue);
	}

	public void updateAfterRentBike(int bikeId, int bikeType) throws SQLException {
		rentBike_BL.updateAfterRentBike(bikeId, bikeType);
	}

}
