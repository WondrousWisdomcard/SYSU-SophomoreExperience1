package GUI;

import java.awt.*;
import java.awt.event.*;

class MNB extends Frame {

	MNB() {
		super("Example: MenuBar");

		final MenuBar mb = new MenuBar();

		setMenuBar(mb);

		final Menu m = new Menu("File");
		MenuItem mi;

		mi = new MenuItem("Exit");
		mi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		m.add(mi);
		mb.add(m);
		setSize(250, 100);
	}

	public static void main(String[] args) {
		new MNB().setVisible(true);
	}

}
