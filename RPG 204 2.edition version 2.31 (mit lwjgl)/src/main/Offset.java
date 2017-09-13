package main;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import test.Test;

public class Offset {

	public static enum richtung {
		Up,
		Down,
		Left,
		Right
	}
	
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
	
	private static richtung lastMove = null;
	
	
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
	
	
	
	
	public static void move(richtung direction) {
		switch(direction) {
		case Up:
			moveUp = true;
			lastMove = richtung.Up;
			break;
			
		case Down:
			moveDown = true;
			lastMove = richtung.Down;
			break;
			
		case Left:
			moveLeft = true;
			lastMove = richtung.Left;
			break;
			
		case Right:
			moveRight = true;
			lastMove = richtung.Right;
			break;
		
		}
	}

	
	public static void moveNotMore(richtung direction) {
		switch(direction) {
		case Up:
			moveUp = false;
			break;
			
		case Down:
			moveDown = false;
			break;
			
		case Left:
			moveLeft = false;
			break;
			
		case Right:
			moveRight = false;
		break;
		
		}
	}
	

	public static void tick(int px, int py) {
		Shape playertempoderso = new Rectangle(1200/2/2/2-32+28, 800/2/2/2-32+24, 64/2/2/2, 64/2/2);

		if (!Offset.isMoving()) {
			return;
		}

		boolean canMoveUp = tryMove(playertempoderso, richtung.Up, px, py);
		boolean canMoveDown = tryMove(playertempoderso, richtung.Down, px, py);
		boolean canMoveLeft = tryMove(playertempoderso, richtung.Left, px, py);
		boolean canMoveRight = tryMove(playertempoderso, richtung.Right, px, py);

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
		
		
		pickUpItems(playertempoderso);
		
		
	}

	
	private static void pickUpItems(Shape playertempoderso) {

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				Shape s = Handler.getMap().getItemHitbox(i, j);
				if (s == null) {
					continue;
				}
				
//				Test.addPol(s);
				Test.addPol(playertempoderso);
				
				if (playertempoderso.intersects(s)) {
					
					System.out.println("Item pick up");
					
					
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
	private static boolean tryMove(Shape playertempoderso, richtung direction, int px, int py) {
		
//		Shape playertempoderso = new Rectangle(/*px+*/Player.hitboxX+1, /*py+*/Player.hitboxY+1, Player.hitboxWidth-2, Player.hitboxHeight-2); // TODO später aus der Playerklasse holen
//		Shape playertempoderso = new Rectangle(1200/2/2/2-32+28, 800/2/2/2-32+24, 64/2/2/2, 64/2/2);
		
		if (direction == richtung.Up) {
			playertempoderso.setY(playertempoderso.getY()-upGeschwindigkeit);
			return checkIfHit(playertempoderso);
		} else if (direction == richtung.Down) {
			playertempoderso.setY(playertempoderso.getY()+downGeschwindigkeit);
			return checkIfHit(playertempoderso);
		} else if (direction == richtung.Left) {
			playertempoderso.setX(playertempoderso.getX()-leftGeschwindigkeit);
			return checkIfHit(playertempoderso);
		} else if (direction == richtung.Right) {
			playertempoderso.setX(playertempoderso.getX()+rightGeschwindigkeit);
			return checkIfHit(playertempoderso);
		}
		return true;
	}

	/**
	 * 
	 * @param block
	 * @param playeroderso
	 * @return true wenn man sich dorthin bewegen kann
	 */
	private static boolean checkIfHit(Shape playeroderso) {

		int startx = 0;//((Offset.getX() / 64)-7)*-1;
		int endx = 100;//((Offset.getX() / 64)-9)*-1;
		int starty = 0;//((Offset.getY() / 64)-6)*-1;
		int endy = 100;//((Offset.getY() / 64)-8)*-1;

//		System.out.println(startx + "|" + endx + "|" + starty + "|" + endy);

		for (int i = startx; i < /*Handler.getMap().getHeight()*/ endx; i++) {
			for (int j = starty; j < /*Handler.getMap().getWidth()*/ endy; j++) {
				int tile = Handler.getMap().getTile(i, j);
				if (Handler.getMap().getHitbox(tile) != null) {

					Polygon pol = Handler.getMap().getHitbox(tile);
					if (pol != null) {
						pol = GameWindow.editPol(pol, i, j);

						Test.player = playeroderso;
						if (pol.intersects(playeroderso)) {
							Test.pol = pol;
							return false;
						} else {
							Test.pol = null;
						}
					}
				}
			}
		}
		return true;
	}

	
////////
	
	
	
	public static richtung getLastMove() {
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
	
	public static boolean getMoveRight() {
		return Offset.moveRight;
	}
	
	public static boolean isMoving() {
		if (Offset.moveDown || Offset.moveUp || Offset.moveRight || Offset.moveLeft) {
			return true;
		}
		return false;
	}
	
	
	
	
}
