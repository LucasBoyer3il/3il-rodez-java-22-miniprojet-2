package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe<E> {

    Map<Noeud<E>, Map<Noeud<E>, Double>> voisins;

    public Graphe() {
        this.voisins = new HashMap<>();
    }

    public void ajouterNoeud(Noeud<E> noeud) {
        if (!voisins.containsKey(noeud)) {
            voisins.put(noeud, new HashMap<>());
        }
    }

    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        depart.ajouterVoisin(arrivee);
        arrivee.ajouterVoisin(depart);
        voisins.get(depart).put(arrivee, cout);
    }

    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        // Cette méthode pourrait être implémentée en fonction des coûts associés
        // à chaque arête dans votre graphe
        // Ici, vous pouvez simplement retourner 1 si les nœuds sont voisins
        return depart.getVoisins().contains(arrivee) ? 1 : Double.POSITIVE_INFINITY;
    }

    public List<Noeud<E>> getNoeuds() {
        return new ArrayList<>(voisins.keySet());
    }

    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        return noeud.getVoisins();
    }
}
