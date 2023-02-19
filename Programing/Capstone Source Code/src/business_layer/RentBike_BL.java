package business_layer;
import java.sql.SQLException;
import data_access_layer.bike.Bike_DAL;
import entity.bike.Bike;

public class RentBike_BL {
	private Bike_DAL bike_DAL = new Bike_DAL();

	public int convertBarcodeToBikeId(String barcode) throws SQLException {
		return bike_DAL.convertBarcodeToBikeId(barcode);
	}

	public Bike getBikeByBikeId(int bikeId) throws SQLException{
		return  bike_DAL.getBikeByBikeId(bikeId);
	}

	public void updateAfterRentBike(Bike bike) throws SQLException {
		bike_DAL.updateAfterRentBike(bike);
	}

}
