package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAO.DAOUtilisateur;
import models.Utilisateur;
import views.ConnectionFenetre;
import views.HomeFenetre;
import views.InscriptionFenetre;

public class ConnectionController implements ActionListener{
	
	private ConnectionFenetre c;
	private DAOUtilisateur daoUtilisateur;
	
	public ConnectionController(ConnectionFenetre c) throws SQLException {
		super();
		this.c = c;
		this.daoUtilisateur = new DAOUtilisateur();
		init();
		c.setVisible(true);
	}
	
	public void init() {
		c.getBtnInscription().addActionListener(this);
		c.getBtnConnection().addActionListener(this);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == c.getBtnConnection()) {
	    	// Code pour gérer la connexion
	    	String mail = c.getTextFieldMail().getText();
	    	String motDePasse = c.getTextFieldMdp().getText();
	    	
	    	Utilisateur utilisateur = new Utilisateur();
	    	utilisateur.setMail(mail);
	    	utilisateur.setMotDePasse(motDePasse);
	    	try {
	    		if (daoUtilisateur.verifierUtilisateur(utilisateur)) {
	    			// Authentification réussie
	    			JOptionPane.showMessageDialog(c, "Connexion réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
	    			HomeFenetre homeFenetre = new HomeFenetre();
	    			HomeController homeController = new HomeController(homeFenetre);
	    			homeFenetre.setVisible(true);
	    			c.setVisible(false);
	    		} else {
	    			// Authentification échouée
	    			JOptionPane.showMessageDialog(c, "Identifiants invalides. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
	    			c.getTextFieldMail().setText("");
	    			c.getTextFieldMdp().setText("");
	    			}
	    	} catch (SQLException e1) {
	    		e1.printStackTrace();
	    		JOptionPane.showMessageDialog(c, "Erreur lors de la connexion. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
	    	}
	    } else if (e.getSource() == c.getBtnInscription()) {
	    	InscriptionFenetre inscriptionFenetre = new InscriptionFenetre();
		    try {
				InscriptionController inscriptionController = new InscriptionController(inscriptionFenetre, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    inscriptionFenetre.setVisible(true);
		    c.setVisible(false);
	    }
	}
}
