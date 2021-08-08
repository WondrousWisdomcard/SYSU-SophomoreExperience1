package Client;

import java.awt.*;

import javax.swing.*;

public class WestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton b1 = new JButton();
	public JButton b2 = new JButton();
	public JButton b3 = new JButton();
	public JButton b4 = new JButton();
	public JButton b5 = new JButton();
	public JButton b6 = new JButton();

	public JButton[] btns = {b1, b2, b3, b4, b5, b6};

	public WestPanel() {
		setLayout(new GridLayout(9, 1, 5, 5));
		setBackground(new Color(244, 244, 244));

		b1.setText("   锅 底 类   ");
		b2.setText("   荤 菜 类   ");
		b3.setText("   素 菜 类   ");
		b4.setText("   小 吃 类   ");
		b5.setText("   酒 水 类   ");
		b6.setText("   主 食 类   ");
		
		for (int i = 0; i <= 5; i++) {
			btns[i].setFont(new Font("宋体", Font.BOLD, 25));
			btns[i].setBorderPainted(false);
			btns[i].setBackground(new Color(255, 239, 213));
			btns[i].addFocusListener(new MenuBarAction());
			add(btns[i]);
		}

	}
}
