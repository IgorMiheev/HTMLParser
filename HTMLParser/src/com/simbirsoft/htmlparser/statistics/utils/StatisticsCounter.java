package com.simbirsoft.htmlparser.statistics.utils;

import java.util.HashMap;

public class StatisticsCounter {

	public static HashMap<String, Long> getStatisticsByWords(String[] words) {
		HashMap<String, Long> statistics = new HashMap<String, Long>();
		for (String word : words) {
			if (statistics.containsKey(word)) {
				statistics.replace(word, statistics.get(word) + 1);
			} else {
				statistics.put(word, 1L);
			}
		}
		return statistics;
	}

}
