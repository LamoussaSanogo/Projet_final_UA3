import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Fichier d'entrée et fichier de sortie
        String fichierEntree = "notes.csv";
        String fichierSortie = "resultats.csv";

        // Lire les étudiants depuis le fichier CSV
        ArrayList<Etudiant> etudiants = LectureCSV.lireFichier(fichierEntree);

        // Vérifier si la liste est vide
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé dans le fichier.");
            scanner.close();
            return;
        }

        int choix;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Afficher tous les étudiants");
            System.out.println("2. Afficher le classement par moyenne");
            System.out.println("3. Afficher la moyenne générale de la classe");
            System.out.println("4. Afficher le meilleur étudiant");
            System.out.println("5. Sauvegarder les résultats dans un fichier CSV");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            // Vérifier que l'utilisateur entre un entier
            while (!scanner.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre valide : ");
                scanner.next();
            }

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    GestionNotes.afficherDetailsComplets(etudiants);
                    break;

                case 2:
                    GestionNotes.afficherClassement(etudiants);
                    break;

                case 3:
                    double moyenneClasse = GestionNotes.calculerMoyenneClasse(etudiants);
                    System.out.println("Moyenne générale de la classe : "
                            + String.format("%.2f", moyenneClasse));
                    break;

                case 4:
                    Etudiant meilleur = GestionNotes.trouverMeilleurEtudiant(etudiants);

                    if (meilleur != null) {
                        System.out.println("Meilleur étudiant : " + meilleur.getEtudiant()
                                + " avec une moyenne de "
                                + String.format("%.2f", meilleur.calculerMoyenne()));
                    } else {
                        System.out.println("Aucun étudiant trouvé.");
                    }
                    break;

                case 5:
                    // Trier avant d'enregistrer pour avoir un vrai classement
                    GestionNotes.trierParMoyenne(etudiants);
                    SauvegardeCSV.enregistrerResultats(fichierSortie, etudiants);
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }
}