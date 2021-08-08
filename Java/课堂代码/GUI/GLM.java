package GUI;

import java.awt.*;
import java.awt.event.*;

class GLM extends Frame {

	GLM() {
		super("Example: GridLayout");

		setLayout(new GridLayout(2, 2));
		add(new Button("1,1"));
		add(new Button("1,2"));
		add(new Button("2,1"));
		add(new Button("2,2"));
		setSize(250, 100);
	}

	public static void main(String[] args) {
		new GLM().setVisible(true);
	}

}
