package Client;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import Database.*;

public class AlterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public int size = 0;
	public MenuItemPanel[] mip = new MenuItemPanel[30];

	public AlterPanel(int n, HashMap<String, Cuisine> Menu)// n为传入菜品数
	{
		this.size = n;
		setLayout(new FlowLayout(FlowLayout.CENTER));// 居中对齐
		setBackground(Color.white);
		Iterator<String> iter = Menu.keySet().iterator();// 以菜品的id作为key，遍历map中所有的key
		setPreferredSize(new Dimension(500, 2000));// 强行设置面板大小
		for (int i = 0; i < n; i++) {
			String id = (String) iter.next();
			mip[i] = new MenuItemPanel(id, Menu.get(id).getname(), Menu.get(id).getprice(), Menu.get(id).geticon());
			add(mip[i]);
		}
	}
}
