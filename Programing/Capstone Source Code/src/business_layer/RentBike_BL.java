package business_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.bike.Bike_DAL;
import data_access_layer.database.Database;
import entity.bike.Bike;

public class RentBike_BL {
	private Bike_DAL bike_DAL = new Bike_DAL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return bike_DAL.convertBarcodeToBikeId(barcode);
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		bike_DAL.updateAfterRentBike(bike);
	}

}
