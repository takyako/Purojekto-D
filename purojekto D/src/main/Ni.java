package main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lib.BilderLaden;

public class Ni 
{
	public Ni()
	{
		JFrame fenster = new Ichi();
		
		hintergrundPanel pnl = new hintergrundPanel();
		fenster.setLayout(new BorderLayout());
		fenster.add(pnl, BorderLayout.CENTER);
	}
	
	
	public class hintergrundPanel extends JPanel{
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			BufferedImage img = BilderLaden.laden("lib/bground.png");
			
//			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			
		}
		
	}
	
	
	public static void main (String [] args ) {
		new Ni();
		
		
	}
	
}
