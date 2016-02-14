package main;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Registrierung {
	
	public Registrierung() {
		JDialog dlg = new JDialog();
		dlg.setModal(true);
		dlg.getContentPane().setLayout(new MigLayout("", "[50px,fill][50px,fill][50px,fill][50px,fill]", "[50px,fill][50px,fill][20px,fill][50px,fill]"));
		dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		JTextField benutzername = new JTextField();
		JPasswordField password = new JPasswordField();
		
		
		
		
		
		dlg.getContentPane().add(benutzername, "cell 2 2");
		dlg.getContentPane().add(password, "cell 2 3");
		
		
		dlg.setVisible(true);
	}
	
}
