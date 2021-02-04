import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
/**
 * La classe <code>Dessin</code> concerne l'affichage d'une case
 * du demineur lors du clique.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */ 
public class Dessin extends JComponent {
	/**
	 * Booleen de controle pour une case contenant un nombre de bombes adjacentes.
	 */
	private boolean bool1=false;
	/**
	 * Booleen de controle pour une case contenant une bombe.
	 */
	private boolean bool2=false;
	/**
	 * Booleen de controle pour la case cliquee contenant une bombe.
	 */
	private boolean bool3=false;
	/**
	 * Booleen de controle pour le faux drapeau.
	 */
	private boolean bool4=false;
	/**
	 * Chaine de caractere a ecrire dans la case.
	 */
	private String ecrit;
	/**
	 * Image de la bombe dans la case.
	 */
	private char o='p';
	public Dessin(){
		super();
	}
	@Override
	/**
	 * Dessine par defaut une case de demineur grise foncee puis en fonction des variables de controle 
	 * , la methode dessine une case contenant ce pour quoi la variable controle.
	 */
	public void paintComponent(Graphics pinceau) {
		Graphics secondPinceau = pinceau.create();
		if (this.isOpaque()) { 
			secondPinceau.setColor(this.getBackground());
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		secondPinceau.setColor(new Color(80,80,80));
		secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(bool2){
			if(!bool3){
				secondPinceau.setColor(new Color(80,80,80));
				secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
				secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/bomb.png"),5,0,this);
			}
			else{
				secondPinceau.setColor(new Color(255,0,0));
				secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
				secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/bomb.png"),5,0,this);
			}
		}
		else if(this.o=='a'){
			secondPinceau.setColor(new Color(80,80,80));
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/interro.png"),3,2,this);
		}
		else if(this.o=='b'){
			secondPinceau.setColor(new Color(80,80,80));
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
			if(this.bool4){
				secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/drapeau1.png"),3,2,this);
			}else{
				secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/drapeau.png"),3,2,this);
			}
		}
		else if(bool1){
			secondPinceau.setColor(new Color(180,180,180));
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
			if(this.ecrit!=""){
				if(Integer.parseInt(this.ecrit)==1){
					secondPinceau.setColor(new Color(0,0,255));
				}
				else if(Integer.parseInt(this.ecrit)==2){
					secondPinceau.setColor(new Color(255,0,0));
				}
				else if(Integer.parseInt(this.ecrit)==3){
					secondPinceau.setColor(new Color(0,255,0));
				}
				else if(Integer.parseInt(this.ecrit)==4){
					secondPinceau.setColor(new Color(255,0,255));
				}
				else if(Integer.parseInt(this.ecrit)==5){
					secondPinceau.setColor(new Color(255,255,0));
				}
				else if(Integer.parseInt(this.ecrit)==6){
					secondPinceau.setColor(new Color(0,255,255));
				}
				else if(Integer.parseInt(this.ecrit)==7){
					secondPinceau.setColor(new Color(255,255,255));
				}
				else if(Integer.parseInt(this.ecrit)==8){
					secondPinceau.setColor(new Color(0,0,0));
				}
			}
			secondPinceau.setFont(new Font("",Font.BOLD,20));
			secondPinceau.drawString(this.ecrit,(this.getWidth()/2)-6,(this.getHeight()/2)+7);
		}
	}
	/**
	 * Dessine un nombre passé en argument au milieu d'une case tout en ayant un fond
	 * gris clair.
	 */
	public void Dessiner(int nb){
		this.bool1=true;
		if(nb==0){
			this.ecrit="";
		}else{
			this.ecrit=Integer.toString(nb);
		}
		this.repaint();
	}
	/**
	 * Dessine une bombe dans une case avec un fond rouge pour la case cliquee 
	 * et un fond gris clair pour toutes les autres cases contenant un bombes.
	 */
	public void Dessiner(boolean j){
		this.bool2=true;
		this.bool3=j;
		this.repaint();
	}
	/**
	 * Dessine dans une case soit un drapeau ou un point d'interrogation en fonction du caractere
	 * : soit 'a' ou 'b'
	 */
	public void Dessiner(char a){
		this.o=a;
		this.repaint();
	}
	/**
	 * Dessine dans une case soit un drapeau ou un point d'interrogation en fonction du caractere
	 * et dessine si booleen b = true, un drapeau barré. Si le dessin voulue correspond à un point d'interrogation
	 * alors le booleen ne sera pas pris en compte et la fonction sera redirigee vers la fonction Dessiner(char).
	 */
	public void Dessiner(char a,boolean b){
		if(a=='a'){
			this.Dessiner(a);
		}else{
			this.bool4=b;
			this.o=a;
			this.repaint();
		}	
	}
	/**
	 * Dessine une case vierge c'est à dire une case grise foncee
	 */
	public void Dessiner(){
		this.bool1=false;
		this.bool2=false;
		this.o='p';
		this.repaint();
	}
}
