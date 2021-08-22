package com.simbirsoft.htmlparser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.simbirsoft.htmlparser.statistics.utils.StatisticsCounter;
import com.simbirsoft.htmlparser.statistics.utils.WordsSplitter;

class StatisticsTest {

	@Test
	void testGetWords() {
		assertTrue(Arrays.equals(new String[] { "te", "st", "123", "a", "b", "c", "d", "e", "f", "g", "h", "i" },
				WordsSplitter.getWords("te st!123;a.b,c?d:e[f]g(h)i")));
	}

	@Test
	void testGetStatisticsByWords() {

		HashMap<String, Long> testEntry = new HashMap<String, Long>();
		testEntry.put("test", 2L);
		testEntry.put("123", 1L);
		testEntry.put("12", 1L);

		assertTrue(StatisticsCounter.getStatisticsByWords(new String[] { "12", "test", "123", "test" }).equals(testEntry));
	}

}
