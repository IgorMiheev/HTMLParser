package com.simbirsoft.htmlparser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.simbirsoft.htmlparser.statistics.StatisticsController;

class StatisticsControllerTest {

	@Test
	void testGetWords() {

		assertTrue(Arrays.equals(new String[] { "test", "123" }, StatisticsController.getWords("test 123")));
	}

	@Test
	void testGetStatisticsByWords() {

		HashMap<String, Long> testEntry = new HashMap<String, Long>();
		testEntry.put("test", 2L);
		testEntry.put("123", 1L);

		assertTrue(StatisticsController.getStatisticsByWords(new String[] { "test", "123", "test" }).equals(testEntry));

//		fail("Not yet implemented");
	}

}
