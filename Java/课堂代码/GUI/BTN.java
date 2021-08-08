package GUI;

import java.awt.*;
import java.awt.event.*;

class BTN extends Frame {

	BTN() {
		super("Example: Button");

		final Button b = new Button("Press me!");

		b.addActionListener(new ActionListener() {
			// the event handler
			public void actionPerformed(ActionEvent ae) {
				b.setLabel("Thank you!");
			}

		});
		add(b);
		setSize(200, 100);
	}

	public static void main(String[] args) {
		new BTN().setVisible(true);
	}

}
