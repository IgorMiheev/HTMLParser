package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.simbirsoft.htmlparser.statistics.utils.StatisticsCounter;
import com.simbirsoft.htmlparser.statistics.utils.WordsSplitter;

public class Statistics {

	HashMap<String, Long> statisticInstance = new HashMap<String, Long>();

	public Statistics(URL url) throws IOException {
		String htmlTextString = Statistics.getHTMLText(url);
		String[] htmlWords = WordsSplitter.getWords(htmlTextString);
		setInstance(StatisticsCounter.getStatisticsByWords(htmlWords));
	}

	public HashMap<String, Long> getInstance() {
		return statisticInstance;
	}

	public void setInstance(HashMap<String, Long> instance) {
		this.statisticInstance = instance;
	}

	public static String getHTMLText(URL UrlAdress) throws IOException {
		Document doc = Jsoup.connect(UrlAdress.toString()).get();
		return doc.body().text();

	}

}
