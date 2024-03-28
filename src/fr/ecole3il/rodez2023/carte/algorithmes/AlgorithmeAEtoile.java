package fr.ecole3il.rodez2023.carte.algorithmes;

import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

import java.util.*;

public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        Map<Noeud<E>, Integer> coutsEstimes = new HashMap<>();
        Map<Noeud<E>, Integer> coutsReels = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingInt(coutsEstimes::get));
        Set<Noeud<E>> noeudsExplores = new HashSet<>();

        // Initialisation des coûts
        coutsEstimes.put(depart, coutEstime(depart, arrivee));
        coutsReels.put(depart, 0);
        filePriorite.add(depart);

        // Boucle principale
        while (!filePriorite.isEmpty()) {
            Noeud<E> noeudActuel = filePriorite.poll();
            if (noeudActuel.equals(arrivee)) {
                break; // Arrêter si on a atteint le nœud d'arrivée
            }
            noeudsExplores.add(noeudActuel);

            // Mise à jour des coûts pour les voisins
            for (Noeud<E> voisin : graphe.getVoisins(noeudActuel)) {
                if (noeudsExplores.contains(voisin)) {
                    continue; // Skip si le voisin a déjà été exploré
                }
                int nouveauCoutReel = (int) (coutsReels.get(noeudActuel) + graphe.getCoutArete(noeudActuel, voisin));
                if (!coutsReels.containsKey(voisin) || nouveauCoutReel < coutsReels.get(voisin)) {
                    coutsReels.put(voisin, nouveauCoutReel);
                    int coutTotalEstime = nouveauCoutReel + coutEstime(voisin, arrivee);
                    coutsEstimes.put(voisin, coutTotalEstime);
                    predecesseurs.put(voisin, noeudActuel);
                    filePriorite.add(voisin);
                }
            }
        }

        // Reconstruction du chemin
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeudActuel = arrivee;
        while (noeudActuel != null) {
            chemin.add(noeudActuel);
            noeudActuel = predecesseurs.get(noeudActuel);
        }
        Collections.reverse(chemin);
        return chemin;
    }
    // Fonction d'estimation de coût (heuristique)
    private int coutEstime(Noeud<E> noeud, Noeud<E> arrivee) {
        // Exemple d'heuristique : distance à vol d'oiseau (si applicable)
        // Ici, je suppose que la méthode getDistanceVolDOiseau est implémentée dans la classe Noeud<E>
        // Cette méthode pourrait calculer la distance à vol d'oiseau entre le nœud actuel et le nœud d'arrivée.
        return 0;//(int) noeud.getValeur(arrivee);
    }

    @Override
    public Chemin trouverChemin(Carte carte, int caseDepartX, int caseDepartY, int caseArriveeX, int caseArriveeY) {
        return null;
    }
}
