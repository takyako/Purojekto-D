package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class Ichi {
  
	public static void main(String[]args){
		JFrame fenster = new JFrame() ;
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(800, 600);
		fenster.getContentPane().setLayout(new MigLayout("", "[50px][50px,fill][][][][][]", "[50px][50px,fill][][][][][][]"));
		
		String test = "test";
		JButton btn = new JButton("test");
		
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String encryptedString = null;
				MessageDigest messageDigest;
				try {
					messageDigest = MessageDigest.getInstance("SHA-256");
					messageDigest.update(test.getBytes());
					encryptedString = new String(messageDigest.digest());
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(encryptedString);
			}
		});
		fenster.add(btn, "cell 1 1");
		fenster.setVisible(true);
		}
}
