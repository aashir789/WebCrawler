Walmart WebCrawler
==========

The class WebCrawler in the ./src/webscrapper/ contains the main function which runs the program.

It is currently set to find items on http://walmart.com that are related to a particular keyword.
The program exploits the results given by walmarts search engine.

In order to run the program type the following on the command line:
Query 1: java -jar WebCrawler.jar <keyword> (e.g. java -jar WebCrawler.jar baby strollers)
Query 2: java -jar WebCrawler.jar <keyword> <page number> (e.g. java -jar WebCrawler.jar baby strollers 2)

NOTE: There are no inverted commas around the keyword string. It should be typed as is  

The program uses the following assumptions:
1. The site to be crawled is http://walmart.com and the parsing is done using the site specific HTML structure.
2. It is assumed that the search engine of the site will give ALL RELEVANT items related to a keyword.
3. In order to make the program faster, its assumed that the items on the search page of walmart are always 16.

The WebCrawlerClassDiagram.jpg coudl be useful for an architectural view of the program. 



