package main;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Anmeldung 
{

	public Anmeldung()
	{
		
		JDialog dlgAnmeldung = new JDialog();
		dlgAnmeldung.setModal(true);
		dlgAnmeldung.setSize(500, 500);
		dlgAnmeldung.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dlgAnmeldung.getContentPane().setLayout
		(new MigLayout("", "[80.00,fill][120.00,fill][80.00,fill]", "[30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill]"));
				
						
			JTextField txtName = new JTextField();
			txtName.setColumns(10);
				
				
			JPasswordField pwField = new JPasswordField();
		
		
			JButton btnAnmelden = new JButton("Anmelden");
				
			
			JButton btnAbbrechen = new JButton("Abbrechen");
			btnAbbrechen.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					dlgAnmeldung.dispose();	
				}
			});
				
			
			Action commit = new AbstractAction() 
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) 
				{	
					
					Sql.setHash("daniel", "daniel");
					String insHash = Hash.calc(pwField.getText());
					String dbHash = Sql.getHash(txtName.getText());
					System.out.println(Hash.calc("daniel"));
					System.out.println(dbHash);
					if(insHash.equals(dbHash)) System.out.println("successfully logged in");
					else System.out.println("failed to log in");
					
				}
			};

			
			btnAnmelden.addActionListener(commit);
			pwField.addActionListener(commit);
			txtName.addActionListener(commit);

			
			dlgAnmeldung.getContentPane().add(txtName, "cell 1 1,growx");
			dlgAnmeldung.getContentPane().add(pwField, "cell 1 2,growx");
			dlgAnmeldung.getContentPane().add(btnAnmelden, "cell 1 3");
			dlgAnmeldung.getContentPane().add(btnAbbrechen, "cell 1 4");
			dlgAnmeldung.pack();
			dlgAnmeldung.setVisible(true);
		
	}
}
