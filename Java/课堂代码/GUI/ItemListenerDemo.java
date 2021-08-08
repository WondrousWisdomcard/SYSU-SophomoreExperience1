package ppt;

import java.awt.*;
import java.awt.event.*;

public class ItemListenerDemo {
    static class MyItemListener implements ItemListener {
        private String[] books, authors;
        private Label author;
        public MyItemListener(String[] books, String[] authors, Label author) {
            this.books = books;
            this.authors = authors;
            this.author = author;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            String item = (String)e.getItem();
            for (int i = 0; i < books.length; ++i)
                if(item.equals(books[i]))
                    author.setText("author: " + authors[i]);
        }
    }
    static class Demo extends Frame {
        private Label author;
        public Demo() {
            setLayout(new FlowLayout());
            Choice choice = new Choice();
            String[] books = {"XiYouJi","SanGuoYanYi","HongLouMeng","ShuiHuZhuan"};
            String[] authors = {"WuChengEn","LuoGuanZhong","CaoXueQin","ShiNaiAn"};
            for(int i = 0;i < 4; ++i)
                choice.add(books[i]);
            author = new Label("author: " + authors[0]);
            this.add(choice);
            this.add(author);
            choice.addItemListener(new MyItemListener(books,authors,author));
            this.setSize(100,100);
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setVisible(true);
    }
}
