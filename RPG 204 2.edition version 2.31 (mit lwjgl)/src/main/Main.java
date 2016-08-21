package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame{




	@Override
	public void init(GameContainer gc) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
	}

	
	
	public Main(String title) {
		super(title);
		

	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Main("Title"));
			app.setDisplayMode(600, 600, false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
			
		
			
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
		
	}

}
