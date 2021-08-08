package Client;
import java.awt.*;
import javax.swing.*;

public class MenuItemPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton imgBtn = new JButton();
	JButton textBtn = new JButton();

	MenuItemPanel(String id, String name, double price, String address) {
		setLayout(new BorderLayout());

		ImageIcon icontemp = new ImageIcon(new ImageIcon(address).getImage());
		int w = icontemp.getIconWidth();
		int h = icontemp.getIconHeight();

		ImageIcon icon = new ImageIcon(
				new ImageIcon(address).getImage().getScaledInstance(200, 200 * h / w, Image.SCALE_SMOOTH));

		imgBtn.setIcon(icon);
		imgBtn.setBorderPainted(false);
		imgBtn.setBackground(new Color(255, 218, 185));

		textBtn.setText(id + "    " + name + "    " + price + "Ôª");
		textBtn.setFont(new Font("ËÎÌå", Font.BOLD, 15));
		textBtn.setBorderPainted(false);
		textBtn.setBackground(new Color(255, 160, 122));

		add(imgBtn, BorderLayout.NORTH);
		add(textBtn, BorderLayout.CENTER);
	}
}
