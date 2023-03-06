package controller;

import java.sql.SQLException;

import business_layer.View_BL;
import data_access_layer.bike.Bike_DAL;
import entity.bike.BikeType;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import entity.dock.DockList;

public class ViewController extends BaseController {

	private View_BL view_BL = new View_BL();

	public void getListDock(DockList dockList) throws Exception {
		view_BL.getListDock(dockList);
	}

	public void getListBikeType(BikeType listBikeType) throws SQLException {
		view_BL.getListBikeType(listBikeType);
	}

	public void getListBike(DockBikeList bikeList, Dock dock) throws Exception {
		view_BL.getListBike(bikeList, dock);
	}
}
