package Server;

import java.awt.*;
import javax.swing.*;

public class TopPanel extends JPanel {

	public TopPanel() {
		setLayout(new BorderLayout());
		setBackground(new Color(255,255,240));
		setPreferredSize(new Dimension(1000,100));
		JLabel top = new JLabel("���ǻ��������ϵͳ",JLabel.CENTER);
		top.setFont(new Font("����", Font.BOLD, 55));
		top.setForeground(new Color(139, 0, 0));

		add(top,BorderLayout.CENTER);
	}
}
