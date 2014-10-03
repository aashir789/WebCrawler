package webscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Query1Parser extends PageParserTemplate {
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

    private StringBuilder parseResult;
    private int noOfItems;

    public StringBuilder getParseResult(String myurl) throws IOException {
	try {
	    String url = myurl;

	    parseResult = new StringBuilder();
	   
	    
	    Document doc = Jsoup.connect(url).timeout(2000).get();

	    Elements productElements = doc.select("a.js-product-title");

	    String[] productName = new String[productElements.size()];

	    super.noOfItems = productName.length;
	    
	    
	    // return null because we do not need additional info for query1
	    return parseResult;

	} catch (IOException e) {
	    e.printStackTrace();
	    return parseResult;
	}

    }

  

}
