package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.HashMap;

public class StatisticsView {
	public void printStatistics(HashMap<String, Long> statisticsInstance) throws IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Statistics by words:");
			System.out.println(statisticsInstance);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

}
