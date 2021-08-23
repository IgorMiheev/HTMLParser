package com.simbirsoft.htmlparser;

import java.net.URL;
import java.util.logging.Level;

import com.simbirsoft.htmlparser.statistics.Statistics;
import com.simbirsoft.htmlparser.statistics.StatisticsController;
import com.simbirsoft.htmlparser.statistics.StatisticsView;
import com.simbirsoft.htmlparser.statistics.utils.ApplicationLog;

public class MainApplication {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException, ClassNotFoundException {

		Settings settings = new Settings();
		settings.loadFromClassLoader("./resources/app.properties");
		ApplicationLog applicationLog = new ApplicationLog(settings, MainApplication.class.getName());
		applicationLog.log.info("Starting HTMLParser...");

		try {
			URL url;
			if (args.length == 1) {
				url = new URL(args[0]);
			} else {
				System.err.println("Invalid args count. Allowed one arg: string URL");
				applicationLog.log.warning("Invalid args count");
				return;
			}

			Statistics model = new Statistics(url);
			StatisticsView view = new StatisticsView(model);
			StatisticsController controller = new StatisticsController(model, view);
			controller.updateView();
		} catch (

		Exception e) {
			applicationLog.log.log(Level.SEVERE, "Exception: ", e);
			System.out.println("Unexpected error. See the log file for details");
		}
	}
}