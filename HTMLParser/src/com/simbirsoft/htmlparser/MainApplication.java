package com.simbirsoft.htmlparser;

import java.net.MalformedURLException;
import java.net.URL;
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
			Handler logFileHandler = new FileHandler("HTMLParser.log");
			log.setLevel(Level.ALL);
			log.addHandler(logFileHandler);
			log.setUseParentHandlers(false);
			log.info("Starting HTMLParser...");

			URL url = StatisticsView.returnInputURL();

			Statistics model = new Statistics(url);
			StatisticsView view = new StatisticsView(model);
			StatisticsController controller = new StatisticsController(model, view);
			controller.updateView();

		} catch (MalformedURLException e) {
			log.log(Level.WARNING, "Wrong URL Exception: ", e);
			System.out.println("URL is not valid");
		} catch (Exception e) {
			log.log(Level.SEVERE, "Exception: ", e);
			System.out.println("Unexpected error. See the log file for details");
		}
	}
}