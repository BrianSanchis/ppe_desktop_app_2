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
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class ConnectionFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMail;
	private JButton btnConnection;
	private JButton btnInscription;
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
	public ConnectionFenetre() {
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
		
		btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInscription.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnInscription.setBounds(52, 308, 119, 27);
		panel.add(btnInscription);
		
		 textFieldMail = new JTextField();
		textFieldMail.setBounds(418, 107, 114, 21);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		btnConnection = new JButton("Connexion");
		btnConnection.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConnection.setBounds(418, 204, 114, 27);
		contentPane.add(btnConnection);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblMail.setBounds(418, 89, 136, 17);
		contentPane.add(lblMail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		lblMotDePasse.setBounds(418, 140, 136, 17);
		contentPane.add(lblMotDePasse);
		
		textFieldMdp = new JPasswordField();
		textFieldMdp.setBounds(418, 158, 114, 21);
		contentPane.add(textFieldMdp);
	}
	public JTextField getTextFieldMail() {
		return textFieldMail;
	}
	public JTextField getTextFieldMdp() {
		return textFieldMdp;
	}
	public JButton getBtnConnection() {
		return btnConnection;
	}
	public JButton getBtnInscription() {
		return btnInscription;
	}
}
