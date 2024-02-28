package fr.ecole3il.rodez2023.carte.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.List;

public interface AlgorithmeChemin<E> {



    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);

    public Chemin trouverChemin(Carte carte, int caseDepartX, int caseDepartY, int caseArriveeX, int caseArriveeY);
}
