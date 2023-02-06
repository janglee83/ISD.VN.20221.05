package subsystem.interbank;

import common.exception.CapstoneException;
import entity.card.Card;
import lib.TransactionLib;

public class InterbankBoundary {

	private TransactionLib transactionLib;

	public String sendRequest(String param) {
		String response = null;

		try {
			response = transactionLib.processTransaction(param);
		} catch (Exception e) {
			throw new CapstoneException("Unreconize");
		}
		return response;
	}

	public void sendRequestHard(Card card) throws Exception {
		if (!card.getCardHolderName().equals(Card.ownerTest)
			|| !card.getCardNumber().equals(Card.cardCodeTest)
			|| !card.getSecurityCode().equals(Card.ccvCodeTest)
			|| !card.getExpirationDate().equals(Card.dateExpiredTest))
			throw new Exception();
	}

}
