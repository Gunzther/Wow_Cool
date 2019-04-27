package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameController {
	
	public static Stage stage;
	public static boolean startStage = false; 
	public static int times;
	public static Player player;
	
	private int timeInSec;
	private String ans;
	private Random rand;
	
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

	public Button[] buttonArray = new Button[4];
	public List<Integer> list;
	
	@FXML
	public void initialize() {
//		buttonArray = {choice1, choice2, choice3, choice4};
		player = new Player();
		generateQuestion();
		startTimer();
//		back.setText();
		
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
		
		EventHandler<MouseEvent> event3 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == choice1.getClass()) {
					Button target = (Button) event.getTarget();
					String text = target.getText();
					player.playerAns();
					handleAnswer(text);
				}
			}
		};
		
		choice1.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice2.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice3.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice4.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
	}
	
	public void startTimer() {
		timeInSec = 60;
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  Platform.runLater(() -> {
					  time.setText(String.valueOf(timeInSec));
		            });
				  timeInSec--;
				  if(timeInSec == 0) {
					  myTimer.cancel();
					  showScore();
				  }
				  System.out.println(timeInSec);
			  }
			}, 1000, 1000);
	}
	
	public void handleBack() {
		if(TimesTableChoosingController.stage.isShowing()) TimesTableChoosingController.stage.close();
		HomeController.gameStage = true;
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
	
	public void handleAnswer(String text) {
		if(text.equals(this.ans)) {
			player.correctAns();
			score.setText(Integer.toString(player.getScore()));
		}
		generateQuestion();
	}
	
	public void generateQuestion() {
		list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
		rand = new Random();
		int question = list.get(rand.nextInt(list.size()));
		list.remove(question);
		
		front.setText(Integer.toString(times));
		back.setText(Integer.toString(question));
		
		ans = Integer.toString(times * question);
		
		int ansButton = ((int) Math.random()) * 4 + 1;
		
		for(int i = 0; i < 4; i++) {
			if(i == ansButton) {
				buttonArray[i].setText(ans);
			}
			else {
				int choice = list.get(rand.nextInt(list.size()));
				buttonArray[i].setText(Integer.toString(times * choice));
				list.remove(choice);
			}
		}
	}
	
	public void showScore() {
		System.out.println("Show score");
	}

}
