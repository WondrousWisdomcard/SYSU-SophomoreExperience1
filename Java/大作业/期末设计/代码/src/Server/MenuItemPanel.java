package Server;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuItemPanel extends JPanel {

    public JButton textBtn = new JButton();
    public JPanel Inner2 = new JPanel();
    public JButton confirmBtn = new JButton();
    public JTextField capacityTxt = new JTextField(4);

    public int capacity; //库存

    public MenuItemPanel(String id, String name, int cap) {

        this.capacity = cap;

        setLayout(new BorderLayout());
        Inner2.setLayout(new GridLayout(1, 2));
        textBtn.setText(id + " " + name + " 剩余:");
        textBtn.setFont(new Font("宋体", Font.BOLD, 15));
        textBtn.setBorderPainted(false);
        textBtn.setBackground(new Color(230, 250, 250));
        textBtn.setPreferredSize(new Dimension(210, 70));

        capacityTxt.setText(cap + "");
        capacityTxt.setFont(new Font("宋体", Font.BOLD, 15));
        capacityTxt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                confirmBtn.setBackground(new Color(255,182,193));
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        confirmBtn.setText("确认");
        confirmBtn.setBackground(new Color(230, 250, 250));
        confirmBtn.setFont(new Font("宋体", Font.BOLD, 15));
        confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                capacity = capacityTxt.getText().equals("") ? 0 : Integer.valueOf(capacityTxt.getText());
                capacityTxt.setText(capacity + "");

                //把cap存回去

                confirmBtn.setBackground(new Color(230, 250, 250));
            } 
        });

        Inner2.add(capacityTxt);
        Inner2.add(confirmBtn);
        Inner2.setPreferredSize(new Dimension(180, 70));
        add(textBtn, BorderLayout.WEST);
        add(Inner2, BorderLayout.EAST);

    }
}
