package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Block.blockType;

public class Map {
	
	private BufferedImage map;
	
	public Map(String name) {
		try {
			
			map = ImageIO.read(Map.class.getResource(name));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Gibt den definierte Pixel der Map zurück
	 * @param x
	 * @param y
	 * @return blockType
	 */
	public blockType getTile(int x, int y) {
		int tile = map.getRGB(x, y);
		
		switch (tile & 0xFFFFFF) {
		case 0x00FF00:
			return Block.blockType.Moos;//Oder so
			
		case 0x141400:
			return Block.blockType.Stein;
			
		case 0x140A00:
			return Block.blockType.SteinOben;
		case 0x141E00:
			return Block.blockType.SteinUnten;
		case 0x0A1400:
			return Block.blockType.SteinLinks;
		case 0x1E1400:
			return Block.blockType.SteinRechts;
			
		case 0x1E0A00:
			return Block.blockType.SteinOR;
		case 0x0A0A00:
			return Block.blockType.SteinOL;
		case 0x1E1E00:
			return Block.blockType.SteinUR;
		case 0x0A1E00:
			return Block.blockType.SteinUL;
			
		case 0x281400:
			return Block.blockType.SteinORE;
		case 0x321400:
			return Block.blockType.SteinOLE;
		case 0x280A00:
			return Block.blockType.SteinURE;
		case 0x320A00:
			return Block.blockType.SteinULE;
			
		
		case 0x461400:
			return Block.blockType.SteinRUZ;
		case 0x460A00:
			return Block.blockType.SteinROZ;
		case 0x3C1400:
			return Block.blockType.SteinLUZ;
		case 0x3C0A00:
			return Block.blockType.SteinLOZ;
		case 0x5A0A00:
			return Block.blockType.SteinORZ;
		case 0x500A00:
			return Block.blockType.SteinOLZ;
		case 0x5A1400:
			return Block.blockType.SteinURZ;
		case 0x501400:
			return Block.blockType.SteinULZ;

		case 0x282800:
			return Block.blockType.SteinORA;
		case 0x281E00:
			return Block.blockType.SteinURA;
		case 0x321E00:
			return Block.blockType.SteinULA;
		case 0x322800:
			return Block.blockType.SteinOLA;
			
			
			
			
		case 0x0A6400:
			return Block.blockType.tuerZu;
			
			
			
		}
		
//		return Block.blockType.Luft;
		return Block.blockType.Grundgestein;
	}
	
}
