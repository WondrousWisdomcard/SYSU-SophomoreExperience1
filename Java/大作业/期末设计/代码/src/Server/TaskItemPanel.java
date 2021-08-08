package Server;

import java.awt.*;
import javax.swing.*;
import Database.*;

public class TaskItemPanel extends JPanel {

    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JTextArea content = new JTextArea();
    JButton accept = new JButton();
    JButton refuse = new JButton();
    TaskItemPanel(PurchaseCuisines plist) {
        setLayout(new BorderLayout());

        String str = getStrContent(plist);
        //System.out.println(str);

        content.setText(str);
        content.setLineWrap(true);
        //content.setPreferredSize(new Dimension(300, 100));
        content.setFont(new Font("宋体", Font.BOLD, 16));
        content.setBackground(new Color(240, 250, 250));
        content.setEditable(false);

        JScrollPane js = new JScrollPane(content);
        add(js, BorderLayout.NORTH);

        right.setLayout(new BorderLayout());

        accept.setText("接单");
        accept.setFont(new Font("宋体", Font.BOLD, 14));
        accept.setBorderPainted(true);
        accept.setBackground(new Color(0, 225, 127));
        accept.setPreferredSize(new Dimension(150, 50));
        right.add(accept, BorderLayout.EAST);

        refuse.setText("拒绝");
        refuse.setFont(new Font("宋体", Font.BOLD, 14));
        refuse.setBorderPainted(true);
        refuse.setBackground(new Color(255, 69, 0));
        refuse.setPreferredSize(new Dimension(150, 50));
        right.add(refuse, BorderLayout.WEST);

        add(right, BorderLayout.SOUTH);
    }

    String getStrContent(PurchaseCuisines plist) {
        String s = new String();
        for (int i = 0; i < plist.size(); i++) {
            if (plist.get(i).getname() != "") {
                s += (plist.get(i).getname() + " " + plist.get(i).getprice() + "x" + plist.get(i).getnum() + " "
                    + plist.get(i).getAmountPrice()) + "\n";
            }
        }
        return s;
    }
}
