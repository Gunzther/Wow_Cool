package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javafx.event.EventHandler;
import javafx.fxml.*;

public class HomeController {
	public static Stage stage;
	public static boolean timesTableChoosingStage = false; 
	public static boolean gameStage = false;
	public static boolean boardStage = false;
	
	@FXML
	Button start;
	@FXML
	Button quit;
	
	@FXML
	public void initialize() {
		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == start) {
					start.setText("C L I C K   M E !");
				}
				else if(event.getTarget() == quit) {
					quit.setText("N O O O O O O O O O ! !");
					quit.setStyle("-fx-text-fill: #ff0000; -fx-background-color: #000000");
				}
			}
		};
		
		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == start) {
					start.setText("S T A R T   G A M E");
				}
				else if(event.getTarget() == quit) {
					quit.setText("Q U I T");
					quit.setStyle("-fx-text-fill: #ababab; -fx-background-color: #000000");
				}
			}
		};
		
		start.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		start.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		quit.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		quit.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
	}
	
	/** Go to mode selection */
	public void handleStart() {
		if(Main.stage.isShowing()) Main.stage.close();
		else if(timesTableChoosingStage && TimesTableChoosingController.stage.isShowing()) {
			TimesTableChoosingController.stage.close();
			timesTableChoosingStage = false;
		}
		else if(gameStage && GameController.stage.isShowing()) {
			GameController.stage.close();
			gameStage = false;
		}
		else if(boardStage && BoardController.stage.isShowing()) {
			BoardController.stage.close();
			boardStage = false;
		}
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
	
	public void handleQuit() {
		System.exit(0);
	}
	
}
