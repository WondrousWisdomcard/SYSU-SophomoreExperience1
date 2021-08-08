package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HLW extends JFrame {

	HLW() {
		super("Example: Swing GUI");

		final JButton b = new JButton("Show message!");

		b.addActionListener(new HLWButtonListener(b));
		add(b);
		setSize(250, 100);
	}

	public static void main(String[] args) {
		new HLW().setVisible(true);
	}

}

class HLWButtonListener implements ActionListener {

	private JButton jb;

	HLWButtonListener(JButton b) {
		jb = b;
	}

	public void actionPerformed(ActionEvent e) {
		jb.setText("Hello World!");
	}

}
