package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public static String[] getWords(String inputString) {
		List words = new ArrayList<String>();
		// char[] splitChars = { ' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(',
		// ')', '\n', '\r', '\t' };
		String splitString = new String(" |,|\\.|!|\\?|\"|;|:|[|]|\\(|\\)|\n|\r|\t");
		for (String word : inputString.split(splitString)) {
			words.add(word);
		}
		return (String[]) words.toArray(new String[0]);
	}
}
