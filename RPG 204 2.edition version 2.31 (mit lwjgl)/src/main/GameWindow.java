package main;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWindow extends BasicGameState{

	private SpriteSheet sheet;
	private static Block[][] block;
	
	private static Input input;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		//um den Spieler zu zeichnen
		sheet = new SpriteSheet("img/spritesheet.png", 16, 16);	//player bekommt später ne eigene Klasse
		
		//map init
		MapManager map = new MapManager("map1.png");
		block = map.init();
		
		//input init
		input = gc.getInput();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
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

//		Offset.tick();
		Offset.tick(block, ((gc.getWidth()/2-32))/2, ((gc.getHeight()/2-32))/2);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		
		//Blöcke zeichnen
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				block[i][j].getImg().draw(i*64+Offset.getX(), j*64+Offset.getY(), 64, 64);
			}
		}
		
		
		//player zeichnen
		sheet.getSubImage(0, 12).draw(gc.getWidth()/2-32, gc.getHeight()/2-32, 64, 64);


		//Debug infos zeichnen
		
//		g.setFont(new Font("TimesRoman",Font.PLAIN, 16));
		g.drawString("MoveUp: " + Offset.getMoveUp(), 20, 60);
		g.drawString("MoveDown: " + Offset.getMoveDown(), 20, 80);
		g.drawString("MoveLeft: " + Offset.getMoveLeft(), 20, 100);
		g.drawString("MoveRight: " + Offset.getMooveRight(), 20, 120);
		
		g.drawString("OffsetX: " + Offset.getX(), 20, 160);
		g.drawString("OffsetY: " + Offset.getY(), 20, 180);
		
		g.drawString("PosX: " + ((gc.getWidth()/2-32) - Offset.getX())/2, 20, 220);
		g.drawString("PosY: " + ((gc.getHeight()/2-32) - Offset.getY())/2, 20, 240);

		
		if (false) {
		//Hitbox des Spielers zeichnen
		g.draw(new Rectangle(((gc.getWidth()/2-32)), ((gc.getHeight()/2-32)), 64, 64));

		//restliche Hitboxen zeichnen
		g.scale(2, 2);
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (block[i][j].getHitbox() != null) {
//					g.draw(block[i][j].getHitbox());
//					g.draw(new Rectangle(block[i][j].getHitbox().getX()+Offset.getX()/2, block[i][j].getHitbox().getY()+Offset.getY()/2, block[i][j].getHitbox().getWidth(), block[i][j].getHitbox().getHeight()));
					
					float[] temp = block[i][j].getHitbox().getPoints();
					float[] newPoints = new float[temp.length];
					
					for (int p = 0; p < temp.length; p+=2) {
//						tempPoints[p] = block[i][j].getHitbox().getPoint(p). + Offset.getX();
						newPoints[p] = temp[p] + Offset.getX()/2;
						newPoints[p+1] = temp[p+1] + Offset.getY()/2;
					}
//					System.out.println(block[1][0].getHitbox().getX() + block[1][0].getHitbox().getY());
//					if (i == 0 && j == 1)
//					System.out.println(temp[0]);
					
					g.draw(new Polygon(newPoints));
					
				}
			}
		}
		}
		
	}


	@Override
	public int getID() {
		return 0;
	}
	

}
