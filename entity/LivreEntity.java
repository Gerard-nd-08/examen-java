package entity;

public class LivreEntity {
    private int id;
    private String titre;
    private String auteur;
    private int anneePubication;
    private Double prix;

    public LivreEntity() {
    }

    public LivreEntity( String titre, String auteur, int anneePubication, Double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePubication = anneePubication;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePubication() {
        return anneePubication;
    }

    public void setAnneePubication(int anneePubication) {
        this.anneePubication = anneePubication;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", titre: " + titre + '\'' +
                ", auteur: " + auteur + '\'' +
                ", anneePubication: " + anneePubication + '\'' +
                ", prix: " + prix + '\'' ;
    }
}