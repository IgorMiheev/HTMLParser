package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class StatisticsView {
	private Statistics model;

	public StatisticsView(Statistics model) {
		this.model = model;
	}

	public void printStatistics() throws IOException {
		System.out.println("Statistics by words:");

		List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(model.getInstance().entrySet());
		list.sort(Entry.<String, Long>comparingByValue().reversed());

		for (Entry<String, Long> entry : list) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	public static URL returnInputURL() throws MalformedURLException {
		System.out.print("Enter URL to get statistics: ");
		Scanner in = new Scanner(System.in);
		String inputString = in.next();
		in.close();
		URL url = new URL(inputString);
		return url;
	}
}
