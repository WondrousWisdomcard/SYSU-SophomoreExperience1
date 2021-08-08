package Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RemarkFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public RemarkFrame() {

		setBounds(500, 300, 300, 200);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("��Ʒ��ע");

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JTextArea jt = new JTextArea(6, 19);
		JButton jb = new JButton("ȷ��");
		jt.setFont(new Font("����", Font.BOLD, 15));
		jt.setBackground(new Color(255, 245, 238));

		jb.setFont(new Font("����", Font.BOLD, 17));
		jb.setBackground(new Color(255, 127, 80));
		jb.setBorderPainted(false);

		jt.setLineWrap(true);// �Զ�����

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(jt.getText());
				//����չ
				setVisible(false);
			}
		});
		c.add(jt,BorderLayout.NORTH);
		c.add(jb,BorderLayout.SOUTH);
		setVisible(true);
	}

}
