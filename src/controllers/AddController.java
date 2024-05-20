package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAOEmployee;
import models.Employee;
import models.TableModel;
import utils.DBSingleton;
import views.AddFenetre;
import views.HomeFenetre;
import controllers.HomeController;

public class AddController {
	private AddFenetre a;
	private TableModel myTable;
	private List<Employee> employees;
    private DAOEmployee daoEmployee;
	
	public AddController(AddFenetre a) throws SQLException {
		super();
		this.a = a;
		employees = new ArrayList<>();
		myTable = new TableModel(employees);
		daoEmployee = new DAOEmployee(DBSingleton.getInstance().getConnection());
		init();
		a.setVisible(true);
	}
	
	public void init() {
		a.getBtnBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					doBack();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		a.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				doAdd();
            }
        });
	}
	
	private void doBack() throws SQLException {
		HomeFenetre homeFenetre = new HomeFenetre();
    	HomeController homeController = new HomeController(homeFenetre);
    	homeFenetre.setVisible(true);
    	a.dispose();
	}
	
	private void doAdd() {
		String nom = a.getTextFieldNom().getText();
        String prenom = a.getTextFieldPrenom().getText();
        String dateEmbauche = a.getTextFieldDateEmbauche().getText();
        String poste = a.getTextFieldPoste().getText();

        Employee newEmployee = new Employee();
        newEmployee.setNom(nom);
        newEmployee.setPrenom(prenom);
        newEmployee.setDateEmbauche(dateEmbauche);
        newEmployee.setPoste(poste);

        try {

            daoEmployee.addEmployee(newEmployee);
            
            // Affichez un message de confirmation
            JOptionPane.showMessageDialog(a, "L'employé à bien été ajouté.", "Success", JOptionPane.INFORMATION_MESSAGE);
            employees.add(newEmployee);
        
            a.getTextFieldNom().setText("");
			a.getTextFieldPrenom().setText("");
			a.getTextFieldDateEmbauche().setText("");
			a.getTextFieldPoste().setText("");
       
            
        } catch (SQLException e) {
            // Affichez un message d'erreur
            JOptionPane.showMessageDialog(a, "Erreur dans l'ajout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            a.getTextFieldNom().setText("");
			a.getTextFieldPrenom().setText("");
			a.getTextFieldDateEmbauche().setText("");
			a.getTextFieldPoste().setText("");
        }
    }
}
