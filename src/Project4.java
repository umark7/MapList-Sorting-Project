import java.util.*;

/**
 * 
 * @author Umar K
 * @date 12/7/20
 *
 */

public class Project4 {
	
	// Declaring ArrayLists for the different columns we will use.
	public static WordGUI mygui;
	public static ArrayList<Word> unsorted;
	public static TreeMap <Word, String> sorted; 
	
	public static void main (String[] args) {
		
		unsorted = new ArrayList<Word>();
		sorted = new TreeMap<Word, String>(); //tree map of sorted
	
		// Make sure GUI is launched and other files that are connected launch
		// Instantiate and display our list of words
		mygui = new WordGUI();
		mygui.fillGUI(unsorted,sorted);
	}
}