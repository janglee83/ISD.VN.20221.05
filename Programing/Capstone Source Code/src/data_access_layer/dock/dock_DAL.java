package data_access_layer.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_access_layer.database.database;
import entity.dock.Dock;

public class dock_DAL {
    public ArrayList<Dock> getListDock() throws SQLException {
        Statement statement = database.getConnection().createStatement();
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
}
