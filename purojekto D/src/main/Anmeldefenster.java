package main;

import javax.swing.*;
import java.awt.event.*;

import net.miginfocom.swing.MigLayout;

public class Anmeldefenster extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	static JButton btn;
	static JButton btn2;
	public Anmeldefenster()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		getContentPane().setLayout
		(new MigLayout("", "[120.00,fill][120.00,fill][120.00,fill][120.00,fill][120.00,fill]", 
		"[30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill]"));
		pack();
		setVisible(true);
	}
	
  
	public static void main(String[]args)
	{
		JFrame fenster = new Anmeldefenster() ;
		btn = new JButton("Anmelden");
		btn2 = new JButton("Registrieren");
		fenster.add(btn, "cell 2 3");
		fenster.add(btn2, "cell 2 4");
		
		btn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					new Anmeldung(fenster);
			}
		});
		
		
		btn2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new Registrierung();
			}
		});
		
	}
}
