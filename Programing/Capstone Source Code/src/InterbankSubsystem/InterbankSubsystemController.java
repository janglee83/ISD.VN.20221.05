package InterbankSubsystem;

import java.util.HashMap;

import entity.transaction.Transaction;

public class InterbankSubsystemController implements InterbankInterface {

	private InterbankSubsystem.String API_PATH;

	private InterbankSubsystem.InterbankBoundary interbankBoundary;

	public Transaction refund(HashMap<String, Object> paymentInfo, int refundValue, String transactionContent) {
		return null;
	}

	public Transaction payDeposite(HashMap<String, Object> paymentInfo, int payValue, String transactionContent) {
		return null;
	}

	private Transaction handleResponse(MyMap response) {
		return null;
	}

	private String generateRequestData(HashMap<String, Object> request) {
		return null;
	}

}
