package com.simbirsoft.htmlparser.statistics;

import java.io.IOException;
import java.util.HashMap;

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
		view.printStatistics();
	}
}
