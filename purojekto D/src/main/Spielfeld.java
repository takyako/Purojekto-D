package main;

import java.util.LinkedList;

public class Spielfeld {

	private String name;
	private LinkedList<Charakter> chars;


	public Spielfeld(String name) {
		this.name = name;
	}


	public void addCharakter(Charakter gamer) {
		chars.add(gamer);
	}

}
