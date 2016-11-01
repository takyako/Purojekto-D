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
		SteinORE, //oben rechts ecke
		SteinOLE,
		SteinURE,
		SteinULE,
		SteinLOZ, //links, oben zu
		SteinLUZ,
		SteinROZ,
		SteinRUZ,
		SteinORZ,
		SteinOLZ,
		SteinURZ,
		SteinULZ,
		SteinORA, //oben rechts alternativ
		SteinOLA,
		SteinURA,
		SteinULA,
		
		Grundgestein, //meh
		
		
		Moos,
		
		Luft //Nichts (wird im moment nicht benutzt)

	}
	
}
