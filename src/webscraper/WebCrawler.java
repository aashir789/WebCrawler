package webscraper;

import java.util.HashSet;
import java.io.IOException;
import java.net.URLEncoder;

import javax.management.Query;

public class WebCrawler {
    /*
     * Author: Aashir Gajjar
     * 
     * Date: 10/1/2014
     * 
     * This {@link WebCrawler} essentially uses all the other objects of the
     * "webscrapper" package in order to initiate a web crawling process.
     * 
     * 
     * The class contains only one public method which has the core
     * implementation of the web crawler. A breadth first search is used here to
     * accomplish the goal of searching every page on the website/domain and
     * returning the result of a query
     * 
     * 
     * The result is stored in a {@link Result} class
     */

    private Result FinalResult;
    private String currentURL;
    private String startURL;
    private PageParserTemplate parser;
    private LinkGrabber grabber;
    private String[] allURLs;
    private String queryString;
    private Integer queryPage;

    /*
     * The constructor initializes all the private fields to default values
     */
    public WebCrawler(String url, Integer query2Page) {

	this.startURL = url;

	// set correct subclasses according to the query

	if (query2Page != null) {

	    this.queryPage = query2Page;
	    this.parser = new Query2Parser(this.queryPage);

	} else {
	    this.parser = new Query1Parser();
	}

    }

    public void run(String query) throws IOException, GenericSearchException,
	    QueryPageOutOfBoundsException {

	// form the initial query url by combinig startURL and query
	this.queryString = query;
	this.currentURL = this.startURL
		+ URLEncoder.encode(this.queryString, "UTF-8");

	// get all links to all the pages found related to the query
	this.grabber = new LinkGrabber(this.currentURL);
	this.allURLs = grabber.getURLs();

	// the type of instance takes care which getParseResult to call
	FinalResult = this.parser.getParseResult(this.allURLs);

	// prints the correct result according to the query
	this.FinalResult.printResult();

    }

    public static String mergeArrayOfStrings(String[] str, int length) {
	StringBuilder builder = new StringBuilder();
	int count = 0;

	for (String s : str) {
	    if (count == length) {
		break;
	    }

	    builder.append(s);
	    builder.append(" ");
	    count++;
	}
	return builder.toString();

    }

    public static void main(String[] args) {
	try {

	    // try to parse the last digit as an integer to check if its query2

	     args = new String[2];
	    args[0] = "camera";
		    args[1]= "2";

	    String query;
	    Integer queryPage = null;
	    try {
		queryPage = Integer.parseInt(args[args.length - 1]);
		query = mergeArrayOfStrings(args, args.length - 1);
		System.out.println("\nEntered a string with page no: "
			+ queryPage
			+ ". Running query2 to search detailed results");

	    } catch (NumberFormatException ne) {
		System.out
			.println("\nEntered a string only. Running query1 to search the no of results");
		query = mergeArrayOfStrings(args, args.length);
	    }

	    System.out.println("\nQuery String is: " + query);
	    String startURL = "http://www.walmart.com/search/?query=";

	    WebCrawler crawler = new WebCrawler(startURL, queryPage);
	    crawler.run(query);
	} catch (Exception e) {
	    if (e instanceof GenericSearchException) {
		((GenericSearchException) e).print();
	    } else if (e instanceof QueryPageOutOfBoundsException) {
		((QueryPageOutOfBoundsException) e).print();
	    } else if (e instanceof IOException) {
		System.out
			.println("\nError: The connection might have timed out. Please try again");
		e.printStackTrace();

	    } else {
		e.printStackTrace();
	    }
	}

    }

}
