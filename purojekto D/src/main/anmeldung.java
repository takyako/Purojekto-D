package main;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class anmeldung {

	public anmeldung(){
		
		JDialog anmeldung = new JDialog();
		anmeldung.setSize(500, 500);
		anmeldung.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		anmeldung.getContentPane().setLayout
		(new MigLayout("", "[80px][63.00px,grow][70.00px][75.00][120px][80px]", "[30px][30px][30px][30px][30px][30px][30px][30px][30px]"));
		
		JTextField txtName = new JTextField();
		anmeldung.getContentPane().add(txtName, "cell 1 2 2 1,growx");
		txtName.setColumns(10);
		
		
		JPasswordField pwField = new JPasswordField();
		anmeldung.getContentPane().add(pwField, "cell 1 3 2 1,growx");
		
		
		JButton btnAnmelden = new JButton("Anmelden");
	
		anmeldung.getContentPane().add(btnAnmelden, "cell 1 5");
		
		
		JButton btnAbbrechen = new JButton("Abbrechen");
			btnAbbrechen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					anmeldung.dispose();
					
				}
			});
		anmeldung.getContentPane().add(btnAbbrechen, "cell 2 5");
		
		Action commit = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
		
				switch( txtName.getText() ){
				
				case "daniel": 
					{
					System.out.println("HHHHHHHHHHHHAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					String zeug = hash.hash(pwField.getText());
					System.out.println(zeug);
					}	
				}
		
			}
		};
		txtName.addActionListener(commit);
		btnAnmelden.addActionListener(commit);
		pwField.addActionListener(commit);
		
		anmeldung.setVisible(true);
	}
}
