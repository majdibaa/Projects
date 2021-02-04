import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * La classe <code>Gameplay</code> correspond au panneau de stats du jeu
 * avec l'affichage du nombre de cases ouvertes et l'affichage du nombre de bombes
 * restantes.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class Gameplay extends JComponent{
	/**
	 * Image du bouton "Sauver et Quitter".
	 */
	private Image save;
	/**
	 * Image du bouton "Menu".
	 */
	private Image menu;
	/**
	 * Fenetre de jeu.
	 */
	private JFr b;
	public Gameplay(JFr j){
		this.b=j;
		this.save = Toolkit.getDefaultToolkit().getImage("../img/save.png");
		this.menu = Toolkit.getDefaultToolkit().getImage("../img/menu.png");
	}
	@Override
	public void paintComponent(Graphics pinceau) {
		Graphics secondPinceau = pinceau.create();
		if (this.isOpaque()) { 
			secondPinceau.setColor(this.getBackground());
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		secondPinceau.setColor(Color.WHITE);
		secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		secondPinceau.drawImage(this.save,20,20,this);
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/open.png"),20,80,this);
		secondPinceau.setFont(new Font("",Font.BOLD,20));
		secondPinceau.setColor(Color.BLACK);
		secondPinceau.drawString(Integer.toString(this.b.getBombes()-this.b.getDrap()),250,140);
		secondPinceau.drawString(Integer.toString(this.b.getOpen()),250,100);
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/reste.png"),20,120,this);
		secondPinceau.drawImage(this.menu,250,165,this);
		if(this.b.getGameStatus()==1){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/perdu.png"),20,160,this);
		}else if(this.b.getGameStatus()==2){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/gagne.png"),20,160,this);
		}
	}
	/**
	 * Methode qui gere la surbrillance des boutons "sauver et quitter" et "menu"
	 */
	public void Surbrillance(int x, int y){
		if(x>=this.b.getTailleX()+40 && x<=this.b.getTailleX()+340 && y>=20 && y<=73){
			this.save=Toolkit.getDefaultToolkit().getImage("../img/save1.png");
		}else{
			this.save=Toolkit.getDefaultToolkit().getImage("../img/save.png");
		}
		if(x>=this.b.getTailleX()+270 && x<=this.b.getTailleX()+342 && y>=165 && y<=195){
			this.menu=Toolkit.getDefaultToolkit().getImage("../img/menu1.png");
		}else{
			this.menu=Toolkit.getDefaultToolkit().getImage("../img/menu.png");
		}
		this.repaint();
	}
	/**
	 * Methode qui gere des que le joueur clique sur le bouton "sauver et quitter"(en appelant la methode Enregistrement
	 * de la fenetre donnee en parametre du constructeur) ou "menu" (en rouvrant une fenetre de menu tout en fermant celle du jeu).
	 */
	public void Clique(int x, int y){
		if(x>=this.b.getTailleX()+40 && x<=this.b.getTailleX()+340 && y>=20 && y<=73){
			this.b.Enregistrement();
			System.exit(0);
		}
		if(x>=this.b.getTailleX()+270 && x<=this.b.getTailleX()+342 && y>=165 && y<=195){
			this.b.Enregistrement();
			this.b.dispose();
			FenMenu uu = new FenMenu();
			uu.setVisible(true);
		}
	}
}