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
	 * Gibt den definierte Pixel der Map zur�ck
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
			
		
		case 0x606960:
			return Block.blockType.SteinRUZ;
		case 0x607D60:
			return Block.blockType.SteinROZ;
		case 0x605F60:
			return Block.blockType.SteinLUZ;
		case 0x604B60:
			return Block.blockType.SteinLOZ;
		case 0x4B6060:
			return Block.blockType.SteinORZ;
		case 0x5F6060:
			return Block.blockType.SteinOLZ;
		case 0x7D6060:
			return Block.blockType.SteinURZ;
		case 0x696060:
			return Block.blockType.SteinULZ;

		case 0x5F5F50:
			return Block.blockType.SteinORA;
		case 0x5F5F70:
			return Block.blockType.SteinURA;
		case 0x5F5F80:
			return Block.blockType.SteinULA;
		case 0x5F5F40:
			return Block.blockType.SteinOLA;
			
			
		}
		
//		return Block.blockType.Luft;
		return Block.blockType.Grundgestein;
	}
	
}
