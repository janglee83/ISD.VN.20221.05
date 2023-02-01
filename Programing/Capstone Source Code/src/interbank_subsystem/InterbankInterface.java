package interbank_subsystem;


import java.util.HashMap;

import entity.transaction.Transaction;

public interface InterbankInterface {

	public Transaction refund(HashMap<String, Object> paymentInfo, int refundValue, String transactionContent);

	public Transaction payDeposite(HashMap<String, Object> paymentInfo, int payValue, String transactionContent);

}
