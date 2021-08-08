package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.Iterator;
import javax.swing.*;
import Database.*;

public class OperatorInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	public Warehouse wh = new Warehouse();
	public CenterPanel cp = new CenterPanel(wh);
	public TopPanel tp = new TopPanel();
	public WestPanel wp = new WestPanel();
	public EastPanel ep = new EastPanel();
	public ListItemPanel[] orderForm = new ListItemPanel[30];// �㵥�б�
	public double countPrice = 0.0;// �ܼ�
	public PurchaseCuisines pcc = new PurchaseCuisines();// �ѹ����Ʒ����
	public int num = 0;// ������ʼֵ

	public static void main(String[] args) throws UnknownHostException, IOException {
		new OperatorInterface();
	}// end main


	public OperatorInterface() {
		setBounds(180, 10, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("���");

		Container c = getContentPane();
		c.setLayout(new BorderLayout());// ��Ե����

		for (int i = 0; i < orderForm.length; i++) {// ��Ӳ˵���Ʒ

			orderForm[i] = new ListItemPanel("��", 0.0, "01");
			orderForm[i].addNum.addActionListener(new ChangeCuiNumberListener(i));
			orderForm[i].delNum.addActionListener(new ChangeCuiNumberListener(i));
			orderForm[i].subNum.addActionListener(new ChangeCuiNumberListener(i));

			ep.order_list.add(orderForm[i]);// ��������ϵĵ����ѵ��Ʒ����뵽

		}

		ep.delAll.addActionListener(new DeletionListener(0));// ����0ʱ�����ȫ����ѡ��Ʒ

		ep.confirm_cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num2 = ep.jpnum.getText().equals("") ? 0 : Integer.valueOf(ep.jpnum.getText());
				if (num2 < 0) {
					num2 = 0;
					ep.jpnum.setText("0");
				}
				countPrice += (num2 - num) * 6;
				ep.setCountPrice(countPrice);
				num = num2;
			}
		});

		String[] s = new String[10];
		s[0] = "pot_bottom";
		s[1] = "meat";
		s[2] = "vegetable";
		s[3] = "snack";
		s[4] = "drink";
		s[5] = "staplefood";

		Iterator<String> iter0 = wh.get(s[0]).keySet().iterator();// ��ȡ��ز�ϵ�Ĳ�Ʒid
		Iterator<String> iter1 = wh.get(s[1]).keySet().iterator();
		Iterator<String> iter2 = wh.get(s[2]).keySet().iterator();
		Iterator<String> iter3 = wh.get(s[3]).keySet().iterator();
		Iterator<String> iter4 = wh.get(s[4]).keySet().iterator();
		Iterator<String> iter5 = wh.get(s[5]).keySet().iterator();

		Cuisine cuisine;

		for (int i = 0; i < cp.j0.size; i++) {
			String j = (String) iter0.next();// ��ÿ����ϵҳ��ľ����Ʒ��չʾ��ť��Ӽ���
			cuisine = wh.get(s[0]).get(j);
			cp.j0.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j0.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}
		for (int i = 0; i < cp.j1.size; i++) {
			String j = (String) iter1.next();
			cuisine = wh.get(s[1]).get(j);
			cp.j1.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j1.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}
		for (int i = 0; i < cp.j2.size; i++) {
			String j = (String) iter2.next();
			cuisine = wh.get(s[2]).get(j);
			cp.j2.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j2.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}
		for (int i = 0; i < cp.j3.size; i++) {
			String j = (String) iter3.next();
			cuisine = wh.get(s[3]).get(j);
			cp.j3.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j3.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}
		for (int i = 0; i < cp.j4.size; i++) {
			String j = (String) iter4.next();
			cuisine = wh.get(s[4]).get(j);
			cp.j4.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j4.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}
		for (int i = 0; i < cp.j5.size; i++) {
			String j = (String) iter5.next();
			cuisine = wh.get(s[5]).get(j);
			cp.j5.mip[i].imgBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
			cp.j5.mip[i].textBtn
					.addActionListener(new ImgAction(cuisine.getname(), cuisine.getprice(), cuisine.getID()));
		}

		for (int i = 0; i < wp.getComponentCount(); i++) {
			wp.btns[i].addActionListener(new PageTurnListener(cp.card, cp));
		}

		ep.confirm_btn.addActionListener(new DeletionListener(1));
		// ep.confirm_btn.setEnabled(false);

		JScrollPane jsCP = new JScrollPane(cp);
		jsCP.setBorder(BorderFactory.createEmptyBorder());
		c.add(jsCP, BorderLayout.CENTER);
		c.add(tp, BorderLayout.NORTH);
		c.add(wp, BorderLayout.WEST);
		c.add(ep, BorderLayout.EAST);

		setVisible(true);

		netCheck();

		// ȷ �� �� ��
		ep.account_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ep.account_btn.setEnabled(false);
				char a = ep.jpnum.getText().charAt(0);
				int t, count = 0;
				for (t = 0; t < orderForm.length; t++) {
					if (orderForm[t].isVisible() != false)
						count++;
				}
				if (count == 0 || Integer.valueOf(ep.jpnum.getText()) == 0 || Character.isDigit(a) == false)// ��δ��ͣ�����δ��д����д�쳣ʱ�׳��쳣
				{
					JDialog result = new JDialog();
					result.setTitle("������ϵͳ");
					result.setBounds(600, 400, 350, 100);
					result.setLayout(new FlowLayout(1));
					JLabel k = new JLabel();
					k.setFont(new Font("����", Font.BOLD, 20));
					k.setText("����δ�㵥," + '\n' + "���ò�������д�쳣��");
					result.add(k);
					result.setVisible(true);
					// ep.account_btn.setEnabled(true);
					return;
				}
				pcc = new PurchaseCuisines();
				for (int j = 0; j < orderForm.length; j++) {
					if (orderForm[j].isVisible() != false)
						pcc.add(new HasCuisine(orderForm[j].name, orderForm[j].num, orderForm[j].price));
				}
				newConnect();
			}
		});


	}

	public PurchaseCuisines getMessage() {
		return pcc;
	}

	public void start() {
	}

	public void newConnect() {
		InetAddress host = null;
		Socket client = null;
		try {
			host = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		try {
			client = new Socket(host.getHostName(), 9876);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String name = client.getLocalAddress().toString() + ":" + client.getLocalPort();
		System.out.println(name);

		// ep.delAll.setEnabled(false);
		// ep.confirm_btn.setEnabled(true);
		// �ͻ��˷���
		new Thread(new Send(client, getMessage())).start();
		// �ͻ��˽���
		Receive rec = new Receive(client);
		new Thread(rec).start();

		/*
		 * while(true){ System.out.println(rec.getResult()); if(rec.getResult() == 1){
		 * System.out.println("'SURE!"); ep.account_btn.setEnabled(false); //ȷ�϶���
		 * ep.confirm_btn.setEnabled(true); //���� ep.delAll.setEnabled(false); break; }
		 * else if(rec.getResult() == 0){ System.out.println("NONONO!");
		 * ep.account_btn.setEnabled(true); //ȷ�϶��� ep.confirm_btn.setEnabled(false);
		 * //���� ep.delAll.setEnabled(true); break; } }
		 */
	}

	public void netCheck(){
		InetAddress host = null;
		Socket client = null;
		try {
			host = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		try {
			client = new Socket(host.getHostName(), 9876);
		} catch (IOException e1) {
			e1.printStackTrace();
			JDialog result = new JDialog();
			result.setModal(true);
			result.setTitle("������ϵͳ - �������Ӽ��");
			result.setBounds(600, 400, 350, 100);
			result.setLayout(new FlowLayout(1));
			JLabel k = new JLabel();
			k.setFont(new Font("����", Font.BOLD, 24));
			k.setText("�������");
			result.add(k);
			result.setVisible(true);
			
		}
	}

	class ImgAction implements ActionListener {
		public String name;
		public double price;
		public String id;

		public ImgAction(String name, double price, String id) {
			this.name = name;
			this.price = price;
			this.id = id;
		}

		public void actionPerformed(ActionEvent e) {
			int i, sign = 0;
			for (i = 0; i < orderForm.length; i++) {
				if (orderForm[i].isVisible() && orderForm[i].getName().equals(name)) {
					orderForm[i].num++;
					String Snum = Integer.toString(orderForm[i].num);
					orderForm[i].jnum.setText(Snum);
					countPrice += orderForm[i].price;
					ep.setCountPrice(countPrice);
					sign = 1;
				}
			}
			if (sign == 0) {
				for (i = 0;; i++) {
					if (!orderForm[i].isVisible())
						break;
				}
				orderForm[i].setVisible(true);
				orderForm[i].setName(name);
				orderForm[i].setPrice(price);
				orderForm[i].setID(id);
				orderForm[i].setNum(1);
				countPrice += orderForm[i].getAmount();// ��̬�任
				ep.setCountPrice(countPrice);
			}
		}
	}

	class ChangeCuiNumberListener implements ActionListener {
		// ���Ե��Ʒ�ĵ�������ϵ���ɾ��
		public int i;// ���������

		public ChangeCuiNumberListener(int i) {
			this.i = i;
		}

		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			if (btn.getText().equals("+1")) {
				orderForm[i].num++;

				String Snum = Integer.toString(orderForm[i].num);
				orderForm[i].jnum.setText(Snum);
				countPrice += orderForm[i].price;
			}
			if (btn.getText().equals("-1")) {
				orderForm[i].num--;

				String Snum = Integer.toString(orderForm[i].num);
				orderForm[i].jnum.setText(Snum);
				countPrice -= orderForm[i].price;

				if (orderForm[i].num < 1) {
					orderForm[i].setVisible(false);
				}
			}
			if (btn.getText().equals("����")) {
				countPrice -= orderForm[i].price * orderForm[i].num;
				orderForm[i].setNum(1);
				orderForm[i].setName("��");
				orderForm[i].setPrice(0.0);
				orderForm[i].id = "000";
				orderForm[i].amount = 0.0;
				orderForm[i].setVisible(false);
			}
			ep.setCountPrice(countPrice);// ���ղ˵��۸�
		}
	}

	class DeletionListener implements ActionListener {
		// ȡ�����е㵥,���������Ϊ1ʱ ����
		public int i;

		public DeletionListener(int i) {
			this.i = i;
			ep.jpnum.setText("0");
		}

		public void actionPerformed(ActionEvent e) {
			if (i == 1) {
				// ep.account_btn.setEnabled(true);
				// ep.delAll.setEnabled(true);
				pcc.printFile(Integer.valueOf(ep.jpnum.getText()), countPrice);
				pcc.setString();

				for (int i = 0; i < orderForm.length; i++) {
					orderForm[i].setVisible(false);
					orderForm[i].id = "000";
					orderForm[i].setPrice(0.0);
					orderForm[i].setName("��");
					orderForm[i].setNum(1);
				}
				ep.setCountPrice(0.0);
				ep.jpnum.setText("0");
				countPrice = 0.0;
				num = 0;
				pcc = new PurchaseCuisines();

				JDialog result2 = new JDialog();
				result2.setTitle("������ϵͳ");
				result2.setBounds(600, 400, 350, 100);
				result2.setLayout(new FlowLayout(1));
				JLabel k2 = new JLabel();
				k2.setFont(new Font("����", Font.BOLD, 20));
				k2.setText("�ѽ���");
				result2.add(k2);
				result2.setVisible(true);
				// ep.confirm_btn.setEnabled(false);

			} else {
				for (int i = 0; i < orderForm.length; i++) {
					orderForm[i].setVisible(false);
					orderForm[i].id = "000";
					orderForm[i].setPrice(0.0);
					orderForm[i].setName("��");
					orderForm[i].setNum(1);
				}
				ep.setCountPrice(0.0);
				ep.jpnum.setText("0");
				countPrice = 0.0;
				num = 0;
			}
		}// end if
	}// end ActionPerformed

}
