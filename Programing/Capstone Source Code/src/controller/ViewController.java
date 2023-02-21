package controller;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayNameGenerator.Standard;

import business_layer.View_BL;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardEBike;
import entity.dock.Dock;
import entity.dock.DockBikeList;
import entity.dock.DockList
;
public class ViewController extends BaseController {

	private View_BL view_BL = new View_BL();
	public void getDockInfo() {

	}

	public void getBikeInfo() {

	}

	public void getDockInfoRequest() {

	}
	public void getListDock(DockList dockList) throws Exception
	{
		view_BL.getListDock(dockList);
	}
	public StandardEBike getEBikeAttr(Bike bike) throws SQLException
	{
		return view_BL.getEBikeAttr(bike);
	}
	public void getListBikeType(BikeType listBikeType) throws SQLException {
        view_BL.getListBikeType(listBikeType);
    }
	public void getListBike(DockBikeList bikeList ,Dock dock) throws Exception
	{
		view_BL.getListBike(bikeList, dock);
	}
}
