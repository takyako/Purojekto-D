package main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Registrierung {
	
	public Registrierung() {
		JDialog dlgRegistrierung = new JDialog();
		dlgRegistrierung.setModal(true);
		dlgRegistrierung.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dlgRegistrierung.setTitle("Registrieren");
		dlgRegistrierung.getContentPane().setLayout(new MigLayout("", "[20.00::20.00,fill][150.00::150.00,fill][10.00::10.00][150.00::150.00,fill][20.00::20.00]", "[20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill][20.00::20.00,fill]"));
		
		
		JTextField txtBenutzername = new JTextField();
		JPasswordField txtPassword = new JPasswordField();
		JPasswordField txtPassword2 = new JPasswordField();
		
		
		JButton btnBestaetigen = new JButton("Registrieren");
		JButton btnAbbrechen = new JButton("Abbrechen");
		
		
		Action action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("some action");
		    }
		};
		
		
		dlgRegistrierung.getContentPane().add(new JLabel("Benutzername"), "cell 1 1");
		dlgRegistrierung.getContentPane().add(txtBenutzername, "cell 3 1");
		txtBenutzername.addActionListener(action);
		
		dlgRegistrierung.getContentPane().add(new JLabel("Password"), "cell 1 2");
		dlgRegistrierung.getContentPane().add(txtPassword, "cell 3 2");
		txtPassword.addActionListener(action);
		
		dlgRegistrierung.getContentPane().add(new JLabel("Password wiederholen"), "cell 1 3");
		dlgRegistrierung.getContentPane().add(txtPassword2, "cell 3 3");
		txtPassword2.addActionListener(action);

		
		dlgRegistrierung.getContentPane().add(btnBestaetigen, "cell 1 6");
		btnBestaetigen.addActionListener(action);

		dlgRegistrierung.getContentPane().add(btnAbbrechen, "cell 3 6");
		btnBestaetigen.addActionListener(action);
		
		dlgRegistrierung.pack();
		dlgRegistrierung.setVisible(true);
	}
	
}
