package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application implements StageBuilder{
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		playAudio();
		stage = primaryStage;
		build(stage, "homeUI.fxml");
	}
	
	private void playAudio() {
		URL resource = getClass().getResource("../song/nightFever.mp3");
		MediaPlayer a =new MediaPlayer(new Media(resource.toString()));
		a.setOnEndOfMedia(new Runnable() {
	       public void run() {
	         a.seek(Duration.ZERO);
	       }
		});
		a.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void destroy() {
		if(stage.isShowing()) stage.close();
	}
}
