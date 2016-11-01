package main;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Offset {

	
	public static final String Up = "up";
	public static final String Down = "down";
	public static final String Left = "left";
	public static final String Right = "right";
	
	
	//TODO später alles wieder private machen
	
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
	
	
	public static Block[][] block;

	
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
	

	public static void tick(Block[][] block, int px, int py) {
for(int f = 0; f < 6; f++) {//weiß nicht ob ich das so machen soll
		
		boolean canMoveUp = tryMove(Offset.Up, block, px, py);
		boolean canMoveDown = tryMove(Offset.Down, block, px, py);
		boolean canMoveLeft = tryMove(Offset.Left, block, px, py);
		boolean canMoveRight = tryMove(Offset.Right, block, px, py);
		
		if (canMoveUp) {Offset.y += upGeschwindigkeit;}
		if (canMoveDown) {Offset.y -= downGeschwindigkeit;}
		if (canMoveLeft) {Offset.x += leftGeschwindigkeit;}
		if (canMoveRight) {Offset.x -= rightGeschwindigkeit;}
		
		
//		if ( !canMoveUp) {	//hatte eigentlich ein smoothes bewegen vor, aber dann will das mit den Hitboxen nichit so wirklich. Muss später mal gucken
//			upGeschwindigkeit = 0;
//		} else {
			if (Offset.moveUp) {
				if (upGeschwindigkeit < maxGeschwindigkeit) {
					upGeschwindigkeit++;
				}
			} else if (upGeschwindigkeit > 0) {
				upGeschwindigkeit--;
			}
//		}


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



	/**
	 * 
	 * @param direction
	 * @param block
	 * @param px
	 * @param py
	 * @return true wenn man sich dorthin bewegen kann
	 */
	private static boolean tryMove(String direction, Block[][] block, int px, int py) {
		
		Shape playeroderso = new Rectangle(px+1, py+1, 32-2, 32-2);	//ist das so OK? Achja, der bekommt ja eh noch ne eigene Klasse

		
		if (direction == Offset.Up) {
			playeroderso.setY(playeroderso.getY()-upGeschwindigkeit);
			return checkIfHit(block, playeroderso);
		} else if (direction == Offset.Down) {
			playeroderso.setY(playeroderso.getY()+downGeschwindigkeit);
			return checkIfHit(block, playeroderso);
		} else if (direction == Offset.Left) {
			playeroderso.setX(playeroderso.getX()-leftGeschwindigkeit);
			return checkIfHit(block, playeroderso);
		} else if (direction == Offset.Right) {
			playeroderso.setX(playeroderso.getX()+rightGeschwindigkeit);
			return checkIfHit(block, playeroderso);
		}

		return true;
	}

	/**
	 * 
	 * @param block
	 * @param playeroderso
	 * @return true wenn man sich dorthin bewegen kann
	 */
	public static boolean checkIfHit(Block[][] block, Shape playeroderso) {
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (block[i][j].getHitbox() != null) {

					float[] temp = block[i][j].getHitbox().getPoints();
					float[] newPoints = new float[temp.length];
					
					for (int p = 0; p < temp.length; p+=2) {
//							tempPoints[p] = block[i][j].getHitbox().getPoint(p). + Offset.getX();
						newPoints[p] = temp[p] + Offset.getX()/2;
						newPoints[p+1] = temp[p+1] + Offset.getY()/2;
					}
					
//						Rectangle temp = new Rectangle(block[i][j].getHitbox().getX()+Offset.getX()/2, block[i][j].getHitbox().getY()+Offset.getY()/2, block[i][j].getHitbox().getWidth(), block[i][j].getHitbox().getHeight());
//						if (temp.intersects(playeroderso)) {
					if (new Polygon(newPoints).intersects(playeroderso)) {
//							System.out.println(block[i][j].getHitbox().getX() + " | " + block[i][j].getHitbox().getMaxX() + " | " + block[i][j].getHitbox().getY() + " | " + block[i][j].getHitbox().getMaxY() + " | " + block[i][j].getType() + " | " + geschwindigkeit);
						return false;
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
	
	
	public static boolean getMoveUp() {
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
	
	
	
	
	
}
