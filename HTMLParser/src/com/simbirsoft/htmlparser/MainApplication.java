package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.simbirsoft.htmlparser.statistics.Statistics;
import com.simbirsoft.htmlparser.statistics.StatisticsController;
import com.simbirsoft.htmlparser.statistics.StatisticsView;

public class MainApplication {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(MainApplication.class.getName());
		try {
			Handler fh = new FileHandler("HTMLParser.log");
			log.setLevel(Level.ALL);
			log.addHandler(fh);
			log.info("Starting HTMLParser...");
			String url = returnInputURL();
			Statistics model = retrieveStatisticsFromURL(url);
//			Statistics model = retrieveStatisticsFromURL("https://www.simbirsoft.com/");
			StatisticsView view = new StatisticsView();
			StatisticsController controller = new StatisticsController(model, view);
			controller.updateView();
		} catch (Exception e) {
			log.log(Level.SEVERE, "Exception: ", e);
		}
	}

	public static Statistics retrieveStatisticsFromURL(String URL) throws IOException {
		Statistics statistics = new Statistics();
		String htmlTextString = null;

		htmlTextString = StatisticsController.getHTMLText(URL);

		String[] htmlWords = StatisticsController.getWords(htmlTextString);
		statistics.setInstance(StatisticsController.getStatisticsByWords(htmlWords));

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