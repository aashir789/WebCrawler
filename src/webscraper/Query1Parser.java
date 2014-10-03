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
    private Query1Result finalResult;

    
    @Override
    public Query1Result getParseResult(String[] urlarr) throws IOException  {
	
	    
	    String url = urlarr[urlarr.length-1];
	    this.parseResult = new StringBuilder();
	    this.finalResult = new Query1Result();
	    
	    Document doc = Jsoup.connect(url).timeout(3000).get();

	    Elements productElements = doc.select("a.js-product-title");

	    String[] productName = new String[productElements.size()];

	    super.noOfItems = productName.length;
	    
	    int totalItem = 16*(urlarr.length-1) + productName.length;
	    
	    this.finalResult.addNoOfItems(totalItem);
	    
	    return finalResult;
	    

    }

   

  

}
