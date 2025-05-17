import java.util.ArrayList;
import java.util.Scanner;

public class GestionNotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Eleve> listeEleves = new ArrayList<>();

        System.out.print("Combien d'élèves ? ");
        int nbEleves = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nbEleves; i++) {
            System.out.print("\nNom de l'élève " + (i + 1) + " : ");
            String nom = scanner.nextLine();

            Eleve eleve = new Eleve(nom);

            System.out.print("Combien de notes pour " + nom + " ? ");
            int nbNotes = scanner.nextInt();

            for (int j = 0; j < nbNotes; j++) {
                System.out.print("Note " + (j + 1) + " : ");
                double note = scanner.nextDouble();
                eleve.ajouterNote(note);
            }

            scanner.nextLine();
            eleve.calculerMoyenne();
            listeEleves.add(eleve);
        }

        System.out.println("\n=== Résultats ===");
        for (Eleve e : listeEleves) {
            System.out.println("Élève: " + e.getNom() + " | Moyenne: " + String.format("%.2f", e.getMoyenne()));
        }

        if (!listeEleves.isEmpty()) {
            Eleve meilleur = listeEleves.get(0);
            Eleve pire = listeEleves.get(0);

            for (Eleve e : listeEleves) {
                if (e.getMoyenne() > meilleur.getMoyenne()) {
                    meilleur = e;
                }
                if (e.getMoyenne() < pire.getMoyenne()) {
                    pire = e;
                }
            }

            System.out.println("\n🔝 Meilleure moyenne: " + meilleur.getNom() + " (" + String.format("%.2f", meilleur.getMoyenne()) + ")");
            System.out.println("🔻 Moins bonne moyenne: " + pire.getNom() + " (" + String.format("%.2f", pire.getMoyenne()) + ")");
        }

        scanner.close();
    }
}
