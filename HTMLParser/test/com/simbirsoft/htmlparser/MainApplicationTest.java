package com.simbirsoft.htmlparser;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class MainApplicationTest {

	@Test
	void testMain() {
		if (Files.exists(Paths.get(MainApplication.logFileName))) {
			assertTrue(Files.isWritable(Paths.get(MainApplication.logFileName)));
		} else {
			try {
				Files.createFile(Paths.get(MainApplication.logFileName));
			} catch (IOException e) {
				fail("Can't create log file");
			}
			assertTrue(Files.isWritable(Paths.get(MainApplication.logFileName)));
		}
	}

}
