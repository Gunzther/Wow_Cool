package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		playAudio();
		try {
			stage = primaryStage;
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("homeUI.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Wow cool!!");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
}
