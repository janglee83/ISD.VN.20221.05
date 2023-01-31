package entity.dock;

import java.util.HashMap;
import java.util.List;

import entity.bike.Bike;

public class Dock {

	private int dockId;

	private String dockName;

	private String dockAddress;

	private int dockArea;

	private HashMap<String, Integer> numberOfEmptyDockPoint;

	private String dockImageUrl;

	// getter setter function
	public int getDockId() {
		return dockId;
	}

	public void setDockId(Integer dockId) {
		this.dockId = dockId;
	}

	public String getDockName() {
		return dockName;
	}

	public void setDockName(String dockName) {
		this.dockName = dockName;
	}

	public String getDockAddress() {
		return dockAddress;
	}

	public void setDockAddress(String dockAddress) {
		this.dockAddress = dockAddress;
	}

	public int getDockArea() {
		return dockArea;
	}

	public void setDockArea(Integer dockArea) {
		this.dockArea = dockArea;
	}

	public String getDockImageUrl() {
		return dockImageUrl;
	}

	public void setDockImageUrl(String dockImageUrl) {
		this.dockImageUrl = dockImageUrl;
	}

}
