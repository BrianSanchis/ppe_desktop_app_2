package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import models.Utilisateur;
import utils.DBSingleton;

public class DAOUtilisateur {
	private Connection cnx;  // Déplacez la déclaration du champ ici
	 
    public DAOUtilisateur() throws SQLException {
        this.cnx = (Connection) DBSingleton.getInstance().getConnection();
    }
    
    public void inscrireUtilisateur(Utilisateur utilisateur) throws SQLException {
    	String sql = "INSERT INTO Utilisateur (Nom, Prenom, Mail, NumTel, MotDePasse, Adresse, Ville) VALUES (?, ?, ?, ?, ?, ?, ?)";
    	PreparedStatement preparedStatement = cnx.prepareStatement(sql);
    	preparedStatement.setString(1, utilisateur.getNom()); 
    	preparedStatement.setString(2, utilisateur.getPrenom());
    	preparedStatement.setString(3, utilisateur.getMail());
    	preparedStatement.setNString(4, utilisateur.getNumTel());
    	preparedStatement.setString(5, utilisateur.getMotDePasse());
    	preparedStatement.setString(6, utilisateur.getAdresse());
    	preparedStatement.setString(7, utilisateur.getVille());
    	preparedStatement.executeUpdate(); 
    }
    
    public boolean verifierUtilisateur(Utilisateur utilisateur) throws SQLException {
    	String sql = "SELECT MotDePasse FROM Utilisateur WHERE Mail = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(sql);
        preparedStatement.setString(1, utilisateur.getMail());
     
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
        	String motDePasseStocke = resultSet.getString("MotDePasse");
            return BCrypt.checkpw(utilisateur.getMotDePasse(), motDePasseStocke);
        }
        return false; // Aucun utilisateur trouvé pour cet email
    }
}
