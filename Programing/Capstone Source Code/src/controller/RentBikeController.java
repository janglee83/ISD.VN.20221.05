package controller;

import business_layer.RentBike_BL;

public class RentBikeController extends BaseController {

	private RentBike_BL rentBike_BL = new RentBike_BL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return rentBike_BL.convertBarcodeToBikeId(barcode);
	}

	public int getDeposit(int bikeType) {
		return utlis.Helper.getDepositeAmount(bikeType);
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		rentBike_BL.updateAfterRentBike(bike);
	}

}
