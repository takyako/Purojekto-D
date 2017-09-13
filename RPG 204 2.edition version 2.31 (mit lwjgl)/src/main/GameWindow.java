package main;


import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import test.Test;

public class GameWindow extends BasicGameState implements MouseListener{

	private MapManager map; // TODO über den Handler zugreifen
	
	private static Input input;
	
	private static boolean debug = false;
	
	private static double delta;
	
	private int whilePlayerMoving = 0;
	private int whichPlayerPicture = 0;
	
	private Inventar inventar;
	private ItemManager itemManager; // auch nur über handler zugreifen

	
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		//um den Spieler zu zeichnen
		Player.initPlayer();
		
		//map init
		map = new MapManager("map1.json");
		Handler.setMap(map);
		
		//input init
		input = gc.getInput();
		
		
		
		inventar = new Inventar();
		itemManager = new ItemManager();
		Handler.setItem(itemManager);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
//for (int i = 0; i < delta/17; i++) { // TODO spaeter mit delta rumspielen
for (int i = 0; i < 5; i++) { // damit sich der Spieler schneller bewegt
		//Zeug
		
		if (input.isKeyPressed(Input.KEY_F9)) {
			debug = !debug;
		}
		
		
		//Bewegen
		
		if (input.isKeyDown(Input.KEY_W)) {
			Offset.move(Offset.richtung.Up);
		} else {
			Offset.moveNotMore(Offset.richtung.Up);
		}

		if (input.isKeyDown(Input.KEY_S)) {
			Offset.move(Offset.richtung.Down);
		} else {
			Offset.moveNotMore(Offset.richtung.Down);
		}

		if (input.isKeyDown(Input.KEY_A)) {
			Offset.move(Offset.richtung.Left);
		} else {
			Offset.moveNotMore(Offset.richtung.Left);
		}
		
		if (input.isKeyDown(Input.KEY_D)) {
			Offset.move(Offset.richtung.Right);
		} else {
			Offset.moveNotMore(Offset.richtung.Right);
		}
		
		
		//Bewegung ausführen

		Offset.tick(((gc.getWidth()/2-32))/2, ((gc.getHeight()/2-32))/2);
}
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

		// Blöcke zeichnen
		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				map.getImage(map.getTile(i, j)).draw(i*64+Offset.getX(), j*64+Offset.getY(), 64, 64);
			}
		}
		
		
		//Item zeichnen
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				Handler.getItem().getItemPicture(Handler.getMap().getItem(i, j)).draw(i*64/2+Offset.getX(), j*64/2+Offset.getY(), 64/2, 64/2);
			}
		}
		
		//Itemhitbox zeichnen
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (Handler.getMap().getItemHitbox(i, j) != null) {
					g.draw(Handler.getMap().getItemHitbox(i, j));
				}
			}
		}
		
		
		
		//player zeichnen
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
		} else if (Offset.getMoveRight()) {
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
			if (Offset.getLastMove() == Offset.richtung.Down) {
				Player.getTile(0, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.richtung.Up) {
				Player.getTile(3, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.richtung.Left) {
				Player.getTile(8, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			} else if (Offset.getLastMove() == Offset.richtung.Right) {
				Player.getTile(6, 0).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);
			}
		}
		
		
		//inventar zeichnen
		if (inventar.isInventarOpen()) {
			inventar.getInventarPicture().draw(64*4, 64*2, 64*6, 64*6);
			
			for (int i = 0; i < inventar.getInventarSize(); i++) {
				for (int j = 0; j < inventar.getInventarSize(); j++) {
					itemManager.getItemPicture(inventar.getID(i, j)).draw(i*63+64*2, j*63+64, 63, 63); // Bild zeichnen
					
					if (inventar.getMenge(i, j) != 0) {
						g.drawString(String.valueOf(inventar.getMenge(i, j)), i*63+64*2+5, j*63+64+5); // Menge zeichnen
					}
				}
			}
		}
		
		//Debug infos zeichnen
		if (debug) {
			
//		g.setFont(new Font("TimesRoman",Font.PLAIN, 16));
		g.drawString("MoveUp: " + Offset.getMoveUp(), 20, 60);
		g.drawString("MoveDown: " + Offset.getMoveDown(), 20, 80);
		g.drawString("MoveLeft: " + Offset.getMoveLeft(), 20, 100);
		g.drawString("MoveRight: " + Offset.getMoveRight(), 20, 120);
		
		g.drawString("OffsetX: " + Offset.getX(), 20, 160);
		g.drawString("OffsetY: " + Offset.getY(), 20, 180);
		
		g.drawString("PosX: " + ((gc.getWidth()/2-32) - Offset.getX())/2, 20, 220);
		g.drawString("PosY: " + ((gc.getHeight()/2-32) - Offset.getY())/2, 20, 240);

		g.drawString("Delta: " + delta, 20, 260);
		
//		if (debug) {
		//Hitbox des Spielers zeichnen
//		g.draw(new Rectangle(((gc.getWidth()/2-32)+Player.hitboxX*2), ((gc.getHeight()/2-32)+Player.hitboxY*2), Player.hitboxWidth*2, Player.hitboxHeight*2));

		//restliche Hitboxen zeichnen
		List<Shape> list = Test.getPolList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				g.draw(list.get(i));
			}
		}
		g.scale(4, 4);
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int tile = map.getTile(i, j);

				Polygon pol = Handler.getMap().getHitbox(tile);
				if (pol != null) {
					g.draw(editPol(pol, i, j));
				}
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
	
	
	//Für debug
	@Override
	public void mousePressed(int button, int x, int y) {
		super.mousePressed(button, x, y);
		
		x = (x-Offset.getX())/64;
		y = (y-Offset.getY())/64;

		
		if (x < 0 || y < 0) {
			return;
		}
		
		System.out.println("button: " + button + " x: " + x + " y " + y);
		
		System.out.println(Handler.getMap().getTile(x, y));
		
		
	}
	
	

}
