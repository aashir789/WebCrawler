package webscraper;

import java.util.HashMap;

abstract public class Result {
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

    protected HashMap<Integer,String> resultMap;
    protected int totalItems; 
    protected int pageQuery;
    
    public Result(){
	this.resultMap = new HashMap<Integer,String>();
	}
    

    public void setPageQuery(int i){
	this.pageQuery = i; 
    }
    
    public int getPageQuery(){
	return this.pageQuery;
    }
    
    public void addResult(int key, String value){
	
	this.resultMap.put(key, value);
	
    }
    
    public void addNoOfItems(int i){
	
	this.totalItems +=i;
	
    }
    
abstract public void printResult();
    
}
