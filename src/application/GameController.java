package application;

import java.io.FileNotFoundException;
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
	
	private Timer myTimer;
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
		buttonArray[0] = choice1;
        buttonArray[1] = choice2;
        buttonArray[2] = choice3;
        buttonArray[3] = choice4;
		player = new Player();
		generateQuestion();
		startTimer();
		
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
				Button target = (Button) event.getSource();
				String text = target.getText();
				player.playerAns();
				handleAnswer(text);
			}
		};
		
		choice1.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice2.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice3.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		choice4.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
	}
	
	public void startTimer() {
		timeInSec = 60;
		myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  Platform.runLater(() -> {
					  time.setText(String.valueOf(timeInSec));
		            });
				  timeInSec--;
				  if(timeInSec == 0) {
					  myTimer.cancel();
					  Platform.runLater(() -> {
						  try {
								showScore();
						  } catch (FileNotFoundException e) {
								e.printStackTrace();
						  }
			          	});
				  }
			  }
			}, 1000, 1000);
	}
	
	public void handleBack() {
		myTimer.cancel();
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
		list.remove(list.indexOf(question));
		
		front.setText(Integer.toString(times));
		back.setText(Integer.toString(question));
		
		ans = Integer.toString(times * question);
		int ansButton = (rand.nextInt(4));
		
		for(int i = 0; i < 4; i++) {
			if(i == ansButton) {
				buttonArray[i].setText(ans);
			}
			else {
				int choice = list.get(rand.nextInt(list.size()));
				buttonArray[i].setText(Integer.toString(times * choice));
				list.remove(list.indexOf(choice));
			}
		}
	}
	
	public void showScore() throws FileNotFoundException {
		if(TimesTableChoosingController.stage.isShowing()) TimesTableChoosingController.stage.close();
		else if(HomeController.boardStage && BoardController.stage.isShowing()) {
			BoardController.stage.close();
			HomeController.boardStage = false;
		}
		ScoreManager scoreManager = new ScoreManager();
		scoreManager.recordScore(GameController.times, player.getScore());
		stage = new Stage();
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("boardUI.fxml"));
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
