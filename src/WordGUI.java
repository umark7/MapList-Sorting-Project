import java.awt.*;
import java.util.*;

import javax.swing.*; 
	
	public class WordGUI extends JFrame{ 

		private static final long serialVersionUID = -7388313485187505131L; //added # so that warning doesn't occur 
		//Declaring public JTextAreas that we can reference
		public JTextArea unsortedArea;
		public JTextArea sortedArea;
		
		public WordGUI() {
			
			this.setSize(1000,500); //size of window
			this.setTitle("Project 4");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			this.setLayout(new GridLayout(1,2)); // 2 columns for sorted, unsorted words
			//this.setLocation(400,200);
			
			// Create menu layout, bar and menu. Create Open and close items
			JMenuBar bar = new JMenuBar();
			JMenu menu = new JMenu("File");
			JMenu menu2 = new JMenu("Edit"); //edit item added for search
			JMenuItem open = new JMenuItem("Open");
			JMenuItem close = new JMenuItem("Quit");
			JMenuItem search = new JMenuItem("Search");
			
			// Handler opens a new event when file or open/close is pressed
			// We are giving instructions when the file is to be opened or closed, and search option on 
			FileMenuHandler handler = new FileMenuHandler(this);
			EditMenuHandler edit = new EditMenuHandler(this);
			open.addActionListener(handler);
			close.addActionListener(handler);
			search.addActionListener(edit);
			
			//JOptionPane.showMessageDialog(null, "Yes is in the TreeMap");
			// add elements of menu to our GUI
			this.setJMenuBar(bar);
			menu.add(open);
			menu.add(close);
			menu2.add(search); //add the search function to the Edit tab on the bar
			bar.add(menu);
			bar.add(menu2); //add Edit option on the bar
			
			//initialize areas for the columns
			this.unsortedArea = new JTextArea(); // new area declared for unsorted
			this.sortedArea = new JTextArea();   // new area declared for sorted

			
			//scroll panes if we wish, so that a large file can be inputted & can be scrolled through
			JScrollPane s1 = new JScrollPane();
			JScrollPane s2 = new JScrollPane();
			s1.setViewportView(unsortedArea);
			s2.setViewportView(sortedArea);
	
			// Add our scrolling capabilities to the GUI
			this.add(s1);
			this.add(s2);
			// Show our layout and makes it visible.
			this.setVisible(true);
		}
		
	// Fill up our GUI with the different words in their respective columns (unsorted, sorted, invalid)
	public void fillGUI(ArrayList<Word> unsorted, TreeMap<Word, String> sorted) {
		// Fill unsorted portion
		this.unsortedArea.setText("");
		for (int i = 0; i < unsorted.size(); i++) {
			this.unsortedArea.append(unsorted.get(i).w + "\n");
		}
		// Fill sorted portion using TreeMap method.
		sortedArea.setText("");
		for (Map.Entry<Word, String> me : Project4.sorted.entrySet()) {
			this.sortedArea.append(me.getKey() + "\n");
		}

	}
}
	
	