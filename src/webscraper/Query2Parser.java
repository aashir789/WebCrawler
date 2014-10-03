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
     */

    private StringBuilder parseResult;
    private int pageNo;
    private Query2Result finalResult;

    public Query2Parser(int pageNoQuery){
	this.pageNo = pageNoQuery;
    }
    
    
    @Override
    public Query2Result getParseResult(String[] myurl) throws IOException,QueryPageOutOfBoundsException {

	String url = myurl[this.pageNo-1];
	this.parseResult = new StringBuilder();
	this.finalResult = new Query2Result();
	
	int totalPages = myurl.length;
	
	if (this.pageNo > totalPages) {

	    throw new QueryPageOutOfBoundsException(this.pageNo, totalPages);
	}

	Document doc = Jsoup.connect(url).timeout(3000).get();

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
	
	this.finalResult.addResult(this.pageNo, this.parseResult.toString());
	this.finalResult.addNoOfItems(productName.length);
	this.finalResult.setPageQuery(this.pageNo);
	return this.finalResult;

    }

}
