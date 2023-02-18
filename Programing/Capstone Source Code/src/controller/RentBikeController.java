package controller;

import java.sql.SQLException;

import business_layer.RentBike_BL;
import entity.bike.Bike;

public class RentBikeController extends BaseController {

	private RentBike_BL rentBike_BL = new RentBike_BL();

	public void rentBike() {

	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		rentBike_BL.updateAfterRentBike(bike);
	}

}
