package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.List;

public class Noeud<E> {

    private E valeur; // valeur sert à pourvoir être adpaté pour être utilisé dans plusieurs algo différents

    private List<Noeud<E>> voisins;

    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<>();
    }

    public E getValeur(){
        return valeur;
    }

    public List<Noeud<E>> getVoisins() {
        return voisins;
    }

    public void ajouterVoisin(Noeud<E> voisin) {
        voisins.add(voisins.size() + 1, voisin);
    }
}
