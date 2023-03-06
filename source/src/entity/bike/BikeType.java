package entity.bike;

import java.sql.SQLException;
import java.util.HashMap;

import common.exception.CapstoneException;
import controller.ReturnBikeController;

public class BikeType {

    private final ReturnBikeController returnBikeController = new ReturnBikeController();

    private HashMap<Integer, String> listBikeType;

    public void setListBikeType(Integer value, String name) {
        listBikeType.put(value, name);
    }

    public void setListBikeType(HashMap<Integer, String> listBikeType) {
        this.listBikeType = listBikeType;
    }

    public String getNameBikeType(Integer bikeTypeValue) {
        return listBikeType.get(bikeTypeValue);
    }

    public void getEntityBikeType(BikeType bikeType) {
        try {
            returnBikeController.getListBikeType(bikeType);
        } catch (SQLException e) {
            throw new CapstoneException(e.getMessage());
        }
    }
}
