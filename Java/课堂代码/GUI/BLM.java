package GUI;

import java.awt.*;
import java.awt.event.*;

class BLM extends Frame {

	BLM() {
		super("Example: BorderLayout");

		setLayout(new BorderLayout());
		add(new Button("Center"), BorderLayout.CENTER);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("West"), BorderLayout.WEST);
		setSize(200, 200);
	}

	public static void main(String[] args) {
		new BLM().setVisible(true);
	}

}
