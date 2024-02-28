package fr.ecole3il.rodez2023.carte.elements;

import java.util.List;

public class Graphe<E> {

    private Noeud<E> noeud;
    private double cout;
    public void ajouterNoeud(Noeud<E> noeud) {
        //TODO ajouter le noeud au graphe sauf si il existe déjà
    }

    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        /*TODO
            Ajouter une arrête entre deux noeuds. Si les noeuds n'existent pas alors on les ajoutes avec ajouterNoeud. Initialiser l'arête à la matrice adjacence
         */
    }

    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        return cout;
    }

    public List<Noeud<E>> getNoeuds() {
        return null; //TODO retourner les noeuds du graphe
    }

    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        return noeud.getVoisins(); //renvoyer les voisins d'un noeud
    }
}
