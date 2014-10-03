package webscraper;

import java.util.HashSet;

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
    private PageParser parser;
    private LinkGrabber grabber;
    private HashSet<String> visitedURLs;
    private HashSet<String> newURLs;
    private String queryString;

    /*
     * The constructor initializes all the private fields to default values
     */
    public WebCrawler(String url) {

	this.currentURL = url;

    }

    public void run(String query) {

	this.queryString = query;

	// put the url in visited list
	// enqueue the url
	
	// dequeue url

	// fetch data from parser with current url
	
	// fetch other links from grabber and add only new urls to queue only if they are
	// not in the visited list
	
	//fetch data from parser and append to the existing result object 
	
	
	
	
	

    }

    public static void main(String[] args) {

	String queryString = "";
	String startURL = "http://walmart.com";

	WebCrawler crawler = new WebCrawler(startURL);
	crawler.run(queryString);

    }

}
