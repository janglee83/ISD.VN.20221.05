package controller;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayNameGenerator.Standard;

import business_layer.View_BL;
import entity.bike.Bike;
import entity.bike.StandardEBike;

public class ViewController extends BaseController {

	private View_BL view_BL = new View_BL();
	public void getDockInfo() {

	}

	public void getBikeInfo() {

	}

	public void getDockInfoRequest() {

	}
	public StandardEBike getEBikeAttr(Bike bike) throws SQLException
	{
		return view_BL.getEBikeAttr(bike);
	}
}
