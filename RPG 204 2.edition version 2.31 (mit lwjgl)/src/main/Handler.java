package main;

public class Handler { // TODO 

	
	private static MapManager map = null;
	private static ItemManager item = null;
	
	
	public Handler() {
	
	}

	
	
	
	
	
	public static void setMap(MapManager map) {
		Handler.map = map;
	}
	
	public static MapManager getMap() {
		return Handler.map;
	}
	
	public static void setItem(ItemManager item) {
		Handler.item = item;
	}
	
	public static ItemManager getItem() {
		return Handler.item;
	}
	
}
