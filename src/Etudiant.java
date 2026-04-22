import java.util.ArrayList;

public class Etudiant {

    // Attributs privés
    // etudiant : nom de l'étudiant
    // cours : liste des cours
    // notes : liste des notes correspondantes
    private String etudiant;
    private ArrayList<String> cours;
    private ArrayList<Double> notes;

    // Constructeur
    public Etudiant(String etudiant) {
        this.etudiant = etudiant;
        this.cours = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    // Getter pour récupérer le nom de l'étudiant
    public String getEtudiant() {
        return etudiant;
    }

    // Getter pour récupérer la liste des cours
    public ArrayList<String> getCours() {
        return cours;
    }

    // Getter pour récupérer la liste des notes
    public ArrayList<Double> getNotes() {
        return notes;
    }

    // Ajouter un cours et une note
    // Cette méthode est utilisée lors de la lecture du fichier CSV
    public void ajouterNote(String cours, double note) {
        this.cours.add(cours);
        this.notes.add(note);
    }

    // Calculer la moyenne de l'étudiant
    public double calculerMoyenne() {
        if (notes.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (double note : notes) {
            somme += note;
        }

        return somme / notes.size();
    }

    // toString() permet d'afficher facilement un objet Etudiant
    @Override
    public String toString() {
        String resultat = "Étudiant : " + etudiant + "\n";

        for (int i = 0; i < cours.size(); i++) {
            resultat += "  Cours : " + cours.get(i) + " | Note : " + notes.get(i) + "\n";
        }

        resultat += "  Moyenne : " + String.format("%.2f", calculerMoyenne());

        return resultat;
    }
}