package com.simbirsoft.htmlparser.statistics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class SettingsTest {

	@Test
	void testLoad() throws FileNotFoundException, IOException {
		Settings settings = new Settings();
		ClassLoader loader = settings.getClass().getClassLoader();
		try (InputStream io = loader.getResourceAsStream("app.properties")) {
			settings.load(io);
		}
		String value = settings.getValue("logFileName");
		assertTrue(value.equals("/logs/HTMLParser.log"));
	}

}
