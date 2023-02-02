package business_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_access_layer.database.Database;

public class RentBike_BL {

	public int convertToRentalCode(String barcode) throws SQLException {
		Statement statement = Database.getConnection().createStatement();
		String query = String.format("select bike_id from(rental_bike_code) where bar_code = '%s' ;", barcode);
		ResultSet result = statement.executeQuery(query);
		result.next();
		return result.getInt("bike_id");
	}
}
