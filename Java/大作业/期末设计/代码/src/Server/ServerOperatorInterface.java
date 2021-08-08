package Server;

import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import Database.*;

public class ServerOperatorInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	Warehouse wh = new Warehouse();
	CenterPanel cp = new CenterPanel(wh);
	TopPanel tp = new TopPanel();
	WestPanel wp = new WestPanel(); // ��ϵ�б�
	EastPanel ep = new EastPanel(); // �ͻ���������
	public TaskItemPanel[] orderForm = new TaskItemPanel[30];

	int sign = -1; // �ܾ����߽����ź�
	int enable = 0;
	int orderNum = 1000;

	private List<MyChannel> all = new ArrayList<MyChannel>();// ͨ����������һ��ͨ����Ӧ������һ���ͻ�
	public PurchaseCuisines pcc = new PurchaseCuisines();

	
	public static void main(String[] args) throws IOException {
		ServerOperatorInterface a = new ServerOperatorInterface();
		a.start();
	}

	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9876);// ��������
		while (true) {// ���ϼ����Ƿ�����������
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			if (!all.contains(channel)) {
				all.add(channel);
				new Thread(channel).start(); // һ����·
			}
		}
	}

	/**
	 * һ���ͻ�һ����· ������������ͻ���֮�������ͨ��
	 */
	private class MyChannel implements Runnable {

		private ObjectOutputStream oos;
		private ObjectInputStream ois;

		public MyChannel(Socket client) {
			try {
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// ���տͻ��˵���Ϣ
		private boolean receive() throws ClassNotFoundException {
			try {
				pcc = (PurchaseCuisines) ois.readObject();
				if (!pcc.isEmpty()) {
					System.out.println("New Cuisine");
					
					if(orderForm[0] != null && orderForm[0].accept.isEnabled()){
						JDialog result4 = new JDialog();
								result4.setTitle("�����͹���ϵͳ");
								result4.setBounds(600, 400, 350, 100);
								result4.setLayout(new FlowLayout(1));
								JLabel k4 = new JLabel();
								k4.setFont(new Font("����", Font.BOLD, 20));
								k4.setText("����δ������!");
								result4.add(k4);
								result4.setVisible(true);
								while(orderForm[0].accept.isEnabled());
					}

					newTask(pcc);
					ep.setNum(ep.getNum()+1);
					return true;
				} else {
					return false;
				}
			} catch (IOException e) {
				//e.printStackTrace();
			}
			return false;
		}

		// ��ͻ��˷�����Ϣ
		private void send(String msg) {
			try {
				oos.writeObject(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					boolean i = receive();
					while (i) {
						if (enable == 1) {
							if (sign == 1) {
								System.out.println("Server Reaction: YES");
								send("Y" + orderNum);
								enable = 0;
								sign = -1;
								orderNum++;
								break;
							} 
							else if (sign == 0) {
								System.out.println("Server Reaction: NO");
								send("N" + orderNum);
								enable = 0;
								sign = -1;
								orderNum++;
								break;
							}
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void underStockAction() {
		orderForm[0].accept.setText("�ӵ�ʧ��");
		orderForm[0].refuse.setBackground(new Color(255, 192, 203));
		orderForm[0].refuse.setText("");
		orderForm[0].accept.setBackground(new Color(255, 192, 203));
		orderForm[0].accept.setEnabled(false);
		orderForm[0].refuse.setEnabled(false);
		sign = 0;
		enable = 1;
	}

	public void newTask(PurchaseCuisines plist) {

		orderForm[0] = new TaskItemPanel(plist);
		
		ep.order_list.add(orderForm[0]);// ����������ҿ�
		ep.order_list.setVisible(false);
		ep.order_list.setVisible(true);

		orderForm[0].refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderForm[0].refuse.setText("�Ѿܾ�");
				orderForm[0].refuse.setBackground(new Color(255, 255, 240));
				orderForm[0].accept.setText("");
				orderForm[0].accept.setBackground(new Color(255, 255, 240));
				orderForm[0].accept.setEnabled(false);
				orderForm[0].refuse.setEnabled(false);
				sign = 0;
				enable = 1;
			}
		});
		orderForm[0].accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int k = 0; k < plist.size(); k++) {
					Iterator<String> iter0 = wh.get("pot_bottom").keySet().iterator();
					Iterator<String> iter1 = wh.get("meat").keySet().iterator();
					Iterator<String> iter2 = wh.get("vegetable").keySet().iterator();
					Iterator<String> iter3 = wh.get("snack").keySet().iterator();
					Iterator<String> iter4 = wh.get("drink").keySet().iterator();
					Iterator<String> iter5 = wh.get("staplefood").keySet().iterator();

					String name = plist.get(k).getname();
					int num = plist.get(k).getnum();
					Cuisine cuisine;

					JDialog result2 = new JDialog();
					result2.setTitle("�����͹���ϵͳ");
					result2.setBounds(600, 400, 350, 100);
					result2.setLayout(new FlowLayout(1));
					JLabel k2 = new JLabel();
					k2.setFont(new Font("����", Font.BOLD, 20));
					k2.setText(name + "��治��");
					result2.add(k2);
					result2.setVisible(false);

					for (int i = 0; i < cp.j0.size; i++) {
						String j = (String) iter0.next();
						cuisine = wh.get("pot_bottom").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j0.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}

					for (int i = 0; i < cp.j1.size; i++) {
						String j = (String) iter1.next();
						cuisine = wh.get("meat").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j1.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}
					for (int i = 0; i < cp.j2.size; i++) {
						String j = (String) iter2.next();
						cuisine = wh.get("vegetable").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j2.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}
					for (int i = 0; i < cp.j3.size; i++) {
						String j = (String) iter3.next();
						cuisine = wh.get("snack").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j3.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}
					for (int i = 0; i < cp.j4.size; i++) {
						String j = (String) iter4.next();
						cuisine = wh.get("drink").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j4.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}
					for (int i = 0; i < cp.j5.size; i++) {
						String j = (String) iter5.next();
						cuisine = wh.get("staplefood").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j5.mip[i].capacity - num;
							if (n < 0) {
								result2.setVisible(true);
								underStockAction();
								return;
							}
						}
					}
				}

				for (int k = 0; k < plist.size(); k++) {

					Iterator<String> iter0 = wh.get("pot_bottom").keySet().iterator();
					Iterator<String> iter1 = wh.get("meat").keySet().iterator();
					Iterator<String> iter2 = wh.get("vegetable").keySet().iterator();
					Iterator<String> iter3 = wh.get("snack").keySet().iterator();
					Iterator<String> iter4 = wh.get("drink").keySet().iterator();
					Iterator<String> iter5 = wh.get("staplefood").keySet().iterator();

					String name = plist.get(k).getname();
					int num = plist.get(k).getnum();

					Cuisine cuisine;

					for (int i = 0; i < cp.j0.size; i++) {
						String j = (String) iter0.next();
						cuisine = wh.get("pot_bottom").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j0.mip[i].capacity - num;
							if (n >= 0) {
								cp.j0.mip[i].capacity = n;
								cp.j0.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
					for (int i = 0; i < cp.j1.size; i++) {
						String j = (String) iter1.next();
						cuisine = wh.get("meat").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j1.mip[i].capacity - num;
							if (n >= 0) {
								cp.j1.mip[i].capacity = n;
								cp.j1.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
					for (int i = 0; i < cp.j2.size; i++) {
						String j = (String) iter2.next();
						cuisine = wh.get("vegetable").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j2.mip[i].capacity - num;
							if (n >= 0) {
								cp.j2.mip[i].capacity = n;
								cp.j2.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
					for (int i = 0; i < cp.j3.size; i++) {
						String j = (String) iter3.next();
						cuisine = wh.get("snack").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j3.mip[i].capacity - num;
							if (n >= 0) {
								cp.j3.mip[i].capacity = n;
								cp.j3.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
					for (int i = 0; i < cp.j4.size; i++) {
						String j = (String) iter4.next();
						cuisine = wh.get("drink").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j4.mip[i].capacity - num;
							if (n >= 0) {
								cp.j4.mip[i].capacity = n;
								cp.j4.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
					for (int i = 0; i < cp.j5.size; i++) {
						String j = (String) iter5.next();
						cuisine = wh.get("staplefood").get(j);
						String name2 = cuisine.getname();
						if (name2.equals(name)) {
							int n = cp.j5.mip[i].capacity - num;
							if (n >= 0) {
								cp.j5.mip[i].capacity = n;
								cp.j5.mip[i].capacityTxt.setText(n + "");
							}
						}
					}
				}

				orderForm[0].accept.setText("�ѽӵ�");
				orderForm[0].accept.setBackground(new Color(255, 255, 240));
				orderForm[0].refuse.setBackground(new Color(255, 255, 240));
				orderForm[0].refuse.setText("");
				orderForm[0].accept.setEnabled(false);
				orderForm[0].refuse.setEnabled(false);

				sign = 1;
				enable = 1;
			}
		});

	}

	public ServerOperatorInterface() {
		setBounds(180, 10, 1050, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("��̨����");

		Container c = getContentPane();
		c.setLayout(new BorderLayout());// ��Ե����

		String[] s = new String[10];
		s[0] = "pot_bottom";
		s[1] = "meat";
		s[2] = "vegetable";
		s[3] = "snack";
		s[4] = "drink";
		s[5] = "staplefood";

		Iterator<String> iter0 = wh.get(s[0]).keySet().iterator();
		Iterator<String> iter1 = wh.get(s[1]).keySet().iterator();
		Iterator<String> iter2 = wh.get(s[2]).keySet().iterator();
		Iterator<String> iter3 = wh.get(s[3]).keySet().iterator();
		Iterator<String> iter4 = wh.get(s[4]).keySet().iterator();
		Iterator<String> iter5 = wh.get(s[5]).keySet().iterator();

		Cuisine cuisine;

		for (int i = 0; i < cp.j0.size; i++) {
			String j = (String) iter0.next();// ��ÿ����ϵҳ��ľ����Ʒ��չʾ��ť��Ӽ���
			cuisine = wh.get(s[0]).get(j);
		}
		for (int i = 0; i < cp.j1.size; i++) {
			String j = (String) iter1.next();
			cuisine = wh.get(s[1]).get(j);
		}
		for (int i = 0; i < cp.j2.size; i++) {
			String j = (String) iter2.next();
			cuisine = wh.get(s[2]).get(j);
		}
		for (int i = 0; i < cp.j3.size; i++) {
			String j = (String) iter3.next();
			cuisine = wh.get(s[3]).get(j);
		}
		for (int i = 0; i < cp.j4.size; i++) {
			String j = (String) iter4.next();
			cuisine = wh.get(s[4]).get(j);
		}
		for (int i = 0; i < cp.j5.size; i++) {
			String j = (String) iter5.next();
			cuisine = wh.get(s[5]).get(j);
		}
		for (int i = 0; i < wp.getComponentCount(); i++)// �������İ�ť��Ӷ�������
		{
			wp.btns[i].addActionListener(new MyTurnPageActionListener(cp.card, cp));
		}

		JScrollPane jsCP = new JScrollPane(cp);
		jsCP.setBorder(BorderFactory.createEmptyBorder());
		c.add(jsCP, BorderLayout.CENTER);
		c.add(tp, BorderLayout.NORTH);
		c.add(wp, BorderLayout.WEST);
		c.add(ep, BorderLayout.EAST);
		setVisible(true);
	}

	class MyTurnPageActionListener implements ActionListener {
		CardLayout card;
		JPanel jp;

		MyTurnPageActionListener(CardLayout card, JPanel jp) {
			this.card = card;
			this.jp = jp;
		}

		public void actionPerformed(ActionEvent e) {

			JButton jb = (JButton) e.getSource();
			if (jb.getText().equals("   �� �� ��   "))
				card.show(jp, "a0");
			else if (jb.getText().equals("   �� �� ��   "))
				card.show(jp, "a1");
			else if (jb.getText().equals("   �� �� ��   "))
				card.show(jp, "a2");
			else if (jb.getText().equals("   С �� ��   "))
				card.show(jp, "a3");
			else if (jb.getText().equals("   �� ˮ ��   "))
				card.show(jp, "a4");
			else if (jb.getText().equals("   �� ʳ ��   "))
				card.show(jp, "a5");
		}
	}

}
