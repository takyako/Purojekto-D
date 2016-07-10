package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import lib.Picture;

public class Startbildschirm extends Fenster {
	private static final long serialVersionUID = 1L;

	Picture pnl;
//	JPanel player;
	Dimension d = this.getSize();


	public Startbildschirm() {

		setLayout(new BorderLayout());
		try {
			pnl = new Picture("src/lib/bgroundStart.png");
//			player = new Picture("src/lib/char.png");
			pnl.addCharacter("src/lib/char.png", 50, 50);
		} catch (IOException e) {
			System.out.println("Kein Bild gefunden: " + e.getMessage());
		}

		add(pnl, BorderLayout.CENTER);
//		add(player);
//		player.setSize(166, 200);
//		player.setLocation(10, 10);
		
		
		
		
		
		 repaint();

	}
}
