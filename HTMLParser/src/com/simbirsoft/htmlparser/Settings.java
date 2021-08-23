package com.simbirsoft.htmlparser;

import java.io.InputStream;
import java.util.Properties;

public class Settings {
	private final Properties prs = new Properties();

	public void load(InputStream io) {
		try {
			this.prs.load(io);
		} catch (Exception e) {
			System.out.println("Load settings error");
			e.printStackTrace();
		}

	}

	public void loadFromClassLoader(String propertyClassName) {
		ClassLoader loader = Settings.class.getClassLoader();

		try (InputStream io = loader.getResourceAsStream(propertyClassName)) {
			this.prs.load(io);
		} catch (Exception e1) {
			System.out.println("Load settings error. Can't find " + propertyClassName);

		}
	}

	public String getValue(String key) {
		return this.prs.getProperty(key);
	}

	public Object getObj(String key) {
		return this.prs.get(key);

	}
}
