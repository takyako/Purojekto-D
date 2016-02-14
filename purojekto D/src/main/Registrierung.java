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
		dlgRegistrierung.getContentPane().setLayout(new MigLayout("", "[60px,fill][100px,fill][100px,fill][60px]", "[20px,fill][20px,fill][20px,fill][20px,fill][20px,fill][20px,fill][20px,fill][20px,fill][20px,fill]"));
		dlgRegistrierung.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		JTextField txtBenutzername = new JTextField();
		JPasswordField txtPassword = new JPasswordField();
		JPasswordField txtPassword2 = new JPasswordField();
		
		
		JButton btnBestaetigen = new JButton("test");
		
		
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
		dlgRegistrierung.getContentPane().add(txtBenutzername, "cell 2 1");
		txtBenutzername.addActionListener(action);
		
		dlgRegistrierung.getContentPane().add(new JLabel("Password"), "cell 1 2");
		dlgRegistrierung.getContentPane().add(txtPassword, "cell 2 2");
		txtPassword.addActionListener(action);
		
		dlgRegistrierung.getContentPane().add(new JLabel("Password wiederholen"), "cell 1 3");
		dlgRegistrierung.getContentPane().add(txtPassword2, "cell 2 3");
		txtPassword2.addActionListener(action);

		
		dlgRegistrierung.getContentPane().add(btnBestaetigen, "cell 2 5");
		btnBestaetigen.addActionListener(action);
		
		dlgRegistrierung.pack();
		dlgRegistrierung.setVisible(true);
	}
	
}
