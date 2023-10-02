
/**
 * Application class for testing the DictionaryMap class
 * @author Patrick Valsted
 *
 */
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DictionaryMap dm=new DictionaryMap();
		
		dm.read("DictionaryWordValuePairs.csvs"); //testing to see if the exception is caught
		System.out.println();
		dm.read("DictionaryWordValuePairs.csv"); //importing the words from the file into a HashMap
		
		dm.printDictionary(); //testing the organized printing of the entire dictionary
		
		//testing 5 words present in the HashMap
		dm.search("asunder");
		dm.search("tithe");
		dm.search("varlet");
		dm.search("howbeit");
		dm.search("dame");
		
		dm.search("sjifjj"); //testing to see what happens when a word isn't present
	}//end main

}//end class
