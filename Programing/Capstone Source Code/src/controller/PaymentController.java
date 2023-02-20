package controller;

import business_layer.PayDeposite_BL;
import entity.bike.BikeRentInfo;
import entity.card.Card;
import entity.transaction.Transaction;
import request_layer.Card_RL;
import subsystem.InterbankSubsystem;

public class PaymentController extends BaseController {

    private Card_RL card_RL = new Card_RL();

    private PayDeposite_BL payDeposite_BL = new PayDeposite_BL();

    private final InterbankSubsystem interbankSubsystem = new InterbankSubsystem();

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
        Transaction transaction = interbankSubsystem.payDeposite(card, payValue, transactionContent);
        return transaction;
    }

    public int caculateAmount(BikeRentInfo bikeRentInfo) {
        int amount = payDeposite_BL.caculateAmount(bikeRentInfo);
        return amount;
    }
}
