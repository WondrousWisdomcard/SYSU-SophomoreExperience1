package ppt;

import java.awt.*;
import java.awt.event.*;

public class KeyListenerDemo {
    static class myKeyListener implements KeyListener {
        private Label[] labels;
        private int currentIndex;
        public myKeyListener(Label[] labels) {
            this.labels = labels;
            this.currentIndex = -1;
        }
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            int index = -1;
            int[] keyCode = {KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_UP};
            for (int i = 0; i < 4; ++i)
                if (e.getKeyCode() == keyCode[i])
                    index = i;
            if (index != -1) {
                if (currentIndex != -1)
                    labels[currentIndex].setForeground(Color.BLACK);
                currentIndex = index;
                labels[currentIndex].setForeground(Color.red);
            }
        }
    }
    static class Window extends Frame {
        private Label[] labels;
        public Window() {
            this.setLayout(new BorderLayout());
            String[] directions = {BorderLayout.WEST, BorderLayout.EAST, BorderLayout.SOUTH, BorderLayout.NORTH};
            labels = new Label[4];
            for(int i = 0;i < 4; ++i) {
                labels[i] = new Label(directions[i],Label.CENTER);
                this.add(labels[i], directions[i]);
            }
            this.addKeyListener(new myKeyListener(labels));
            this.setSize(200,150);
        }
    }
    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
    }
}
