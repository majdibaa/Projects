import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * La classe <code>JFr</code> correspond à la fenetre de jeu.
 *
 * @version 0.1
 * @author Majdi Baaziz et Nathan Bernard
 */
public class JFr extends JFrame {
	/**
	 * Panneau de jeu qui va etre affiche.
	 */
	private Fenetre x;
	public JFr(int lignes, int colonnes, int bombes){
		super("MineSweeper");
		this.x = new Fenetre(lignes,colonnes,bombes);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.x.setSize(30*colonnes,30*lignes);
		if(this.x.getHeight()<400){
			this.setSize(this.x.getWidth()+370,this.x.getHeight()+126);
		}else{
			this.setSize(this.x.getWidth()+370,this.x.getHeight()+50);
		}
		this.x.setLocation(20,20);
		JPanel pan = new JPanel();
		this.setResizable(false);
		pan.setBackground(Color.WHITE);
		pan.setLayout(null);
		Gameplay game = new Gameplay(this);
		game.setSize(this.getWidth()-this.x.getWidth(),this.getHeight());
		game.setLocation(this.x.getWidth()+20,0);
		pan.addMouseMotionListener(new MotionGame(game));
		this.x.addMouseListener(new CliqueActu(game));
		pan.addMouseListener(new CliqueSaveGame(game));
		pan.add(game);
		this.addWindowListener(new WindowControl(this));
		pan.add(this.x);
		this.add(pan);
	}
	public JFr(Fenetre b){
		super();
		this.x =b;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.x.setSize(new Dimension(30*this.x.getCol(),30*this.x.getLig()));
		if(this.x.getHeight()<400){
			this.setSize(this.x.getWidth()+350,this.x.getHeight()+126);
		}else{
			this.setSize(this.x.getWidth()+350,this.x.getHeight()+26);
		}
		this.x.setLocation(20,20);
		JPanel pan = new JPanel();
		this.setResizable(false);
		pan.setBackground(Color.WHITE);
		pan.setLayout(null);
		Gameplay game = new Gameplay(this);
		game.setSize(this.getWidth()-this.x.getWidth(),this.getHeight());
		game.setLocation(this.x.getWidth()+20,0);
		pan.addMouseMotionListener(new MotionGame(game));
		this.x.addMouseListener(new CliqueActu(game));
		pan.addMouseListener(new CliqueSaveGame(game));
		pan.add(game);
		this.addWindowListener(new WindowControl(this));
		pan.add(this.x);
		this.add(pan);
	}
	/**
	 * Enregistre la partie si celle-ci est encore en cours.
	 */
	public void Enregistrement(){
		if(this.x.getGameStatus()==0){
			int lig = this.x.getLig();
			int col = this.x.getCol();
			char[][] ouvertoupas = new char[lig][col];
			ouvertoupas = this.x.getOuverture();
			char[][] chr = new char[lig][col];
			chr = this.x.getClick();
			boolean[][] alea = new boolean[lig][col];
			alea = this.x.getBomb();
			int aleatoire = this.x.getBombes();
			try{
				DataOutputStream ecrit = new DataOutputStream(new FileOutputStream("log"));
				try{
					ecrit.writeInt(lig);
					ecrit.writeInt(col);
					ecrit.writeInt(aleatoire);
					for(int i=0;i<lig;i++){
						for(int j=0;j<col;j++){
							ecrit.writeChar(chr[i][j]);
						}
					}
					for(int i=0;i<lig;i++){
						for(int j=0;j<col;j++){
							ecrit.writeChar(ouvertoupas[i][j]);
						}
					}
					for(int i=0;i<lig;i++){
						for(int j=0;j<col;j++){
							ecrit.writeBoolean(alea[i][j]);
						}
					}
					ecrit.close();
				}catch(IOException e){}
			}catch(FileNotFoundException e){}
		}else{
			try{
				BufferedWriter ecrit = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("log")));
				ecrit.write("");
				ecrit.close();
			}catch(IOException e){}
		}
	}
	/**
	 * Renvoie la largeur de la grille du demineur.
	 */
	public int getTailleX(){
		return this.x.getWidth();
	}
	/**
	 * Renvoie l' etat de jeu de la partie.
	 */
	public int getGameStatus(){
		return this.x.getGameStatus();
	}
	/**
	 * Renvoie le nombre de bombes.
	 */
	public int getBombes(){
		return this.x.getBombes();
	}
	/**
	 * Renvoie le nombre de drapeaux contenus dans la grille.
	 */
	public int getDrap(){
		return this.x.getDrap();
	}
	/**
	 * Renvoie le nombre de cases ouvertes.
	 */
	public int getOpen(){
		return this.x.getOpen();
	}
	
}