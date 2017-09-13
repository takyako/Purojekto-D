package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.Log;

public class ItemManager {

	private static SpriteSheet itemSheet;
	
	private int anzahl; //Anzahl an Items pro Zeile/Spalte
	
	

	
	public ItemManager() {
		init();
	}
	
	
	
	private void init() {
		try {
			itemSheet = new SpriteSheet("img/Items.png", 16, 16);
		} catch (SlickException ex) {
			Log.error(ex);
		}
		
		
		
		anzahl = itemSheet.getHorizontalCount();
		
	}
	
	
	
	
	////////////////////getter/setter

	/**
	 * 0->erstes Feld(nichts), 1->zweites Feld, usw.
	 * @param id
	 * @return subImage der ID
	 */
	public Image getItemPicture(int id) { 
		
		int x = id / anzahl;
		int y = id % anzahl;
		
		return itemSheet.getSubImage(y, x);
	}
	
	public int getAnzahl() {
		return this.anzahl;
	}
	
	
}
