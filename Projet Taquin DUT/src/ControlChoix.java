import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/**
 * La classe <code>CliqueChoix</code> concerne le controleur qui gere la surbrillance
 * du choix du nombre de lignes et du nombre de colonnes et du nombre de bombes.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class ControlChoix implements MouseMotionListener{
	public Choix j;
	public ControlChoix(Choix b){
		super();
		this.j=b;
	}
	@Override
	public void mouseMoved(MouseEvent e){
		this.j.Surbrillance(e.getX(),e.getY());
	}
	@Override
	public void mouseDragged(MouseEvent e){
	}
}