import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * La classe <code>FenMenu</code> represente la fenetre du menu du jeu
 * celle-ci fera 651px par 651px et ne sera pas ajustable pour éviter tout
 * type de bug..
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class FenMenu extends JFrame{
	public FenMenu(){
		super("MineSweeper Launcher");
		this.setResizable(false);
		this.setSize(651,651);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuDessin p = new MenuDessin(this);
		p.setLocation(0,0);
		p.setSize(651,651);
		this.addMouseMotionListener(new ControlMenu(p));
		this.addMouseListener(new CliqueMenu(p));
		this.add(p);
	}
	
}