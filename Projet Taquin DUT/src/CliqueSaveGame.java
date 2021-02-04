import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/**
 * La classe <code>CliqueSaveGame</code> concerne le controleur qui gere le clique
 * pendant la session de jeu, lorsque le joueur clique, la methode appelle la methode Clique
 * de l'objet de la classe Gameplay donnee en argument du constructeur.en faisant passer les coordonnees
 * du curseur au moment du clique a la methode.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class CliqueSaveGame implements MouseListener{
	public Gameplay j;
	public CliqueSaveGame(Gameplay b){
		this.j=b;
	}
	public void mouseDragged(MouseEvent e){
		
	}
	public void mouseClicked(MouseEvent e){
		this.j.Clique(e.getX(),e.getY());
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
		
		
	}         
	public void mouseReleased(MouseEvent e){
	} 
}