package com.simbirsoft.htmlparser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Controller {
	public static String getHTMLText(String UrlAdress) throws IOException {
		try {
			Document doc = Jsoup.connect(UrlAdress).get();
			String text = doc.text();
			return text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
}
