package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StatisticsController {
	private Statistics model;
	private StatisticsView view;

	public StatisticsController(Statistics model, StatisticsView view) {
		this.model = model;
		this.view = view;
	}

	public HashMap<String, Long> getStatisticsInstance() {
		return model.getInstance();
	}

	public void setModel(HashMap<String, Long> instance) {
		model.setInstance(instance);
	}

	public void updateView() throws IOException {
		view.printStatistics(model.getInstance());
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
