package webscraper;

import java.util.HashSet;
import java.io.IOException;
import java.net.URLEncoder;


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

	this.startURL = url;
	
	
	
	

    }

    public void run(String query) throws IOException {
	try{
	
	// form the initial query url    
	this.queryString = query;
	this.currentURL = URLEncoder.encode(this.queryString, "UTF-8");
	
	// get all links to all the pages found related to the query
	
	this.grabber = new LinkGrabber(this.currentURL);
	
	
	
	
	
	
	
	
	
	
	}
	catch (IOException e){
	    e.printStackTrace();
	}
	
	
	
	

    }

    public static void main(String[] args) {

	String queryString = "camera";
	String startURL = "http://www.walmart.com/search/?query=";

	WebCrawler crawler = new WebCrawler(startURL);
	crawler.run(queryString);

    }

}
