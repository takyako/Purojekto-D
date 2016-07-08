package main;

import javax.swing.*;
import java.awt.event.*;

public class Anmeldefenster extends Fenster implements ActionListener {
	private static final long serialVersionUID = 1L;

	static JButton btn;
	static JButton btn2;


	public Anmeldefenster() {

		btn = new JButton("Anmelden");
		btn.addActionListener(this);
		add(btn, "cell 2 3");

		btn2 = new JButton("Registrieren");
		btn2.addActionListener(this);
		add(btn2, "cell 2 4");

		pack();
		repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn) {
			new Anmeldung(this);

		}
		if (e.getSource() == btn2) {
			new Registrierung();
		}

	}
}
