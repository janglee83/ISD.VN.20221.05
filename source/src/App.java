import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import utlis.Configs;
import view.handler.view.HomeScreenHandler;

public class App extends Application {

  @FXML
  ImageView logo;

  /**
   * @param primaryStage
   */
  @Override
  public void start(Stage primaryStage) {
    try {
      // initialize the screen
      VBox root = (VBox) FXMLLoader.load(getClass().getResource(Configs.LOADING_SCREEN_PATH));
      Scene scene = new Scene(root);

      primaryStage.setScene(scene);
      primaryStage.show();

      // Load splash screen with effect
      FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
      fadeIn.setFromValue(0);
      fadeIn.setToValue(1);
      fadeIn.setCycleCount(1);

      // Finish splash
      FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
      fadeOut.setFromValue(1);
      fadeOut.setToValue(0);
      fadeOut.setCycleCount(1);

      // After fade in, start fade out
      fadeIn.play();
      fadeIn.setOnFinished((event) -> {
        fadeOut.play();
      });

      // After fade out, load actual content
      fadeOut.setOnFinished((e) -> {
        try {
          HomeScreenHandler homeScreenHandler = new HomeScreenHandler(Configs.HOME_SCREEN_PATH, primaryStage);
          homeScreenHandler.setScreenTitle("Home Screen");
          homeScreenHandler.setHomeScreenHandler(homeScreenHandler);
          // homeScreenHandler.setImage();
          homeScreenHandler.show();
        } catch (IOException exception) {
          exception.printStackTrace();
        }
      });
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }
}
