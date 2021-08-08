package Client;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class Receive implements Runnable {
    // ������
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

    // ��������
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
        result2.setTitle("������ϵͳ");
        result2.setBounds(600, 400, 350, 100);
        result2.setLayout(new FlowLayout(1));
        JLabel k2 = new JLabel();
        k2.setFont(new Font("����", Font.BOLD, 20));
        k2.setText("�ȴ���̨��Ӧ ...");
        result2.add(k2);
        result2.setVisible(true);

        while (true) {
            try {
                String mes = receive();
                String orderNumNow = mes.substring(2);

                if (mes.charAt(0) == 'Y' && orderNumNow != orderNum) {
                    // ������
                    result2.setTitle("������ϵͳ �㵥��" + mes);
                    k2.setText("�㵥�ɹ���");
                    result2.setVisible(true);
                    System.out.println(mes);
                    orderNum = orderNumNow;
                    result = 1;
                    break;

                } else if (mes.charAt(0) == 'N' && orderNumNow != orderNum) {
                    // ������
                    result2.setTitle("������ϵͳ �㵥��" + mes);
                    k2.setText("�㵥ʧ�ܣ����Ժ�����");
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
