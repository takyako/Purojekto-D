package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	private BufferedImage map;
	
	public Map(String path) {
		try {
			map = ImageIO.read(new File(path));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
//	public something getTile(int x, int y) {
//		
//		map.getRGB(x, y);//TODO switch und return
//		
//	}
	
}
