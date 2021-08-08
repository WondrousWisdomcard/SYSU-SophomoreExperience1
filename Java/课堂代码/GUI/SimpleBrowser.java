import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;

public class SimpleBrowser {
    public static void main(String[] args) throws Exception {

        // html显示组件
        final JEditorPane jep = new JEditorPane();
        jep.setEditable(false);
        // 设置主页
        jep.setContentType("text/html;charset=utf-8");
        try {
            jep.setPage("http://inpluslab.com/java2020");
        } catch (IOException e) {
            jep.setText("<html>Error! Could not load page</html>");
        }
        // 带滑动条的组件 用于存放显示html的jep组件
        JScrollPane scrollpane = new JScrollPane(jep);

        // 输入框 输入URL
        final JTextField jtf = new JTextField(40);
        jtf.setText("http://inpluslab.com/java2020");

        // 按钮
        final JButton goBtn = new JButton("点我访问网页");

        // 上方菜单盒子
        JPanel menuBox = new JPanel();
        menuBox.add(jtf);
        menuBox.add(goBtn);

        // 添加超链接点击事件回调函数 并将JEditorPane的页面改为超链接的页面
        jep.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        jep.setPage(event.getURL());
                    } catch (IOException e) {
                        jep.setText("<html>Error! Could not load page</html>");
                    }
                }
            }
        });

        // 绑定访问按钮点击事件 从JTextField输入框获取URL并且访问
        goBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    jep.setPage(jtf.getText());
                } catch (IOException e1) {
                    jep.setText("<html>Error! Could not load page</html>");
                }
            }
        });

        // 绑定输入框回车按键事件
        jtf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_ENTER) {
                    goBtn.doClick();	// 按下回车等于点击按钮
                }
            }
        });

        JFrame jf = new JFrame("SimpleBrowser");
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setSize(1200, 700);
        jf.add(menuBox, BorderLayout.NORTH);		// 必须设置方位为North才能在上方显示
        jf.add(scrollpane, BorderLayout.CENTER);	// 设置访问为center
        jf.setVisible(true);
    }
}