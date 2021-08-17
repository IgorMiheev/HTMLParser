package com.simbirsoft.htmlparser;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.simbirsoft.htmlparser.statistics.Statistics;
import com.simbirsoft.htmlparser.statistics.StatisticsController;
import com.simbirsoft.htmlparser.statistics.StatisticsView;

public class MainApplication {
	public static String logFileName = "HTMLParser.log";

	public static void main(String[] args) {
		Logger log = Logger.getLogger(MainApplication.class.getName());
		log.setLevel(Level.ALL);

		try {
			if (Files.isWritable(Paths.get(logFileName))) {
				Handler logFileHandler = new FileHandler(logFileName);
				log.addHandler(logFileHandler);
				log.setUseParentHandlers(false);
				log.info("Starting HTMLParser...");
			} else {
				System.out.println("The log file is not recorded. Check the access settings");
			}

			URL url = StatisticsView.returnInputURL();

			Statistics model = new Statistics(url);
			StatisticsView view = new StatisticsView(model);
			StatisticsController controller = new StatisticsController(model, view);
			controller.updateView();
		} catch (Exception e) {
			log.log(Level.SEVERE, "Exception: ", e);
			System.out.println("Unexpected error. See the log file for details");
		}
	}
}