package subsystem;

import entity.card.Card;
import entity.transaction.Transaction;

public interface InterbankInterface {

	public Transaction refund(Card card, int refundValue, String transactionContent);

	public Transaction payDeposite(Card card, int payValue, String transactionContent) throws Exception;

}
