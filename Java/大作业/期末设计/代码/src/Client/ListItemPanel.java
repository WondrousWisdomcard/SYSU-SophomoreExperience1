package Client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ListItemPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JLabel jname;
	public JButton jprice;
	public JButton jnum;
	public String id;
	public String name;
	public double price;
	public double amount = 0.0;
	public JButton addNum = new JButton("+1"), subNum = new JButton("-1"), delNum = new JButton("撤销"),
			remark = new JButton("添加备注");

	public int num = 1;

	public ListItemPanel(String name, double price, String id) {
		this.id = id;
		this.name = name;
		this.price = price;
		JPanel item_name = new JPanel();
		JPanel item_operation = new JPanel();

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 100));

		item_name.setLayout(new BorderLayout());
		item_name.setPreferredSize(new Dimension(300, 40));
		jname = new JLabel("宋体", JLabel.CENTER);

		jname.setText(name);
		jname.setFont(new Font("宋体", Font.BOLD, 24));
		item_name.add(jname, BorderLayout.WEST);
		item_name.setBackground(new Color(240,230,140));

		item_operation.setLayout(new GridLayout(2,3));
		item_operation.setBackground(Color.white);

		addNum.setFont(new Font("宋体", Font.BOLD, 16));
		addNum.setBorderPainted(false);
		addNum.setForeground(new Color(225, 245, 238));
		addNum.setBackground(new Color(255, 127, 80));

		subNum.setFont(new Font("宋体", Font.BOLD, 16));
		subNum.setBorderPainted(false);
		subNum.setForeground(new Color(225, 245, 238));
		subNum.setBackground(new Color(250, 128, 114));

		delNum.setFont(new Font("宋体", Font.BOLD, 16));
		delNum.setBorderPainted(false);
		delNum.setForeground(new Color(225, 245, 238));
		delNum.setBackground(new Color(225, 69, 0));
		
		setVisible(false);

		remark.setFont(new Font("宋体", Font.BOLD, 14));
		remark.setBorderPainted(false);
		remark.setForeground(new Color(165, 42, 42));
		remark.setBackground(Color.white);
		remark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemarkFrame();
			}
		});

		String Sprice = Double.toString(price);
		String Snum = Integer.toString(num);

		jprice = new JButton(Sprice);
		jprice.setFont(new Font("宋体", Font.BOLD, 14));
		jprice.setBackground(Color.WHITE);
		jprice.setBorderPainted(false);

		JLabel fen = new JLabel("单价 | 份数",JLabel.CENTER);
		fen.setFont(new Font("宋体", Font.BOLD, 14));
		fen.setBackground(Color.WHITE);

		jnum = new JButton(Snum);
		jnum.setFont(new Font("宋体", Font.BOLD, 14));
		jnum.setBackground(Color.WHITE);
		jnum.setBorderPainted(false);

		item_operation.add(jprice);
		item_operation.add(fen);
		item_operation.add(jnum);
		item_operation.add(addNum);
		item_operation.add(subNum);
		item_operation.add(delNum);

		item_name.add(remark, BorderLayout.EAST);

		add(item_name, BorderLayout.NORTH);
		add(item_operation, BorderLayout.CENTER);
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
		jname.setText(name);
	}

	public void setPrice(double price) {
		this.price = price;
		String Sprice = Double.toString(price);
		jprice.setText(Sprice);
	}

	public void setNum(int num) {
		this.num = num;
		String Snum = Integer.toString(num);
		jnum.setText(Snum);
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public String getID() {
		return this.id;
	}

	public double getAmount() {
		double amount = getPrice() * Integer.valueOf(jnum.getText());
		this.amount = amount;
		return amount;
	}
}
