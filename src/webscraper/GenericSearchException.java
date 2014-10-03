package webscraper;

public class GenericSearchException extends Exception {
    /*
     * Author : Aashir Gajjar
     * 
     * Date: 10/3/2014
     * 
     * This class helps in handling exceptions related to keywords that are 
     * generic and would result in a lot of search results which is quite impratical
     * 
     * 
     */
    private String badurl;
    
    public GenericSearchException(String url){
	
	this.badurl = url;
	
    }
    
    public String getURL(){
	return this.badurl;
    }
    
    public void print(){
	
	System.out.println("\nThe keyword used is too generic and it has its own category page on walmart.com\n"
				+ "Please enter a more specific keyword or subcategories of the current keyword to get appropriate results\n"
				+ "For eg: \"tablet\" or \"harry potter\" as opposed to \"books\" or \"shoes\" ");
	this.printStackTrace();
    }
    
}
