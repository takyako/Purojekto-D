package main;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

import lib.Picture;

public class Startbildschirm 
{
	public Startbildschirm()
	{
		JFrame fenster = new Anmeldefenster();
		
		fenster.setLayout(new BorderLayout());
		try{
			fenster.add(Picture.get("src/lib/bgroundStart.png"), BorderLayout.CENTER);			
		}catch(IOException e)
		{
			System.out.println("Kein Bild gefunden: "+e.getMessage());
		}
	}
	
	
	
	public static void main (String [] args ) {
		new Startbildschirm();
		
		
	}
	
}
