package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.elements.*;

import java.util.ArrayList;
import java.util.List;

public class AdaptateurAlgorithme<E> {
    private Carte carte;

    private Noeud<E> noeud;

    private Graphe<E> graphe;

    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> noeudDepart = getNoeud(graphe, xDepart, yDepart);
        Noeud<Case> noeudArrivee = getNoeud(graphe, xArrivee, yArrivee);
        List<Noeud<Case>> cheminNoeuds = algorithme.trouverChemin(graphe, noeudDepart, noeudArrivee);
        List<Case> cheminCases = new ArrayList<>();
        for (Noeud<Case> noeud : cheminNoeuds) {
            cheminCases.add(noeud.getValeur());
        }

        return new Chemin(cheminCases);
    }

    public static Graphe<Case> creerGraphe(Carte carte) {
        Graphe<Case> graphe = new Graphe<>();
        // Ajouter les cases comme nœuds au graphe
        for (int i = 0; i < carte.getLargeur(); i++) {
            for (int j = 0; j < carte.getHauteur(); j++) {
                Case currentCase = new Case(carte.getTuile(i, j), i, j);
                graphe.ajouterNoeud(new Noeud<>(currentCase));
            }
        }
        // Ajouter les arêtes entre les cases voisines dans le graphe
        for (int i = 0; i < carte.getLargeur(); i++) {
            for (int j = 0; j < carte.getHauteur(); j++) {
                Case currentCase = new Case(carte.getTuile(i, j), i, j);
                ajouterAretesVoisines(graphe, currentCase, i, j, carte.getLargeur(), carte.getHauteur());
            }
        }
        return graphe;
    }

    public static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {
        Noeud<Case> currentNode = null;
        for (Noeud<Case> noeud : graphe.getNoeuds()) {
            Case c = noeud.getValeur();
            if (c.equals(currentCase)) {
                currentNode = noeud;
                break;
            }
        }

        assert currentNode != null;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < largeur && newY >= 0 && newY < hauteur) {
                Noeud<Case> neighborNode = getNoeud(graphe,newX, newY);
                if (neighborNode != null) {
                    Case neighborCase = neighborNode.getValeur();
                    double cost = calculerCout(currentCase, neighborCase);
                    graphe.ajouterArete(currentNode, neighborNode, cost);
                    currentNode.ajouterVoisin(neighborNode);
                }
            }
        }
    }

    public static double calculerCout(Case from, Case to) {
        return 0.0;
    }

    public static void afficherChemin(List<Noeud<Case>> chemin) {

    }

    private static Noeud<Case> getNoeud(Graphe graphe,int x, int y) {
        for (Object noeud : graphe.getNoeuds()) {
            Case caseActuelle = (Case) ((Noeud)noeud).getValeur();
            if (caseActuelle.getX() == x && caseActuelle.getY() == y) {
                return (Noeud)noeud;
            }
        }
        return null;
    }
}
