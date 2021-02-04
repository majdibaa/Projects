import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * La classe <code>Fenetre</code> represente la grille du demineur.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class Fenetre extends JPanel{
	/**
	 * Tableau representant la presence des bombes (true pour une bombe).
	 */
	private boolean[][] alea;
	/**
	 * Tableau montrant l'etat de chaque case : 'O' pour ouvert, 'D' pour drapeau, 'I' pour 
	 * point d'interrogation et 'X' pour ferme.
	 */
	private char[][] ouvertoupas;
	/**
	 * Tableau de cases de demineur
	 */
	private Dessin[][] tab;
	/**
	 * Attribut representant le nombre de colonnes.
	 */
	private int col;
	/**
	 * Attribut representant le nombre de lignes.
	 */
	private int lig;
	/**
	 * Tableau montrant l'etat de la recursivite pour chaque case : 'O' si la recursivite est passee
	 * par la case et 'X' si elle n'est pas passee. 
	 */
	private char[][] chr;
	/**
	 * Attribut correspondant à l'etat d'une partie : 0 = partie en cours,
	 * 1 = partie perdue et 2 = partie gagnee.
	 */
	private int jeu=0;
	/**
	 * Attribut correspondant au nombre de bombes
	 */
	private int aleatoire;
	/**
	 * On cree une grille a partir du panneau decoupe en lignes, colonnes (parametres) et on positionne
	 * aleatoirement dans la grille  creee des bombes (dans le tableau attribut alea). Par defaut, toutes les 
	 * cases sont automatiquement fermees.
	 */
	public Fenetre(int lignes, int colonnes, int bombes){
		super();
		GridLayout grille = new GridLayout(lignes,colonnes,5,5);
		this.col=colonnes;
		this.lig=lignes;
		this.setLayout(grille);
		this.tab = new Dessin[lignes][colonnes];
		this.chr = new char[lignes][colonnes];
		this.ouvertoupas=new char[lignes][colonnes];
		this.addMouseListener(new Mousemotion(this));
		this.aleatoire=bombes;
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.tab[i][j]=new Dessin();
			}
		}
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.ouvertoupas[i][j]='X';
			}
		}
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.chr[i][j]='X';
			}
		}
		this.alea = new boolean[lignes][colonnes];
		for(int i=0;i<this.aleatoire;i++){
			Random j = new Random();
			int lignealea = j.nextInt(lignes);
			int colalea = j.nextInt(colonnes);
			while(this.alea[lignealea][colalea]){
				lignealea = j.nextInt(lignes);
				colalea = j.nextInt(colonnes);
			}
			this.alea[lignealea][colalea]=true;
		}
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.add(this.tab[i][j]);
			}
		}
	}
	/**
	 * Renvoie le nombre de cases ouvertes
	 */
	public int getOpen(){
		int p=0;
		for(int i=0;i<this.lig;i++){
			for(int j=0;j<this.col;j++){
				if(this.ouvertoupas[i][j]=='O'){
					p++;
				}
			}
		}
		return p;
	}
	public Fenetre(int lignes, int colonnes, int bombes, boolean[][] alea, char[][] ouvertoupas,char[][] chr){
		super();
		GridLayout grille = new GridLayout(lignes,colonnes,5,5);
		this.col=colonnes;
		this.lig=lignes;
		this.setLayout(grille);
		this.tab = new Dessin[lignes][colonnes];
		this.chr = new char[lignes][colonnes];
		this.ouvertoupas=new char[lignes][colonnes];
		this.addMouseListener(new Mousemotion(this));
		this.aleatoire=bombes;
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.tab[i][j]=new Dessin();
			}
		}
		this.ouvertoupas=ouvertoupas;
		this.chr=chr;
		this.alea = new boolean[lignes][colonnes];
		this.alea=alea;
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				if(this.ouvertoupas[i][j]=='O'){
					this.tab[i][j].Dessiner(this.Compt(i,j));
				}
				if(this.ouvertoupas[i][j]=='I'){
					this.tab[i][j].Dessiner('a');
				}
				if(this.ouvertoupas[i][j]=='D'){
					this.tab[i][j].Dessiner('b');
				}
			}
		}
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				this.add(this.tab[i][j]);
			}
		}
	}
	/**
	 * Renvoie le nombre de drapeaux positionnes.
	 */
	public int getDrap(){
		int b=0;
		for(int i=0;i<this.lig;i++){
			for(int j=0;j<this.col;j++){
				if(this.ouvertoupas[i][j]=='D'){
					b++;
				}
			}
		}
		return b;
	}
	/**
	 * Renvoie l'etat de la partie.
	 */
	public int getGameStatus(){
		return this.jeu;
	}
	/**
	 * Renvoie le tableau de bombes.
	 */
	public boolean[][] getBomb(){
		return this.alea;
	}
	/**
	 * Renvoie le tableau de cases ouvertes.
	 */
	public char[][] getOuverture(){
		return this.ouvertoupas;
	}
	/**
	 * Renvoie le nombre de colonnes.
	 */
	public int getCol(){
		return this.col;
	}
	/**
	 * Renvoie le nombre de lignes.
	 */
	public int getLig(){
		return this.lig;
	}
	/**
	 * Renvoie le tableau de cases cliquees.
	 */
	public char[][] getClick(){
		return this.chr;
	}
	/**
	 * Renvoie le nombre de bombes.
	 */
	public int getBombes(){
		return this.aleatoire;
	}
	/**
	 * Renvoie le nombre de bombes adjacentes à la case
	 * situee aux coordonnees [yInfo][xInfo].
	 */
	private int Compt(int yInfo, int xInfo){
		int compteur=0;
		if(this.alea[yInfo][xInfo]){
			return -1;
		}
		else{
			if(yInfo-1>=0){
				if(xInfo-1>=0){
					if(this.alea[yInfo-1][xInfo-1]){
						compteur++;
					}
				}
				if(xInfo+1<this.col){
					if(this.alea[yInfo-1][xInfo+1]){
					compteur++;
					}
				}
				if(this.alea[yInfo-1][xInfo]){
					compteur++;
				}
			}
			if(xInfo-1>=0){
				if(this.alea[yInfo][xInfo-1]){
					compteur++;
				}
				if(yInfo+1<this.lig){
					if(this.alea[yInfo+1][xInfo-1]){
						compteur++;
					}
				}
			}
			if(yInfo+1<this.lig){
				if(this.alea[yInfo+1][xInfo]){
					compteur++;
				}
				if(xInfo+1<this.col){
					if(this.alea[yInfo+1][xInfo+1]){
						compteur++;
					}
				}
			}
			if(xInfo+1<this.col){
				if(this.alea[yInfo][xInfo+1]){
					compteur++;
				}
			}
		}
		return compteur;
	}
	/**
 	 * Renvoie la coordonnee X correspondant a la position X du curseur
 	 * donnee en parametre.
 	 */
	private int xValeur(int X){
		int i=0;
		Dessin b = this.tab[0][0];
		if(X>(5+(b.getWidth()))*i && X<(5+(b.getWidth()))*(i+1)){
		}else{
			while(X>(5+(b.getWidth()))*(i+1)){
				i++;
			}
		}
		return i;
	}
	/**
	 * Renvoie la coordonnee Y correspondant a la position Y du curseur
 	 * donnee en parametre.
 	 */
	private int yValeur(int Y){
		int i=0;
		Dessin b = this.tab[0][0];
		if(Y>(5+(b.getHeight()))*i && Y<(5+(b.getHeight()))*(i+1)){
		}else{
			while(Y>(5+(b.getHeight()))*(i+1)){
				i++;
			}
		}
		return i;
	}
	/**
	 * Attribut à une case aux coordonnes [X][Y](parametres) un drapeau ou un point d'interrogation en fonction de
	 * ce que la case possedait precedemment. Change les valeurs des tableaux attributs en consequence.
	 */
	public void Drapeau(int X, int Y){
		int y = this.xValeur(X);
		int x = this.yValeur(Y);
		if(jeu==0 && this.ouvertoupas[x][y]!='O'){
			if(this.ouvertoupas[x][y]=='D'){
				this.tab[x][y].Dessiner('a');
				this.ouvertoupas[x][y]='I';
			}else if(this.ouvertoupas[x][y]=='X'){
				this.tab[x][y].Dessiner('b');
				this.ouvertoupas[x][y]='D';
			}
			else if(this.ouvertoupas[x][y]=='I'){
				this.tab[x][y].Dessiner();
				this.ouvertoupas[x][y]='X';
			}
			this.Verification();
		}
	}
	/**
	 * Verifie si la partie est gagnee ou non.
	 */
	private void Verification(){
		if((this.getDrap()==this.aleatoire && this.getOpen()==((this.lig*this.col)-this.aleatoire)) || this.getOpen()==((this.lig*this.col)-this.aleatoire)){
			this.jeu=2;
		}
		
	}
	/**
	 * Lance le mecanisme de recursion si la case à la coordonnee [X][Y] ne contenait pas de bombe
	 * ou sinon il modifie la case en consequence. Change l'etat du jeu en consequence.
	 */
	public void Clique(int X, int Y){
		int curX=this.xValeur(X);
		int curY=this.yValeur(Y);
		if(this.Compt(curY,curX)==-1 && this.jeu==0 && this.ouvertoupas[curY][curX]!='D' && this.ouvertoupas[curY][curX]!='I'){
			for(int i=0;i<this.lig;i++){
				for(int j=0;j<this.col;j++){
					if(this.ouvertoupas[i][j]=='D' && !this.alea[i][j]){
						this.tab[i][j].Dessiner('b',true);
					}
					if(this.Compt(i,j)==-1){
 						this.tab[i][j].Dessiner(false);

					}
					if(i==curY && j==curX){
						this.tab[i][j].Dessiner(true);
					}
				}
			}
			this.jeu=1;
		}
		if(this.jeu==0 && this.ouvertoupas[curY][curX]!='D' && this.ouvertoupas[curY][curX]!='I'){
			this.Recursion(curY,curX);
			this.Verification();
		}
	}
	/**
	 * Ouvre la case à la coordonnee [y][x] (il faut pas qu'elle contienne de drapeau ou de point d'interrogation)
	 * et ouvre les 8 cases adjacentes (ouvre celles ne contenant ni de bombe, ni de drapeau et ni de point d'interrogation).
	 * Change les attributs tableaux en consequence.
	 */
	private void Ouverture(int y, int x){
		if(this.ouvertoupas[y][x]!='I' && this.ouvertoupas[y][x]!='D'){
			this.tab[y][x].Dessiner(this.Compt(y,x));
			this.ouvertoupas[y][x]='O';
			if(this.Compt(y,x)==0){
				if(y+1<this.lig && this.Compt(y+1,x)!=-1 && this.ouvertoupas[y+1][x]!='I' && this.ouvertoupas[y+1][x]!='D'){
					this.tab[y+1][x].Dessiner(this.Compt(y+1,x));
					this.ouvertoupas[y+1][x]='O';
					if(x+1<this.col && this.Compt(y+1,x+1)!=-1 && this.ouvertoupas[y+1][x+1]!='I' && this.ouvertoupas[y+1][x+1]!='D'){
						this.tab[y+1][x+1].Dessiner(this.Compt(y+1,x+1));
						this.ouvertoupas[y+1][x+1]='O';
					}
					if(x-1>=0 && this.Compt(y+1,x-1)!=-1 && this.ouvertoupas[y+1][x-1]!='I' && this.ouvertoupas[y+1][x-1]!='D'){
						this.tab[y+1][x-1].Dessiner(this.Compt(y+1,x-1));
						this.ouvertoupas[y+1][x-1]='O';
					}
				}
				if(x+1<this.col && this.Compt(y,x+1)!=-1 && this.ouvertoupas[y][x+1]!='I' && this.ouvertoupas[y][x+1]!='D'){
					this.tab[y][x+1].Dessiner(this.Compt(y,x+1));
					this.ouvertoupas[y][x+1]='O';
				}
				if(x-1>=0 && this.Compt(y,x-1)!=-1 && this.ouvertoupas[y][x-1]!='I' && this.ouvertoupas[y][x-1]!='D'){
					this.tab[y][x-1].Dessiner(this.Compt(y,x-1));
					this.ouvertoupas[y][x-1]='O';
				}
				if(y-1>=0 && this.Compt(y-1,x)!=-1 && this.ouvertoupas[y-1][x]!='I' && this.ouvertoupas[y-1][x]!='D'){
					this.tab[y-1][x].Dessiner(this.Compt(y-1,x));
					this.ouvertoupas[y-1][x]='O';
					if(x+1<this.col && this.Compt(y,x+1)!=-1 && this.ouvertoupas[y-1][x+1]!='I' && this.ouvertoupas[y-1][x+1]!='D'){
						this.tab[y-1][x+1].Dessiner(this.Compt(y-1,x+1));
						this.ouvertoupas[y-1][x+1]='O';
					}
					if(x-1>=0 && this.Compt(y,x-1)!=-1 && this.ouvertoupas[y-1][x-1]!='I' && this.ouvertoupas[y-1][x-1]!='D'){
						this.tab[y-1][x-1].Dessiner(this.Compt(y-1,x-1));
						this.ouvertoupas[y-1][x-1]='O';
					}
				}
			}
		}
	}
	/**
	 * Methode de recursion pour ouvrir toutes les cases vides adjacentes à la case aux coordonnees [y][x] (parametres) 
	 * jusqu'à ce qu'il y a une case contenant un nombre. Change les attributs tableaux en consequence.
	 */
	private void Recursion(int y, int x){
		if(this.Compt(y,x)==0){
			this.Ouverture(y,x);
			this.chr[y][x]='O';
			if(y+1<this.lig && this.chr[y+1][x]!='O' && this.Compt(y+1,x)==0){
				this.Recursion(y+1,x);
			}
			if(x+1<this.col && this.chr[y][x+1]!='O' && this.Compt(y,x+1)==0){
				this.Recursion(y,x+1);
			}
			if(x+1<this.col && y+1<this.lig && this.chr[y+1][x+1]!='O' && this.Compt(y+1,x+1)==0){
				this.Recursion(y+1,x+1);
			}
			if(x-1>=0 && y+1<this.lig && this.chr[y+1][x-1]!='O' && this.Compt(y+1,x-1)==0){
				this.Recursion(y+1,x-1);
			}
			if(x+1<this.col && y-1>=0 && this.chr[y-1][x+1]!='O' && this.Compt(y-1,x+1)==0){
				this.Recursion(y-1,x+1);
			}
			if(x-1>=0 && y-1>=0 && this.chr[y-1][x-1]!='O' && this.Compt(y-1,x-1)==0){
				this.Recursion(y-1,x-1);
			}
			if(y-1>=0 && this.chr[y-1][x]!='O' && this.Compt(y-1,x)==0){
				this.Recursion(y-1,x);
			}
			if(x-1>=0 && this.chr[y][x-1]!='O' && this.Compt(y,x-1)==0){
				this.Recursion(y,x-1);
			}
		}else{
			this.Ouverture(y,x);
			this.chr[y][x]='O';
		}
		
	}
}