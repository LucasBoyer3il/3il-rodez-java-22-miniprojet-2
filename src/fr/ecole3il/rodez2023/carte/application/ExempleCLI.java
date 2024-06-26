package fr.ecole3il.rodez2023.carte.application;

import fr.ecole3il.rodez2023.carte.AdaptateurAlgorithme;
import fr.ecole3il.rodez2023.carte.algorithmes.AlgorithmeAEtoile;
import fr.ecole3il.rodez2023.carte.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.algorithmes.AlgorithmeDijkstra;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.manipulateurs.GenerateurCarte;

/**
 * @author p.roquart
 */
public class ExempleCLI {

	public static void main(String[] args) {
		GenerateurCarte generateur = new GenerateurCarte();
		Carte test = generateur.genererCarte(100,100);
		AlgorithmeChemin algoChemin = new AlgorithmeDijkstra();
		Chemin chemin = algoChemin.trouverChemin(test, 0, 0, 50, 50);
		chemin.afficherChemin();
		chemin = algoChemin.trouverChemin(test, 0, 0, 50, 50);
		chemin.afficherChemin();
	}
	
}
