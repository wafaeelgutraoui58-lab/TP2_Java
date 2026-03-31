package tp2;
public class Banque {
    private String nom;
    private CompteBancaire[] comptes;
    private int nbActuels;

    public Banque(String nom, int capaciteMaximale) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capaciteMaximale];
        this.nbActuels = 0;
    }

    public void ajouterCompte(CompteBancaire c) {
        if (nbActuels < comptes.length) {
            comptes[nbActuels] = c;
            nbActuels++;
        } else {
            System.out.println("Banque pleine, impossible d'ajouter un compte.");
        }
    }

    public void afficherTous() {
        System.out.println("--- Liste des comptes de la banque " + nom + " ---");
        for (int i = 0; i < nbActuels; i++) {
            comptes[i].afficher();
        }
    }
}
