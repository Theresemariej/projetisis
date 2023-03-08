package salle;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class JPanelSouth extends JPanel{
	 

  	public JPanelSouth() {
  	 
 		 setUp();
		 }

		 private void setUp() {
			 
			 this.setLayout(new GridLayout(1,2,10,10));
			 
			 this.add(new JButtons("Annuler la commande"));
			 this.add(new JButtons("Commander"));
			 

			 

		 }
		 

	 
}
