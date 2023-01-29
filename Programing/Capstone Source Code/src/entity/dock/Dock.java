package entity.dock;

import java.text.StringCharacterIterator;

import entity.bike.Bike;

public class Dock {

	private int id;
	
	private String dockName;

	private String dockAddress;

	private int dockArea;

	private List<Bike> bikeList;

	private HashMap<String, Integer> numberOfEmptyDockPoint;

	private String dockImageUrl;

	private Bike[] bike;

	public Dock(int id, String dockName, int dockArea,String dockAddress, String dockImageUrl){
		this.id = id;
		this.dockName = dockName;
		this.dockArea = dockArea;
		this.dockAddress = dockAddress;
		this.dockImageUrl = dockImageUrl;
	}
	public void getListDock() {

	}

	public void getAvailableNumberPosition() {

	}

	public void updateAvailablePosition() {

	}

	public void updateEmpty() {

	}

	public void getBike() {

	}

	public void getDock() {

	}

}
