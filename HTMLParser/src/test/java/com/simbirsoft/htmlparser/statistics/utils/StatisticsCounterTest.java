package test.java.com.simbirsoft.htmlparser.statistics.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import main.java.com.simbirsoft.htmlparser.statistics.utils.StatisticsCounter;

class StatisticsCounterTest {

	@Test
	void testGetStatisticsByWords() {

		HashMap<String, Long> testEntry = new HashMap<String, Long>();
		testEntry.put("test", 2L);
		testEntry.put("123", 1L);
		testEntry.put("12", 1L);

		assertTrue(
				StatisticsCounter.getStatisticsByWords(new String[] { "12", "test", "123", "test" }).equals(testEntry));
	}
	
	
	}
