package entity.dock;

import java.util.ArrayList;

// danh sach cas dock trong he thong
public class DockList {
    private ArrayList<Dock> docksList;

    public void setDocksList(ArrayList<Dock> docksList) {
        this.docksList = docksList;
    }

    public ArrayList<Dock> getDocksList() {
        return docksList;
    }
}
