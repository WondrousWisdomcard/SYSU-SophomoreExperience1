package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class LoginInterface extends JFrame {
	//public static FileWriter ffww;
	public static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		try {
			//ffww =  new FileWriter("src/OurClient/OURCLIENTS.txt");
			new LoginInterface();
		}
		catch(Exception e) {
			System.out.println("Can't build file!");
		}
	}

	public LoginInterface() {
		setTitle("登陆");
		setBounds(450, 300, 580, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(new Color(255, 255, 240));
		c.setLayout(null);// 绝对布局

		JLabel topImg = new JLabel();// 添加图片标签

		Icon icon = new ImageIcon("src/image/login.jpg/");
		topImg.setIcon(icon);
		topImg.setBounds(0, -95, 580, 250);

		JLabel text = new JLabel("账号 ");
		text.setFont(new Font("宋体", Font.BOLD, 16));
		text.setBounds(135, 85, 80, 20);

		JTextField inText = new JTextField(20);
		inText.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inText.setText("");//
		inText.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// 红色
		inText.setBounds(180, 85, 200, 20);

		JLabel psw = new JLabel("密码  ");
		psw.setFont(new Font("宋体", Font.BOLD, 16));
		psw.setBounds(135, 115, 80, 20);

		JPasswordField inPsw = new JPasswordField();
		inPsw.setColumns(20);
		inPsw.setFont(new Font("MS Gothic", Font.BOLD, 16));
		inPsw.setEchoChar('*');// 设置密码显示字符
		inPsw.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// 红色
		inPsw.setBounds(180, 115, 200, 20);

		JButton submit = new JButton("登陆");
		submit.setFont(new Font("宋体", Font.BOLD, 24));
		submit.setBorderPainted(false);
		submit.setBackground(new Color(255, 255, 224));
		submit.setBounds(280, 160, 100, 40);
		
		JButton registion = new JButton("注册");
		registion.setFont(new Font("宋体", Font.BOLD, 24));
		registion.setBorderPainted(false);
		registion.setBackground(new Color(255, 255, 224));
		registion.setBounds(170, 160, 100, 40);

		c.add(topImg);
		c.add(text);
		c.add(inText);
		c.add(psw);
		c.add(inPsw);
		c.add(submit);
		c.add(registion);
		setResizable(false);
		setVisible(true);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User user = new User(new String(inText.getText()),new String(inPsw.getPassword()));
					File file = new File("src\\OurClient\\OURCLIENTS.txt");
					//C:\Users\Administrator\eclipse-workspace\JavaOrderSystem\src\OurClient
					//System.out.println("Read in Client Text");
					List<User> list = new ArrayList<>();
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
					BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
					String line = ""; // 每一行的内容
					/*if (inPsw.getText().equals("admin")) {
						setVisible(false);
						new OperatorInterface();
					} else {
						JOptionPane.showMessageDialog(c, "密码错误");
						inPsw.setText("");
						inPsw.requestFocus();
					}*/
					int i = 1;
					while ((line = br.readLine()) != null) {
		        		String[] split = line.trim().split(" ");// .trim()可以去掉首尾多余的空格
		        		System.out.println(split[0] + " " + split[1]);
		        		list.add(new User(split[0],split[1])); // 添加一个User实体
		        		i++;
		    		}
					if(list.size() == 0) {
						JOptionPane.showMessageDialog(c, "用户不存在");
						inText.setText("");
						inText.requestFocus();
						inPsw.setText("");
						inPsw.requestFocus();
					}
					else {
						int flag = 0;
						for(int m = 0; m < list.size(); m++) {
							User matching = (User)list.get(m);
							//System.out.println(user.registWord+"\n"+user.password);
							//System.out.println(matching.registWord +"\n"+ matching.password);
							if(matching.registWord.equals(user.registWord)) {
								flag = 1;
								if(!matching.password.equals(user.password)) {
									JOptionPane.showMessageDialog(c, "密码错误");
									inText.setText("");
									inText.requestFocus();
									inPsw.setText("");
									inPsw.requestFocus();
								}
								else {
									setVisible(false);
									new OperatorInterface();
								}
							}
						}
						if(flag == 0) {
							JOptionPane.showMessageDialog(c, "用户不存在啊！");
							inText.setText("");
							inText.requestFocus();
							inPsw.setText("");
							inPsw.requestFocus();
						}
					}
					reader.close();
				    br.close();
				}
				catch(Exception w) {
					System.out.println("Read text error!");
				}
				
			}
		});
		registion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistWindow().setVisible(true);
			}
		});
	}

	
}
