package webscraper;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Example program to list links from a URL.
 */
public class LinkGrabber {
    public static void main(String[] args) throws IOException {
	// Validate.isTrue(args.length == 1, "usage: supply url to fetch");
	String url = "http://walmart.com";
	print("Fetching %s...", url);

	Document doc = Jsoup.connect(url).get();
	Elements links = doc.select("a[href]");
	HashSet<String> linkStrings = new HashSet<String>();

	print("\nLinks: (%d)", links.size());
	for (Element link : links) {
	    print(" * a: <%s>  (%s)", link.attr("abs:href"),
		    trim(link.text(), 35));
	    linkStrings.add(trim(link.text(), 35));

	}
    }

    private static void print(String msg, Object... args) {
	System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
	if (s.length() > width)
	    return s.substring(0, width - 1) + ".";
	else
	    return s;
    }
    
     	

}