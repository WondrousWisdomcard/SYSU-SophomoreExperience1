package Server;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import Database.*;

public class AlterPanel extends JPanel {
	int size = 0;
	MenuItemPanel[] mip = new MenuItemPanel[30];

	AlterPanel(int n, HashMap<String, Cuisine> Menu) {
		this.size = n;
		setLayout(new FlowLayout(0));
		setBackground(Color.white);
		Iterator<String> iter = Menu.keySet().iterator();
		setPreferredSize(new Dimension(250, 2000));
		for (int i = 0; i < n; i++) {
			String id = (String) iter.next();
			mip[i] = new MenuItemPanel(id, Menu.get(id).getname(), 100);
			add(mip[i]);
		}
	}
}
