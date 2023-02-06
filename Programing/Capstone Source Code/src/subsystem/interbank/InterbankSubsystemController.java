package subsystem.interbank;

import java.util.HashMap;

import data_access_layer.transaction.Transaction_DAL;
import entity.card.Card;
import entity.transaction.Transaction;

public class InterbankSubsystemController {

	private InterbankBoundary interbankBoundary = new InterbankBoundary();

	private Transaction_DAL transaction_DAL = new Transaction_DAL();

	public Transaction refund(Card card, int refundValue, String transactionContent) {
		return null;
	}

	public void payDeposite(Transaction transaction) throws Exception {
		interbankBoundary.sendRequestHard(transaction.getCard());
		transaction_DAL.saveTransaction(transaction);
	}

	private Transaction handleResponse(String response) {
		return null;
	}

	private String generateRequestData(HashMap<String, Object> request) {
		return null;
	}

}
