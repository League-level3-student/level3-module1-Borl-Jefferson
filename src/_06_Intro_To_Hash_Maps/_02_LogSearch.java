package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
    HashMap<Integer, String> intstr = new HashMap<Integer, String>();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    
    String list = "";
    
    
    
   public void setup() {
	   jb1.setText("Add Entry");
	   jb2.setText("Search");
	   jb3.setText("View List");
	   jb1.addActionListener(this);
	   jb2.addActionListener(this);
	   jb3.addActionListener(this);
	   frame.setVisible(true);
	   frame.setSize(500, 500);
	   frame.add(panel);
	   panel.add(jb1);
	   panel.add(jb2);
	   panel.add(jb3);
   frame.pack();
   }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == this.jb1) {
		String idnum = JOptionPane.showInputDialog("Enter and ID number");
		int fnum = Integer.parseInt(idnum);
		String name = JOptionPane.showInputDialog("Enter a name");
		intstr.put(fnum, name);
	}
	if(e.getSource()==this.jb2) {
		String id = JOptionPane.showInputDialog("Enter an ID #");
		int fid = Integer.parseInt(id);
		JOptionPane.showMessageDialog(null, intstr.get(fid));
	}
	if(e.getSource()==this.jb3) {
		for (int i : intstr.keySet()) {
			list += ("\nID: " + i  + " Name: " + intstr.get(i));
		}
		JOptionPane.showMessageDialog(null, list);
	}
}
    
}
