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
     * getParseResult():Result 
     * 		This method returns a HashMap<String> object which
     * contains the information of the full name of which the query string is a
     * sub-part of and 
     */

    private String url;
    private HashSet<String> parseResult;
    
    
    public PageParser(String myurl){
	
	this.url = myurl;
	
    }
    
    public HashSet<String> getPareseResult() throws IOException{
	try{
	    
	    this.parseResult = new HashSet<String>();
	    
	    Document doc = Jsoup.connect(url).get();
	    String productName = doc.select("h1.productTitle").text(); // take only the text from the body
	    String productPriceDollars = doc.select("span.bigPriceText1").text(); // take only the text from the body
	    String productPriceCents = doc.select("span.smallPriceText1").text(); // take only the text from the body
	    
	    
	    
	    // if product name and price are not null, add it to the result  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    return this.parseResult;
		    
	}
	catch(IOException e){
	    e.printStackTrace();
	    return this.parseResult;
	}
	
    }
    
    
    public static void main(String[] Args) throws IOException{
	try{
	PageParser parser = new PageParser("http://www.walmart.com/ip/Nikon-Silver-COOLPIX-L27-Digital-Camera-and-8GB-Memory-Card-Value-Bundle/31033089");
	
	parser.getPareseResult();
	}
	catch(IOException ex){
	    ex.printStackTrace();
	    
	}
	
    }
    
	
}
