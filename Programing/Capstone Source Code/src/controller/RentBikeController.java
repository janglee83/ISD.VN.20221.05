package controller;

import java.sql.SQLException;

import business_layer.RentBike_BL;
import data_access_layer.bike.Bike_DAL;
import entity.bike.Bike;

public class RentBikeController extends BaseController {

	private RentBike_BL rentBike_BL = new RentBike_BL();
	private Bike_DAL bike_DAL = new Bike_DAL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return rentBike_BL.convertBarcodeToBikeId(barcode);
	}

	public Bike getBikeByBikeId(int bikeId) throws SQLException{
		return  bike_DAL.getBikeByBikeId(bikeId);
	}

	public int getDeposit(int bikeType) {
		return utlis.Helper.getDepositeAmount(bikeType);
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		rentBike_BL.updateAfterRentBike(bike);
	}

}
