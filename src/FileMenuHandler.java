import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

public class FileMenuHandler implements ActionListener {
	
	// Instantiate GUI object
	WordGUI myGUI;
	public FileMenuHandler(WordGUI frame) {
		myGUI = frame;
	}
	// Handler for Open and Exiting the program
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Open")) {
			this.fileOpen();
		}
		else if (event.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
	}
	
	// Use to handle file opening 
	private void fileOpen() {

		JFileChooser select = new JFileChooser();
		int state;
		state = select.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			// if file opened, clear out any older entries inside
			Project4.unsorted.clear();
			Project4.sorted.clear();
			// Try catch to add words into unsorted and sorted list
			try {
				File myFile = select.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(myFile));
				String line = br.readLine();
				StringTokenizer token;
				// Create tokens for the unsorted and sorted words like in Project 2
				while (line != null) {
					token = new StringTokenizer(line);
					while (token.hasMoreTokens()) {
						String name = token.nextToken();
						Word w = new Word(name);
						Project4.unsorted.add(w);
						Project4.sorted.put(w, name);
					}
					line = br.readLine();
				}
				br.close(); // close for memory leakage prevention
			}
			catch (IOException io) {
			}
		// fill up gui with our sorted and unsorted words
		myGUI.fillGUI(Project4.unsorted, Project4.sorted);
		
		} //if statement
	} //fileopen
}
