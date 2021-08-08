import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextReader extends JFrame {
	
	private static final long serialVersionUID = 1L;

	TextReader(){
		super("Simple TXT Reader");
		
		setLayout(new BorderLayout());
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		//1. The initial size of the window is (800,600)
		setSize(new Dimension(800,600));
		
		JMenu u = new JMenu("文件");
		JMenuItem m1,m2,m3;
		
		//2. Text can be wrapped automatically
		//3. Text is not writable but readable only
		JTextArea text = new JTextArea();
		text.setEditable(false);
		
		m1 = new JMenuItem("打开");
		m2 = new JMenuItem("关闭");
		m3 = new JMenuItem("退出");
		
		//6. The menu item “关闭” is enabled only when a file is open
		m2.setEnabled(false);
		
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				//8. The default path of file chooser is the current path where program executes
				String userDirLocation = System.getProperty("user.dir");
				File userDir = new File(userDirLocation);
				
				JFileChooser jfc = new JFileChooser(userDir);
					
				//7. Only files with suffix “.txt” can be chosen to read
				jfc.setFileFilter(new FileNameExtensionFilter("*.txt","txt"));
				jfc.showOpenDialog(text);
					
				/*
				 jfc.setFileFilter(new javax.swing.filechooser.FileFilter(){
					  public boolean accept(File f) {
						    return f.getName().endsWith(".txt");
						  } 
						  public String getDescription(){
						    return "*.txt";
						  }
					}); 
				 */
				File file = jfc.getSelectedFile();
				
				try {
					BufferedReader in = new BufferedReader(new FileReader(file));
					
					String str = new String();
					String tmpstr;
					
					while ((tmpstr = in.readLine()) != null) {
					    str += tmpstr;
					    str += '\n';
					}
					text.setLineWrap(true);
					text.setText(str);

					in.close();
				} catch (FileNotFoundException e1) { 
					e1.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				m2.setEnabled(true);
			}
		});
		
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				//6. The menu item “关闭” is enabled only when a file is open
				m2.setEnabled(false);
			}
		});
		
		m3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		
		//4. Only vertical scroll bar, no horizontal scroll bar
		JScrollPane jsp = new JScrollPane(text);
		
		u.add(m1);
		u.add(m2);
		//5. A separating line is between the menu item “关闭” and “退出”
		u.addSeparator();
		u.add(m3);
		
		mb.add(u);
		
		add(jsp);
	}
	
	
	public static void main(String[] args) {
		new TextReader().setVisible(true);
	}
}
