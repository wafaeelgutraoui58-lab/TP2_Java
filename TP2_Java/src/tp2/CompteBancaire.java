package tp2;
public class CompteBancaire { 
    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;
 
    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03;
  
    public CompteBancaire() {
        nbComptes++;
        this.numero = nbComptes; 
        this.titulaire = "Inconnu";
        this.solde = 0;
        this.decouvertAutorise = 0;
    }
    public CompteBancaire(String titulaire, double soldeInitial, double decouvert) {
        nbComptes++;
        this.numero = nbComptes;
        this.setTitulaire(titulaire);
        this.solde = soldeInitial;
        this.setDecouvertAutorise(decouvert);
    }  
    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) {
        if (!titulaire.isEmpty()) {
            this.titulaire = titulaire;
        }
    }
    public double getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise(double decouvert) {
        if (decouvert >= 0) {
            this.decouvertAutorise = decouvert;
        }
    }
    public double getSolde() { return solde; }

    
    public void afficher() {
        System.out.println("Compte N°: " + numero + " | Titulaire: " + titulaire + 
                           " | Solde: " + solde + " MAD | Découvert: " + decouvertAutorise + " MAD");
    } 
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }
    public void retirer(double montant) {
        if (montant > 0 && (solde - montant) >= -decouvertAutorise) {
            solde -= montant;
        } else {
            System.out.println("Retrait refusé (Solde ou montant insuffisant).");
        }
    }
    public void virementVers(CompteBancaire autre, double montant) {
        if (montant > 0 && (solde - montant) >= -decouvertAutorise) {
            this.solde -= montant;
            autre.deposer(montant);
        } else {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
        }
    }
    public double calculerSoldeAvecInterets() {
        solde = solde + (solde * tauxInteretAnnuel);
        return solde;
    }
    public double calculerSoldeAvecInterets(double bonus) {
        solde = solde + (solde * (tauxInteretAnnuel + bonus));
        return solde;
    }
    public static int getNbComptes() { return nbComptes; }
    public static double getTauxInteretAnnuel() { return tauxInteretAnnuel; }
    public static void setTauxInteretAnnuel(double taux) { tauxInteretAnnuel = taux; }
}