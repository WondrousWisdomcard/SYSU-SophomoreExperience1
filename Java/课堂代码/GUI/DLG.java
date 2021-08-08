package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DLG extends JFrame {

	DLG() {
		super("Example: Swing Dialog");

		final JFrame jf = this;
		final JButton jb = new JButton("Show a message dialog!");

		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(jf, "This is a simple message dialog");
			}
		});
		add(jb);
		setSize(250, 100);
	}

	public static void main(String[] args) {
		new DLG().setVisible(true);
	}

}
