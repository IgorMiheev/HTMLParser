package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.simbirsoft.htmlparser.statistics.Settings;
import com.simbirsoft.htmlparser.statistics.Statistics;
import com.simbirsoft.htmlparser.statistics.StatisticsController;
import com.simbirsoft.htmlparser.statistics.StatisticsView;

public class MainApplication {

	public static String logFileName = "HTMLParser.logsss";

	public static void main(String[] args) {
		Logger log = Logger.getLogger(MainApplication.class.getName());
		log.setLevel(Level.ALL);
		Settings settings = new Settings();
		ClassLoader loader = settings.getClass().getClassLoader();
		try (InputStream io = loader.getResourceAsStream("app.properties")) {
			settings.load(io);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (!Files.exists(Paths.get(logFileName))) {
				Files.createFile(Paths.get(logFileName));
			}
			if (Files.isWritable(Paths.get(logFileName))) {
				Handler logFileHandler = new FileHandler(logFileName);
				log.addHandler(logFileHandler);
				log.setUseParentHandlers(false);
				log.info("Starting HTMLParser...");
			} else {
				System.out.println("The log file is not recorded. Check the access settings");
			}

			URL url;
			if (args.length == 0) {
				url = StatisticsView.returnInputURL();
			} else {
				if (args.length == 1) {
					url = new URL(args[0]);
				} else {
					System.out.println("Only one parameter(URL) is allowed");
					return;
				}
			}

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