package webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.examples.*;
import org.jsoup.select.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.*;
import java.nio.file.Files;

public class Main {

	String url;

	public static void main(String[] args) {

		Writer writer = null;

		try {

			// Fetch data from url

			Document mainDoc = Jsoup.connect("http://walmart.com").get();
			String impData = mainDoc.html();

			mainDoc.text();

			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("data.txt"), "utf-8"));

			writer.write(impData);

		} catch (IOException ex) {

			ex.printStackTrace();

		} finally {
			try {

				writer.close();

			} catch (Exception ex) {

				ex.printStackTrace();
				
			}

		}

	}

}
