package main;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Anmeldung extends JDialog {

	private static final long serialVersionUID = 1L;


	public Anmeldung(JFrame Ichi) {
		
		
		setModal(true);
		setSize(500, 500);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[80.00,fill][120.00,fill][80.00,fill]",
				"[30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill]"));

		new Startbildschirm();
		Ichi.dispose();
		dispose();

//		JTextField txtName = new JTextField();
//		txtName.setColumns(10);
//
//		JPasswordField pwField = new JPasswordField();
//		JButton btnAnmelden = new JButton("Anmelden");
//		JButton btnAbbrechen = new JButton("Abbrechen");
//
//		btnAbbrechen.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//
//		Action commit = new AbstractAction() {
//			private static final long serialVersionUID = 1L;
//
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				String insHash = Hash.calc(pwField.getPassword().toString());
//				String dbHash = dbAdapter.getHash(txtName.getText());
//				System.out.println(dbHash);
//				System.out.println(insHash);
//				if (insHash.equals(dbHash)) {
//					System.out.println("successfully logged in");
//					new Startbildschirm();
//					Ichi.dispose();
//					dispose();
//				} else
//					System.out.println("failed to log in");
//
//			}
//		};
//
//		btnAnmelden.addActionListener(commit);
//		pwField.addActionListener(commit);
//		txtName.addActionListener(commit);
//
//		getContentPane().add(txtName, "cell 1 1,growx");
//		getContentPane().add(pwField, "cell 1 2,growx");
//		getContentPane().add(btnAnmelden, "cell 1 3");
//		getContentPane().add(btnAbbrechen, "cell 1 4");
//		pack();
//		setVisible(true);

	}
}
