package com.simbirsoft.htmlparser.statistics.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WordSplitterTest {

	@Test
	void testGetWords() {
		assertTrue(Arrays.equals(new String[] { "te", "st", "123", "a", "b", "c", "d", "e", "f", "g", "h", "i" },
				WordsSplitter.getWords("te st!123;a.b,c?d:e[f]g(h)i")));
	}
}
