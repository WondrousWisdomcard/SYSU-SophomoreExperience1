package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
    private JTextField textField; 
	  
    private void init() {
        textField = new JTextField();   
        textField.setEditable(false);
        textField.setHorizontalAlignment (JTextField.RIGHT);
        textField.setFont(new Font(null, Font.PLAIN, 20));
        
   
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4)); // 4 X 4
        
        Container container = getContentPane();
        container.add(textField, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        
        panel.add(createButton('7'));
        panel.add(createButton('8'));
        panel.add(createButton('9'));
        panel.add(createButton('/'));
        panel.add(createButton('4'));
        panel.add(createButton('5'));
        panel.add(createButton('6'));
        panel.add(createButton('*'));
        panel.add(createButton('1'));
        panel.add(createButton('2'));
        panel.add(createButton('3'));
        panel.add(createButton('-'));
        panel.add(createButton('0'));
        panel.add(createButton('.'));
        panel.add(createButton('='));
        panel.add(createButton('+'));
    }
    
    public JButton createButton (char key) {
    	// 创建按钮
        JButton button = new JButton(String.valueOf(key));
        button.setFont(new Font("粗体", Font.PLAIN, 15));
        
        // 单击时触发
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // 获取目标按钮
            	JButton sourceBtn = (JButton) event.getSource();
                // 获取按钮上的字符
                char bottonKey = sourceBtn.getText().charAt(0);
                // 执行字符对应的操作
                calculatorAction(bottonKey);
            }
        });
        
      return button;
    }
    
    private void calculatorAction(char key) {
        switch(key) {
            case '.':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                String text = textField.getText() + key;
                textField.setText(text);
                break;
            default:
            	break;
        }
    }
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        calculator.setTitle("Calculator");
        calculator.setSize(300, 300);
        calculator.setResizable(false);
        calculator.setLocationRelativeTo(null);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        calculator.init();
        
        // 显示窗口
        calculator.setVisible(true);
    }
}

