package fr.ecole3il.rodez2023.carte.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.*;

import java.util.*;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        //initialiser les valeurs en créent des nouvelles valeurs, ne pas se servir du graphe existant
        Map<Noeud<E>, Integer> couts = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingInt(couts::get));

        // Initialisation des coûts et prédécesseurs
        for (Noeud<E> noeud : graphe.getNoeuds()) {
            if (noeud.equals(depart)) {
                couts.put(noeud, 0);
            } else {
                couts.put(noeud, Integer.MAX_VALUE);
            }
            predecesseurs.put(noeud, null);
            filePriorite.add(noeud);
        }

        // Exploration des nœuds
        while (!filePriorite.isEmpty()) {
            Noeud<E> u = filePriorite.poll();
            if (u.equals(arrivee)) {
                break; // Arrêter si on a atteint le nœud d'arrivée
            }
            for (Noeud<E> voisin : graphe.getVoisins(u)) {
                int nouveauCout = (int) (couts.get(u) + graphe.getCoutArete(u, voisin));
                if (nouveauCout < couts.get(voisin)) {
                    couts.put(voisin, nouveauCout);
                    predecesseurs.put(voisin, u);
                    // Mise à jour de la file de priorité
                    filePriorite.remove(voisin);
                    filePriorite.add(voisin);
                }
            }
        }

        // Reconstruction du chemin le plus court
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeudActuel = arrivee;
        while (noeudActuel != null) {
            chemin.add(noeudActuel);
            noeudActuel = predecesseurs.get(noeudActuel);
        }
        Collections.reverse(chemin);
        return chemin;
    }

    @Override
    public Chemin trouverChemin(Carte carte, int caseDepartX, int caseDepartY, int caseArriveeX, int caseArriveeY) {
        return null;
    }


}
