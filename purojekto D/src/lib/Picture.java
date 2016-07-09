package lib;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Picture extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage bg;


	public Picture(String picture) throws IOException {
		bg = ImageIO.read(new File(picture));
	}


	public Picture(String picture, int width, int height) throws IOException{
		bg = ImageIO.read(new File(picture));
		bg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);

	}

}
