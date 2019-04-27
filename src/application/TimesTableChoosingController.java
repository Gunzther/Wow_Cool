package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.*;

public class TimesTableChoosingController {
	public static Stage stage;
	public List<String> scoreList;
	
	@FXML
	Button times2;
	@FXML
	Button times3;
	@FXML
	Button times4;
	@FXML
	Button times5;
	@FXML
	Button times6;
	@FXML
	Button times7;
	@FXML
	Button times8;
	@FXML
	Button times9;
	@FXML
	Button times10;
	@FXML
	Button times11;
	@FXML
	Button times12;
	@FXML
	Button back;
	@FXML
	Label highscore;
	
	@FXML
	public void initialize() {
		scoreList = new ArrayList<>();
		ScoreManager scoreManager = new ScoreManager();
		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == times2.getClass()) {
					try {
						scoreList = scoreManager.readScore();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					Button target = (Button) event.getTarget();
					String text = target.getText();
					target.setText("          " + text);
					highscore.setText(scoreList.get(Integer.parseInt(text) - 2));
				}
			}
		};
		
		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == times2.getClass()) {
					Button target = (Button) event.getTarget();
					String text = target.getText();
					target.setText(text.trim());
					highscore.setText("??");
				}
			}
		};
		
		EventHandler<MouseEvent> event3 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == times2.getClass()) {
					Button target = (Button) event.getTarget();
					try {
						wait(3500);
					}catch(Exception x) {}
					String text = target.getText();
					GameController.times = Integer.parseInt(text.trim());
				}
			}
		};
		
		times2.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times2.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times2.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times3.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times3.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times3.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times4.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times4.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times4.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times5.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times5.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times5.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times6.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times6.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times6.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times7.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times7.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times7.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times8.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times8.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times8.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times9.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times9.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times9.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times10.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times10.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times10.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times11.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times11.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times11.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times12.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times12.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times12.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
	}
	
	public void handleBack() {
		if(HomeController.stage.isShowing()) HomeController.stage.close();
		HomeController.timesTableChoosingStage = true;
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
	
	public void handlePlay() {
		if(HomeController.stage.isShowing()) HomeController.stage.close();
		HomeController.gameStage = true;
		stage = new Stage();
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("GameUI.fxml"));
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
