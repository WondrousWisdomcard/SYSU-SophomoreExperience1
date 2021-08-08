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

		b1.setText("   �� �� ��   ");
		b2.setText("   �� �� ��   ");
		b3.setText("   �� �� ��   ");
		b4.setText("   С �� ��   ");
		b5.setText("   �� ˮ ��   ");
		b6.setText("   �� ʳ ��   ");
		
		for (int i = 0; i <= 5; i++) {
			btns[i].setFont(new Font("����", Font.BOLD, 25));
			btns[i].setBorderPainted(false);
			btns[i].setBackground(new Color(255, 239, 213));
			btns[i].addFocusListener(new MenuBarAction());
			add(btns[i]);
		}

	}
}
