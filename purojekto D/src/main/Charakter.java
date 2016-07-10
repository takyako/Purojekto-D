package main;

import java.awt.Dimension;

public class Charakter {

	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Dimension getC() {
		return c;
	}


	public void setC(Dimension c) {
		this.c = c;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getAp() {
		return ap;
	}


	public void setAp(int ap) {
		this.ap = ap;
	}


	private Dimension c;
	private int hp;
	private int ap;


	public Charakter(String name) {
		this.name = name;
	}
	
	
	
}
