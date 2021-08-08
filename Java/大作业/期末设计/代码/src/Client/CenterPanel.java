package Client;

import java.awt.*;
import java.util.Iterator;

import javax.swing.*;

import Database.*;

public class CenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;


	public AlterPanel j0;
	public AlterPanel j1;
	public AlterPanel j2;
	public AlterPanel j3;
	public AlterPanel j4;
	public AlterPanel j5;

	public static CardLayout card = new CardLayout();

	public CenterPanel(Warehouse wh) {
		setLayout(card);
		setPreferredSize(new Dimension(250, 2000));// 强行设置面板大小
		String s[] = new String[10];
		s[0] = "pot_bottom";
		s[1] = "meat";
		s[2] = "vegetable";
		s[3] = "snack";
		s[4] = "drink";
		s[5] = "staplefood";

		// 传入仓库的分类菜品库
		j0 = new AlterPanel(wh.get(s[0]).size(), wh.get(s[0]));
		j1 = new AlterPanel(wh.get(s[1]).size(), wh.get(s[1]));
		j2 = new AlterPanel(wh.get(s[2]).size(), wh.get(s[2]));
		j3 = new AlterPanel(wh.get(s[3]).size(), wh.get(s[3]));
		j4 = new AlterPanel(wh.get(s[4]).size(), wh.get(s[4]));
		j5 = new AlterPanel(wh.get(s[5]).size(), wh.get(s[5]));

		// 添加组件并为组件命名
		add(j0, "a" + 0);
		add(j1, "a" + 1);
		add(j2, "a" + 2);
		add(j3, "a" + 3);
		add(j4, "a" + 4);
		add(j5, "a" + 5);
	}
}
