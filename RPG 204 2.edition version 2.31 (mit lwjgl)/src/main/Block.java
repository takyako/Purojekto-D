package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class Block {

	private blockType type;
	private Image img;
	private Shape hitbox;
	
	public Block(blockType type, Image img, Shape hitbox) {
		this.type = type;
		this.img = img;
		this.hitbox = hitbox;
	}

	
	
	public Image getImg() {
		return img;
	}
	
	
	public blockType getType() {
		return type;
	}
	
	public Shape getHitbox () {
		return hitbox;
	}
	
	public enum blockType{
		
		Stein,
		SteinOben,
		SteinUnten,
		SteinRechts,
		SteinLinks,
		SteinOR,
		SteinOL,
		SteinUR,
		SteinUL,
		SteinORE,
		SteinOLE,
		SteinURE,
		SteinULE,
		
		
		Moos,
		
		Luft //Nichts

	}
	
}
