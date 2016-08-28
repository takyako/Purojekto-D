package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

public class MapManager {

	Map map;
	SpriteSheet sheet;
	
	
	public MapManager(String name) {
		map = new Map(name);
		
	}
	
	
	public Block[][] init() throws SlickException {
		sheet = new SpriteSheet("img/spritesheet.png", 16, 16);
		
		Block[][] block = new Block[100][100];
		
		
		Image steinImg = sheet.getSubImage(1, 1);
		Image steinObenImg = sheet.getSubImage(1, 0);
		Image steinUntenImg = sheet.getSubImage(1, 2);
		Image steinRechteImg = sheet.getSubImage(2, 1);
		Image steinLinksImg = sheet.getSubImage(0, 1);
		Image steinORImg = sheet.getSubImage(2, 0);
		Image steinOLImg = sheet.getSubImage(0, 0);
		Image steinURImg = sheet.getSubImage(2, 2);
		Image steinULImg = sheet.getSubImage(0, 2);
		
		Image steinUREImg = sheet.getSubImage(3, 0);
		Image steinULEImg = sheet.getSubImage(3, 1);
		Image steinOREImg = sheet.getSubImage(4, 0);
		Image steinOLEImg = sheet.getSubImage(4, 1);
		

		
		Image moosImg = sheet.getSubImage(10, 1);

		
		Image luftImg = sheet.getSubImage(10, 0);
		

		
		//jede map müsste 100*100 groß sein. Später das in ner extra Datei (oder so) gespeichert wird wie groß die ist und andere Infos. Oder die größe vllt anders herausfinden
		
		float[] points;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				switch(map.getTile(i, j)) {
				case Stein:
					block[i][j] = new Block(Block.blockType.Stein, steinImg, null);
					break;
					
				case SteinOben:
					block[i][j] = new Block(Block.blockType.SteinOben, steinObenImg, new Rectangle(0+i*32, 0+j*32, 32, 8));
					break;
					
				case SteinUnten:
					block[i][j] = new Block(Block.blockType.SteinUnten, steinUntenImg, new Rectangle(0+i*32, 24+j*32, 32, 8));
					break;
					
				case SteinRechts:
					block[i][j] = new Block(Block.blockType.SteinRechts, steinRechteImg, new Rectangle(24+i*32, 0+j*32, 8, 32));
					break;
					
				case SteinLinks:
					block[i][j] = new Block(Block.blockType.SteinLinks, steinLinksImg, new Rectangle(0+i*32, 0+j*32, 8, 32));
					break;
					
				case SteinOR:
					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 24+i*32, 32+j*32, 24+i*32, 8+j*32, 0+i*32, 8+j*32};
					
//					block[i][j] = new Block(Block.blockType.SteinOR, steinORImg, new Rectangle(24+i*32, 0+j*32, 8, 8));
					block[i][j] = new Block(Block.blockType.SteinOR, steinORImg, new Polygon(points));
					break;
					
				case SteinOL:
					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 8+j*32, 8+i*32, 8+j*32, 8+i*32, 32+j*32, 0+i*32, 32+j*32};
					
					block[i][j] = new Block(Block.blockType.SteinOL, steinOLImg, new Polygon(points));
//					block[i][j] = new Block(Block.blockType.SteinOL, steinOLImg, new Rectangle(0+i*32, 0+j*32, 8, 8));
					break;
					
				case SteinUR:
					points = new float[] {24+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32, 0+i*32, 24+j*32, 24+i*32, 24+j*32};
					
//					block[i][j] = new Block(Block.blockType.SteinUR, steinURImg, new Rectangle(24+i*32, 24+j*32, 8, 8));
					block[i][j] = new Block(Block.blockType.SteinUR, steinURImg, new Polygon(points));
					break;
					
				case SteinUL:
					points = new float[] {0+i*32, 0+j*32, 8+i*32, 0+j*32, 8+i*32, 24+j*32, 32+i*32, 24+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32};
					
//					block[i][j] = new Block(Block.blockType.SteinUL, steinULImg, new Rectangle(0+i*32, 24+j*32, 8, 8));
					block[i][j] = new Block(Block.blockType.SteinUL, steinULImg, new Polygon(points));
					break;
					
				case SteinORE:
					block[i][j] = new Block(Block.blockType.SteinORE, steinOREImg, new Rectangle(0+i*32, 24+j*32, 8, 8));
					break;
					
				case SteinOLE:
					block[i][j] = new Block(Block.blockType.SteinOLE, steinOLEImg, new Rectangle(0+i*32, 0+j*32, 8, 8));
					break;
					
				case SteinURE:
					block[i][j] = new Block(Block.blockType.SteinURE, steinUREImg, new Rectangle(24+i*32, 24+j*32, 8, 8));
					break;
					
				case SteinULE:
					block[i][j] = new Block(Block.blockType.SteinULE, steinULEImg, new Rectangle(24+i*32, 0+j*32, 8, 8));
					break;
					
					
				case Moos:
					block[i][j] = new Block(Block.blockType.Moos, moosImg, null/*new Rectangle(0+i*16, 0+j*16, 16, 16)*/);
					break;
					
				case Luft: //nichts machen. Oder doch. Oder auch nicht. Doch!!!! Sonst Fehler
					block[i][j] = new Block(Block.blockType.Luft, luftImg, null);
					break;
					
					
				default:
					System.out.println("Default im MapManager");
					break;
					
				}
				
				
//				block[i][j] = map.getTile(i, j);				
			}
		}
		return block;
	}
	
}
