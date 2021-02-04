import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * La classe <code>FenChoix</code> represente le panneau qui va 
 * contenir le composant du choix des lignes, colonnes et bombes.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class FenChoix extends JPanel{
	public FenChoix(FenMenu b){
		super();
		Choix p = new Choix(b);
		this.setLayout(null);
		p.setSize(651,651);
		p.setLocation(0,0);
		this.addMouseMotionListener(new ControlChoix(p));
		this.addMouseListener(new CliqueChoix(p));
		this.add(p);
	}
	
}