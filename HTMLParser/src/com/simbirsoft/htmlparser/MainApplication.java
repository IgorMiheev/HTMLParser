package com.simbirsoft.htmlparser;

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
			String url = Statistics.returnInputURL();
			Statistics model = Statistics.retrieveStatisticsFromURL(url);
//			Statistics model = retrieveStatisticsFromURL("https://www.simbirsoft.com/");
			StatisticsView view = new StatisticsView();
			StatisticsController controller = new StatisticsController(model, view);
			controller.updateView();
		} catch (Exception e) {
			log.log(Level.SEVERE, "Exception: ", e);
		}
	}
}