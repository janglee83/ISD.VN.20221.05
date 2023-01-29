package Class.data_access_layer.dock;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data_access_layer.database.database;
import entity.dock.DockList;

public class dock_DAL {
   public DockList getAllDocks() throws SQLException{
    if(dockList == null){
        dockList = new DockList;
        Statement stm = database.getConnection().createStatement();
        String query = "select * from dock order by (id) asc;";
        ResultSet = stm.executeQuery(query);
        while (res.next()){
            dockList.add(newDock(res.getInt("id"),
                                res.getString("name"),
                                res.getInt("dockArea"),
                                res.getString("address"),
                                res.getString("dock_image_url"),);
        }
    }
    return dockList;
   }
}
