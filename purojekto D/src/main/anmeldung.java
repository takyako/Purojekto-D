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
		
		JDialog dlgAnmeldung = new JDialog();
		
			Action commit = new AbstractAction() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
						
					switch( txtName.getText() )
					{
					case "daniel": 
						{
						System.out.println(txtName.getText());
						String zeug = hash.hash(pwField.getText());
						System.out.println(zeug);
						}	
					}
				}
			};
				
						
			JTextField txtName = new JTextField();
			txtName.setColumns(10);
			txtName.addActionListener(commit);
				
				
			JPasswordField pwField = new JPasswordField();
			pwField.addActionListener(commit);
		
		
			JButton btnAnmelden = new JButton("Anmelden");
			btnAnmelden.addActionListener(commit);
				
			
			JButton btnAbbrechen = new JButton("Abbrechen");
			btnAbbrechen.addActionListener(new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent e) 
				{
				dlgAnmeldung.dispose();	
				}
			});
				
				
			dlgAnmeldung.setSize(500, 500);
			dlgAnmeldung.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dlgAnmeldung.getContentPane().setLayout
			(new MigLayout("", "[80px,fill][120px,fill][80.00px,fill]", "[30px,fill][30px,fill][30px,fill][30px,fill][30px,fill][30px,fill]"));
			dlgAnmeldung.getContentPane().add(txtName, "cell 1 1,growx");
			dlgAnmeldung.getContentPane().add(pwField, "cell 1 2,growx");
			dlgAnmeldung.getContentPane().add(btnAnmelden, "cell 1 3");
			dlgAnmeldung.getContentPane().add(btnAbbrechen, "cell 1 4");
			dlgAnmeldung.pack();
			dlgAnmeldung.setVisible(true);
		
	}
}
