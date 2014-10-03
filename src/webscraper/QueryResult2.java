package webscraper;

import java.util.HashMap;

public class QueryResult2 extends Result {
    /*
     * Author: Aashir Gajjar
     * 
     * Date: 10/2/2014
     * 
     * The class is a wrapper over the Result class and overrides the print method
     * 
     */
    
    @Override
    public void printResult(){
	HashMap<Integer,String> map = super.resultMap;
	String resultString = map.get(super.pageQuery);
	System.out.println("The total no of results are:" +this.totalItems);
	System.out.println("\nThe result of the query on page no "+super.pageQuery+" is:\n"+resultString);
	
    }
    
}
