package databases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationCrud {
   
    public static void ajouterEtudiant(int id, String nom, String prenom, String email, String telephone) {
        String requete = "INSERT INTO etudiants (id_etudiants, nom, prenom, email, telephone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Connexiondb.connect();
             PreparedStatement prepare= conn.prepareStatement(requete)
             ){
        	prepare.setInt(1, id);
        	prepare.setString(2, nom);
        	prepare.setString(3, prenom);
        	prepare.setString(4, email);
        	prepare.setString(5, telephone);
        	prepare.executeUpdate();
            System.out.println("Étudiant ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void lireEtudiants() {
        String requete = "SELECT * FROM etudiants";
        try (Connection conn = Connexiondb.connect();
             PreparedStatement prepare = conn.prepareStatement(requete);
             ResultSet resultat = prepare.executeQuery()) {
        	 System.out.println("-------------------------------------------------------------------------------------------------------");
             
             System.out.printf("%-11s| %-16s| %-16s| %-36s| %-16s|\n", "ID", "Nom", "Prenom", "Email", "Téléphone");
             System.out.println("-------------------------------------------------------------------------------------------------------");
             
             while ( resultat.next()) {
                 System.out.printf("%-11d| %-16s| %-16s| %-36s| %-16s|\n",
                		 resultat.getInt("id_etudiants"),
                		 resultat.getString("nom"),
                		 resultat.getString("prenom"),
                		 resultat.getString("email"),
                		 resultat.getString("telephone"));
             }
             System.out.println("-------------------------------------------------------------------------------------------------------");
     
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mettreAJourEtudiant(int id, String nom, String prenom, String email, String telephone) {
        String requete = "UPDATE etudiants SET nom = ?, prenom = ?, email = ?, telephone = ? WHERE id_etudiants = ?";
        try (Connection conn = Connexiondb.connect();
             PreparedStatement pstmt = conn.prepareStatement(requete)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, telephone);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Étudiant mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerEtudiant(int id) {
        String requete = "DELETE FROM etudiants WHERE id_etudiants = ?";
        try (Connection conn = Connexiondb.connect();
             PreparedStatement prepare = conn.prepareStatement(requete)) {
        	prepare.setInt(1, id);
        	prepare.executeUpdate();
            System.out.println("Étudiant supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
