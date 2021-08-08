package Server;

import java.awt.*;
import java.util.Iterator;
import javax.swing.*;
import Database.*;

public class CenterPanel extends JPanel {

	AlterPanel j0;
	AlterPanel j1;
	AlterPanel j2;
	AlterPanel j3;
	AlterPanel j4;
	AlterPanel j5;

	static CardLayout card = new CardLayout();

	public CenterPanel(Warehouse wh) {
		setLayout(card);
		
		String[] s = new String[10];
		s[0] = "pot_bottom";
		s[1] = "meat";
		s[2] = "vegetable";
		s[3] = "snack";
		s[4] = "drink";
		s[5] = "staplefood";
		

		j0 = new AlterPanel(wh.get(s[0]).size(), wh.get(s[0]));
		j1 = new AlterPanel(wh.get(s[1]).size(), wh.get(s[1]));
		j2 = new AlterPanel(wh.get(s[2]).size(), wh.get(s[2]));
		j3 = new AlterPanel(wh.get(s[3]).size(), wh.get(s[3]));
		j4 = new AlterPanel(wh.get(s[4]).size(), wh.get(s[4]));
		j5 = new AlterPanel(wh.get(s[5]).size(), wh.get(s[5]));

		add(j0, "a" + 0);
		add(j1, "a" + 1);
		add(j2, "a" + 2);
		add(j3, "a" + 3);
		add(j4, "a" + 4);
		add(j5, "a" + 5);
	
	}
}
