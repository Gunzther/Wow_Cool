package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BoardController {
	public static Stage stage;
	public static boolean boardStage = false; 
	
	@FXML
	Label scoreLb;
	@FXML
	Label frequency;
	@FXML
	Label correct;
	@FXML
	Label wrong;
	@FXML
	Button welcomeHome;
	@FXML
	Button playAgain;
	
	public void initialize() {
		stage = new Stage();
		Player player = GameController.player;
		scoreLb.setText(Integer.toString(player.getScore()) + "/" + Integer.toString(player.getTotal()));
		correct.setText(Integer.toString(player.getCorrectAns()));
		wrong.setText(Integer.toString(player.getWrongAns()));
		frequency.setText(player.getFrequent());
	}
	
	public void handleBack() {
		if(GameController.stage.isShowing()) GameController.stage.close();
		HomeController.boardStage = true;
		stage = new Stage();
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("HomeUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Wow cool!!");
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					System.exit(0);
				}
			});
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handlePlayAgain() {
		if(GameController.stage.isShowing()) GameController.stage.close();
		HomeController.boardStage = true;
		stage = new Stage();
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("TimesTableChoosingUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Wow cool!!");
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					System.exit(0);
				}
			});
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
