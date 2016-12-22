package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.Log;

public class Inventar {

	private boolean isInventarOpen = false;
	private SpriteSheet inventarTestSheet;
	private Items[][] content;
	private int inventarSize = 6;
	
	
	
	public Inventar() {
		init();
	}
	
	
	private void init() {
		try {
			inventarTestSheet = new SpriteSheet("img/Inventar.png", 96+1, 96+1);
		} catch (SlickException ex) {
//			ex.printStackTrace();
			Log.error(ex);
		}
		
		
		//content intiialisieren
		content = new Items[inventarSize][inventarSize];
		
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				content[i][j] = new Items(); 
			}
		}
		
	}
	
	
	
	public void showInventar() {
		isInventarOpen = !isInventarOpen;
	}
	 	
	
	
	
	
	
	////////////////////getter/setter
	
	public Image getInventarPicture() {
		return inventarTestSheet.getSubImage(0, 0);
	}
	
	public boolean isInventarOpen() {
		return isInventarOpen;
	}
	
	/**
	 * 
	 * @param id
	 * @param menge
	 * @return false wenn nicht möglich, da das Inventar voll ist
	 */
	public boolean putItemIn(int id, int menge) {
		int[] i = getNextFreeItemSlot();
		
		if (i != null) {
			content[i[0]][i[1]].putItemIn(id, menge);
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public int getID(int x, int y) {
		return content[x][y].getID();
	}
	
	public int getMenge(int x, int y) {
		return content[x][y].getMenge();
	}
	
	public int getInventarSize() {
		return inventarSize;
	}
	
	
	/////////////////////////////////
	
	
	/**
	 * Gibt den nexten freien Itemslot zurück
	 * @return null wenn kein freier Slot vorhanden ist
	 */
	private int[] getNextFreeItemSlot() {
		
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				if (content[j][i].getID() == 0) {
					return new int[] {j, i};
				}
			}
		}
		return null;
	}
	
	
	
	
}