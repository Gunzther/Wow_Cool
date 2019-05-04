package application;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.fxml.*;

public class HomeController implements StageBuilder{
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
		destroy();
		stage = new Stage();
		build(stage, "TimesTableChoosingUI.fxml");
	}
	
	public void handleQuit() {
		System.exit(0);
	}

	@Override
	public void destroy() {
		if(Main.stage.isShowing()) Main.stage.close();
		else if(timesTableIsShower()) TimesTableChoosingController.stage.close();
		else if(gameIsShower()) GameController.stage.close();
		else if(boardIsShower()) BoardController.stage.close();
	}
	
}
