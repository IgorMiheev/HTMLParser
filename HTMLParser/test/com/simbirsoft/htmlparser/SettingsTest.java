package com.simbirsoft.htmlparser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class SettingsTest {

	@Test
	void testLoad() throws FileNotFoundException, IOException {
		Settings settings = new Settings();
		settings.loadFromClassLoader("./resources/app.properties");
		String value = settings.getValue("testLogFileName");
		assertTrue(value.equals("/logs/HTMLParserTest.log"));
	}

}
