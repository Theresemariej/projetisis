import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vision {
		public HashMap map;

	public Vision() {
		this.map= new HashMap<JButtons, Integer>();
		

	}

	public void recap(JPanels w, JLabel texte) {

		for (JButtons b : w.getListB()) {
			b.addActionListener(ef -> {// on ajoute une action au bouton b
				b.getP().setQtt(b.getP().getQtt() + 1);// getP ça renvoie le plat qui correspond au bouton
				// du coup on prend l'ecriture du bouton b et on modifie sa qtt; à chaque fois
				// qu'on clique dessus, on ajoute 1.
				texte.setText(// on modifie le texte contenu dans le label ENTREE
						texte.getText() // du coup toujours dans le label qui est dans mon panel s on ecrit
										// un texte
								+ b.getP().getDescription()// dans le bouton b on prend la description et on l'écrit
								+ "x" + b.getP().getQtt());

			});
		}
	}
	
	
}