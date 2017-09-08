package main;


import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import test.Test;

public class GameWindow extends BasicGameState{

//	private SpriteSheet sheet;
//	private static Block[][] block;
	private MapManager map; // über den Handler zugreifen
	
	private static Input input;
	
	private static boolean debug = false;
	
	private static double delta;
	
	private int whilePlayerMoving = 0;
	private int whichPlayerPicture = 0;
	
	private Inventar inventar;
	private ItemManager itemManager;

	
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		//um den Spieler zu zeichnen
//		sheet = new SpriteSheet("img/spritesheet.png", 16, 16);	//player bekommt spaeter ne eigene Klasse
		Player.initPlayer();
		
		//map init
		map = new MapManager("map1.json");
		Handler.setMap(map);
//		block = map.init();
		
		//input init
		input = gc.getInput();
		
		
		
		inventar = new Inventar();
		itemManager = new ItemManager();

		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
//for (int i = 0; i < delta/17; i++) { // TODO spaeter mit delta rumspielen
		
		//Zeug
		
		if (input.isKeyPressed(Input.KEY_F9)) {
			debug = !debug;
		}
		
		
		//Bewegen
		
		if (input.isKeyDown(Input.KEY_W)) {
			Offset.move(Offset.Up);
		} else {
			Offset.moveNotMore(Offset.Up);
		}

		if (input.isKeyDown(Input.KEY_S)) {
			Offset.move(Offset.Down);
		} else {
			Offset.moveNotMore(Offset.Down);
		}

		if (input.isKeyDown(Input.KEY_A)) {
			Offset.move(Offset.Left);
		} else {
			Offset.moveNotMore(Offset.Left);
		}
		
		if (input.isKeyDown(Input.KEY_D)) {
			Offset.move(Offset.Right);
		} else {
			Offset.moveNotMore(Offset.Right);
		}
		
		
		//Bewegung ausführen

//		Offset.tick();
		Offset.tick(/*block, */((gc.getWidth()/2-32))/2, ((gc.getHeight()/2-32))/2);
//}	
		
		
		
		
		//anderes
		
		if (input.isKeyPressed(Input.KEY_I)) { //Inventar öffnen
			inventar.showInventar();
		}
		
		
		//Test
		if(input.isKeyPressed(Input.KEY_T)) {
			inventar.putItemIn(1, 1);
		}
		//Test
		
		
		
		GameWindow.delta = delta;
	}
	

	
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {  //TODO nur das was man sieht zeichnen, nicht alle Hitboxen beachten. Alles auf ein Bild packen und dieses Zeichnen, statt alles einzeln zu zeichnen!!!

		//Bloecke zeichnen
//		for (int i = 0; i < block.length; i++) {
//			for (int j = 0; j < block[0].length; j++) {
//				block[i][j].getImg().draw(i*64+Offset.getX(), j*64+Offset.getY(), 64, 64); // kp ob das so gut ist die Bilder im Array zu speichern, da dies redundant ist und vllt nicht so gut für die Performance
//			}
//		}

		// Blöcke zeichnen neu
		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				map.getImage(map.getTile(i, j)).draw(i*64+Offset.getX(), j*64+Offset.getY(), 64, 64);
			}
		}
		
		
		//player zeichnen
//		sheet.getSubImage(0, 12).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
		if (Offset.getMoveDown()) {
			whilePlayerMoving++;
			if (whilePlayerMoving%10 == 0) {
				whichPlayerPicture++;
			}
			
			if (whichPlayerPicture%2 == 0) {
				Player.getTile(1, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else {
				Player.getTile(2, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		} else if (Offset.getMoveUp()){ 
			whilePlayerMoving++;
			if (whilePlayerMoving%10 == 0) {
				whichPlayerPicture++;
			}
			
			if (whichPlayerPicture%2 == 0) {
				Player.getTile(4, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else {
				Player.getTile(5, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		} else if (Offset.getMooveRight()) {
			whilePlayerMoving++;
			if (whilePlayerMoving%10 == 0) {
				whichPlayerPicture++;
			}
			
			if (whichPlayerPicture%2 == 0) {
				Player.getTile(7, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else {
				Player.getTile(6, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		} else if (Offset.getMoveLeft()) {
			whilePlayerMoving++;
			if (whilePlayerMoving%10 == 0) {
				whichPlayerPicture++;
			}
			
			if (whichPlayerPicture%2 == 0) {
				Player.getTile(0, 1).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else {
				Player.getTile(8, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		} else {
			whilePlayerMoving = 0;
			whichPlayerPicture = 0;
			if (Offset.getLastMove() == Offset.Down) {
				Player.getTile(0, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.Up) {
				Player.getTile(3, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.Left) {
				Player.getTile(8, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.Right) {
				Player.getTile(6, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		}


		
		
		//inventar zeichnen
		if (inventar.isInventarOpen()) {
			inventar.getInventarPicture().draw(64*2, 64, 64*6, 64*6);
			
			
			for (int i = 0; i < inventar.getInventarSize(); i++) {
				for (int j = 0; j < inventar.getInventarSize(); j++) {
					itemManager.getItemPicture(inventar.getID(i, j)).draw(i*63+64*2, j*63+64, 63, 63); // Bild zeichnen
					g.drawString(String.valueOf(inventar.getMenge(i, j)), i*63+64*2+5, j*63+64+5); // Menge zeichnen
				}
			}
		}
		
		
		
		//Debug infos zeichnen
		if (debug) {
			
//		g.setFont(new Font("TimesRoman",Font.PLAIN, 16));
		g.drawString("MoveUp: " + Offset.getMoveUp(), 20, 60);
		g.drawString("MoveDown: " + Offset.getMoveDown(), 20, 80);
		g.drawString("MoveLeft: " + Offset.getMoveLeft(), 20, 100);
		g.drawString("MoveRight: " + Offset.getMooveRight(), 20, 120);
		
		g.drawString("OffsetX: " + Offset.getX(), 20, 160);
		g.drawString("OffsetY: " + Offset.getY(), 20, 180);
		
		g.drawString("PosX: " + ((gc.getWidth()/2-32) - Offset.getX())/2, 20, 220);
		g.drawString("PosY: " + ((gc.getHeight()/2-32) - Offset.getY())/2, 20, 240);

		g.drawString("Delta: " + delta, 20, 260);
		
//		if (debug) {
		//Hitbox des Spielers zeichnen
//		g.draw(new Rectangle(((gc.getWidth()/2-32)+Player.hitboxX*2), ((gc.getHeight()/2-32)+Player.hitboxY*2), Player.hitboxWidth*2, Player.hitboxHeight*2));

		//restliche Hitboxen zeichnen
		g.scale(2, 2);
//		for (int i = 0; i < block.length; i++) { // TODO später wenn ich die wieder einbastle
//			for (int j = 0; j < block[0].length; j++) {
//				if (block[i][j].getHitbox() != null) {
////					g.draw(block[i][j].getHitbox());
////					g.draw(new Rectangle(block[i][j].getHitbox().getX()+Offset.getX()/2, block[i][j].getHitbox().getY()+Offset.getY()/2, block[i][j].getHitbox().getWidth(), block[i][j].getHitbox().getHeight()));
//					
//					float[] temp = block[i][j].getHitbox().getPoints();
//					float[] newPoints = new float[temp.length];
//					
//					for (int p = 0; p < temp.length; p+=2) {
////						tempPoints[p] = block[i][j].getHitbox().getPoint(p). + Offset.getX();
//						newPoints[p] = temp[p] + Offset.getX()/2;
//						newPoints[p+1] = temp[p+1] + Offset.getY()/2;
//					}
////					System.out.println(block[1][0].getHitbox().getX() + block[1][0].getHitbox().getY());
////					if (i == 0 && j == 1)
////					System.out.println(temp[0]);
//					
//					g.draw(new Polygon(newPoints));
//					
//				}
//			}
//		}
		
		
		
		g.scale(2,2);
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
//				if (Handler.getMap().getHitbox(i*16+j) != null) {
 				int tile = map.getTile(i, j);
				
//				tile--;
				
				
					Polygon pol = Handler.getMap().getHitbox(tile);
//					Test.pol = pol;
					if (pol != null) {
						g.draw(editPol(pol, i, j));
					}

//				}
			}
		}
		
		
		g.setColor(Color.red);
		
		if (Test.pol != null) {
			g.draw(Test.pol);
		}
		if (Test.player != null) {
			g.draw(Test.player);
		}
		
		g.setColor(Color.white);
		}
		
		
		
		
		
		
		// Test
//		if (Test.pol != null)
//		g.draw(Test.pol);
		
		// Test
		
	}
	
	
	/**
	 * das polygon so umwandeln, dass ich das einfach zeichnen kann.
	 * @param pol
	 * @param x
	 * @param y
	 * @return
	 */
	public static Polygon editPol(Polygon pol, int x, int y) {
		List<Float> list = new ArrayList<Float>();
//		float[] newPoints = new float[pol.getPointCount()];
		
		for (int i = 0; i < pol.getPointCount(); i++) {
			float[] points = pol.getPoint(i);
			
			list.add(points[0] + ((x)*16));
			list.add(points[1] + ((y)*16));
							
		}
		
		float[] newPoints = new float[list.size()];
		
		for (int i = 0; i < newPoints.length; i++) {
			newPoints[i] = list.get(i);
		}
		
		Polygon newPol = new Polygon(newPoints);
		
		return newPol;
	}

	@Override
	public int getID() {
		return 0;
	}
	

}
