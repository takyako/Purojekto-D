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
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Menu("Title"));
			appgc.setDisplayMode(1200, 800, false);
			appgc.setTargetFrameRate(60);
			appgc.setVSync(true);
			appgc.start();
			
			
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}


}
