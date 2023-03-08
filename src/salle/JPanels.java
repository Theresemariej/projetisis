package salle;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class JPanels extends JPanel {

	private String nom;
	private String n1;
	private String n2;
	private String n3;

	public JPanels(String nom, String n1, String n2, String n3) {

		this.nom = nom;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;

		setUp();
	}

	private void setUp() {
		this.setPreferredSize(new Dimension(200, 400));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
				BorderFactory.createEmptyBorder(8, 3, 3, 8)));

		this.setLayout(new GridLayout(4, 1, 5, 5));
		JLabel p = new JLabel(nom);
		p.setHorizontalAlignment(JLabel.CENTER);

		this.add(p);

		this.add(new JButtons(n1));
		this.add(new JButtons(n2));
		this.add(new JButtons(n3));
	}

}
