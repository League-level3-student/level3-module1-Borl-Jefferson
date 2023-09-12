package _00_Intro_To_ArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
		JPanel jp = new JPanel();
	JFrame jf = new JFrame();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	 ArrayList<String> shapes = new ArrayList<String>();
	public static void main(String[] args) {
		new _02_GuestBook().run();
	}
public void run() {
	


	
	jf.add(jp);
	jp.add(jb1);
	jp.add(jb2);
	jf.pack();
	
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
	
	jf.setSize(500, 300);
	jb1.setPreferredSize(new Dimension (100, 50));
	jb2.setPreferredSize(new Dimension (100, 50));
	
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	
	jb1.setText("Add Name");
	jb2.setText("View Names");
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == jb1) {
	shapes.add(JOptionPane.showInputDialog("Enter a name"));
	}
	else {for (int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i));
		}System.out.println();
	}
}/*
good name
Awesome Name
Nice Name
Amazing Name
Good Name
Awe Inspiring Name*/
}
