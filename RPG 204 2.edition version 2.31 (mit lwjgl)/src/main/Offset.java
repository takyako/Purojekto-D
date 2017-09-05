package main;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import test.Test;

public class Offset {

	
	public static final String Up = "up"; // kann ich theoretisch als enums machen
	public static final String Down = "down";
	public static final String Left = "left";
	public static final String Right = "right";
	
	
	private static int x;
	private static int y;
	
	
	
	private static boolean moveUp = false;
	private static boolean moveDown = false;
	private static boolean moveRight = false;
	private static boolean moveLeft = false;
	
	
	private static final int maxGeschwindigkeit = 1;
	private static int upGeschwindigkeit = 0;
	private static int rightGeschwindigkeit = 0;
	private static int downGeschwindigkeit = 0;
	private static int leftGeschwindigkeit = 0;
	
	
	private static String lastMove = Down;
	
	
//	public static Block[][] block;

	
	public Offset() {}
	
	
	public static int getX() {
		return x;
	}
	
	public static void addX(int x) {
		Offset.x += x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static void addY(int y) {
		Offset.y += y;
	}
	
	
	
	
	public static void move(String direction) {
		switch(direction) {
		case Offset.Up:
			moveUp = true;
			lastMove = Offset.Up;
			break;
			
		case Offset.Down:
			moveDown = true;
			lastMove = Offset.Down;
			break;
			
		case Offset.Left:
			moveLeft = true;
			lastMove = Offset.Left;
			break;
			
		case Offset.Right:
			moveRight = true;
			lastMove = Offset.Right;
			break;
		
		}
	}

	
	public static void moveNotMore(String direction) {
		switch(direction) {
		case Offset.Up:
			moveUp = false;
			break;
			
		case Offset.Down:
			moveDown = false;
			break;
			
		case Offset.Left:
			moveLeft = false;
			break;
			
		case Offset.Right:
			moveRight = false;
		break;
		
		}
	}
	

	public static void tick(/*Block[][] block,*/ int px, int py) {
		if (Offset.isMoving()) {
for(int f = 0; f < 6; f++) {//weiß nicht ob ich das so machen soll (Habe das so gemacht, damit sich die Figur schneller bewegt)
		
		boolean canMoveUp = tryMove(Offset.Up/*, block*/, px, py);
		boolean canMoveDown = tryMove(Offset.Down/*, block*/, px, py);
		boolean canMoveLeft = tryMove(Offset.Left/*, block*/, px, py);
		boolean canMoveRight = tryMove(Offset.Right/*, block*/, px, py);
		
		if (canMoveUp) {Offset.y += upGeschwindigkeit;}
		if (canMoveDown) {Offset.y -= downGeschwindigkeit;}
		if (canMoveLeft) {Offset.x += leftGeschwindigkeit;}
		if (canMoveRight) {Offset.x -= rightGeschwindigkeit;}


		if (Offset.moveUp) {
			if (upGeschwindigkeit < maxGeschwindigkeit) {
				upGeschwindigkeit++;
			}
		} else if (upGeschwindigkeit > 0) {
			upGeschwindigkeit--;
		}

		if (Offset.moveDown) {
			if (downGeschwindigkeit < maxGeschwindigkeit) {
				downGeschwindigkeit++;
			}
		} else if (downGeschwindigkeit > 0) {
			downGeschwindigkeit--;
		}

		if (Offset.moveRight) {
			if (rightGeschwindigkeit < maxGeschwindigkeit) {
				rightGeschwindigkeit++;
			}
		} else if (rightGeschwindigkeit > 0) {
			rightGeschwindigkeit--;
		}

		if (Offset.moveLeft) {
			if (leftGeschwindigkeit < maxGeschwindigkeit) {
				leftGeschwindigkeit++;
			}
		} else if (leftGeschwindigkeit > 0) {
			leftGeschwindigkeit--;
		}

}
	}
	}



	/**
	 * 
	 * @param direction
	 * @param block
	 * @param px
	 * @param py
	 * @return true wenn man sich dorthin bewegen kann
	 */
	private static boolean tryMove(String direction/*, Block[][] block*/, int px, int py) { //TODO später wieder einbauen
		
//		Shape playertempoderso = new Rectangle(/*px+*/Player.hitboxX+1, /*py+*/Player.hitboxY+1, Player.hitboxWidth-2, Player.hitboxHeight-2); // TODO später aus der Playerklasse holen
		Shape playertempoderso = new Rectangle(1200/2/2/2-32+28, 800/2/2/2-32+24, 64/2/2/2, 64/2/2);
		
		
		if (direction == Offset.Up) {
			playertempoderso.setY(playertempoderso.getY()-upGeschwindigkeit);
			return checkIfHit(/*block,*/ playertempoderso);
		} else if (direction == Offset.Down) {
			playertempoderso.setY(playertempoderso.getY()+downGeschwindigkeit);
			return checkIfHit(/*block,*/ playertempoderso);
		} else if (direction == Offset.Left) {
			playertempoderso.setX(playertempoderso.getX()-leftGeschwindigkeit);
			return checkIfHit(/*block,*/ playertempoderso);
		} else if (direction == Offset.Right) {
			playertempoderso.setX(playertempoderso.getX()+rightGeschwindigkeit);
			return checkIfHit(/*block,*/ playertempoderso);
		}

		return true;
	}

	/**
	 * 
	 * @param block
	 * @param playeroderso
	 * @return true wenn man sich dorthin bewegen kann
	 */
	public static boolean checkIfHit(/*Block[][] block,*/ Shape playeroderso) { //Später wieder einbauen
		
		
		int startx = 0;//((Offset.getX() / 64)-7)*-1;
		int endx = 50;//((Offset.getX() / 64)-9)*-1;
		int starty = 0;//((Offset.getY() / 64)-6)*-1;
		int endy = 50;//((Offset.getY() / 64)-8)*-1;
		
//		System.out.println(startx + "|" + endx + "|" + starty + "|" + endy);
		
		for (int i = startx; i < /*Handler.getMap().getHeight()*/ endx; i++) {
			for (int j = starty; j < /*Handler.getMap().getWidth()*/ endy; j++) {
				if (Handler.getMap().getHitbox(i*16+j) != null) {
	 				int tile = Handler.getMap().getTile(i, j);
					
					tile--;
					
					
						Polygon pol = Handler.getMap().getHitbox(tile);
//						Test.pol = pol;
						if (pol != null) {
							pol = GameWindow.editPol(pol, i, j);
							
							Test.pol = pol;
							Test.player = playeroderso;
							if (pol.intersects(playeroderso)) {
								return false;
							}
						}

				}
			}
		}
		return true;
	}

	
	////////
	
	
	
	public static String getLastMove() {
		return lastMove;
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static boolean getMoveUp() { // Sollte das nicht in den Player
		return Offset.moveUp;
	}
	
	public static boolean getMoveDown() {
		return Offset.moveDown;
	}
	
	public static boolean getMoveLeft() {
		return Offset.moveLeft;
	}
	
	public static boolean getMooveRight() {
		return Offset.moveRight;
	}
	
	public static boolean isMoving() {
		if (Offset.moveDown || Offset.moveUp || Offset.moveRight || Offset.moveLeft) {
			return true;
		}
		return false;
	}
	
	
	
	
}
