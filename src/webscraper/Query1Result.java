package webscraper;

public class Query1Result extends Result {
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
	int number = super.totalItems;
	
	System.out.println("\nThe total items matching the query are: "+number);
	
    }
    
    
    
}
