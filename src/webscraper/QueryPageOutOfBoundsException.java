package webscraper;

public class QueryPageOutOfBoundsException extends Exception {
    /*
     * Author : Aashir Gajjar
     * 
     * Date: 10/3/2014
     * 
     * This class helps in handling exceptions related to queries which have seach page 
     * greater than the no of pages existing for the article
     * 
     * 
     */
    
    private int querypage;
    private int totalpages;

    public QueryPageOutOfBoundsException(int qpage, int tpage){
	this.querypage = qpage;
	this.totalpages = tpage;
    }

    public void print(){
	System.out.println("\nThe query page: "+this.querypage+" is more than the total no of pages ("+this.totalpages+")");
	this.printStackTrace();
    }
    
}
