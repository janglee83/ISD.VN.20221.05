package business_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.database.Database;
import entity.dock.Dock;

public class RentBike_BL {

	public int convertToRentalCode(String barcode) throws SQLException{
		Statement statement = Database.getConnection().createStatement();
		String query = String.format("select bike_id"+"from(rental_bike_code)"+ "where barcode =" + barcode +";");
		ResultSet result = statement.executeQuery(query);
		int Barcode = result.getInt("bar_code");
		return Barcode;
	}
}
