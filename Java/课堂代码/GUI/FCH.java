package GUI;

import javax.swing.*;

class FCH extends JFrame {

	final JLabel jl = new JLabel("hello");

	FCH() {
		super("Example: Swing FileChooser");

		add(jl);
		setSize(300, 150);
	}

	public static void main(String[] args) {
		final FCH fch = new FCH();
		final JFileChooser jfc = new JFileChooser();

		fch.setVisible(true);

		final int val = jfc.showOpenDialog(fch);

		if (val == JFileChooser.APPROVE_OPTION)
			fch.jl.setText("You chose to open this file: " + jfc.getSelectedFile().getName());
	}

}