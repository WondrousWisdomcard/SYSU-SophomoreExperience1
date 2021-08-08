package Client;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PageTurnListener implements ActionListener {

    public CardLayout card;
    public JPanel jp;

    public PageTurnListener(CardLayout card, JPanel jp) {
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