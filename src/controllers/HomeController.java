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
import views.ConnectionFenetre;
import views.HomeFenetre;
import views.AddFenetre;

public class HomeController {
	private HomeFenetre h;
	private TableModel myTable;
	private List<Employee> employees;
    private DAOEmployee daoEmployee;
	
	public HomeController(HomeFenetre h) throws SQLException {
		super();
		this.h = h;
		employees = new ArrayList<>();
		myTable = new TableModel(employees);
		daoEmployee = new DAOEmployee(DBSingleton.getInstance().getConnection());
		init();
		h.setVisible(true);
	}
	
	public void init() {
		try {
            employees = daoEmployee.findAll(0, 48);
            myTable = new TableModel(employees);
			h.getTable().setModel(myTable);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }	
		h.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doSearch();
			}
		});
		h.getBtnLogout().addActionListener(new ActionListener() {  // Ajoutez votre bouton de déconnexion ici
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					doLogout();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		h.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doUpdate();
            }
        });
		h.getBtnAddEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					doAdd();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
	}
	
	private void doSearch() {
        String name = h.getTextFieldSearch().getText();
        try {
            if (name.isEmpty()) { // Vérifie si le champ de recherche est vide
                employees = daoEmployee.findAll(0, 48); // Recherche de tous les employés
                myTable = new TableModel(employees);
                h.getTable().setModel(myTable);
            } else {
                Employee employee = daoEmployee.findByName(name);
                List<Employee> employeeList = new ArrayList<>();
                if (employee != null) {
                    employeeList.add(employee);
                }
                myTable = new TableModel(employeeList);
                h.getTable().setModel(myTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void doLogout() throws SQLException {
        int response = JOptionPane.showConfirmDialog(
            h,
            "Voulez-vous vraiment vous déconnecter ?",
            "Confirmation de déconnexion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Redirigection
        	ConnectionFenetre connectionFenetre = new ConnectionFenetre();
        	ConnectionController connectionController = new ConnectionController(connectionFenetre);
        	connectionFenetre.setVisible(true);
            h.dispose(); // Fermerture de la fenetre
        }
    }
	
	private void doUpdate() {
		List<Employee> modifiedEmployees = myTable.getModifiedList();
        if (modifiedEmployees.isEmpty()) {
            JOptionPane.showMessageDialog(h, "Aucun employé n'a été modifié.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            for (Employee employee : modifiedEmployees) {
                daoEmployee.updateEmployee(employee);
            }
            JOptionPane.showMessageDialog(h, "Les employés modifiés ont été mis à jour avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            // Réinitialiser la liste des employés modifiés
            myTable.getModifiedList().clear();
            myTable.getModifiedEmployees().clear();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(h, "Erreur lors de la mise à jour des employés.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private void doAdd() throws SQLException {
		AddFenetre addFenetre = new AddFenetre();
    	AddController addController = new AddController(addFenetre);
    	addFenetre.setVisible(true);
    	h.dispose();
	}
}
