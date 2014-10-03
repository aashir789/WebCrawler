package webscraper;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkGrabber {
    /*
     * Author : Aashir Gajjar
     * 
     * Date: 10/2/14
     * 
     * This class helps in grabbing all the urls which represent all the search pages releated to the query string
     * 
     * The class has one public funtion that can be used:
     * 
     * getURLs(): LinkedList<String> It uses the url of the first search page given the query element and returns the links to all the pages
     * that contains the search items.
     */

    private String url;
    private String[] linkStrings;

    /* Class constructor */

    public LinkGrabber(String pageurl) {

	this.url = pageurl;

    }

    public String[] getURLs() throws IOException, Exception {
	try {
	    // Test url
	    
	    //String url = "http://www.walmart.com/search/?query=camera";

	    // parse the first search page to get the total no of pages for
	    // which the query item is listed

	    Document doc = Jsoup.connect(url).get();
	    String pageNumbers = doc.select("ul.paginator-list").text();

	    // split the numbers on space and get the last number to indentify
	    // the number of search results

	    String[] pageNumberSplit = pageNumbers.split(" ");
	    int lastElementIndex = pageNumberSplit.length - 1;
	    int totalPages = Integer
		    .parseInt(pageNumberSplit[lastElementIndex]);

	    // intialize an array of urls (Strings) for all the pages to be
	    // parsed

	    this.linkStrings = new String[totalPages];

	    for (int i = 0; i < totalPages; i++) {

		linkStrings[i] = url + "&page=" + (i+1);

	    }

	    return linkStrings;

	} catch (IOException e) {
	    e.printStackTrace();
	    linkStrings = null;
	    return linkStrings;
	} catch (Exception re) {
	    re.printStackTrace();
	    linkStrings = null;
	    return linkStrings;
	}

    }

    public static void main(String[] args) throws IOException, Exception {
	try {

	    LinkGrabber gra = new LinkGrabber("http://www.walmart.com");

	    gra.getURLs();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}