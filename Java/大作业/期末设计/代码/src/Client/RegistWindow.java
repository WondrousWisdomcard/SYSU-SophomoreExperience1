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
		setTitle("ע��");
		setBounds(450, 350, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(new Color(255, 255, 240));
		c.setLayout(null);// ���Բ���

		JLabel registWord = new JLabel("���˺�");
		registWord.setFont(new Font("����", Font.BOLD, 16));
		registWord.setBounds(75, 85, 80, 20);
		
		JTextField inText = new JTextField(20);
		inText.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inText.setText("");//
		inText.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// ��ɫ
		inText.setBounds(180, 85, 200, 20);
		
		JLabel Password = new JLabel("����");
		Password.setFont(new Font("����", Font.BOLD, 16));
		Password.setBounds(75, 115, 80, 20);
		
		JPasswordField inTextCode = new JPasswordField(20);
		inTextCode.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inTextCode.setText("");//
		inTextCode.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// ��ɫ
		inTextCode.setBounds(180, 115, 200, 20);
		
		JLabel CorrectPassword = new JLabel("ȷ������");
		CorrectPassword.setFont(new Font("����", Font.BOLD, 16));
		CorrectPassword.setBounds(75, 145, 80, 20);
		
		JPasswordField inTextCodeCorrect = new JPasswordField(20);
		inTextCodeCorrect.setFont(new Font("MS Gothic", Font.BOLD, 20));
		inTextCodeCorrect.setText("");//
		inTextCodeCorrect.setBorder(BorderFactory.createLineBorder(new Color(255, 202, 24)));// ��ɫ
		inTextCodeCorrect.setBounds(180, 145, 200, 20);
		
		JButton registion = new JButton("ȷ��");
		registion.setFont(new Font("����", Font.BOLD, 20));
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
					JOptionPane.showMessageDialog(c, "�û�������Ϊ��");
					inTextCode.setText("");
					inTextCode.requestFocus();
					inTextCodeCorrect.setText("");
					inTextCodeCorrect.requestFocus();
					inText.setText("");
					inText.requestFocus();
				}
				else if(aixing_a.equals("")) {
					JOptionPane.showMessageDialog(c, "���벻��Ϊ��");
					inTextCode.setText("");
					inTextCode.requestFocus();
					inTextCodeCorrect.setText("");
					inTextCodeCorrect.requestFocus();
					inText.setText("");
					inText.requestFocus();
				}
				else if(!aixing_a.equals(aixingwuyue_b)) {
					JOptionPane.showMessageDialog(c, "����У�����");
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
						InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // ����һ������������reader
						//System.out.println("in Client Text");
						BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
						String line = ""; // ÿһ�е�����
						int i = 1;
						//System.out.println("Before while");
				    	while ((line = br.readLine()) != null) {
				        	String[] split = line.trim().split(" ");// .trim()����ȥ����β����Ŀո�
				        	System.out.println(split[0] + "\n" + split[1]);
				        	list.add(new User(split[0],split[1])); // ���һ��Userʵ��
				        	i++;
				    	}
				    	System.out.println("Before");
				    	if(list.size() == 0) {
				    	    FileOutputStream fos = new FileOutputStream(file);
				    	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
				    	    writer.write(user.toString() + "\n");
				    	    //System.out.println("Write to text:"+user.toString()+"\n");
				    	    JOptionPane.showMessageDialog(c, "ע��ɹ�");
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
				    				JOptionPane.showMessageDialog(c, "�û����Ѵ���");
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
					    	    JOptionPane.showMessageDialog(c, "ע��ɹ�");
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
