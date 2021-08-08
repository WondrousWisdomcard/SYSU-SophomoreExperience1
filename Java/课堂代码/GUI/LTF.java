package GUI;

import java.awt.*;
import java.awt.event.*;

class LTF extends Frame {

	LTF() {
		super("Example: Label & TextField");

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setResizable(false);
		add(new Label("Cannot edit!"));

		final TextField tf = new TextField("Edit me!", 37);

		tf.addTextListener(new TextListener() {

			public void textValueChanged(TextEvent te) {
				System.out.println(te.paramString());
			}
		});
		add(tf);
		setSize(400, 100);
	}

	public static void main(String[] args) {
		new LTF().setVisible(true);
	}

}