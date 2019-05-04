package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface StageBuilder {
	
	public default void build(Stage stage, String resource) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource(resource));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Wow cool!!");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public default boolean homeIsShower() {
		if(HomeController.stage.isShowing()) {
			return true;
		}
		return false;
	}
	
	public default boolean timesTableIsShower() {
		if(HomeController.timesTableChoosingStage && TimesTableChoosingController.stage.isShowing()) {
			HomeController.timesTableChoosingStage = false;
			return true;
		}
		return false;
	}
	
	public default boolean gameIsShower() {
		if(HomeController.gameStage && GameController.stage.isShowing()) {
			HomeController.gameStage = false;
			return true;
		}
		return false;
	}
	
	public default boolean boardIsShower() {
		if(HomeController.boardStage && BoardController.stage.isShowing()) {
			HomeController.boardStage = false;
			return true;
		}
		return false;
	}
	
	public abstract void destroy();

}
