import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * Class that uses a HashMap to create a dictionary. It has the capability to read from
 * a file, print the dictionary, and search for a specific word.
 * @author Patrick Valsted
 *
 */

public class DictionaryMap {

	private HashMap<String,String> dictionaryMap;
	
	/**
	 * Constructor instantiates a new HashMap to be used in the rest of the class
	 */
	public DictionaryMap() {
		dictionaryMap=new HashMap<String,String>();
	}//end constructor
	
	
	/**
	 * This method reads the file specified and enters each line into the HashMap using a while loop.
	 * If the file doesn't exist, the exception is caught.
	 * @param fileName: name of the file with the data
	 */
	public void read(String fileName) {
		
		try {
			File file=new File(fileName);
			FileReader fr;
			fr = new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String word="";
			String[] tempArray;
			
			while((word=br.readLine()) != null) { //as long as the line isn't empty
				tempArray=word.split(","); //each line is stored in a StringArray; the comma in the file is marked as the point at which the key and value are split
				dictionaryMap.put(tempArray[0], tempArray[1]); //line by line, the key and value are added to the HashMap; they are entries in the array and are then overwritten
			}//end while
			
			br.close(); //reader not left opened
			
		}//end try
		
		catch (IOException e) {
			System.out.println(e.getMessage()); //if the file does not exist, the exception is caught and an error message is printed
		}//end catch
	}//end read
	
	
	/**
	 * This method prints out the entire dictionary. It uses a for loop to iterate through
	 * the HashMap, printing out each entry in an organized and visually-pleasing way.
	 */
	public void printDictionary() {
		for(@SuppressWarnings("rawtypes") Map.Entry entry:dictionaryMap.entrySet()) { //for each entry in the HashMap,
			System.out.println(entry.getKey()+"\nDefinition: "+entry.getValue()+"\n"); //the key (word) and definition will be printed
		}
	}//end printDictionary
	
	
	/**
	 * Searches the HashMap and prints out information about a String if
	 * the entry is found.
	 * @param word: the String the user wants to look up
	 */
	public void search(String word) {
		
		if ((dictionaryMap.containsKey(word))==true) { //block runs if word is in the dictionary
		String def=dictionaryMap.get(word);
		int code=word.hashCode(); //converts the word to HashCode
		
		System.out.println("Key: "+word+"\nValue: "+def+"\nHashCode: "+code+"\n"); //prints the key(word), value(definition), and HashCode integer
		}//end if statement 
		
		else System.out.println("This word is not in the dictionary."); //if the word is not present, this message prints to let the user know
		
	}//end search
	
}//end class
