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
	WestPanel wp = new WestPanel(); // 菜系列表
	EastPanel ep = new EastPanel(); // 客户订单接收
	public TaskItemPanel[] orderForm = new TaskItemPanel[30];

	int sign = -1; // 拒绝或者接受信号
	int enable = 0;
	int orderNum = 1000;

	private List<MyChannel> all = new ArrayList<MyChannel>();// 通道链表，其中一个通道对应连接了一个客户
	public PurchaseCuisines pcc = new PurchaseCuisines();

	
	public static void main(String[] args) throws IOException {
		ServerOperatorInterface a = new ServerOperatorInterface();
		a.start();
	}

	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9876);// 定义服务端
		while (true) {// 不断监听是否有连接请求
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			if (!all.contains(channel)) {
				all.add(channel);
				new Thread(channel).start(); // 一条道路
			}
		}
	}

	/**
	 * 一个客户一条道路 建立服务器与客户端之间的数据通道
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

		// 接收客户端的信息
		private boolean receive() throws ClassNotFoundException {
			try {
				pcc = (PurchaseCuisines) ois.readObject();
				if (!pcc.isEmpty()) {
					System.out.println("New Cuisine");
					
					if(orderForm[0] != null && orderForm[0].accept.isEnabled()){
						JDialog result4 = new JDialog();
								result4.setTitle("火锅点餐管理系统");
								result4.setBounds(600, 400, 350, 100);
								result4.setLayout(new FlowLayout(1));
								JLabel k4 = new JLabel();
								k4.setFont(new Font("宋体", Font.BOLD, 20));
								k4.setText("您有未处理订单!");
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

		// 向客户端发送信息
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
		orderForm[0].accept.setText("接单失败");
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
		
		ep.order_list.add(orderForm[0]);// 将任务加入右框
		ep.order_list.setVisible(false);
		ep.order_list.setVisible(true);

		orderForm[0].refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderForm[0].refuse.setText("已拒绝");
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
					result2.setTitle("火锅点餐管理系统");
					result2.setBounds(600, 400, 350, 100);
					result2.setLayout(new FlowLayout(1));
					JLabel k2 = new JLabel();
					k2.setFont(new Font("宋体", Font.BOLD, 20));
					k2.setText(name + "库存不足");
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

				orderForm[0].accept.setText("已接单");
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
		setTitle("后台管理");

		Container c = getContentPane();
		c.setLayout(new BorderLayout());// 边缘布局

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
			String j = (String) iter0.next();// 对每个菜系页面的具体菜品的展示按钮添加监听
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
		for (int i = 0; i < wp.getComponentCount(); i++)// 对左栏的按钮添加动作监听
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
			if (jb.getText().equals("   锅 底 类   "))
				card.show(jp, "a0");
			else if (jb.getText().equals("   荤 菜 类   "))
				card.show(jp, "a1");
			else if (jb.getText().equals("   素 菜 类   "))
				card.show(jp, "a2");
			else if (jb.getText().equals("   小 吃 类   "))
				card.show(jp, "a3");
			else if (jb.getText().equals("   酒 水 类   "))
				card.show(jp, "a4");
			else if (jb.getText().equals("   主 食 类   "))
				card.show(jp, "a5");
		}
	}

}
