package entity.dock;

import java.util.ArrayList;

import entity.bike.Bike;

public class DockBikeList {

    private ArrayList<Bike> dockBikeList;

    public void setDockBikeList(ArrayList<Bike> dockBikeList) {
        this.dockBikeList = dockBikeList;
    }
    public ArrayList<Bike> getBikesList()
    {
        return dockBikeList;
    }
}
