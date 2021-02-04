import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
/**
 * La classe <code>Choix</code> concerne l'affichage du choix des colonnes et lignes
 * dans le menu avec l'aide de boutons representees sous la forme d'images.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class Choix extends JComponent {
	/**
	 * Image du bouton plus pour les lignes.
	 */
	private Image plus1;
	/**
	 * Image du bouton plus pour les colonnes.
	 */
	private Image plus2;
	/**
	 * Image du bouton plus 1 pour les bombes.
	 */
	private Image plus31;
	/**
	 * Image du bouton plus 10 pour les bombes.
	 */
	private Image plus32;
	/**
	 * Image du bouton plus 100 pour les bombes.
	 */
	private Image plus33;
	/**
	 * Image du bouton moins pour les lignes.
	 */
	private Image moins1;
	/**
	 * Image du bouton moins pour les colonnes.
	 */
	private Image moins2;
	/**
	 * Image du bouton moins 1 pour les bombes.
	 */
	private Image moins31;
	/**
	 * Image du bouton moins 10 pour les bombes.
	 */
	private Image moins32;
	/**
	 * Image du bouton moins 100 pour les bombes.
	 */
	private Image moins33;
	/**
	 * Image du bouton jouer.
	 *
	 *
	 * Images mises en attributs pour pouvoir être redessines (effet de surbrillance du bouton)
	 * dans une autre methode de la classe.
	 */
	private Image jouer;
	/**
	 * L'affichage du nombre de lignes avec la une police en image
	 * en tableau pour l'affichage de plusieurs chiffres.
	 */
	private Image[] chiffre1;
	/**
	 * L'affichage du nombre de colonnes avec la une police en image
	 * en tableau pour l'affichage de plusieurs chiffres.
	 */
	private Image[] chiffre2;
	/**
	 * L'affichage du nombre de bombes avec la une police en image
	 * en tableau pour l'affichage de plusieurs chiffres.
	 */
	private Image[] chiffre3;
	/**
	 * Attribut representant le nombre de lignes
	 * celui-ci est majore par 30 et minore par 4.
	 */
	private int lig;
	/**
	 * Attribut representant le nombre de colonnes
	 * celui-ci est majore par 30 et minore par 4.
	 */
	private int col;
	/**
	 * Attribut representant le nombre de bombes.
	 */
	private int bombe;
	/**
	 * Attribut representant l'unite du nombre de lignes
	 * il sera egal a 1 si le nombre de lignes s'ecrit sur 1 chiffre
	 * il sera egal a 2 si le nombre de lignes s'ecrit sur 2 chiffres
	 * il ne peut pas depasser 2 car le nombre max de lignes est de 30.
	 */
	private int compteur1;
	/**
	 * Attribut representant l'unite du nombre de colonnes
	 * il sera egal a 1 si le nombre de colonnes s'ecrit sur 1 chiffre
	 * il sera egal a 2 si le nombre de colonnes s'ecrit sur 2 chiffres
	 * il ne peut pas depasser 2 car le nombre max de colonnes est de 30.
	 */
	private int compteur2;
	/**
	 * Attribut representant l'unite du nombre de bombes
	 * il sera egal a 1 si le nombre de bombes s'ecrit sur 1 chiffre
	 * il sera egal a 2 si le nombre de bombes s'ecrit sur 2 chiffres
	 * il sera egal a 3 si le nombre de bombes s'ecrit sur 3 chiffres
	 * il ne peut pas depasser 3 car le nombre max de bombes est de 899
	 * =(nombre_max_lignes*nombre_max_colonnes)-1.
	 */
	private int compteur3;
	/**
	 * Attribut representant l'etat du bouton jouer car lors de la surbrillance,
	 * celui-ci est plus large donc il faut le replacer sur le panneau
	 * = true lorsque le bouton surbrille
	 * = false lorsque le bouton ne surbrille pas.
	 */
	private boolean switchh=false;
	/**
	 * Attribut representant la fenetre du choix.
	 */
	private FenMenu b;
	public Choix(FenMenu m){
		super();
		this.lig = 4;
		this.col = 4;
		this.bombe=1;
		this.b = new FenMenu();
		this.b = m;
		this.compteur1=1;
		this.compteur2=1;
		this.compteur3=1;
		this.chiffre1 = new Image[2];
		this.chiffre2 = new Image[2];
		this.chiffre3 = new Image[3];
		this.chiffre1[0] = Toolkit.getDefaultToolkit().getImage("../img/4.png");
		this.chiffre2[0] = Toolkit.getDefaultToolkit().getImage("../img/4.png");
		this.chiffre3[0] = Toolkit.getDefaultToolkit().getImage("../img/1.png");
		this.jouer =  Toolkit.getDefaultToolkit().getImage("../img/jouuer1.png");
		this.plus1=Toolkit.getDefaultToolkit().getImage("../img/+.png");
		this.plus2=Toolkit.getDefaultToolkit().getImage("../img/+.png");
		this.plus31=Toolkit.getDefaultToolkit().getImage("../img/+ 11.png");
		this.plus32=Toolkit.getDefaultToolkit().getImage("../img/+ 101.png");
		this.plus33=Toolkit.getDefaultToolkit().getImage("../img/+ 100.png");
		this.moins1=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		this.moins2=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		this.moins31=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		this.moins32=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		this.moins33=Toolkit.getDefaultToolkit().getImage("../img/-.png");
	}
	/**
	 * Affichage du choix et les conditions traitent le cas de l'affichage
	 * de plusieurs chiffres pour les lignes, colonnes et bombes (reajustement abcisse et ordonnee).
	 */
	@Override
	public void paintComponent(Graphics pinceau) {
		Graphics secondPinceau = pinceau.create();
		if (this.isOpaque()) { 
			secondPinceau.setColor(this.getBackground());
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/Choix.png"),0,0,this);
		if(!this.switchh){
			secondPinceau.drawImage(this.jouer,230,115,this);
		}else{
			secondPinceau.drawImage(this.jouer,225,110,this);
		}
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/lignes.png"),20,180,this);
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/colonnes.png"),20,290,this);
		secondPinceau.drawImage(this.moins1,353,180,this);
		secondPinceau.drawImage(this.plus1,573,180,this);
		secondPinceau.drawImage(this.moins2,353,290,this);
		secondPinceau.drawImage(this.plus2,573,290,this);
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/bombes.png"),20,480,this);
		secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("../img/boomb.png"),242,480,this);
		secondPinceau.drawImage(this.plus31,573,410,this);
		secondPinceau.drawImage(this.plus32,573,474,this);
		secondPinceau.drawImage(this.plus33,573,538,this);
		secondPinceau.drawImage(this.moins31,353,410,this);
		secondPinceau.drawImage(this.moins32,353,474,this);
		secondPinceau.drawImage(this.moins33,353,538,this);
		if(this.compteur2==1){
			secondPinceau.drawImage(this.chiffre2[0],473,297,this);
		}else if(this.compteur2==2){
			secondPinceau.drawImage(this.chiffre2[0],461,297,this);
			secondPinceau.drawImage(this.chiffre2[1],487,297,this);
		}
		if(this.compteur1==1){
			secondPinceau.drawImage(this.chiffre1[0],473,190,this);
		}else if(this.compteur1==2){
			secondPinceau.drawImage(this.chiffre1[0],461,190,this);
			secondPinceau.drawImage(this.chiffre1[1],487,190,this);
		}
		if(this.compteur3==1){
			secondPinceau.drawImage(this.chiffre3[0],473,483,this);
		}else if(this.compteur3==2){
			secondPinceau.drawImage(this.chiffre3[0],461,483,this);
			secondPinceau.drawImage(this.chiffre3[1],487,483,this);
		}else if(this.compteur3==3){
			secondPinceau.drawImage(this.chiffre3[0],449,483,this);
			secondPinceau.drawImage(this.chiffre3[1],480,483,this);
			secondPinceau.drawImage(this.chiffre3[2],511,483,this);
		}
	}
	/**
	 * Methode qui traite les cas de surbrillance en fonction de la coordonnee
	 * du x et y.
	 */
	public void Surbrillance(int x, int y){
		if(x>=230 && x<=414 && y>=(115) && y<=(180)){
			this.switchh=true;
			this.jouer=Toolkit.getDefaultToolkit().getImage("../img/jouuer.png");
		}else{
			this.switchh=false;
			this.jouer=Toolkit.getDefaultToolkit().getImage("../img/jouuer1.png");
		}
		if(x>=573 && x<=633 && y>=(246-66) && y<=(307-66)){
			this.plus1=Toolkit.getDefaultToolkit().getImage("../img/+1.png");
		}else{
			this.plus1=Toolkit.getDefaultToolkit().getImage("../img/+.png");
		}
		if(x>=353 && x<=413 && y>=(246-66) && y<=(307-66)){
			this.moins1=Toolkit.getDefaultToolkit().getImage("../img/-1.png");
		}else{
			this.moins1=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		}
		if(x>=573 && x<=633 && y>=(356-66) && y<=(417-66)){
			this.plus2=Toolkit.getDefaultToolkit().getImage("../img/+1.png");
		}else{
			this.plus2=Toolkit.getDefaultToolkit().getImage("../img/+.png");
		}
		if(x>=353 && x<=413 && y>=(356-66) && y<=(417-66)){
			this.moins2=Toolkit.getDefaultToolkit().getImage("../img/-1.png");
		}else{
			this.moins2=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		}
		if(x>=573 && x<=633 && y>=(410) && y<=(471)){
			this.plus31=Toolkit.getDefaultToolkit().getImage("../img/+111.png");
		}else{
			this.plus31=Toolkit.getDefaultToolkit().getImage("../img/+ 11.png");
		}
		if(x>=573 && x<=633 && y>=(474) && y<=(535)){
			this.plus32=Toolkit.getDefaultToolkit().getImage("../img/+101.png");
		}else{
			this.plus32=Toolkit.getDefaultToolkit().getImage("../img/+ 101.png");
		}
		if(x>=573 && x<=633 && y>=(538) && y<=(599)){
			this.plus33=Toolkit.getDefaultToolkit().getImage("../img/+10001.png");
		}else{
			this.plus33=Toolkit.getDefaultToolkit().getImage("../img/+ 100.png");
		}
		if(x>=353 && x<=413 && y>=(410) && y<=(471)){
			this.moins31=Toolkit.getDefaultToolkit().getImage("../img/-1.png");
		}else{
			this.moins31=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		}
		if(x>=353 && x<=413 && y>=(474) && y<=(535)){
			this.moins32=Toolkit.getDefaultToolkit().getImage("../img/-1.png");
		}else{
			this.moins32=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		}
		if(x>=353 && x<=413 && y>=(538) && y<=(599)){
			this.moins33=Toolkit.getDefaultToolkit().getImage("../img/-1.png");
		}else{
			this.moins33=Toolkit.getDefaultToolkit().getImage("../img/-.png");
		}
		this.repaint();
	}
	/**
	 * Methode qui convertie un chiffre en l'image de ce chiffre.
	 */
	private Image Conversion(int nb){
		if(nb==0){
			return Toolkit.getDefaultToolkit().getImage("../img/0.png");
		}
		if(nb==1){
			return Toolkit.getDefaultToolkit().getImage("../img/1.png");
		}
		if(nb==2){
			return Toolkit.getDefaultToolkit().getImage("../img/2.png");
		}
		if(nb==3){
			return Toolkit.getDefaultToolkit().getImage("../img/3.png");
		}
		if(nb==4){
			return Toolkit.getDefaultToolkit().getImage("../img/4.png");
		}
		if(nb==5){
			return Toolkit.getDefaultToolkit().getImage("../img/5.png");
		}
		if(nb==6){
			return Toolkit.getDefaultToolkit().getImage("../img/6.png");
		}
		if(nb==7){
			return Toolkit.getDefaultToolkit().getImage("../img/7.png");
		}
		if(nb==8){
			return Toolkit.getDefaultToolkit().getImage("../img/8.png");
		}
		if(nb==9){
			return Toolkit.getDefaultToolkit().getImage("../img/9.png");
		}
		return Toolkit.getDefaultToolkit().getImage("../img/1.png");
	}
	/**
	 * Methode qui s'occupe de l'augmentation ou la diminution du nombre de lignes, de colonnes
	 * ou de bombes lorsque le joueur clique sur le plus ou le moins (depend de la coordonne x et y) et traite le cas du clique
	 * sur le bouton jouer en affichant la fenetre de jeu en fonction du nombre choisit de lignes
	 * et de colonnes et en faisant disparaitre la fenetre du menu.
	 */
	public void Chiffres(int x, int y){
		if(x>=230 && x<=414 && y>=(115) && y<=(180)){
			JFr a = new JFr(this.lig,this.col,this.bombe);
			a.setLocation(50,50);
			a.setVisible(true);
			this.b.dispose();
		}
		if(x>=573 && x<=633 && y>=(246-66) && y<=(307-66)){
			if(this.lig<30){
				this.lig++;
				if(this.lig>=10){
					this.compteur1=2;
					this.chiffre1[0]=this.Conversion(this.lig/10);
					this.chiffre1[1]=this.Conversion(this.lig%10);
				}else{
					this.compteur1=1;
					this.chiffre1[0]=this.Conversion(this.lig);
				}
			}
		}
		if(x>=353 && x<=413 && y>=(246-66) && y<=(307-66)){
			if(this.lig-1>=4){
				this.lig--;
				if(this.lig>=10){
					this.compteur1=2;
					this.chiffre1[0]=this.Conversion(this.lig/10);
					this.chiffre1[1]=this.Conversion(this.lig%10);
				}else{
					this.compteur1=1;
					this.chiffre1[0]=this.Conversion(this.lig);
				}
			}
		}
		if(x>=573 && x<=633 && y>=(356-66) && y<=(417-66)){
			if(this.col<30){
				this.col++;
				if(this.col>=10){
					this.compteur2=2;
					this.chiffre2[0]=this.Conversion(this.col/10);
					this.chiffre2[1]=this.Conversion(this.col%10);
				}else{
					this.compteur2=1;
					this.chiffre2[0]=this.Conversion(this.col);
				}
			}
		}
		if(x>=353 && x<=413 && y>=(356-66) && y<=(417-66)){
			if(this.col-1>=4){
				this.col--;
				if(this.col>=10){
					this.compteur2=2;
					this.chiffre2[0]=this.Conversion(this.col/10);
					this.chiffre2[1]=this.Conversion(this.col%10);
				}else{
					this.compteur2=1;
					this.chiffre2[0]=this.Conversion(this.col);
				}
			}
		}
		if(x>=573 && x<=633 && y>=(410) && y<=(471)){
			if(this.bombe+1<this.lig*this.col){
				this.bombe++;
				if(this.bombe>=100){
					this.compteur3=3;
					this.chiffre3[0]=this.Conversion(this.bombe/100);
					this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
					this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
				}else if(this.bombe<100 && this.bombe>=10){
					this.compteur3=2;
					this.chiffre3[0]=this.Conversion(this.bombe/10);
					this.chiffre3[1]=this.Conversion(this.bombe%10);
				}else if(this.bombe<10){
					this.compteur3=1;
					this.chiffre3[0]=this.Conversion(this.bombe);
				}
			}
		}
		if(x>=573 && x<=633 && y>=(538) && y<=(599)){
			if(this.bombe+100<this.lig*this.col){
				this.bombe+=100;
				this.compteur3=3;
				this.chiffre3[0]=this.Conversion(this.bombe/100);
				this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
				this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
			}
		}
		if(x>=573 && x<=633 && y>=(474) && y<=(535)){
			if(this.bombe+10<this.lig*this.col){
				this.bombe+=10;
				if(this.bombe>=100){
					this.compteur3=3;
					this.chiffre3[0]=this.Conversion(this.bombe/100);
					this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
					this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
				}else if(this.bombe<100 && this.bombe>=10){
					this.compteur3=2;
					this.chiffre3[0]=this.Conversion(this.bombe/10);
					this.chiffre3[1]=this.Conversion(this.bombe%10);
				}
			}
		}
		if(x>=353 && x<=413 && y>=(410) && y<=(471)){
			if(this.bombe-1>0){
				this.bombe--;
				if(this.bombe>=100){
					this.compteur3=3;
					this.chiffre3[0]=this.Conversion(this.bombe/100);
					this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
					this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
				}else if(this.bombe<100 && this.bombe>=10){
					this.compteur3=2;
					this.chiffre3[0]=this.Conversion(this.bombe/10);
					this.chiffre3[1]=this.Conversion(this.bombe%10);
				}else if(this.bombe<10){
					this.compteur3=1;
					this.chiffre3[0]=this.Conversion(this.bombe);
				}
			}
		}
		if(x>=353 && x<=413 && y>=(538) && y<=(599)){
			if(this.bombe-100>0){
				this.bombe-=100;
				if(this.bombe>=100){
					this.compteur3=3;
					this.chiffre3[0]=this.Conversion(this.bombe/100);
					this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
					this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
				}else if(this.bombe<100 && this.bombe>=10){
					this.compteur3=2;
					this.chiffre3[0]=this.Conversion(this.bombe/10);
					this.chiffre3[1]=this.Conversion(this.bombe%10);
				}else if(this.bombe<10){
					this.compteur3=1;
					this.chiffre3[0]=this.Conversion(this.bombe);
				}
			}
		}
		if(x>=353 && x<=413 && y>=(474) && y<=(535)){
			if(this.bombe-10>0){
				this.bombe-=10;
				if(this.bombe>=100){
					this.compteur3=3;
					this.chiffre3[0]=this.Conversion(this.bombe/100);
					this.chiffre3[1]=this.Conversion((this.bombe%100)/10);
					this.chiffre3[2]=this.Conversion((this.bombe%100)%10);
				}else if(this.bombe<100 && this.bombe>=10){
					this.compteur3=2;
					this.chiffre3[0]=this.Conversion(this.bombe/10);
					this.chiffre3[1]=this.Conversion(this.bombe%10);
				}else if(this.bombe<10){
					this.compteur3=1;
					this.chiffre3[0]=this.Conversion(this.bombe);
				}
			}
		}
		this.repaint();
	}
	
}
