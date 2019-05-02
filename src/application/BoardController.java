package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
		
		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == welcomeHome) {
					welcomeHome.setText("N O O O ! !");
					welcomeHome.setStyle("-fx-text-fill: #ff0000; -fx-background-color: #000000");
				}
				else if(event.getTarget() == playAgain) {
					playAgain.setText("Go Go!!");
				}
			}
		};
		
		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == welcomeHome) {
					welcomeHome.setText("Back to Home");
					welcomeHome.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #000000");
				}
				else if(event.getTarget() == playAgain) {
					playAgain.setText("Play Again");
				}
			}
		};
		
		welcomeHome.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		welcomeHome.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		
		playAgain.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		playAgain.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
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
