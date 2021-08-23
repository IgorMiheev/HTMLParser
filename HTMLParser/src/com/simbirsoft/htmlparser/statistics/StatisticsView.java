package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

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

}
