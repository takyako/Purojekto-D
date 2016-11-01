package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	private static int health;
	private static int exp;
	private static int strength;
	private static SpriteSheet playerSheet = null;
	
	public Player() {}
	
	public static void initPlayer() throws SlickException {
		//TODO später
		playerSheet = new SpriteSheet("img/peopleSprite.png", 16, 16);
	}
	
	
	public static Image getTile(int x, int y) {
		return playerSheet.getSubImage(x, y);
	}
	
	
	
	
}
