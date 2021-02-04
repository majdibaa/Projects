import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class CliqueMenu implements MouseListener{
	private MenuDessin c;
	public CliqueMenu(MenuDessin m){
		this.c=m;
	}
	public void mouseDragged(MouseEvent e){
		
	}
	public void mouseClicked(MouseEvent e){
		this.c.Commencement(e.getX(),e.getY());
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
		
		
	}         
	public void mouseReleased(MouseEvent e){
	} 
}