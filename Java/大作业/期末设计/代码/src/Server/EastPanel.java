package Server;

import java.awt.*;
import javax.swing.*;

public class EastPanel extends JPanel {

	JPanel topTital;
	JPanel order_list; // �˿Ͷ�����
	JPanel countPart;
	JLabel count; // ���ж��ٶ���
	int num;

	EastPanel() {
		setLayout(new BorderLayout());
		topTital = new JPanel();
		topTital.setLayout(new BorderLayout());

		JLabel j2 = new JLabel("�� ǰ �� ��", JLabel.CENTER);
		j2.setFont(new Font("����", Font.BOLD, 30));
		j2.setBounds(60, 70, 100, 20);
		topTital.setBackground(Color.white);
		topTital.add(j2, BorderLayout.SOUTH);

		order_list = new JPanel();
		order_list.setLayout(new FlowLayout());
		order_list.setPreferredSize(new Dimension(400, 1000));

		JScrollPane js = new JScrollPane(order_list);
		js.setBorder(BorderFactory.createEmptyBorder());

		count = new JLabel("���ն��������� " + num);
		count.setFont(new Font("����", Font.BOLD, 30));

		countPart = new JPanel();
		countPart.add(count);
		add(topTital, BorderLayout.NORTH);
		add(js, BorderLayout.CENTER);
		add(countPart, BorderLayout.SOUTH);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		count.setText("���ն��������� " + num);
	}
}
