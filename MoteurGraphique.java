package moteurJeu;

import projet_zeldiablo.Bob;

/**
 * classe MoteurGraphique represente un moteur de jeu generique.
 * 
 * On lui passe un jeu et un afficheur et il permet d'executer un jeu.
 */
public class MoteurGraphique {
	
	/**
	 * le jeu a executer
	 */
	private Jeu jeu;

	/**
	 * l'interface graphique
	 */
	private InterfaceGraphique gui;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private DessinJeu dessin;

	/**
	 * construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(Jeu pJeu, DessinJeu pAffiche) {
		// creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * permet de lancer le jeu
	 */
	public void lancerJeu(int width, int height) throws InterruptedException {

		// creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin,width,height);
		Controleur controle = this.gui.getControleur();
		// boucle de jeu
		while (!this.jeu.etreFini()) {
			// demande controle utilisateur
			Commande cA = controle.getCommandeAventurier();
			Commande cB = controle.getCommandeBob();
			Commande c = new Commande();
			if(!Bob.commande)
				cB=c;
			// fait evoluer le jeu
			this.jeu.evoluer(cA,cB);
			// affiche le jeu
			this.gui.dessiner();
			// met en attente
			Thread.sleep(10);
		}
	}

}
