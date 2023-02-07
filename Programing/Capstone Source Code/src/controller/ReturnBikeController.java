package controller;

import business_layer.ReturnBike_BL;
import entity.bike.BikeRentInfo;
import entity.dock.DockList;
import provide.strategy.PaymentMethod;
import provide.strategy.implement_strategy.PaymentAmountVer1Strategy;
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
}
