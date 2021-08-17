package com.simbirsoft.htmlparser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class MainApplicationTest {

	@Test
	void testMain() {
		assertTrue(Files.isWritable(Paths.get(MainApplication.logFileName)));
	}

}
