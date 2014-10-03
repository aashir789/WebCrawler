package webscraper;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PageParser {
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
     * which contains the information of the full name of the item with its price and 
     * all the differnent names a seperated by a new line
     */

    private StringBuilder parseResult;
    private int noOfItems;
    
    public StringBuilder getParseResult(String myurl) throws IOException {
	try {
	    String url = myurl;
	 
	    
	    parseResult = new StringBuilder();
	    StringBuilder tempString = new StringBuilder();

	    
	    Document doc = Jsoup.connect(url).get();
	    
	 
	    String productName = doc.select("a.js-product-title").text(); 
	    String[] productNameSplit = productName.split(" ");

	    String productPrice = doc.select("span.price price-display").text(); 
	    String[] productPriceSplit = productPrice.split(" ");

	    for (int i = 0; i < productPriceSplit.length; i++) {

		tempString.append("Product Name: ");
		tempString.append(productNameSplit[i]);
		tempString.append("\t");
		tempString.append("Price: ");
		tempString.append(productPriceSplit[i]);
		tempString.append("\n");
		parseResult.append(tempString);

	    }
	    
	   this.noOfItems = productNameSplit.length;

	    return this.parseResult;

	} catch (IOException e) {
	    e.printStackTrace();
	    return this.parseResult;
	}

    }
    
    
    public int getNoOfItems(){
	// check if the no is valid
	return this.noOfItems;
    }

}
