package controller;

import java.sql.SQLException;

import business_layer.ReturnBike_BL;
import entity.bike.Bike;
import entity.dock.DockList;
import request_layer.ReturnBike_RL;

public class ReturnBikeController extends BaseController {

    private ReturnBike_RL returnBike_RL = new ReturnBike_RL();

    private ReturnBike_BL returnBike_BL = new ReturnBike_BL();

    public void validateName(String name) throws Exception {
        returnBike_RL.validateName(name);
    }

    public void getListDock(DockList dockList) {
        returnBike_BL.getListDock(dockList);
    }

    public void returnBikeUpdateDatabase(Bike bike) throws SQLException {
        returnBike_BL.returnBikeUpdateDatabase(bike);
    }
}
