import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/**
 * La classe <code>ControlMenu</code> concerne le controleur qui gere le surbrillance des images
 * de la classe MenuDessin.
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */ 
public class ControlMenu implements MouseMotionListener{
	public MenuDessin j;
	public ControlMenu(MenuDessin b){
		super();
		this.j=b;
	}
	@Override
	public void mouseMoved(MouseEvent e){
		this.j.Redessin(e.getX(),e.getY());
	}
	@Override
	public void mouseDragged(MouseEvent e){
	} 
}