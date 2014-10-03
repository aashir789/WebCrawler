package webscraper;

import java.util.HashMap;

public class Result {
    /*
     * Author : Aashir Gajjar
     * 
     * Date: 10/2/2014
     * 
     * This class is basically a HashMap whose keys are the page number and the
     * value is the entire formatted String which needs to be printed out
     * 
     * The class contains the following public methods
     * 
     * addResult()
     * addNoOfItems()
     * printResult()
     * 
     * 
     * 
     */

    private HashMap<Integer,String> resultMap;
    private int totalItems; 
    
    
    public void addResult(int key, String value){
	
	this.resultMap.put(key, value);
	
    }
    
    public void addNoOfItems(int i){
	
	this.totalItems +=i;
	
    }
    
    public void printResult(){
	
    }
    
}
