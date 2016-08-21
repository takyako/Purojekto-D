package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends StateBasedGame{


	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new GameWindow());
	}

	public Menu(String name) {
		super(name);
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Menu("Title"));
			app.setDisplayMode(1200, 800, false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
			
			
			
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}


}
