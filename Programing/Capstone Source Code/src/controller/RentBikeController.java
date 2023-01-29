package controller;

import entity.dock.Dock;
import entity.card.Card;
import Class.business_layer.RentBike_BL;
import Class.business_layer.PayDeposite_BL;
import Class.request_layer.RentBike_RL;

public class RentBikeController extends BaseController {
	private Dock currentDock;

	private PayDepositControler payDepositControler;

	private RentBikeInfoScreen rentBikeInfoScreen;

	private PaymentForm paymentForm;

	public Dock getCurrentDock() {
		return currentDock;
	}

	public void setCurrentDock() {
		this.currentDock = currentDock;
	}

	public void rentBike() {

	}

}
