package entity.dock;

import java.util.ArrayList;

import entity.bike.Bike;

// chua danh sach cac bike cua 1 dock
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
