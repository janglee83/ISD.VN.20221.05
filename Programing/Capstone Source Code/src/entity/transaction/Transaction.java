package entity.transaction;

import entity.card.Card;

public class Transaction {

	private int transactionId;

	private Card card;

	private int amount;

	private String content;

	private String time;

	public static final String RENT = "Thuê xe";

	public static final String RETURN = "Thanh toán";

	// getter setter
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
