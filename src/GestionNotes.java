import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestionNotes {

    // Trier les étudiants par moyenne décroissante
    public static void trierParMoyenne(ArrayList<Etudiant> etudiants) {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                return Double.compare(e2.calculerMoyenne(), e1.calculerMoyenne());
            }
        });
    }

    // Afficher le classement des étudiants
    public static void afficherClassement(ArrayList<Etudiant> etudiants) {
        trierParMoyenne(etudiants);

        System.out.println("\n===== CLASSEMENT DES ÉTUDIANTS =====");
        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant e = etudiants.get(i);
            System.out.println((i + 1) + ". " + e.getEtudiant()
                    + " - Moyenne : " + String.format("%.2f", e.calculerMoyenne()));
        }
    }

    // Afficher les détails complets de tous les étudiants
    public static void afficherDetailsComplets(ArrayList<Etudiant> etudiants) {
        System.out.println("\n===== LISTE DES ÉTUDIANTS =====");

        for (Etudiant e : etudiants) {
            System.out.println(e);
            System.out.println();
        }
    }

// Calculer la moyenne générale de la classe
    public static double calculerMoyenneClasse(ArrayList<Etudiant> etudiants) {
        if (etudiants.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (Etudiant e : etudiants) {
            somme += e.calculerMoyenne();
        }

        return somme / etudiants.size();
    }

    // Trouver l'étudiant ayant la meilleure moyenne
    public static Etudiant trouverMeilleurEtudiant(ArrayList<Etudiant> etudiants) {
        if (etudiants.isEmpty()) {
            return null;
        }

        Etudiant meilleur = etudiants.get(0);

        for (Etudiant e : etudiants) {
            if (e.calculerMoyenne() > meilleur.calculerMoyenne()) {
                meilleur = e;
            }
        }

        return meilleur;
    }
}

