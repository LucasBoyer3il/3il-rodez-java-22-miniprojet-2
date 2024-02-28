package fr.ecole3il.rodez2023.carte.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.List;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        double coutDepart = 0;
        //initialiser les valeurs en créent des nouvelles valeurs, ne pas se servir du graphe existant
        for (int i = 0 ; i < graphe.getNoeuds().size() ; i++) {
            graphe.getNoeuds();
        }
        //prendre les voisins du premier noeud
        //faire valeur cout < valeur noeud cout

        return null;
    }

    @Override
    public Chemin trouverChemin(Carte carte, int caseDepartX, int caseDepartY, int caseArriveeX, int caseArriveeY) {
        return null;
    }
}
