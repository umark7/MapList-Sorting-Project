import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditMenuHandler implements ActionListener {

	WordGUI myGUI;
	public EditMenuHandler(WordGUI frame) {
		myGUI = frame;
	}
	
	public void actionPerformed(ActionEvent event) {
		// If someone clicks the search menu item, do this
		if (event.getActionCommand().equals("Search")) {
			//Input will be taken by an input dialog which will ask user to type in a word
			String input = JOptionPane.showInputDialog(null, "Type in a word: ");
			// Create Word object search that holds input
			Word search = new Word(input);
			// If searched word contains the key of the object
			if (Project4.sorted.containsKey(search)) {
			    JOptionPane.showMessageDialog(null, "The word " + input + " is IN the TreeMap.");
			} 
			// Else tell the user that the value isn't in the map.
			else {
			    JOptionPane.showMessageDialog(null, "The word " + input + " is NOT in the TreeMap.");
			}
		}
	}
}

