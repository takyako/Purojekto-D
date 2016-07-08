package main;

import java.awt.Toolkit;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public abstract class Fenster extends JFrame {

	private static final long serialVersionUID = 1L;


	public Fenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-400),
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-300), 800, 600);
		getContentPane().setLayout(new MigLayout("",
				"[120.00,fill][120.00,fill][120.00,fill][120.00,fill][120.00,fill]",
				"[30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill][30.00,fill]"));
		pack();
		setVisible(true);
	}
}
