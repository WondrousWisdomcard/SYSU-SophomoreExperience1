package GUI;

import java.awt.*;
import java.awt.event.*;

class LST extends Frame {

	LST() {
		super("Example: List");

		final List l = new List();

		l.add("I");
		l.add("like");
		l.add("programming");
		l.add("in");
		l.add("Java");
		l.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent ie) {
				System.out.println(ie.paramString());
			}
		});
		add(l);
		setSize(200, 150);
	}

	public static void main(String[] args) {
		new LST().setVisible(true);
	}

}
