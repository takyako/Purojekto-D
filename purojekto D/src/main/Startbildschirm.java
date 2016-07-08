package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lib.Picture;

public class Startbildschirm 
{
	public Startbildschirm()
	{
		JFrame fenster = new Anmeldefenster();
		
		fenster.setLayout(new BorderLayout());
		fenster.add(Picture.get("src/lib/bground.png"), BorderLayout.CENTER);
	}
	
	
	
	public static void main (String [] args ) {
		new Startbildschirm();
		
		
	}
	
}
