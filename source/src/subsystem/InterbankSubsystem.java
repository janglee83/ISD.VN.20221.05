package subsystem;

import entity.card.Card;
import entity.transaction.Transaction;
import subsystem.interbank.InterbankSubsystemController;

public class InterbankSubsystem implements InterbankInterface {

    private InterbankSubsystemController interbankSubsystemController = new InterbankSubsystemController();

    @Override
    public Transaction refund(Card card, int refundValue, String transactionContent) {
        Transaction transaction = interbankSubsystemController.refund(card, refundValue, transactionContent);
        return transaction;
    }

    @Override
    public Transaction payDeposite(Card card, int payValue, String transactionContent) throws Exception {
        Transaction transaction = new Transaction();

        transaction.setAmount(payValue);
        transaction.setContent(transactionContent);
        transaction.setCard(card);
        interbankSubsystemController.payDeposite(transaction);
        return transaction;
    }

}
