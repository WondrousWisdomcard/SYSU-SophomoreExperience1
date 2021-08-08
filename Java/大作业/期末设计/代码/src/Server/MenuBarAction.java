package Server;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuBarAction implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.white);

	}

	@Override
	public void focusLost(FocusEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(new Color(238, 238, 238));

	}// 菜单栏按钮事件监听
}