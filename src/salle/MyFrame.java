package salle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
   	 super();
   	 setUp();
    }

    public void setUp() {
   	 
   	 JPanel pan = new JPanel();
    
   	 this.setContentPane(pan);
   	 pan.setLayout( new BorderLayout());

   	 //pan.setBackground(Color.pink);

   	 JLabel lb = new JLabel("MENU DU JOUR");
   	 lb.setHorizontalAlignment(JLabel.CENTER);
   	 lb.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
   			 BorderFactory.createEmptyBorder(8, 3, 3, 8)));
   	 pan.add(lb, BorderLayout.NORTH);

   	 JPanels w = new JPanels("Entrées", "tomate", "champignons", "Feuilleté au fromage");
   	 pan.add(w, BorderLayout.WEST);

   	 JPanels e = new JPanels("Dessert", "gateau", "crêpe", "pomme");
   	 pan.add(e, BorderLayout.EAST);
   	 
   	 
   	 JPanels c = new JPanels("Plat", "pizza", "frite", "poulet");
   	 pan.add(c, BorderLayout.CENTER);
   	 
   	 JPanelSouth s = new JPanelSouth();
   	 pan.add(s, BorderLayout.SOUTH);
   	 

   	 // Redimensionnement optimal
   	 pack();
   	 // Gestion de la fermeture
   	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   	 // Positionnement au centre de l'écran
   	 setLocationRelativeTo(null);
   	 // Affichage
   	 setVisible(true);

   	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // quand on ferme la fenêtre (le cadre) le programme

    }

}
