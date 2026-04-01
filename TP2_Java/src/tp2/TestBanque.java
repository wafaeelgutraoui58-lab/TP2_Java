package tp2;
public class TestBanque {
    public static void main(String[] args) {   
        Banque maBanque = new Banque("MarocBank", 1500);
      
        CompteBancaire c1 = new CompteBancaire("Ahmed", 1000, 500);
        CompteBancaire c2 = new CompteBancaire("Sara", 2000, 200);
        CompteBancaire c3 = new CompteBancaire("Yassine", 500, 100);
      
        maBanque.ajouterCompte(c1);
        maBanque.ajouterCompte(c2);
        maBanque.ajouterCompte(c3);
     
        c1.deposer(500);
        c1.retirer(1200); // Autorisé (Solde 1500 - 1200 = 300)
        c2.virementVers(c3, 300);
      
        maBanque.afficherTous();
       
        System.out.println("\nCalcul intérêts pour Sara (c2):");
        System.out.println("Nouveau solde (sans bonus): " + c2.calculerSoldeAvecInterets());
        System.out.println("Nouveau solde (avec bonus 1.5%): " + c2.calculerSoldeAvecInterets(0.015));
      
        System.out.println("\n--- Statistiques Globales ---");
        System.out.println("Nombre total de comptes créés: " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt annuel: " + (CompteBancaire.getTauxInteretAnnuel() * 100) + "%");
    }
}