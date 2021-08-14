package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Controller {
	public static String getHTMLText(String UrlAdress) throws IOException {
		try {
			Document doc = Jsoup.connect(UrlAdress).get();
			String text = doc.text();
			return text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}

	public static String[] getWords(String inputString) {
		List<String> words = new ArrayList<String>();
		// char[] splitChars = { ' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(',
		// ')', '\n', '\r', '\t' };
		String splitString = new String(" |,|\\.|!|\\?|\"|;|:|[|]|\\(|\\)|\n|\r|\t");
		for (String word : inputString.split(splitString)) {
			if (word != "")
				words.add(word);
		}
		return (String[]) words.toArray(new String[0]);
	}

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
