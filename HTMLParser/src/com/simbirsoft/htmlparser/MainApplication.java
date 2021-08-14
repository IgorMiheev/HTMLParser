package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		try {
			System.out.print("Please enter URL:");
			Scanner in = new Scanner(System.in);
			String inputString = in.next();
			in.close();

			System.out.println("Your URL is: " + inputString);
			System.out.println(Controller.getHTMLText("https://www.simbirsoft.com/"));
			String[] resultWords = Controller.getWords(Controller.getHTMLText("https://www.simbirsoft.com/"));
			for (String resultword : resultWords) {
				System.out.println(resultword);
			}
			System.out.println(Controller.getStatisticsByWords(resultWords));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}
}