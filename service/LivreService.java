package service;

import java.util.ArrayList;
import entity.LivreEntity;

public class LivreService {
    private static ArrayList<LivreEntity> livres = new ArrayList<>();
    private static int id = 0;

    public LivreService() {
    }

    public static void ajouterLivre(LivreEntity livre) {
        id=id + 1; 
        livre.setId(id);
        livres.add(livre);
    }

    public static ArrayList<LivreEntity> getLivres() {
        return livres;
    }

    public static double calculerPrixTotal() {
        double total = 0;
        for (LivreEntity livre : livres) {
            total += livre.getPrix();
        }
        return total;
    }

    public static boolean verifierAnneePublication(int anneePublication) {
        if(anneePublication < 0 || anneePublication > 2026) {
            return false;
        }
        return true;
    }

    public static boolean verifierPrix(double prix) {
        if(prix < 0) {
            return false;
        }
        return true;
    }

    public static ArrayList<LivreEntity> getLivresPlusAnciens() {
        ArrayList<LivreEntity> livresPlusAnciens = new ArrayList<>();
        int anneeMin = 2026;

        for (LivreEntity livre : livres) {
            if (livre.getAnneePubication() < anneeMin) {
                anneeMin = livre.getAnneePubication();
            } 
        }

        for (LivreEntity livre : livres) {
            if (livre.getAnneePubication() == anneeMin) {
                livresPlusAnciens.add(livre);
            }
        }

        return livresPlusAnciens;
    }

}
