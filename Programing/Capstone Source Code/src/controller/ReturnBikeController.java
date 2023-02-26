package controller;

import java.sql.SQLException;

import business_layer.ReturnBike_BL;
import entity.bike.Bike;
import entity.bike.BikeType;
import entity.bike.StandardEBike;
import entity.dock.DockList;
import request_layer.ReturnBike_RL;

public class ReturnBikeController extends BaseController {

    // request layer = chua ham xu ly validate du lieu
    private ReturnBike_RL returnBike_RL = new ReturnBike_RL();

    // bl = chua ham xu ly
    private ReturnBike_BL returnBike_BL = new ReturnBike_BL();

    public void validateName(String name) throws Exception {
        returnBike_RL.validateName(name);
    }

    public void getListDock(DockList dockList) throws Exception {
        returnBike_BL.getListDock(dockList);
    }

    public void returnBikeUpdateDatabase(Bike bike, int returnedDockId) throws SQLException {
        returnBike_BL.returnBikeUpdateDatabase(bike, returnedDockId);
    }

    public void getListBikeType(BikeType listBikeType) throws SQLException {
        returnBike_BL.getListBikeType(listBikeType);
    }

    public StandardEBike getEBikeAttr(Bike bike) throws SQLException {
        return returnBike_BL.getEBikeAttr(bike);
    }
}
