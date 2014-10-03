package webscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Query2Parser extends PageParserTemplate {

    /*
     * Author: Aashir Gajjar
     * 
     * Date: 10/1/2014
     * 
     * This class parses through an HTML file to search for a query word and
     * stores additional information.
     * 
     * 
     */

    private StringBuilder parseResult;
    private int PageNo;

    public StringBuilder getParseResult(String myurl) {
	try {
	    String url = myurl;

	    parseResult = new StringBuilder();

	    Document doc = Jsoup.connect(url).timeout(2000).get();

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
		
		StringBuilder tempString = new StringBuilder();
		
		tempString.append("\n");
		tempString.append("Product Name: ");
		tempString.append(productName[k]);
		tempString.append("\n");
		tempString.append("Price: ");
		tempString.append(productPrice[k]);
		tempString.append("\n");

		parseResult.append(tempString);

	    }

	    super.noOfItems = productName.length;

	    return this.parseResult;

	} catch (IOException e) {
	    e.printStackTrace();
	    return this.parseResult;
	}

    }


}
