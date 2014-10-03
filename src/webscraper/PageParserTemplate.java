package webscraper;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

abstract public class PageParserTemplate {
    /*
     * Author: Aashir Gajjar
     * 
     * Date: 10/1/2014
     * 
     * This class parses through an HTML file to search for a query word.
     * 
     * The public methods of this class are:
     * 
     * getParseResult():StringBuilder This method returns a StringBuilder object
     * which contains the information of the full name of the item with its
     * price and all the differnent names a seperated by a new line
     */

    
    protected int noOfItems;

    abstract public Result getParseResult(String []myurl) throws IOException, QueryPageOutOfBoundsException ;

    public int getNoOfItems() {
	// check if the no is valid
	return this.noOfItems;
    }

}
