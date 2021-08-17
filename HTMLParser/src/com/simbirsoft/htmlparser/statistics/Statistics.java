package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Statistics {

	HashMap<String, Long> statisticInstance = new HashMap<String, Long>();

	public Statistics(URL url) throws IOException {
		String htmlTextString = Statistics.getHTMLText(url);
		String[] htmlWords = Statistics.getWords(htmlTextString);
		setInstance(Statistics.getStatisticsByWords(htmlWords));
	}

	public HashMap<String, Long> getInstance() {
		return statisticInstance;
	}

	public void setInstance(HashMap<String, Long> instance) {
		this.statisticInstance = instance;
	}

	public static String getHTMLText(URL UrlAdress) throws IOException {
		Document doc = Jsoup.connect(UrlAdress.toString()).get();
		String text = doc.text();
		return text;

	}

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
