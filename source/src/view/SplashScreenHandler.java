package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SplashScreenHandler implements Initializable {

	@FXML
	ImageView logo;

	@FXML
	ImageView loading;

	public void initialize(URL location, ResourceBundle resource) {
		File fileLogoImage = new File("@image/eco-park.png");
		File fileLoadingImage = new File("@image/loading.jpg");
		Image imageLogo = new Image(fileLogoImage.toURI().toString());
		Image imageLoading = new Image(fileLoadingImage.toURI().toString());

		logo.setImage(imageLogo);
		loading.setImage(imageLoading);
	}

}
