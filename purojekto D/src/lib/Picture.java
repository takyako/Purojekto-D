package lib;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Picture  {
	
	private static BufferedImage bg ;
	private static JPanel panel ;
	private static Graphics g ;
	
	public static JPanel get(String picture) {
		
		 try {
		        bg = ImageIO.read(new File(picture));
		    } 
		 catch (IOException e) {
		    }
		    
		 	g = bg.getGraphics() ;
		    panel = new JPanel(){
				private static final long serialVersionUID = 1L;

			@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(Picture.g);
	                g.drawImage(bg, this.getWidth() , this.getHeight(), this);
	            }
			};
			
			return panel ;
	        
		
		
	}

}
