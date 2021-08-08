package Server;

import java.awt.*;
import javax.swing.*;

public class WestPanel extends JPanel {
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	
	JButton[] btns = { b1, b2, b3, b4, b5, b6 };

	WestPanel() {

		setLayout(new GridLayout(9, 1, 5, 5));
		setBackground(new Color(244, 244, 244));

		b1.setText("   �� �� ��   ");
		b1.setFont(new Font("����", Font.BOLD, 25));
		b1.setBorderPainted(false);// ����ʾ�߿�
		b1.setBackground(new Color(238, 238, 238));
		b1.addFocusListener(new MenuBarAction());

		b2.setText("   С �� ��   ");
		b2.setFont(new Font("����", Font.BOLD, 25));
		b2.setBorderPainted(false);// ����ʾ�߿�
		b2.setBackground(new Color(238, 238, 238));
		b2.addFocusListener(new MenuBarAction());

		b3.setText("   �� �� ��   ");
		b3.setFont(new Font("����", Font.BOLD, 25));
		b3.setBorderPainted(false);// ����ʾ�߿�
		b3.setBackground(new Color(238, 238, 238));
		b3.addFocusListener(new MenuBarAction());

		b4.setText("   �� �� ��   ");
		b4.setFont(new Font("����", Font.BOLD, 25));
		b4.setBorderPainted(false);// ����ʾ�߿�
		b4.setBackground(new Color(238, 238, 238));
		b4.addFocusListener(new MenuBarAction());

		b5.setText("   �� ˮ ��   ");
		b5.setFont(new Font("����", Font.BOLD, 25));
		b5.setBorderPainted(false);// ����ʾ�߿�
		b5.setBackground(new Color(238, 238, 238));
		b5.addFocusListener(new MenuBarAction());

		b6.setText("   �� ʳ ��   ");
		b6.setFont(new Font("����", Font.BOLD, 25));
		b6.setBorderPainted(false);// ����ʾ�߿�
		b6.setBackground(new Color(238, 238, 238));
		b6.addFocusListener(new MenuBarAction());
		
		add(b1);
		add(b3);
		add(b4);
		add(b2);
		add(b5);
		add(b6);
	}
}