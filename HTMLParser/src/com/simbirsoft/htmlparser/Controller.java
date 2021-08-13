package com.simbirsoft.htmlparser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Controller {
	public static String Parse(String UrlAdress) throws IOException {
		try {
			Document doc = Jsoup.connect(UrlAdress).get();
			Element words = doc.body();
			String text = doc.text();
			return text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
}
