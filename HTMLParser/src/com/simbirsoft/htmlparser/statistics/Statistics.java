package com.simbirsoft.htmlparser.statistics;

import java.util.HashMap;

public class Statistics {

	HashMap<String, Long> statisticInstance = new HashMap<String, Long>();

	public HashMap<String, Long> getInstance() {
		return statisticInstance;
	}

	public void setInstance(HashMap<String, Long> instance) {
		this.statisticInstance = instance;
	}

}
