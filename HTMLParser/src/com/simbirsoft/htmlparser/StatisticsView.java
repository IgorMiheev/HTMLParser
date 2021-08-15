package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class StatisticsView {
	public void printStatistics(HashMap<String, Long> statisticsInstance) throws IOException {
		try {
			System.out.println("Statistics by words:");
			List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(statisticsInstance.entrySet());
			list.sort(Entry.<String, Long>comparingByValue().reversed());
			for (Entry<String, Long> entry : list) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}
