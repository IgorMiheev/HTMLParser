package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		String url = returnInputURL();
//		Statistics model = retrieveStatisticsFromURL(url);
		Statistics model = retrieveStatisticsFromURL("https://www.simbirsoft.com/");
		StatisticsView view = new StatisticsView();
		StatisticsController controller = new StatisticsController(model, view);
		controller.updateView();
	}

	public static Statistics retrieveStatisticsFromURL(String URL) {
		Statistics statistics = new Statistics();
		try {
			String htmlTextString = StatisticsController.getHTMLText(URL);
			String[] htmlWords = StatisticsController.getWords(htmlTextString);
			statistics.setInstance(StatisticsController.getStatisticsByWords(htmlWords));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return statistics;
	}

	public static String returnInputURL() {
		System.out.print("Please enter URL:");
		Scanner in = new Scanner(System.in);
		String inputString = in.next();
		in.close();
		return inputString;
	}
}