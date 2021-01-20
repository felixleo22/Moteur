package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import projet_zeldiablo.Bob;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeAventurier;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeBob;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeAventurier = new Commande();
		if (Bob.commande)
			this.commandeBob = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommandeAventurier() {
		return commandeAventurier;
	}

	public Commande getCommandeBob() {
		return commandeBob;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case KeyEvent.VK_Q :
			this.commandeAventurier.gauche = true;
			break;
			// si on appuie sur 'd',commande joueur est droite
		case KeyEvent.VK_D :
			this.commandeAventurier.droite = true;
			break;
			// si on appuie sur 'z',commande joueur est haut
		case KeyEvent.VK_Z :
			this.commandeAventurier.haut = true;
			break;
			// si on appuie sur 's',commande joueur est bas
		case KeyEvent.VK_S :
			this.commandeAventurier.bas = true;
			break;
		case KeyEvent.VK_SPACE :
			this.commandeAventurier.tir = true;
			break;
		}
		if(Bob.commande) {
			switch (e.getKeyCode()) {
			// si on appuie sur flèche de gauche, commande joueur est gauche
			case KeyEvent.VK_LEFT :
				this.commandeBob.gauche = true;
				break;
				// si on appuie sur flèche de droite,commande joueur est droite
			case KeyEvent.VK_RIGHT:
				this.commandeBob.droite = true;
				break;
				// si on appuie sur flèche du haut,commande joueur est haut
			case KeyEvent.VK_UP:
				this.commandeBob.haut = true;
				break;
				// si on appuie sur flèche du bas,commande joueur est bas
			case KeyEvent.VK_DOWN:
				this.commandeBob.bas = true;
				break;
			}
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:
			this.commandeAventurier.gauche = false;
			break;
		case KeyEvent.VK_D:
			this.commandeAventurier.droite = false;
			break;
		case KeyEvent.VK_Z:
			this.commandeAventurier.haut = false;
			break;
		case KeyEvent.VK_S:
			this.commandeAventurier.bas = false;
			break;
		case KeyEvent.VK_SPACE:
			this.commandeAventurier.tir = false;
			break;
		}
		if(Bob.commande) {
			switch (e.getKeyCode()) {
			// si on appuie sur flèche de gauche, commande joueur est gauche
			case KeyEvent.VK_LEFT :
				this.commandeBob.gauche = false;
				break;
				// si on appuie sur flèche de droite,commande joueur est droite
			case KeyEvent.VK_RIGHT:
				this.commandeBob.droite = false;
				break;
				// si on appuie sur flèche du haut,commande joueur est haut
			case KeyEvent.VK_UP:
				this.commandeBob.haut = false;
				break;
				// si on appuie sur flèche du bas,commande joueur est bas
			case KeyEvent.VK_DOWN:
				this.commandeBob.bas = false;
				break;
			}
		}

	}

	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
