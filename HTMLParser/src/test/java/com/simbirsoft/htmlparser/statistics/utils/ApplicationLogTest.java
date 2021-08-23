package test.java.com.simbirsoft.htmlparser.statistics.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import main.java.com.simbirsoft.htmlparser.Settings;

class ApplicationLogTest {

	@Test
	void TestApplicationLog() {
		Settings settings = new Settings();
		settings.loadFromClassLoader("./resources/app.properties");
		String logFileName = settings.getValue("logFileName");

		if (Files.exists(Paths.get(logFileName))) {
			assertTrue(Files.isWritable(Paths.get(logFileName)));
		} else {
			try {
				Files.createDirectories(Paths.get(logFileName).getParent());
				Files.createFile(Paths.get(logFileName));
				// Files.
			} catch (IOException e) {
				fail("Can't create log file");
			}
			assertTrue(Files.isWritable(Paths.get(logFileName)));
		}
	}

}
