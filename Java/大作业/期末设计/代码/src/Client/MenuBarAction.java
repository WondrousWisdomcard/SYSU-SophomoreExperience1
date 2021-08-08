package Client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuBarAction implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(new Color(255,222,173));
	} 

	@Override
	public void focusLost(FocusEvent e) {// 菜单栏按钮事件监听
		JButton btn = (JButton) e.getSource();
		btn.setBackground(new Color(255, 239, 213)); // 番木瓜色
	}
}
