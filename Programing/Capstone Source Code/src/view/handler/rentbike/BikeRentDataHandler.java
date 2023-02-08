package view.handler.rentbike;

import java.io.IOException;

import entity.bike.BikeRentInfo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import utlis.Configs;
import view.BaseScreenHandler;
import view.handler.returnbike.ReturnBikeDockListHandler;

public class BikeRentDataHandler extends BaseScreenHandler {

    @FXML
    private Label timeLabel;

    @FXML
    private Button stopButton;

    private int hours;

    private int minutes;

    private int seconds;

    private Timeline timeline;

    @FXML
    private ImageView image;

    private static final String STOP = "Stop";

    private static final String RUN = "Run";

    private BikeRentInfo bikeRentInfo;

    public BikeRentDataHandler(String screenPath, Stage stage, BikeRentInfo bikeRentInfo) throws IOException {
        super(screenPath, stage);
        this.bikeRentInfo = bikeRentInfo;
        this.initialize();
    }

    private void initialize() {
        // set image
        Image imageLink = new Image(bikeRentInfo.getBike().getBikeImageUrl());
        image.setImage(imageLink);
        image.setPreserveRatio(false);

        this.stopWatchInitialize();
    }

    private void stopWatchInitialize() {
        // set up the time display
        start();

        // set up the control buttons
        stopButton.setOnAction(event -> {
            if (stopButton.getText().equals(RUN)) {
                resume();
                stopButton.setText(STOP);
            } else if (stopButton.getText().equals(STOP)) {
                pause();
                stopButton.setText(RUN);
            }
        });
    }

    @FXML
    public void handleReturnBike(MouseEvent event) throws IOException {
        // display Return bike screen
        ReturnBikeDockListHandler returnBikeChooseDockHandler = new ReturnBikeDockListHandler(
                Configs.RETURN_BIKE_DOCK_LIST_SCREEN_PATH, this.stage, bikeRentInfo);

        // configs
        returnBikeChooseDockHandler.setPreviousScreen(this);
        returnBikeChooseDockHandler.setHomeScreenHandler(homeScreenHandler);
        returnBikeChooseDockHandler.setScreenTitle("Return bike - Choose dock");
        returnBikeChooseDockHandler.show();
    }

    private void setTime() {
        // flip 60 seconds over to a minute
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        // flip 60 minutes over to an hour
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        // ensure that values < 10 are padded with a 0
        String hourString = hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours);
        String minuteString = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
        String secondString = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

        timeLabel.setText(hourString + " : " + minuteString + " : " + secondString);
    }

    private void start() {
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), e -> {
            seconds++;
            setTime();
            // init a bike rent info entity
            bikeRentInfo.setHours(hours);
            bikeRentInfo.setMinutes(minutes);
            bikeRentInfo.setSeconds(seconds);
        });

        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void pause() {
        timeline.pause();
    }

    public void resume() {
        timeline.play();
    }
}
