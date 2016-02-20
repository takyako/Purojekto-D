package lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BilderLaden {
	
	public static BufferedImage laden(String pfad) {
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(pfad));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return img;
	}

}
