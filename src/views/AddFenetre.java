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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddFenetre extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldDateEmbauche;
	private JTextField textFieldPoste;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFenetre frame = new AddFenetre();
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
	public AddFenetre() {
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
		
		btnBack = new JButton("Revenir en arrière");
		btnBack.setBounds(52, 308, 119, 27);
		panel.add(btnBack);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(463, 123, 133, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(463, 169, 133, 20);
		contentPane.add(textFieldPrenom);
		
		textFieldDateEmbauche = new JTextField();
		textFieldDateEmbauche.setColumns(10);
		textFieldDateEmbauche.setBounds(463, 212, 133, 20);
		contentPane.add(textFieldDateEmbauche);
		
		textFieldPoste = new JTextField();
		textFieldPoste.setColumns(10);
		textFieldPoste.setBounds(463, 258, 133, 20);
		contentPane.add(textFieldPoste);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(463, 107, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom");
		lblNewLabel_1.setBounds(463, 154, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date embauche (YYYY-MM-DD)");
		lblNewLabel_2.setBounds(463, 200, 133, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Poste");
		lblNewLabel_3.setBounds(463, 243, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(463, 296, 133, 23);
		contentPane.add(btnAdd);
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JTextField getTextFieldNom() {
		return textFieldNom;
	}
	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}
	public JTextField getTextFieldDateEmbauche() {
		return textFieldDateEmbauche;
	}
	public JTextField getTextFieldPoste() {
		return textFieldPoste;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
}
