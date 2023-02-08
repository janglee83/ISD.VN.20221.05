package entity.card;

public class Card {

	private String cardHolderName;

	private String cardNumber;

	private String securityCode;

	private String expirationDate;

	// for test purpose

	public static final String ownerTest = "Group5";

	public static final String cardCodeTest = "123456";

	public static final String ccvCodeTest = "101";

	public static final String dateExpiredTest = "1125";


	

	// construtor
	public Card(String cardHolderName, String cardNumber, String securityCode, String expirationDate) {
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}

	// getter setter method
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
}
