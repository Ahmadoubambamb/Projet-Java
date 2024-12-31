package databases;

import java.util.Scanner;

public class Requete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n--- Gestion des étudiants ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Lire les étudiants");
            System.out.println("3. Mettre à jour un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); //

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();
                    OperationCrud.ajouterEtudiant(id, nom, prenom, email, telephone);
                    break;

                case 2:
                	OperationCrud.lireEtudiants();
                    break;

                case 3:
                    System.out.print("ID de l'étudiant à mettre à jour : ");
                    int idMaj = scanner.nextInt();
                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Nom : ");
                    String nomMaj = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenomMaj = scanner.nextLine();
                    System.out.print("Email : ");
                    String emailMaj = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephoneMaj = scanner.nextLine();
                    OperationCrud.mettreAJourEtudiant(idMaj, nomMaj, prenomMaj, emailMaj, telephoneMaj);
                    break;

                case 4:
                    System.out.print("ID de l'étudiant à supprimer : ");
                    int idSup = scanner.nextInt();
                    scanner.nextLine(); 
                    OperationCrud.supprimerEtudiant(idSup);
                    break;

                case 5:
                    continuer = false;
                    break;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
        System.out.println("Programme terminé.");
    }
}

