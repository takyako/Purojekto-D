package main;

public class Items {

	private int menge;
	private int id;
	
	
	/**
	 * id und menge werden initialisiert
	 */
	public Items() {
		id = 0;
		menge = 0;
	}
	
	
	public void putItemIn(int id, int menge) {
		this.id = id;
		this.menge = menge;
	}
	
	
	
	
	public boolean validID() { // TODO später iwie prüfen. (Brauche ich das überhaupt. Iwie nicht. kp)
		
		return false;
	}
	
	
	
	
	
	///////////////getter/setter
	
	
	public int getID() {
		return id;
	}
	
	
	public int getMenge() {
		return menge;
	}
	
	
	
	
}
