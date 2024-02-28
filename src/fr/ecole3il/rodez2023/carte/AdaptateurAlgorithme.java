package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.elements.*;

import java.util.List;

public class AdaptateurAlgorithme<E> {
    private Carte carte;

    private Noeud<E> noeud;

    private Graphe<E> graphe;

    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        return new Chemin((List<Case>) algorithme); //TODO a corriger
    }

    public static Graphe<Case> creerGraphe(Carte carte) {
        return null;
    }

    public static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {

    }

    public static double calculerCout(Case from, Case to) {
        return 0.0;
    }

    public static void afficherChemin(List<Noeud<Case>> chemin) {

    }
}
