import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/**
 * La classe <code>CliqueActu</code> concerne le controleur qui permet.
 * d'actualiser l'affichage pendant le jeu, c'est à dire le nombre de bombes restantes
 * , le nombre de cases ouvertes.
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class CliqueActu implements MouseListener{
	private Gameplay j;
	public CliqueActu(Gameplay b){
		this.j=b;
	}
	@Override
	public void mouseClicked(MouseEvent e){
		this.j.repaint();
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