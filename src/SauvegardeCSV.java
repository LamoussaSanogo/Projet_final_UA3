import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SauvegardeCSV {

    // Enregistrer les résultats dans un autre fichier CSV
    public static void enregistrerResultats(String nomFichier, ArrayList<Etudiant> etudiants) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier));

            // Écrire l'en-tête du fichier
            bw.write("rang,etudiant,moyenne");
            bw.newLine();

            // Écrire les résultats
            for (int i = 0; i < etudiants.size(); i++) {
                Etudiant e = etudiants.get(i);
                bw.write((i + 1) + "," + e.getEtudiant() + "," + String.format("%.2f", e.calculerMoyenne()));
                bw.newLine();
            }

            bw.close();

            System.out.println("Résultats enregistrés dans : " + nomFichier);

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}