package Client;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class Receive implements Runnable {
    // 输入流
    public String orderNum = "X";
    private ObjectInputStream ois = null;
    private int result = -1;

    public Receive(Socket client) {
        try {
            ois = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getResult() {
        return result;
    }

    // 接收数据
    public String receive() throws ClassNotFoundException {
        String msg = "";
        try {
            msg = (String) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public void run() {

        JDialog result2 = new JDialog();
        result2.setTitle("火锅点餐系统");
        result2.setBounds(600, 400, 350, 100);
        result2.setLayout(new FlowLayout(1));
        JLabel k2 = new JLabel();
        k2.setFont(new Font("宋体", Font.BOLD, 20));
        k2.setText("等待后台响应 ...");
        result2.add(k2);
        result2.setVisible(true);

        while (true) {
            try {
                String mes = receive();
                String orderNumNow = mes.substring(2);

                if (mes.charAt(0) == 'Y' && orderNumNow != orderNum) {
                    // 弹出框
                    result2.setTitle("火锅点餐系统 点单号" + mes);
                    k2.setText("点单成功！");
                    result2.setVisible(true);
                    System.out.println(mes);
                    orderNum = orderNumNow;
                    result = 1;
                    break;

                } else if (mes.charAt(0) == 'N' && orderNumNow != orderNum) {
                    // 弹出框
                    result2.setTitle("火锅点餐系统 点单号" + mes);
                    k2.setText("点单失败，请稍后重试");
                    result2.setVisible(true);
                    System.out.println(mes);
                    orderNum = orderNumNow;
                    result = 0;
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
