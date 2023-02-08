package business_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.bike.Bike_DAL;
import data_access_layer.database.Database;
import entity.bike.Bike;

public class RentBike_BL {
	private static Bike_DAL bike_DAL = new Bike_DAL();

	public int convertToRentalCode(String barcode) throws SQLException {
		Statement statement = Database.getConnection().createStatement();
		String query = String.format("select bike_id from(rental_bike_code) where bar_code = '%s' ;", barcode);
		ResultSet result = statement.executeQuery(query);
		result.next();
		return result.getInt("bike_id");
	}

	public int deposit(Bike bike) {
		return utlis.Helper.getDepositeAmount(bike.getBikeType());
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		bike_DAL.updateRentBike(bike);
	}

}
