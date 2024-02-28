package fr.ecole3il.rodez2023.carte.elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe<E> {

    private Noeud<E> noeud;

    private List<Noeud<E>> noeuds;
    private double cout;

    private Map<Noeud, Map<Noeud, Double>> graphe;


    public Graphe(Noeud<E> noeud, List<Noeud<E>> noeuds, double cout) {
        this.noeud = noeud;
        this.noeuds = noeuds;
        this.cout = cout;
    }

    /**
     * * Ajoute le en paramètre noeud au graphe sauf si il existe déjà
     * @param noeud
     */
    public void ajouterNoeud(Noeud<E> noeud) {
        if (!noeuds.contains(noeud)) {
            noeuds.add(noeud);
        }
    }

    /**
     * Ajoute une arrête entre deux noeuds. Si les noeuds n'existent pas alors on les ajoutes avec ajouterNoeud. Initialiser l'arête à la matrice adjacence
     * @param depart
     * @param arrivee
     * @param cout
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        /*if (!graphe.containsKey(depart)){
            ajouterNoeud(depart);
        } else if (!graphe.containsKey(arrivee)){
            ajouterNoeud(arrivee);
        } else {*/
        Map<Noeud, Double> buffer = new HashMap<>();
        buffer.put(arrivee, cout);
        graphe.put(depart, buffer);
        //}
    }

    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        return graphe.get(depart).get(arrivee);
    }

    public List<Noeud<E>> getNoeuds() {
        return noeuds; //retourner les noeuds du graphe
    }

    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        return noeud.getVoisins(); //renvoyer les voisins d'un noeud
    }
}
