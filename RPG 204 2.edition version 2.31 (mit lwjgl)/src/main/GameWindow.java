package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWindow extends BasicGameState{


	private SpriteSheet sheet;

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		sheet = new SpriteSheet("img/spritesheet.png", 32, 32);		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		sheet.getSubImage(0, 0).draw(0, 0, 128, 128);		
	}


	@Override
	public int getID() {
		return 0;
	}
	
	

}
