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
    private String[] allURLs;
    private String queryString;
    
    

    /*
     * The constructor initializes all the private fields to default values
     */
    public WebCrawler(String url, boolean query2) {
	
	this.startURL = url;
	this.parser = new PageParser();
	
	
	
	
	if(query2){
	    this.FinalResult = new QueryResult2();
	}
	else{
	    this.FinalResult = new QueryResult1();
	}
	
	
    }

    public void run(String query) throws IOException {
	try {

	    // form the initial query url by combinig startURL and query
	    this.queryString = query;
	    this.currentURL = this.startURL+URLEncoder.encode(this.queryString, "UTF-8");

	    // get all links to all the pages found related to the query
	    this.grabber = new LinkGrabber(this.currentURL);
	    this.allURLs = grabber.getURLs();

	    // go over all the links/pages, parse the webpage and append the result
	    // from all the pages

	    for (int i = 0; i < this.allURLs.length; i++) {

		String pageResult = this.parser.getParseResult(allURLs[i])
			.toString();
		int noOfItems = this.parser.getNoOfItems();

		
		// i+1 represents the page no
		this.FinalResult.addResult(i + 1, pageResult); 
		
		// add the no of items in this page to the total no 
		this.FinalResult.addNoOfItems(noOfItems);

	    }
	    
	    
	   // prints the correct result according to the query  
	   this.FinalResult.printResult(); 
	    
	    
	    

	} catch (IOException e) {
	    e.printStackTrace();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }

    public static void main(String[] args) {
	try{
	
	    
	    
	boolean isQuery2 = false;    
	    
	if (args.length>1){
	    isQuery2= true;
	}
	
	
	// do something to filter  arguments
	    
	    
	String queryString = "camera";
	String startURL = "http://www.walmart.com/search/?query=";

	WebCrawler crawler = new WebCrawler(startURL,isQuery2);
	crawler.run(queryString);
	}
	catch(Exception e){
	    e.printStackTrace();
	}
    }

}
