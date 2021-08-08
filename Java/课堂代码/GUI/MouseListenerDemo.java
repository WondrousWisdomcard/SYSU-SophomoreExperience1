package ppt;

import java.awt.*;
import java.awt.event.*;

public class MouseListenerDemo {
    static class MyMouseListener implements MouseListener {
        private Canvas canvas;
        public MyMouseListener(Canvas canvas) {
            this.canvas = canvas;
        }
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) {
            this.canvas.setBackground(Color.blue);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            this.canvas.setBackground(Color.red);
        }
    }
    static class Demo extends Frame {
        public Demo() {
            this.setLayout(new FlowLayout());
            Canvas canvas = new Canvas();
            canvas.setBackground(Color.red);
            canvas.addMouseListener(new MyMouseListener(canvas));
            canvas.setSize(80,50);
            this.add(canvas);
            this.setSize(100,100);
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setVisible(true);
    }
}
