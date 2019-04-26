package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class GameController {
	
	public static int times;
	
	@FXML
	Button choice1;
	@FXML
	Button choice2;
	@FXML
	Button choice3;
	@FXML
	Button choice4;
	@FXML
	Button welcomeHome;
	@FXML
	Label time;
	@FXML
	Label score;
	@FXML
	Label front;
	@FXML
	Label back;
	
	@FXML
	public void initialize() {
		front.setText(Integer.toString(times));
		
//		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				if(event.getTarget() == start) {
//					start.setText("CLICK!");
//				}
//			}
//		};
//		
//		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				if(event.getTarget() == start) {
//					start.setText("START");
//				}
//			}
//		};
		
	}

}
