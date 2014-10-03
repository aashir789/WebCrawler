package webscraper;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

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
     * which contains the information of the full name of the item with its
     * price and all the differnent names a seperated by a new line
     */

    private StringBuilder parseResult;
    private int noOfItems;

    public StringBuilder getParseResult(String myurl) throws IOException {
	try {
	    String url = myurl;

	    parseResult = new StringBuilder();
	   
	    
	    Document doc = Jsoup.connect(url).get();

	    Elements productElements = doc.select("a.js-product-title");

	    String[] productName = new String[productElements.size()];

	    int i = 0;

	    for (Element e : productElements) {

		productName[i] = e.text();
		i++;
	    }

	    Elements priceElements = doc.select("div.item-price-container");

	    String[] productPrice = new String[priceElements.size()];

	    int j = 0;

	    for (Element e : priceElements) {

		productPrice[j] = e.text();
		j++;
	    }
	    
	    for (int k = 0; k < productName.length; k++) {
		
		StringBuilder tempString = new StringBuilder() ;
		
		tempString.append("Product Name: ");
		tempString.append(productName[k]);
		tempString.append("\t");
		tempString.append("Price: ");
		tempString.append(productPrice[k]);
		tempString.append("\n");
		
		parseResult.append(tempString);
		

	    }

	    this.noOfItems = productName.length;

	    return this.parseResult;

	} catch (IOException e) {
	    e.printStackTrace();
	    return this.parseResult;
	}

    }

    public int getNoOfItems() {
	// check if the no is valid
	return this.noOfItems;
    }

}
