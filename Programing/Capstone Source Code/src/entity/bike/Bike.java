package entity.bike;

public class Bike {

	private int bikeId;

	private int bikeType;

	private String rentalCode;

	private int bikeValue;

	private boolean isBeingUsed;

	private String licensePlate;

	private String brand;

	private String bikeImageUrl;

	public Bike() {

	}

	public Bike(int bikeId, int bikeType, String rentalCode, int bikeValue, boolean isBeingUsed,
			String licensePlate, String brand, String bikeImageUrl) {
		this.bikeId = bikeId;
		this.bikeType = bikeType;
		this.rentalCode = rentalCode;
		this.bikeValue = bikeValue;
		this.isBeingUsed = isBeingUsed;
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.bikeImageUrl = bikeImageUrl;
	}

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
