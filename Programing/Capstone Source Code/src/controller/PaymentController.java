package controller;

import entity.card.Card;
import entity.transaction.Transaction;
import request_layer.Card_RL;
import subsystem.InterbankInterface;

public class PaymentController extends BaseController {

    private Card_RL card_RL = new Card_RL();

    private InterbankInterface interbankInterface;

	public void validateCardData(Card card) throws Exception {
		card_RL.validateString(card.getCardHolderName());
		card_RL.validateStringNumber(card.getExpirationDate());
		card_RL.validateStringNumber(card.getCardNumber());
		card_RL.validateStringNumber(card.getSecurityCode());
	}

    public void validateString(String string) throws Exception {
        card_RL.validateString(string);
    }

    public void validateStringNumber(String stringNumber) throws Exception {
        card_RL.validateStringNumber(stringNumber);
    }

    public Transaction payDeposite(Card card, int payValue, String transactionContent) throws Exception {
        Transaction transaction = interbankInterface.payDeposite(card, payValue, transactionContent);
        return transaction;
    }


}
