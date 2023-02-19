package data_access_layer.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_access_layer.database.Database;
import entity.bike.Bike;
import entity.bike.StandardEBike;

public class Bike_DAL {
    
    public Bike getBikeByBikeId(int bike_id) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(bike) where id =  %d and isBeingUsed = 0", bike_id);
        ResultSet result = statement.executeQuery(query);

        result.next();
        Bike bike = utlis.Helper.createBike(result.getInt("bike_type_id"));
        bike.setBikeValue(result.getInt("bikeValue"));
        bike.setBikeImageUrl(result.getString("bike_image_url"));
        bike.setBikeType(result.getInt("bike_type_id"));
        bike.setBrand(result.getString("brand"));
        bike.setBikeId(result.getInt("id"));
        bike.setLicensePlate(result.getString("licence_plate"));
        return bike;
    }

    public ArrayList<Bike> getBikeListInDock(int dock_id) throws SQLException {
        ArrayList<Bike> bikeList = new ArrayList<Bike>();
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(bike) where dock_id = %d and isBeingUsed = 0", dock_id);
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Bike bike = utlis.Helper.createBike(resultSet.getInt("bike_type_id"));
            bike.setBikeValue(resultSet.getInt("bikeValue"));
            bike.setBikeImageUrl(resultSet.getString("bike_image_url"));
            bike.setBikeType(resultSet.getInt("bike_type_id"));
            bike.setBrand(resultSet.getString("brand"));
            bike.setBikeId(resultSet.getInt("id"));
            bike.setLicensePlate(resultSet.getString("licence_plate"));
            bikeList.add(bike);
        }
        return bikeList;
    }

    public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
        StandardEBike eBike = (StandardEBike) bike;
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select * from(standard_e_bike_attribute) where bike_id = %d", eBike.getBikeId());
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            switch (resultSet.getString("name")) {
                case "batery percent":
                    eBike.setBateryPercent(resultSet.getString("value"));
                    break;
                default:
                    break;
            }
        }

        return eBike;
    }

    public void updateAfterRentBike(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("update bike set isBeingUsed = 1 where id = %d", bike.getBikeId());
        statement.execute(query);
        String query1 = String.format(
                "update dock_empty_point set empty_points = (select empty_points where dock_id = %d and bike_type_id = %d) + 1 where dock_id = %d and bike_type_id = %d",
                getDockIdOfBike(bike), bike.getBikeType(), getDockIdOfBike(bike), bike.getBikeType());
        statement.execute(query1);
    }

    public void returnBikeUpdateBikeIsUsed(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("update bike set isBeingUsed = 0 where id = %d", bike.getBikeId());
        statement.execute(query);
    }

    private int getDockIdOfBike(Bike bike) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        String query = String.format("select dock_id from(bike) where id = %d", bike.getBikeId());
        ResultSet result = statement.executeQuery(query);
        result.next();
        return result.getInt("dock_id");
    }

    public int convertBarcodeToBikeId(String barcode) throws SQLException {
		Statement statement = Database.getConnection().createStatement();
		String query = String.format("select bike_id from(rental_bike_code) where bar_code = '%s' ;", barcode);
		ResultSet result = statement.executeQuery(query);
		result.next();
		return result.getInt("bike_id");
	}

}