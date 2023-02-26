package controller;

import java.sql.SQLException;
import business_layer.RentBike_BL;
import entity.bike.Bike;
import entity.bike.StandardEBike;
import entity.dock.Dock;

public class RentBikeController extends BaseController {

	private RentBike_BL rentBike_BL = new RentBike_BL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return rentBike_BL.convertBarcodeToBikeId(barcode);
	}

	public Bike getBikeByBikeId(int bikeId) throws SQLException {
		return rentBike_BL.getBikeByBikeId(bikeId);
	}

	public Dock getDockInfo(int bikeId) throws SQLException {
		return rentBike_BL.getDockInfo(bikeId);
	}

	public int getDeposit(int bikeType) {
		return utlis.Helper.getDepositeAmount(bikeType);
	}

	public void updateAfterRentBike(int bikeId, int bikeType) throws SQLException {
		rentBike_BL.updateAfterRentBike(bikeId, bikeType);
	}

	public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
		return rentBike_BL.getEBikeAttr(bike);
	}
}
