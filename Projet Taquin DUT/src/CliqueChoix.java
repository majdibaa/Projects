import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/**
 * La classe <code>CliqueChoix</code> concerne le controleur qui gere le clique
 * du choix du nombre de lignes et du nombre de colonnes et du nombre de bombes.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class CliqueChoix implements MouseListener{
	private Choix c;
	public CliqueChoix(Choix m){
		super();
		this.c=m;
	}
	@Override
	public void mouseClicked(MouseEvent e){
		this.c.Chiffres(e.getX(),e.getY());
	}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){
	}
	@Override
	public void mousePressed(MouseEvent e){
		
		
	}
	@Override         
	public void mouseReleased(MouseEvent e){
	} 
}