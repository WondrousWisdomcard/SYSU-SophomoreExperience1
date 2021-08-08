package GUI;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreatNewFrame extends JFrame {
	JLabel client_title;
	JButton create_button;

	public CreatNewFrame() {

		getContentPane().setLayout(new GridLayout(1, 0));

		create_button = new JButton("Create");
		create_button.addActionListener(new ButtonListener());
		getContentPane().add(create_button);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewFrame nf = new NewFrame();

			nf.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			nf.setTitle("New Window Frame");
			nf.setSize(200, 150);
			nf.setVisible(true);
		}
	}

	public static void main(String args[]) {
		CreatNewFrame f = new CreatNewFrame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.setTitle("Create New Frame");
		f.setSize(200, 150);
		f.setVisible(true);
	}
} // end of CreatNewFrame

class NewFrame extends JFrame {
	JLabel label;

	public NewFrame() {
		getContentPane().setLayout(new FlowLayout());

		label = new JLabel("Another New Frame");
		getContentPane().add(label);
	} // NewFrame constructor

} // end of NewFrame class
