package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Statistics {

	HashMap<String, Long> statisticInstance = new HashMap<String, Long>();

	public HashMap<String, Long> getInstance() {
		return statisticInstance;
	}

	public void setInstance(HashMap<String, Long> instance) {
		this.statisticInstance = instance;
	}

	public static String returnInputURL() {
		System.out.print("Please enter URL:");
		Scanner in = new Scanner(System.in);
		String inputString = in.next();
		in.close();
		return inputString;
	}

	public static Statistics retrieveStatisticsFromURL(String URL) throws IOException {
		Statistics statistics = new Statistics();
		String htmlTextString = null;

		htmlTextString = Statistics.getHTMLText(URL);

		String[] htmlWords = Statistics.getWords(htmlTextString);
		statistics.setInstance(Statistics.getStatisticsByWords(htmlWords));

		return statistics;
	}

	public static String getHTMLText(String UrlAdress) throws IOException {

		Document doc = Jsoup.connect(UrlAdress).get();
		String text = doc.text();
		return text;

	}

	// splits a string into words
	public static String[] getWords(String inputString) {
		List<String> words = new ArrayList<String>();
		String splitString = new String(" |,|\\.|!|\\?|\"|;|:|[|]|\\(|\\)|\n|\r|\t");
		for (String word : inputString.split(splitString)) {
			if (!"".equals(word)) {
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
