import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LectureCSV {

    // Lire le fichier CSV et créer la liste des étudiants
    public static ArrayList<Etudiant> lireFichier(String nomFichier) {

        // Liste finale des étudiants
        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

        // HashMap pour éviter de créer plusieurs fois le même étudiant
        // clé = nom de l'étudiant
        // valeur = objet Etudiant
        HashMap<String, Etudiant> mapEtudiants = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFichier));
            String ligne;

            // Lire et ignorer l'en-tête
            br.readLine();

            // Lire chaque ligne du fichier
            while ((ligne = br.readLine()) != null) {

                // Découper la ligne avec la virgule
                String[] parties = ligne.split(",");

                // Vérifier que la ligne contient bien 3 colonnes
                if (parties.length != 3) {
                    System.out.println("Ligne ignorée (format incorrect) : " + ligne);
                    continue;
                }

                String etudiant = parties[0].trim();
                String cours = parties[1].trim();
                String noteTexte = parties[2].trim();

                // Vérifier qu'aucune valeur n'est vide
                if (etudiant.isEmpty() || cours.isEmpty() || noteTexte.isEmpty()) {
                    System.out.println("Ligne ignorée (valeur vide) : " + ligne);
                    continue;
                }

                double note;

                // Convertir le texte de la note en nombre
                try {
                    note = Double.parseDouble(noteTexte);
                } catch (NumberFormatException e) {
                    System.out.println("Ligne ignorée (note invalide) : " + ligne);
                    continue;
                }

                // Vérifier que la note est comprise entre 0 et 20
                if (note < 0 || note > 20) {
                    System.out.println("Ligne ignorée (note hors limite) : " + ligne);
                    continue;
                }

                // Si l'étudiant n'existe pas encore, on le crée
                if (!mapEtudiants.containsKey(etudiant)) {
                    Etudiant nouveauEtudiant = new Etudiant(etudiant);
                    mapEtudiants.put(etudiant, nouveauEtudiant);
                    listeEtudiants.add(nouveauEtudiant);
                }

                // Ajouter le cours et la note à l'étudiant
                mapEtudiants.get(etudiant).ajouterNote(cours, note);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return listeEtudiants;
    }
}