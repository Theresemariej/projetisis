import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import org.json.simple.parser.ParseException;

public class MyFrame extends JFrame {

	private String fichier;
	private JPanels jp;
	private Lire lire;
	private Json json;
	private ArrayList<Plat> entreesChoisies;


	public MyFrame(String fichier) throws FileNotFoundException, IOException, ParseException {
		super();
		this.fichier = fichier;// fichier qui se trouve dans le chemin absolu qu'on donne dans le main.HAHAHAHAHAHAHAAHAHAHAHAAHAHA
		this.lire = new Lire();//c'est pour utiliser juste apres
		this.jp=new JPanels("Entree",lire.getListeEntrees());//l'arrayList des entrees est dans lire
		this.entreesChoisies=new ArrayList<Plat>();//C'est la liste de toutes les entrées (nom et qtt) sur lesquelles on a cliqué.
	
		setUp();
	}

	public void setUp() throws FileNotFoundException, IOException, ParseException {

		Lire lire = new Lire();
		Vision vision= new Vision();

		JPanel pan = new JPanel();

		this.setContentPane(pan);
		pan.setLayout(new BorderLayout());

		// § aspect de MENU DU JOUR
		JLabel lb = new JLabel("MENU DU JOUR");
		lb.setOpaque(true);
		lb.setBackground(Color.GRAY);
		lb.setForeground(Color.WHITE);

		// placement de MENU DU JOUR
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
				BorderFactory.createEmptyBorder(8, 3, 3, 8)));

		pan.add(lb, BorderLayout.NORTH);

		// On lit les entrees
		JPanels w = new JPanels("Entrées", lire.ListeDesEntrees(fichier));
		pan.add(w, BorderLayout.WEST);

		JPanels e = new JPanels("Desserts", lire.ListeDesDesserts(fichier));
		pan.add(e, BorderLayout.EAST);

		JPanels c = new JPanels("Plats", lire.ListeDesPlats(fichier));
		pan.add(c, BorderLayout.CENTER);

		JPanelSouth s = new JPanelSouth(entreesChoisies);
		pan.add(s, BorderLayout.SOUTH);
		
		vision.recap(w,s.getEntree());
		vision.recap(e,s.getDessert());
		vision.recap(c,s.getPlat());
		
		for(JButtons jb: jp.getListB()) {//ON REMPLI UNE ARRAYLIST QUAND ON CLIQUE SUR DES BOUTONS DE PLAT
		jb.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {

			//On crée un nouveau plat avec pour nom et id ce qu'y a écrit dans jb
			Plat entree = jb.getP();//jb c'est un bouton et getP renvoie le plat contenu dans jb
			entree.setQtt(1);//On modifie la qtt
			entreesChoisies.add(entree);
			
			System.out.println("menu: "+entreesChoisies);}
		});}
		
		//int a=jb.getQtt();//c'est la qtt du plat
		//a=a+1;//A chaque fois on ajoute 1 à la quantitée

		//on creee un nv plat id nom
		//a ce plat on modifie la quantité grace a une fonction quon crée dans plat
		//Arraylistedejason on ajoute plat

		// Redimensionnement optimal
		pack();
		// Gestion de la fermeture
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Positionnement au centre de l'écran
		setLocationRelativeTo(null);
		// Affichage
		setVisible(true);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // quand on ferme la fenêtre (le cadre), on ferme aussi
																// le programme

	}

	/**
	 * @return the entreesChoisies
	 */
	public ArrayList getEntreesChoisies() {
		return entreesChoisies;
	}

}