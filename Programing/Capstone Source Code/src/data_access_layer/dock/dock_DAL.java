package data_access_layer.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import data_access_layer.database.Database;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.dock.DockList;

public class Dock_DAL {
    public ArrayList<Dock> getListDock() throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from dock");
        ArrayList<Dock> docksList = new ArrayList<Dock>();

        while(resultSet.next()) {
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

    public HashMap<String, Integer> getNumberOfEmptyDockPoint(Integer dockId) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from dock inner join dock_empty_point on dock_empty_point.dock_id = dock.id");
        HashMap<String, Integer> numberOfEmptyDockEach = new HashMap<String, Integer>();

        while(resultSet.next()) {
            if (dockId == resultSet.getInt("dock.id")) {
                int emptyPoint = resultSet.getInt("dock_empty_point.empty_points");
                switch (resultSet.getInt("dock_empty_point.bike_type_id")) {
                    case Bike.STANDARD_BICYCLE_VALUE + 1:
                        numberOfEmptyDockEach.put(Bike.STANDARD_BICYCLE_STRING, emptyPoint);
                        break;
                    case Bike.STANDARD_E_BIKE_VALUE + 1:
                        numberOfEmptyDockEach.put(Bike.STANDARD_E_BIKE_STRING, emptyPoint);
                        break;
                    default:
                        numberOfEmptyDockEach.put(Bike.TWIN_BIKE_STRING, emptyPoint);
                        break;
                }
            }

        }

        return numberOfEmptyDockEach;
    }
}
