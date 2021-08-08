package Client;

import java.awt.*;

import javax.swing.*;

public class EastPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JPanel topTital;// ��������
	public JPanel order_list;// ��ѡ����
	public JPanel confirm;// ȷ���������Ϊ��Ե����
	public JLabel count;// ��ʾ�ܼ�
	public JButton confirm_btn;// ���ȷ�ϵ㵥
	public JButton confirm_cos;// ���ȷ������
	public JButton account_btn;// ����
	public JButton delAll;// ȡ��ȫ��
	public JTextField jpnum;// ����
	public JLabel note;
	public JComboBox<String> combobox;// ѡ��
	public double countPrice;

	public EastPanel() {
		setLayout(new BorderLayout());

		topTital = new JPanel();
		topTital.setLayout(new BorderLayout());

		JPanel j1 = new JPanel();// ѡ���������
		j1.setLayout(new BorderLayout());
		JPanel j2 = new JPanel();
		j2.setLayout(new BorderLayout(1,3));

		String item[] = { "1����", "2����", "3����", "4����", "5����", "6����", "7����", "8����" };

		combobox = new JComboBox<String>(item);
		combobox.setFont(new Font("����", Font.BOLD, 15));
		combobox.setForeground(new Color(240, 128, 128));
		combobox.setPreferredSize(new Dimension(100, 20));
		combobox.setEditable(true);

		JLabel pnum = new JLabel("����:",JLabel.RIGHT);
		pnum.setFont(new Font("����", Font.BOLD, 15));
		pnum.setForeground(new Color(243, 88, 27));
		pnum.setBounds(60, 70, 100, 60);

		jpnum = new JTextField(3);
		jpnum.setFont(new Font("����", Font.BOLD, 15));
		jpnum.setText("0");

		delAll = new JButton("ȡ������");
		delAll.setFont(new Font("����", Font.BOLD, 15));
		delAll.setForeground(Color.white);
		delAll.setBackground(new Color(255, 0, 0));
		delAll.setBorderPainted(false);

		confirm_cos= new JButton("ȷ������");
		confirm_cos.setFont(new Font("����", Font.BOLD, 15));
		confirm_cos.setForeground(Color.white);
		confirm_cos.setBackground(new Color(240, 128, 128));
		confirm_cos.setBorderPainted(false);

		j2.add(pnum,BorderLayout.WEST);
		j2.add(jpnum,BorderLayout.CENTER);
		j2.add(confirm_cos,BorderLayout.EAST);

		j1.add(combobox,BorderLayout.WEST);
		j1.add(j2,BorderLayout.CENTER);
		j1.add(delAll,BorderLayout.EAST);

		JLabel j3 = new JLabel("�� �� �� Ʒ",JLabel.CENTER);
		j3.setFont(new Font("����", Font.BOLD, 20));
		j3.setBounds(60, 70, 100, 60);

		topTital.setBackground(Color.white);
		topTital.add(j1, BorderLayout.NORTH);
		topTital.add(j3, BorderLayout.SOUTH);

		order_list = new JPanel();
		order_list.setLayout(new FlowLayout());
		order_list.setPreferredSize(new Dimension(130, 1000));

		JScrollPane js = new JScrollPane(order_list);// ��ӹ�����
		js.setBorder(BorderFactory.createEmptyBorder());

		confirm = new JPanel();
		confirm.setLayout(new BorderLayout());

		note = new JLabel("��ζ��ÿ����Ԫ",JLabel.CENTER);
		note.setFont(new Font("����", Font.BOLD, 15));
		note.setForeground(Color.white);

		count = new JLabel("�� ��: " + countPrice,JLabel.CENTER);
		count.setFont(new Font("����", Font.BOLD, 22));
		
		JPanel nort = new JPanel();
		nort.setLayout(new BorderLayout());
		nort.setBackground(new Color(255, 228, 225));
		nort.add(note, BorderLayout.NORTH);
		nort.add(count, BorderLayout.SOUTH);

		account_btn = new JButton("ȷ �� �� ��");
		account_btn.setFont(new Font("����", Font.BOLD, 22));
		account_btn.setForeground(Color.white);
		account_btn.setBackground(new Color(255, 0, 0));
		account_btn.setBorderPainted(false);

		confirm_btn = new JButton("�� ��");
		confirm_btn.setFont(new Font("����", Font.BOLD, 22));
		confirm_btn.setForeground(Color.white);
		confirm_btn.setBackground(new Color(255, 202, 24));
		confirm_btn.setBorderPainted(false);

		confirm.add(nort, BorderLayout.NORTH);
		confirm.add(confirm_btn, BorderLayout.SOUTH);
		confirm.add(account_btn, BorderLayout.CENTER);

		add(topTital, BorderLayout.NORTH);
		add(confirm, BorderLayout.SOUTH);
		add(js, BorderLayout.CENTER);
	}

	public void setCountPrice(double countPrice) {
		this.countPrice = countPrice;
		count.setText("�� ��: " + countPrice);
	}

}
