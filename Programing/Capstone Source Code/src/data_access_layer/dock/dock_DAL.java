package data_access_layer.dock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import data_access_layer.database.Database;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import entity.dock.Dock;

public class Dock_DAL {
    public ArrayList<Dock> getListDock() throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from dock");
        ArrayList<Dock> docksList = new ArrayList<Dock>();

        while (resultSet.next()) {
            Dock dock = new Dock();
            dock.setDockId(resultSet.getInt("id"));
            dock.setDockName(resultSet.getString("name"));
            dock.setDockArea(resultSet.getInt("dockArea"));
            dock.setDockAddress(resultSet.getString("address"));
            dock.setDockImageUrl(resultSet.getString("dock_image_url"));

            docksList.add(dock);
        }

        return docksList;
    }

    public Dock getInfoDock(int bikeId) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format("select * from bike inner join dock on bike.dock_id = dock.id where bike.id = %d",
                bikeId);
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        Dock dock = new Dock();
        dock.setDockId(resultSet.getInt("id"));
        dock.setDockName(resultSet.getString("name"));
        dock.setDockArea(resultSet.getInt("dockArea"));
        dock.setDockAddress(resultSet.getString("address"));
        dock.setDockImageUrl(resultSet.getString("dock_image_url"));

        return dock;
    }

    public HashMap<String, Integer> getNumberOfEmptyDockPoint(Integer dockId, BikeType listBikeType)
            throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement
                .executeQuery("select * from dock inner join dock_empty_point on dock_empty_point.dock_id = dock.id");
        HashMap<String, Integer> numberOfEmptyDockEach = new HashMap<String, Integer>();

        while (resultSet.next()) {
            if (dockId == resultSet.getInt("dock.id")) {
                int emptyPoint = resultSet.getInt("dock_empty_point.empty_points");
                switch (resultSet.getInt("dock_empty_point.bike_type_id")) {
                    case StandardBike.BIKE_TYPE_VALUE:
                        numberOfEmptyDockEach.put(listBikeType.getNameBikeType(StandardBike.BIKE_TYPE_VALUE),
                                emptyPoint);
                        break;
                    case StandardEBike.BIKE_TYPE_VALUE:
                        numberOfEmptyDockEach.put(listBikeType.getNameBikeType(StandardEBike.BIKE_TYPE_VALUE),
                                emptyPoint);
                        break;
                    case TwinBike.BIKE_TYPE_VALUE:
                        numberOfEmptyDockEach.put(listBikeType.getNameBikeType(TwinBike.BIKE_TYPE_VALUE), emptyPoint);
                        break;
                }
            }

        }

        return numberOfEmptyDockEach;
    }

    public void updateReturnBikeDockAvailablePosition(Bike bike, int dockId) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format(
                "update dock_empty_point set empty_points = (select empty_points where dock_id = %d and bike_type_id = %d) - 1 where dock_id = %d and bike_type_id = %d",
                dockId, bike.getBikeType(), dockId, bike.getBikeType());
        statement.execute(query);

    }

    public void updateRentBikeDockPoint(int bikeId, int bikeType) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format(
                "update dock_empty_point set empty_points = (select empty_points where dock_id = %d and bike_type_id = %d) + 1 where dock_id = %d and bike_type_id = %d",
                getInfoDock(bikeId).getDockId(), bikeType, getInfoDock(bikeId).getDockId(), bikeType);
        statement.execute(query);

    }

    public void updateReturnBikeDockPoint(Bike bike, int dockId) throws SQLException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        String query = String.format(
                "update bike set dock_id = %d where id = %d",dockId, bike.getBikeId());
        statement.execute(query);

    }
}
