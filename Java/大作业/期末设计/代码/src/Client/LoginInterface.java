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
		setTitle("��½");
		setBounds(450, 300, 580, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(new Color(255, 255, 240));
		c.setLayout(null);// ���Բ���

		JLabel topImg = new JLabel();// ���ͼƬ��ǩ

		Icon icon = new ImageIcon("src/image/login.jpg/");
		topImg.setIcon(icon);
		topImg.setBounds(0, -95, 580, 250);

		JLabel text = new JLabel("�˺� ");
		text.setFont(new Font("����", Font.BOLD, 16));
		text.setBounds(135, 85, 80, 20);

		JTextField inText = new JTextField(20);
		inText.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inText.setText("");//
		inText.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// ��ɫ
		inText.setBounds(180, 85, 200, 20);

		JLabel psw = new JLabel("����  ");
		psw.setFont(new Font("����", Font.BOLD, 16));
		psw.setBounds(135, 115, 80, 20);

		JPasswordField inPsw = new JPasswordField();
		inPsw.setColumns(20);
		inPsw.setFont(new Font("MS Gothic", Font.BOLD, 16));
		inPsw.setEchoChar('*');// ����������ʾ�ַ�
		inPsw.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// ��ɫ
		inPsw.setBounds(180, 115, 200, 20);

		JButton submit = new JButton("��½");
		submit.setFont(new Font("����", Font.BOLD, 24));
		submit.setBorderPainted(false);
		submit.setBackground(new Color(255, 255, 224));
		submit.setBounds(280, 160, 100, 40);
		
		JButton registion = new JButton("ע��");
		registion.setFont(new Font("����", Font.BOLD, 24));
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
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // ����һ������������reader
					BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
					String line = ""; // ÿһ�е�����
					/*if (inPsw.getText().equals("admin")) {
						setVisible(false);
						new OperatorInterface();
					} else {
						JOptionPane.showMessageDialog(c, "�������");
						inPsw.setText("");
						inPsw.requestFocus();
					}*/
					int i = 1;
					while ((line = br.readLine()) != null) {
		        		String[] split = line.trim().split(" ");// .trim()����ȥ����β����Ŀո�
		        		System.out.println(split[0] + " " + split[1]);
		        		list.add(new User(split[0],split[1])); // ���һ��Userʵ��
		        		i++;
		    		}
					if(list.size() == 0) {
						JOptionPane.showMessageDialog(c, "�û�������");
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
									JOptionPane.showMessageDialog(c, "�������");
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
							JOptionPane.showMessageDialog(c, "�û������ڰ���");
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
