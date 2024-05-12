package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import views.InscriptionFenetre;
import javax.swing.JPasswordField;

public class InscriptionFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JButton btnInscription;
	private JButton btnConnexion;
	private JTextField textFieldMail;
	private JTextField textFieldNumTel;
	private JTextField textFieldAdresse;
	private JTextField textFieldVille;
	private JPasswordField textFieldMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionFenetre frame = new InscriptionFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InscriptionFenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(98, 160, 234));
		panel.setBounds(0, 0, 223, 637);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSwissGalaxyRh = new JLabel("Swiss Galaxy RH");
		lblSwissGalaxyRh.setFont(new Font("Montserrat Medium", Font.BOLD, 22));
		lblSwissGalaxyRh.setForeground(new Color(255, 255, 255));
		lblSwissGalaxyRh.setBounds(12, 81, 201, 97);
		panel.add(lblSwissGalaxyRh);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnConnexion.setBounds(52, 308, 119, 27);
		panel.add(btnConnexion);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(418, 32, 114, 21);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(418, 73, 114, 21);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInscription.setBounds(418, 331, 114, 27);
		contentPane.add(btnInscription);
		
		JLabel lblNomDutilisateur = new JLabel("Nom");
		lblNomDutilisateur.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblNomDutilisateur.setBounds(418, 12, 136, 17);
		contentPane.add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Prenom");
		lblMotDePasse.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblMotDePasse.setBounds(418, 55, 136, 17);
		contentPane.add(lblMotDePasse);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblMail.setBounds(418, 94, 136, 17);
		contentPane.add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(418, 113, 114, 21);
		contentPane.add(textFieldMail);
		
		JLabel lblNumroTlphone = new JLabel("Numéro téléphone");
		lblNumroTlphone.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblNumroTlphone.setBounds(418, 135, 136, 17);
		contentPane.add(lblNumroTlphone);
		
		textFieldNumTel = new JTextField();
		textFieldNumTel.setColumns(10);
		textFieldNumTel.setBounds(418, 157, 114, 21);
		contentPane.add(textFieldNumTel);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe");
		lblMotDePasse_1.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblMotDePasse_1.setBounds(418, 183, 136, 17);
		contentPane.add(lblMotDePasse_1);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblAdresse.setBounds(418, 224, 136, 17);
		contentPane.add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(418, 246, 114, 21);
		contentPane.add(textFieldAdresse);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblVille.setBounds(418, 269, 136, 17);
		contentPane.add(lblVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(418, 286, 114, 21);
		contentPane.add(textFieldVille);
		
		textFieldMdp = new JPasswordField();
		textFieldMdp.setBounds(418, 200, 114, 21);
		contentPane.add(textFieldMdp);
	}
	public JTextField getTextFieldNom() {
		return textFieldNom;
	}
	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}
	public JButton getBtnInscription() {
		return btnInscription;
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
	public JTextField getTextFieldMail() {
		return textFieldMail;
	}
	public JTextField getTextFieldNumTel() {
		return textFieldNumTel;
	}
	public JTextField getTextFieldMdp() {
		return textFieldMdp;
	}
	public JTextField getTextFieldAdresse() {
		return textFieldAdresse;
	}
	public JTextField getTextFieldVille() {
		return textFieldVille;
	}
}
