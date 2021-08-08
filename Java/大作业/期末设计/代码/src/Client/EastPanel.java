package Client;

import java.awt.*;

import javax.swing.*;

public class EastPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JPanel topTital;// 顶部标题
	public JPanel order_list;// 已选订单
	public JPanel confirm;// 确认面板设置为边缘布局
	public JLabel count;// 显示总价
	public JButton confirm_btn;// 点击确认点单
	public JButton confirm_cos;// 点击确认人数
	public JButton account_btn;// 结账
	public JButton delAll;// 取消全部
	public JTextField jpnum;// 人数
	public JLabel note;
	public JComboBox<String> combobox;// 选座
	public double countPrice;

	public EastPanel() {
		setLayout(new BorderLayout());

		topTital = new JPanel();
		topTital.setLayout(new BorderLayout());

		JPanel j1 = new JPanel();// 选择桌号面板
		j1.setLayout(new BorderLayout());
		JPanel j2 = new JPanel();
		j2.setLayout(new BorderLayout(1,3));

		String item[] = { "1号桌", "2号桌", "3号桌", "4号桌", "5号桌", "6号桌", "7号桌", "8号桌" };

		combobox = new JComboBox<String>(item);
		combobox.setFont(new Font("宋体", Font.BOLD, 15));
		combobox.setForeground(new Color(240, 128, 128));
		combobox.setPreferredSize(new Dimension(100, 20));
		combobox.setEditable(true);

		JLabel pnum = new JLabel("人数:",JLabel.RIGHT);
		pnum.setFont(new Font("宋体", Font.BOLD, 15));
		pnum.setForeground(new Color(243, 88, 27));
		pnum.setBounds(60, 70, 100, 60);

		jpnum = new JTextField(3);
		jpnum.setFont(new Font("宋体", Font.BOLD, 15));
		jpnum.setText("0");

		delAll = new JButton("取消订单");
		delAll.setFont(new Font("宋体", Font.BOLD, 15));
		delAll.setForeground(Color.white);
		delAll.setBackground(new Color(255, 0, 0));
		delAll.setBorderPainted(false);

		confirm_cos= new JButton("确定人数");
		confirm_cos.setFont(new Font("宋体", Font.BOLD, 15));
		confirm_cos.setForeground(Color.white);
		confirm_cos.setBackground(new Color(240, 128, 128));
		confirm_cos.setBorderPainted(false);

		j2.add(pnum,BorderLayout.WEST);
		j2.add(jpnum,BorderLayout.CENTER);
		j2.add(confirm_cos,BorderLayout.EAST);

		j1.add(combobox,BorderLayout.WEST);
		j1.add(j2,BorderLayout.CENTER);
		j1.add(delAll,BorderLayout.EAST);

		JLabel j3 = new JLabel("已 点 菜 品",JLabel.CENTER);
		j3.setFont(new Font("宋体", Font.BOLD, 20));
		j3.setBounds(60, 70, 100, 60);

		topTital.setBackground(Color.white);
		topTital.add(j1, BorderLayout.NORTH);
		topTital.add(j3, BorderLayout.SOUTH);

		order_list = new JPanel();
		order_list.setLayout(new FlowLayout());
		order_list.setPreferredSize(new Dimension(130, 1000));

		JScrollPane js = new JScrollPane(order_list);// 添加滚动条
		js.setBorder(BorderFactory.createEmptyBorder());

		confirm = new JPanel();
		confirm.setLayout(new BorderLayout());

		note = new JLabel("茶味费每人六元",JLabel.CENTER);
		note.setFont(new Font("宋体", Font.BOLD, 15));
		note.setForeground(Color.white);

		count = new JLabel("合 计: " + countPrice,JLabel.CENTER);
		count.setFont(new Font("宋体", Font.BOLD, 22));
		
		JPanel nort = new JPanel();
		nort.setLayout(new BorderLayout());
		nort.setBackground(new Color(255, 228, 225));
		nort.add(note, BorderLayout.NORTH);
		nort.add(count, BorderLayout.SOUTH);

		account_btn = new JButton("确 认 订 单");
		account_btn.setFont(new Font("宋体", Font.BOLD, 22));
		account_btn.setForeground(Color.white);
		account_btn.setBackground(new Color(255, 0, 0));
		account_btn.setBorderPainted(false);

		confirm_btn = new JButton("结 账");
		confirm_btn.setFont(new Font("宋体", Font.BOLD, 22));
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
		count.setText("合 计: " + countPrice);
	}

}
