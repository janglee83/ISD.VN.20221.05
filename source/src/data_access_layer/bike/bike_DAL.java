package data_access_layer.bike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_access_layer.database.Database;
import entity.bike.Bike;
import entity.bike.StandardEBike;

public class Bike_DAL {

    public Bike getBikeByBikeId(int bike_id) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
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

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

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

            // get bike Attr
            switch (resultSet.getInt("bike_type_id")) {
                case StandardEBike.BIKE_TYPE_VALUE:
                    getEBikeAttribute((StandardEBike) bike);
                    break;

                default:
                    break;
            }
            bikeList.add(bike);
        }

        return bikeList;
    }

    public void getEBikeAttribute(StandardEBike eBike) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

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
    }

    public void updateBikeStatus(int bikeId, int isBeingUsed) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format("update bike set isBeingUsed = %d where id = %d", isBeingUsed ,bikeId);
        statement.execute(query);
    }

    public int convertBarcodeToBikeId(String barcode) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format("select bike_id from(rental_bike_code) where bar_code = '%s' ;", barcode);
        ResultSet result = statement.executeQuery(query);
        result.next();
        int bikeId = result.getInt("bike_id");

        return bikeId;
    }

}
