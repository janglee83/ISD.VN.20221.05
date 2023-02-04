package entity.bike;

import java.util.HashMap;

import entity.dock.Dock;

public class Bike {

	private int bikeId;

	private int bikeType;

	private String rentalCode;

	private String bikeName;

	private int bikeValue;

	private HashMap<String, Object> bikeAttribute; // rèactorrrrrrrrrrrrrrrrrrrrrr

	private boolean isBeingUsed;

	private String licensePlate;

	private String brand;

	private String bikeImageUrl;

	// type bike rèactorrrrrrrrrrrrrrrrrrrrrrr
	public static final int STANDARD_BICYCLE_VALUE = 0;

	public static final int STANDARD_E_BIKE_VALUE = 1;

	public static final int TWIN_BIKE_VALUE = 2;

	public static final String STANDARD_BICYCLE_STRING = "standard bicycle";

	public static final String STANDARD_E_BIKE_STRING = "standard e bike";

	public static final String TWIN_BIKE_STRING = "twin bike";

	// getter setter operation
	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getBikeType() {
		return bikeType;
	}

	public void setBikeType(int bikeType) {
		this.bikeType = bikeType;
	}

	public String getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public int getBikeValue() {
		return bikeValue;
	}

	public void setBikeValue(int bikeValue) {
		this.bikeValue = bikeValue;
	}

	public Boolean getIsBeingUsed() {
		return isBeingUsed;
	}

	public void setIsBeingUsed(Boolean isBeingUsed) {
		this.isBeingUsed = isBeingUsed;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBikeImageUrl() {
		return bikeImageUrl;
	}

	public void setBikeImageUrl(String bikeImageUrl) {
		this.bikeImageUrl = bikeImageUrl;
	}



}
