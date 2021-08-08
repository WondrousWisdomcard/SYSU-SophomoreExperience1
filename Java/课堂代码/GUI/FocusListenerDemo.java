package ppt;

import java.awt.*;
import java.awt.event.*;

public class FocusListenerDemo {
    static class myFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            TextField textField = (TextField)e.getSource();
            textField.setBackground(Color.GREEN);
        }
        @Override
        public void focusLost(FocusEvent e) {
            TextField textField = (TextField)e.getSource();
            textField.setBackground(Color.RED);
        }
    }

    static class Demo extends Frame {
        public Demo() {
            this.setLayout(new FlowLayout());
            TextField textField1 = new TextField();
            TextField textField2 = new TextField();
            textField1.setColumns(15);
            textField2.setColumns(15);
            this.add(textField1);
            this.add(textField2);
            textField1.addFocusListener(new myFocusListener());
            textField2.addFocusListener(new myFocusListener());
            this.setSize(200,100);
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setVisible(true);
    }
}
