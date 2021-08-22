package com.simbirsoft.htmlparser.statistics.utils;

import java.util.ArrayList;
import java.util.List;

public class WordsSplitter {

	// splits a string into words
	public static String[] getWords(String inputString) {
		List<String> words = new ArrayList<String>();
		String splitString = new String(" |,|\\.|!|\\?|\"|;|:|\\[|\\]|\\(|\\)|\n|\r|\t");
		for (String word : inputString.split(splitString)) {
			if ((!"".equals(word)) && word != null) {
				words.add(word);
			}
		}
		return (String[]) words.toArray(new String[0]);
	}

}
