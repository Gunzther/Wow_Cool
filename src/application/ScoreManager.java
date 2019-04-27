package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreManager {
	
	@SuppressWarnings("resource")
	public List<String> readScore() throws FileNotFoundException {
		List<String> listScore = new ArrayList<>();
		String path = System.getProperty("user.dir");
		InputStream in = null;
		try {
			String filename = path + "/score.txt";
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			String filename = path + "/score.txt";
			OutputStream out = null;
			try {
				out = new FileOutputStream(filename, true);
			} catch (FileNotFoundException ex) {
				System.out.println("Couldn't open output file " + filename);
			}
			PrintStream printOut = new PrintStream(out);
			for(int i = 0; i < 11; i++) {
				printOut.printf("0\n");
			}
			in = new FileInputStream(filename);
		}
		Scanner readText = new Scanner(in);
		while (readText.hasNextLine()) {
			String score = readText.nextLine();
			listScore.add(score);
		}
		if (in != null)
			try {
				in.close();
			} catch (IOException ioe) {
		}
		
		return listScore;
	}

	
	@SuppressWarnings("resource")
	public void recordScore(int times, int newScore) throws FileNotFoundException {
		List<String> oldScoreList = readScore();
		String path = System.getProperty("user.dir");
		String outputfile = path + "score.txt";
		OutputStream out = null;
		try {
			out = new FileOutputStream(outputfile, true);
		} catch (FileNotFoundException ex) {
			System.out.println("Couldn't open output file " + outputfile);
			return;
		}
		
		int oldScore = Integer.parseInt(oldScoreList.get(times - 2));
		if(oldScore < newScore){
			oldScoreList.set(times - 2, Integer.toString(newScore));
		}
		
		try {
			// append = false
			FileWriter fw =new FileWriter(outputfile, false);
			for(String score : oldScoreList) {
				fw.write(score + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
