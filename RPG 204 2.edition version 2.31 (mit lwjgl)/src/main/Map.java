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
	 * @param width
	 * @param height
	 * @return blockType
	 */
	public blockType getTile(int x, int y) {
		int tile = map.getRGB(x, y);
		
		switch (tile & 0xFFFFFF) {
		case 0x00FF00:
			return Block.blockType.Moos;//Oder so
		case 0x606060:
			return Block.blockType.Stein;
		case 0x506060:
			return Block.blockType.SteinOben;
		case 0x706060:
			return Block.blockType.SteinUnten;
		case 0x605060:
			return Block.blockType.SteinLinks;
		case 0x607060:
			return Block.blockType.SteinRechts;
		case 0x606050:
			return Block.blockType.SteinOR;
		case 0x606040:
			return Block.blockType.SteinOL;
		case 0x606070:
			return Block.blockType.SteinUR;
		case 0x606080:
			return Block.blockType.SteinUL;
		case 0x756060:
			return Block.blockType.SteinORE;
		case 0x856060:
			return Block.blockType.SteinOLE;
		case 0x456060:
			return Block.blockType.SteinURE;
		case 0x556060:
			return Block.blockType.SteinULE;
		}
		
		return Block.blockType.Luft;
	}
	
}
