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
import views.HomeFenetre;

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
	
}
