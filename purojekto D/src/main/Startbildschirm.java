package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import lib.Picture;

public class Startbildschirm extends Fenster {
	private static final long serialVersionUID = 1L;

	JPanel pnl;
	Dimension d = this.getSize();


	public Startbildschirm() {

		setLayout(new BorderLayout());
		try {
			pnl = new Picture("src/lib/bgroundStart.png");
		} catch (IOException e) {
			System.out.println("Kein Bild gefunden: " + e.getMessage());
		}

		add(pnl, BorderLayout.CENTER);

		 repaint();

	}
}
