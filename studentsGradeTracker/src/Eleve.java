import java.util.ArrayList;

public class Eleve {
        private String nom;
        private ArrayList<Double> notes;
        private double moyenne;

        public Eleve(String nom) {
            this.nom = nom;
            this.notes = new ArrayList<>();
        }

        public void ajouterNote(double note) {
            notes.add(note);
        }

        public void calculerMoyenne() {
            double somme = 0;
            for (double note : notes) {
                somme += note;
            }
            moyenne = notes.isEmpty() ? 0 : somme / notes.size();
        }

        public String getNom() {
            return nom;
        }

        public double getMoyenne() {
            return moyenne;
        }

        public ArrayList<Double> getNotes() {
            return notes;
        }
    }


