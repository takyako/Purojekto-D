package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class Ichi {
  
	public static void main(String[]args){
		JFrame fenster = new JFrame() ;
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(800, 600);
		fenster.getContentPane().setLayout
		(new MigLayout("", "[120px,fill][120px,fill][120px,fill][120px,fill][120px,fill]", "[30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill]"));
		fenster.pack();
		
		
		String test = "test";
		JButton btn = new JButton("Anmelden");
		JButton btn2 = new JButton("Registrieren");
		
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					new anmeldung();
			}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Registrierung();
			}
		});
		
		
		fenster.add(btn, "cell 2 3");
		fenster.add(btn2, "cell 2 4");
		fenster.setVisible(true);
		}
}
