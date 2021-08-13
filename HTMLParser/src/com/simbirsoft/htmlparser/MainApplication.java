package com.simbirsoft.htmlparser;

import java.io.IOException;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		try {
			System.out.print("Please enter URL:");
			Scanner in = new Scanner(System.in);
			String inputString = in.next();

			System.out.println("Your URL is: " + inputString);
			System.out.println(Controller.Parse("https://www.simbirsoft.com/"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}
}