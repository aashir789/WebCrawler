package webscraper;

import java.util.HashSet;

public class WebCrawler {
    /*
     * Author: Aashir Gajjar
     * 
     * Date: 10/1/2014
     * 
     * This class essentially uses all the other objects of the "webscrapper"
     * package in order to initiate a web crawling process.
     * 
     * The class contains only one public method which has the core
     * implementation of the web crawler. A breadth first search is used here 
     * to accomplish the goal of searching every page on the website/domain.
     * 
     * 
     * 
     * 
     */

    private Result FinalResult;
    private String currentURL;
    private String startURL;
    private PageParser parser;
    private LinkGrabber grabber;
    private HashSet<String> visitedURLs;
    private HashSet<String> newURLs;

    /*
     * The constructor initializes all the private fields to default values
     */

    public WebCrawler() {

    }

    public static void main(String[] args) {

	//

    }

}
