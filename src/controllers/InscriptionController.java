package controllers;

import java.awt.event.ActionEvent;

import org.springframework.security.crypto.bcrypt.BCrypt;

import DAO.DAOUtilisateur;
import models.Utilisateur;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import views.ConnectionFenetre;
import views.InscriptionFenetre;

public class InscriptionController implements ActionListener{
	private InscriptionFenetre i;
	private DAOUtilisateur daoUtilisateur;
	
	public InscriptionController(InscriptionFenetre i, DAOUtilisateur daoUtilisateur) throws SQLException {
		super();
		this.i = i;
		this.daoUtilisateur = new DAOUtilisateur();
		init();
		i.setVisible(true);
	}

	public void init() {
		i.getBtnConnexion().addActionListener(this);
		i.getBtnInscription().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == i.getBtnInscription()) {
	    	// Inscription button clicked
	    	String Nom = i.getTextFieldNom().getText();
	    	String Prenom = i.getTextFieldPrenom().getText();
	    	String Mail = i.getTextFieldMail().getText();
	    	String NumTel = i.getTextFieldNumTel().getText();
	    	String MotDePasse = BCrypt.hashpw(i.getTextFieldMdp().getText(), BCrypt.gensalt());
	    	String Adresse = i.getTextFieldAdresse().getText();
	    	String Ville = i.getTextFieldVille().getText();
	    	
	    	Utilisateur utilisateur = new Utilisateur();
	    	utilisateur.setNom(Nom);
	    	utilisateur.setPrenom(Prenom);
	    	utilisateur.setMail(Mail);
	    	utilisateur.setNumTel(NumTel);
	    	utilisateur.setMotDePasse(MotDePasse);
	    	utilisateur.setAdresse(Adresse);
	    	utilisateur.setVille(Ville);
	    	
	    	try {
				daoUtilisateur.inscrireUtilisateur(utilisateur);
				JOptionPane.showMessageDialog(i, "Inscription réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
				
				i.getTextFieldNom().setText("");
				i.getTextFieldPrenom().setText("");
				i.getTextFieldMail().setText("");
				i.getTextFieldNumTel().setText("");
				i.getTextFieldMdp().setText("");
				i.getTextFieldAdresse().setText("");
				i.getTextFieldVille().setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(i, "Inscription n'a pas été réussi...", "Echec", JOptionPane.INFORMATION_MESSAGE);
			}
	    	
	    } else if (e.getSource() == i.getBtnConnexion()) {
	    	ConnectionFenetre connectionFenetre = new ConnectionFenetre();
	    	try {
				ConnectionController connectionController = new ConnectionController(connectionFenetre);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	connectionFenetre.setVisible(true);
	    	i.setVisible(false);
	    }
	}
}