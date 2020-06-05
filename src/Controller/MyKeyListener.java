package Controller;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import View.Window;

public class MyKeyListener extends KeyAdapter{
	
	public Window wd;
	public boolean[] keys;
	
	public MyKeyListener(Window wd) {
		/*
		 * Construit une instance de MyKeyListener 
		 * @args: la fenêtre que l'on va lier
		 */
		super();//on appel le superConstructeur
		this.wd = wd;//on lie la fenêtre
	}
	
	public void keyPressed(KeyEvent e) {
		this.wd.game.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		this.wd.game.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
	}


}
