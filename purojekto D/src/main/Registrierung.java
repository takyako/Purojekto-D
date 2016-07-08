package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
				System.out.println("Some action");

				if (txtBenutzername.getText().length() >= 4) {

					if (String.valueOf(txtPassword).length() >= 6) {

						if ( String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtPassword2.getPassword())) ) {

							int ret = dbAdapter.insertUser(txtBenutzername.getText(), String.valueOf(txtPassword.getPassword()));
							if (ret > 0) {
								JOptionPane.showMessageDialog(null, txtBenutzername.getText() + " wurde erfolgreich angelegt.", "Erfolg!!! (oder so)", JOptionPane.PLAIN_MESSAGE, null);
								dlgRegistrierung.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Fehler beim anlegen von " + txtBenutzername.getText() + ".", "Kein Erfolg!!! (oder so)", JOptionPane.PLAIN_MESSAGE, null);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Die Passwörter stimmen nicht überein.", "Kein Erfolg!!! (oder so)", JOptionPane.PLAIN_MESSAGE, null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Das Password muss mindestens 6 Zeichen lang sein.", "Kein Erfolg!!! (oder so)", JOptionPane.PLAIN_MESSAGE, null);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Der Benutzername muss mindestens 4 Zeichen lang sein.", "Kein Erfolg!!! (oder so)", JOptionPane.PLAIN_MESSAGE, null);
				}
		    }
		};
		
		
		btnBestaetigen.addActionListener(action);
		
		btnAbbrechen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgRegistrierung.dispose();
			}
		});
		
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
//		btnBestaetigen.addActionListener(action); //sonst wird das drei mal ausgeführt

		dlgRegistrierung.getContentPane().add(btnAbbrechen, "cell 3 6");
//		btnBestaetigen.addActionListener(action); //sonst wird das drei mal ausgeführt
		
		dlgRegistrierung.pack();
		dlgRegistrierung.setVisible(true);
	}
	
}
