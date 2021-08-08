package GUI;

import java.awt.*;
import java.awt.event.*;

class PNL extends Frame {

	PNL()
	{
		super("Example: Panel");

		final Panel p = new Panel();

		p.add(new Button("1"));
		p.add(new Button("2"));
		p.add(new Button("3"));
		add(p);
		setSize(250,100);
	}
		
	public static void main(String[] args)
	{
		new PNL().setVisible(true);
	}

}
