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
	    this.FinalResult = new QueryResult2();
	    this.FinalResult.setPageQuery(this.queryPage);
	    this.parser = new Query2Parser();

	} else {
	    this.FinalResult = new QueryResult1();
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

	int totalPages = this.allURLs.length;
	
	
	// check if the query is 1 or 2
	
	
	if (this.parser instanceof Query2Parser) {

	    if (this.queryPage > totalPages) {

		throw new QueryPageOutOfBoundsException(this.queryPage,
			totalPages);
	    }

	    String pageResult = this.parser.getParseResult(
		    allURLs[this.queryPage - 1]).toString();

	    this.FinalResult.addResult(this.queryPage, pageResult);

	    int noOfItems = this.parser.getNoOfItems();

	    // add the no of items in this page to the total no
	    this.FinalResult.addNoOfItems(noOfItems);

	}

	else {

	    // If the query is query1 for only the total no of pages
	    // only check the last items on last page and

	    System.out.print("\nParsing page " + totalPages + " ...");

	    String pageResult = this.parser.getParseResult(
		    allURLs[totalPages - 1]).toString();

	    int iemsOnLastPage = this.parser.getNoOfItems();

	    // the total items are 16*(totalPages-1) + items on last page
	    int totaItems = 16 * (totalPages - 1) + iemsOnLastPage;

	    this.FinalResult.addNoOfItems(totaItems);

	}

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
