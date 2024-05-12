package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{
	private List<Employee> employees;
	private String[] columnNames = {"Nom" ,"Prénom", "Date d'embauche", "Poste"};
	private HashSet<Employee> modifiedEmployees = new HashSet<>();
	List<Employee> modifiedList = new ArrayList<>();

	public TableModel(List<Employee> employees) {
		super();
		this.employees = employees;
	}
	

	/**
	 * @return the modifiedCities
	 */
	public HashSet<Employee> getModifiedCities() {
		return modifiedEmployees;
	}


	/**
	 * @param modifiedCities the modifiedCities to set
	 */
	public void setModifiedCities(HashSet<Employee> modifiedEmployees) {
		this.modifiedEmployees = modifiedEmployees;
	}


	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(employees == null) {
			return 0;
		}
		return employees.size();
	}

	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column == 0 || column == 2) {
			return false;
		}
		return true;
	}

	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		//recup dans un liste l'index 
		Employee e = employees.get(row);
		Object value = null;
		
		switch(column) {
		case 0: 
			value = e.getNom();
			break;
		case 1:
			value = e.getPrenom();
			break;
		case 2: 
			value = e.getDateEmbauche();
			break;
		case 3:
			value = e.getPoste(); 
			break;
		default:
			break;
		}
		return value;
	}

	public void setValueAt(Object aValue, int row, int column) {
		// TODO Auto-generated method stub
		Employee e = employees.get(row);
		
		switch(column) {
		case 0: 
			e.setNom((String) aValue);
			break;
		case 1:
			e.setPrenom((String) aValue);
			break;
		case 2: 
			e.setDateEmbauche((String) aValue);
			break;
		case 3:
			e.setPoste((String) aValue); 
			break;
		default:
			break;
		}
		//Bonne solution
		modifiedEmployees.add(e);
		
		//En Exam 
		//Ajouter la ville a la liste, uniquement si elle n'est pas deja présente dnas la liste...
		//Sans boucle
		if(!modifiedList.contains(e)) {
			modifiedList.add(e);
		}
		
		/*
		for (City mdList : modifiedList){
			if(mdList != c) {
				
			}
		}
		*/
		//return value;
	}

	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		Class<?> type = null;
		switch(columnIndex) {
			case 0: 
				type = String.class;
				break;
			case 1:
				type = String.class;
				break;
			case 2: 
				type = String.class;
				break;
			case 3:
				type = String.class; 
				break;
		}
		return type;
	}
}
