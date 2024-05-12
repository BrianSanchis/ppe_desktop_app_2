package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Employee;

public class DAOEmployee {
	private Connection cnx;  

    /*
    public DAOCity() throws SQLException {
        this.cnx = (Connection) DBSingleton.getInstance().getConnection();
    }
    */
    
    
    public DAOEmployee(Connection cnx) {
        this.cnx = cnx;
    }
    
 
    public List<Employee> findAll(int offset, int limit) throws SQLException {
        String SQL = "SELECT * FROM Employees LIMIT ? OFFSET ?;";
        PreparedStatement pstmt = cnx.prepareStatement(SQL);
        pstmt.setInt(1, limit);
        pstmt.setInt(2, offset);

        ResultSet rs = pstmt.executeQuery();

        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getInt("Id"));
            employee.setNom(rs.getString("Nom"));
            employee.setPrenom(rs.getString("Prenom"));
            employee.setDateEmbauche(rs.getString("DateEmbauche"));
            employee.setPoste(rs.getString("Poste"));

            employees.add(employee);
        }

        return employees;
    }   
    
    public Employee findByName(String employeeName) throws SQLException {
    	String SQL = "SELECT * FROM Employees WHERE Nom = ?;";
        PreparedStatement pstmt = cnx.prepareStatement(SQL);
        pstmt.setString(1, employeeName);
        ResultSet rs = pstmt.executeQuery();
        Employee employee = null;

        if (rs.next()) {
            employee = new Employee();
            employee.setId(rs.getInt("Id"));
            employee.setNom(rs.getString("Nom"));
            employee.setPrenom(rs.getString("Prenom"));
            employee.setDateEmbauche(rs.getString("DateEmbauche"));
            employee.setPoste(rs.getString("Poste"));
        }
        return employee;
    }
}
