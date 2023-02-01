package entity.bike;

import java.util.HashMap;

import entity.dock.Dock;

public class Bike extends Dock {

	private int bikeType;

	private String rentalCode;

	private String bikeName;

	private int bikeValue;

	private HashMap<String, Object> bikeAttribute;

	private boolean isBeingUsed;

	private String licensePlate;

	private String brand;

	private String bikeImageUrl;

	// type bike
	public static final int STANDARD_BICYCLE_VALUE = 0;

	public static final int STANDARD_E_BIKE_VALUE = 1;

	public static final int TWIN_BIKE_VALUE = 2;

	public static final String STANDARD_BICYCLE_STRING = "standard bicycle";

	public static final String STANDARD_E_BIKE_STRING = "standard e bike";

	public static final String TWIN_BIKE_STRING = "twin bike";

	public void getBikeByBarCode() {

	}

	public void getBike() {

	}

	public void getAvailableBike() {

	}

}
