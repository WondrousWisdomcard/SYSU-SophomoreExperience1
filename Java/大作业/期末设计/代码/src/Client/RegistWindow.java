package Client;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RegistWindow extends JFrame{
	public RegistWindow() {
		setTitle("注册");
		setBounds(450, 350, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(new Color(255, 255, 240));
		c.setLayout(null);// 绝对布局

		JLabel registWord = new JLabel("新账号");
		registWord.setFont(new Font("宋体", Font.BOLD, 16));
		registWord.setBounds(75, 85, 80, 20);
		
		JTextField inText = new JTextField(20);
		inText.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inText.setText("");//
		inText.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// 红色
		inText.setBounds(180, 85, 200, 20);
		
		JLabel Password = new JLabel("密码");
		Password.setFont(new Font("宋体", Font.BOLD, 16));
		Password.setBounds(75, 115, 80, 20);
		
		JPasswordField inTextCode = new JPasswordField(20);
		inTextCode.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inTextCode.setText("");//
		inTextCode.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// 红色
		inTextCode.setBounds(180, 115, 200, 20);
		
		JLabel CorrectPassword = new JLabel("确认密码");
		CorrectPassword.setFont(new Font("宋体", Font.BOLD, 16));
		CorrectPassword.setBounds(75, 145, 80, 20);
		
		JPasswordField inTextCodeCorrect = new JPasswordField(20);
		inTextCodeCorrect.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inTextCodeCorrect.setText("");//
		inTextCodeCorrect.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// 红色
		inTextCodeCorrect.setBounds(180, 145, 200, 20);
		
		JButton registion = new JButton("确认");
		registion.setFont(new Font("宋体", Font.BOLD, 20));
		registion.setBorderPainted(false);
		registion.setBackground(new Color(255, 255, 224));
		registion.setBounds(200, 180, 80, 60);
		
		registion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String aixing_a=new String(inTextCode.getPassword());
				String aixingwuyue_b=new String(inTextCodeCorrect.getPassword());
				//System.out.println(aixing_a + "\n" + aixingwuyue_b);
				String admin = new String(inText.getText());
				if(admin.equals("")) {
					JOptionPane.showMessageDialog(c, "用户名不能为空");
					inTextCode.setText("");
					inTextCode.requestFocus();
					inTextCodeCorrect.setText("");
					inTextCodeCorrect.requestFocus();
					inText.setText("");
					inText.requestFocus();
				}
				else if(aixing_a.equals("")) {
					JOptionPane.showMessageDialog(c, "密码不能为空");
					inTextCode.setText("");
					inTextCode.requestFocus();
					inTextCodeCorrect.setText("");
					inTextCodeCorrect.requestFocus();
					inText.setText("");
					inText.requestFocus();
				}
				else if(!aixing_a.equals(aixingwuyue_b)) {
					JOptionPane.showMessageDialog(c, "密码校验错误");
					inTextCode.setText("");
					inTextCode.requestFocus();
					inTextCodeCorrect.setText("");
					inTextCodeCorrect.requestFocus();
					inText.setText("");
					inText.requestFocus();
				}
				else {
					try {
						User user = new User(new String(inText.getText()),new String(inTextCode.getPassword()));
						//System.out.println("Before File");
						File file = new File("src\\OurClient\\OURCLIENTS.txt");
						// System.out.println(file.getAbsolutePath());
						// System.out.println("in Client Text");
						List<User> list = new ArrayList<>();
						InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
						//System.out.println("in Client Text");
						BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
						String line = ""; // 每一行的内容
						int i = 1;
						//System.out.println("Before while");
				    	while ((line = br.readLine()) != null) {
				        	String[] split = line.trim().split(" ");// .trim()可以去掉首尾多余的空格
				        	System.out.println(split[0] + "\n" + split[1]);
				        	list.add(new User(split[0],split[1])); // 添加一个User实体
				        	i++;
				    	}
				    	System.out.println("Before");
				    	if(list.size() == 0) {
				    	    FileOutputStream fos = new FileOutputStream(file);
				    	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
				    	    writer.write(user.toString() + "\n");
				    	    //System.out.println("Write to text:"+user.toString()+"\n");
				    	    JOptionPane.showMessageDialog(c, "注册成功");
				    	    //line = br.readLine();
				    	    //System.out.println("Line 0:"+line);
				    	    writer.close();
				    	    fos.close();
				    	    setVisible(false);
				    	}
				    	else {
				    		int flag = 0;
				    		for(int m = 0; m < list.size(); m++) {
				    			User matching = (User)list.get(m);
				    			if(matching.registWord == user.registWord) {
				    				flag = 1;
				    				JOptionPane.showMessageDialog(c, "用户名已存在");
									inTextCode.setText("");
									inTextCode.requestFocus();
									inTextCodeCorrect.setText("");
									inTextCodeCorrect.requestFocus();
									inText.setText("");
									inText.requestFocus();
				    			}
				    		}
				    		if(flag == 0) {
				    			FileOutputStream fos = new FileOutputStream(file);
					    	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
					    	    for(int temp = 0; temp < list.size(); temp++) {
					    	    	User u = (User)list.get(temp);
					    	    	writer.write(u.toString()+"\n");
					    	    }
					    	    writer.write(user.toString() + "\n");
					    	    //System.out.println(user.toString());
					    	    writer.close();
					    	    fos.close();
					    	    JOptionPane.showMessageDialog(c, "注册成功");
					    	    setVisible(false);
				    		}
				    	}
				    	reader.close();
				        br.close();
				    }
				    //catch(Exception w) {
				    	//System.out.println("Read client file error!");
				    //}
					catch(FileNotFoundException f){
				    	System.out.println("File not found!");
				    }
				    catch(IOException w) {
				    	System.out.println("IOException happens!");
				    }
				}
			}
		});
		
		c.add(registWord);
		c.add(inText);
		c.add(Password);
		c.add(inTextCode);
		c.add(CorrectPassword);
		c.add(inTextCodeCorrect);
		c.add(registion);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String args[]) {
		new RegistWindow().setVisible(true);
	}
}
