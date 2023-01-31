package view;

import controller.BaseController;

import java.io.IOException;
import java.util.Hashtable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.handler.HomeScreenHandler;

import java.util.Objects;

public class BaseScreenHandler extends FXMLScreenHandler {

	private BaseScreenHandler prevScreenHandler;

	private BaseController baseController;

	private Scene scene;

  	protected final Stage stage;

  	protected Hashtable<String, String> messages;

	protected HomeScreenHandler  homeScreenHandler;

	protected BaseScreenHandler(String screenPath) throws IOException {
		super(screenPath);
		this.stage = new Stage();
	}

	public BaseScreenHandler(String screenPath, Stage stage) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	/**
	 * @param prevScreenHandler
	 */
	public void setPreviousScreen(BaseScreenHandler prevScreenHandler) {
		this.prevScreenHandler = prevScreenHandler;
	}

	/**
	 *
	 * @return BaseScreenHandler
	 */
	public BaseScreenHandler getPreviousScreen() {
		return this.prevScreenHandler;
	}

	public void show() {
		if (Objects.isNull(this.scene))
			this.scene = new Scene(this.content);
		this.stage.setScene(this.scene);
	}

	public void setScreenTitle(String title) {
		this.stage.setTitle(title);
	}

	public void setBaseController(BaseController baseController) {
		this.baseController = baseController;
	}

	public BaseController getBaseController() {
		return this.baseController;
	}

	public void setHomeScreenHandler(HomeScreenHandler homeScreenHandler) {
		this.homeScreenHandler = homeScreenHandler;
	}

}
