package main;

public class Handler { // TODO 

	
	private static MapManager map = null;
	
	public Handler() {
	
	}

	
	
	
	
	
	public static void setMap(MapManager map) {
		Handler.map = map;
	}
	
	public static MapManager getMap() {
		return Handler.map;
	}
	
	
	
}
