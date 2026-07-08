package view;

import java.util.Scanner;
import java.util.ArrayList;
import service.LivreService;

import entity.LivreEntity;

public class MainView {
    public MainView() {
    }

    public static LivreEntity saisirLivre() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le titre du livre: ");
        String titre = scanner.nextLine();

        System.out.println("Entrez l'auteur du livre: ");
        String auteur = scanner.nextLine();
        
        System.out.println("Entrez l'année de publication du livre: ");
        int anneePublication = scanner.nextInt();
        if (!LivreService.verifierAnneePublication(anneePublication)) {
            System.out.println("L'année de publication est invalide.");
            return null;
        }

        System.out.println("Entrez le prix du livre: ");
        double prix = scanner.nextDouble();
        if (!LivreService.verifierPrix(prix)) {
            System.out.println("Le prix est invalide.");
            return null;
        }

        return new LivreEntity(titre, auteur, anneePublication, prix);
    }

    public static void afficherLivres(ArrayList<LivreEntity> livres) {
        for (LivreEntity livre : livres) {
            System.out.println(livre);
        }
    }


    public static void afficherMenu() {
        while (true) {
            System.out.println("Choisissez une option: ");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Afficher tous les livres");
            System.out.println("3. Afficher le(s) livre(s) le(s) plus ancien(s)");
            System.out.println("4. Afficher la valeur totale de la collection");
            System.out.println("5. Quitter");
            
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    LivreEntity livre = saisirLivre();
                    if (livre != null) {
                        LivreService.ajouterLivre(livre);
                    }
                    break;
                case 2:
                    ArrayList<LivreEntity> livres = LivreService.getLivres();
                    if (livres.isEmpty()) {
                        System.out.println("La bibliotheque est actuellement vide.");
                    } else {
                        afficherLivres(livres);
                    }
                    break;
                case 3:
                    ArrayList<LivreEntity> livresPlusAnciens = LivreService.getLivresPlusAnciens();
                    afficherLivres(livresPlusAnciens);
                    break;
                case 4:
                    double valeurTotale = LivreService.calculerPrixTotal();
                    System.out.println("La valeur totale : " + valeurTotale + "£");
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }

        }
        
    }
}
