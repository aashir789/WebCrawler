package webscraper;

import java.io.IOException;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkGrabber {
    /*
     * Author : Aashir Gajjar
     * 
     * Date: 10/2/14
     * 
     * This class helps in grabbing all the urls present on an HTML page. It
     * uses some standard functions of the Jsoup library for parsing through
     * HTML
     * 
     * The class has one public funtion that can be used:
     * 
     * getURLs(): HashSet<String> It uses the url with which the class was
     * instantiated and returns a HashSet of Strings which are basically all the
     * unique urls present on the HTML
     */

    private String url;
    private HashSet<String> linkStrings = new HashSet<String>();

    /* Class constructor */

    public LinkGrabber(String pageurl) {

	this.url = pageurl;

    }

    public HashSet<String> getURLs() throws IOException, Exception {
	try {

	    String url = "http://walmart.com";

	    Document doc = Jsoup.connect(url).get();
	    Elements links = doc.select("a[href]");

	    for (Element link : links) {
		
		if (!linkStrings.contains(link.attr("abs:href"))) {
		
		    linkStrings.add(link.attr("abs:href"));
		}
	    }
	    return linkStrings;

	} catch (IOException e) {
	    e.printStackTrace();
	    linkStrings = null;
	    return linkStrings;
	} catch (Exception re) {
	    re.printStackTrace();
	    linkStrings = null;
	    return linkStrings;
	}

    }

    public static void main(String[] args) throws IOException, Exception {
	try {

	    LinkGrabber gra = new LinkGrabber("http://www.walmart.com");

	    gra.getURLs();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}