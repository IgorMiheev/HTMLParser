package main.java.com.simbirsoft.htmlparser.statistics.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.simbirsoft.htmlparser.Settings;

public class ApplicationLog {
	private final Level logLevel = Level.ALL;
	public Logger log;

	public ApplicationLog(Settings settings, String mainClassName) {
		Logger log = Logger.getLogger(mainClassName);
		this.log = log;
		log.setLevel(logLevel);

		String logFileName = settings.getValue("logFileName");
		log.info("log path is " + logFileName);
		try {
			if (!Files.exists(Paths.get(logFileName))) {
				Files.createDirectories(Paths.get(logFileName).getParent());
				Files.createFile(Paths.get(logFileName));
			}
			if (Files.isWritable(Paths.get(logFileName))) {
				log.addHandler(new FileHandler(logFileName));
				log.setUseParentHandlers(false);
			} else {
				System.out.println("The log file is not recorded. Check the access settings");
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "Exception: ", e);
			System.out.println("Unexpected error. See the log file for details");
		}
	}

}
