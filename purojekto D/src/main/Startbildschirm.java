package main;

import java.awt.BorderLayout;
import java.io.IOException;

import lib.Picture;

public class Startbildschirm extends Fenster {
	private static final long serialVersionUID = 1L;


	public Startbildschirm() {

		setLayout(new BorderLayout());

		try {
			add(new Picture("src/lib/bgroundStart.png"), BorderLayout.CENTER);
		} catch (IOException e) {
			System.out.println("Kein Bild gefunden: " + e.getMessage());
		}
		repaint();

	}
}
