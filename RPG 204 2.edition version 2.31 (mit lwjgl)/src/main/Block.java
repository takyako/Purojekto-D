package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
@Deprecated
public class Block {

	private blockType type;
	private Image img;
	private Shape hitbox;
	@Deprecated
	public Block(blockType type, Image img, Shape hitbox) {
		this.type = type;
		this.img = img;
		this.hitbox = hitbox;
	}

	//test
	@Deprecated
	public Image getImg() {
		return img;
	}
	
	@Deprecated
	public blockType getType() {
		return type;
	}
	@Deprecated
	public Shape getHitbox () {
		return hitbox;
	}
	@Deprecated
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
		
		
		
		tuerZu,
		
		Grundgestein, //meh
		
		
		Moos,
		
		Luft //Nichts (wird im moment nicht benutzt)

	}
	
}
